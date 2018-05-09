package top.jinhaoplus.spittr.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import top.jinhaoplus.spittr.data.SpitterRepository;
import top.jinhaoplus.spittr.model.Spitter;

import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/spitter")
public class SpitterController {

    private SpitterRepository spitterRepository;

    @Autowired
    public SpitterController(SpitterRepository spitterRepository) {
        this.spitterRepository = spitterRepository;
    }

    @RequestMapping(value = "/register", method = GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute(new Spitter());
        return "registerForm";
    }

    // multpart数据请求会将HttpServletRequest转换成为MultipartHttpServletRequest
    // 会将传入的数据拆分成为简单字段参数和MultipartFile，前者会拼装成为参数中的bean类型，后者会变成文件对象
    // 后者使用@RequestPart或者@RequestParam来接，前者则通过字段匹配拼装成为bean的对象
    @RequestMapping(value = "/register", method = POST)
    public String processRegistration(
            @Valid Spitter spitter,
            Errors errors,
            @RequestPart("profilePicture") MultipartFile file,
            RedirectAttributes model) {
        if (errors.hasErrors()) {
            return "registerForm";
        }
        System.out.println("---->  " + file.getName() + "  ::  " + file.getSize());
        spitterRepository.save(spitter);
        model.addAttribute("userName", spitter.getUsername());
        model.addAttribute("spitterId", spitter.getId());
        // 使用{userName}而不是直接在url拼接spitter.getUsername()是为了更安全的处理url，这样做Spring甚至会解决转码等安全问题
        // return "redirect:/spitter/" + spitter.getUsername();
        // 要使用的前提是{...}内的变量是model中的字符串或者数字，但是对于复杂的对象就需要使用跨重定向请求RedirectAttributes类型的model的flash属性来传递了
        // 使用flash属性来传递跨重定向请求之间的对象时会将model中的flash属性保存在servlet标准的会话级变量中，即只要会话一致即使请求已经在重定向过程中销毁变量仍然存在
        model.addFlashAttribute("spitter", spitter);
        return "redirect:/spitter/{userName}";
    }

    @RequestMapping(value = "/{username}", method = GET)
    public String showSpitterProfile(@PathVariable String username, Model model) {
        // 跨重定向请求之前构造的对象还要在DB中额外查找一次徒增性能损耗
        // model.addAttribute(spitterRepository.findByUsername(username));
        if (!model.containsAttribute("spitter")) {
            // 之所以不直接去DB查找对象是因为可能会话级对象(flash属性)中存在，避免额外查DB带来的性能损耗
            model.addAttribute(spitterRepository.findByUsername(username));
        }
        return "profile";
    }

}
