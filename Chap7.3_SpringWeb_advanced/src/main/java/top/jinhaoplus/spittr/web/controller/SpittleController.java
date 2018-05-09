package top.jinhaoplus.spittr.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import top.jinhaoplus.spittr.data.SpittleRepository;
import top.jinhaoplus.spittr.model.Spittle;
import top.jinhaoplus.spittr.web.exception.SpittleNotFoundException;
import top.jinhaoplus.spittr.web.vo.SpittleForm;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/spittles")
public class SpittleController {

    private static final String MAX_LONG_AS_STRING = "9223372036854775807";

    private SpittleRepository spittleRepository;

    @Autowired
    public SpittleController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittles(
            @RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max,
            @RequestParam(value = "count", defaultValue = "20") int count) {
        return spittleRepository.findSpittles(max, count);
    }

    // Spring的异常处理之一：使用ResponseStatus
    // 一般情况下当抛出Exception的时候会导致web接口出现500报错
    // 为了能够控制这样的错误并且让报错和业务逻辑本身相关可以在Exception上定义ResponseStatus
    @RequestMapping(value = "/{spittleId}", method = RequestMethod.GET)
    public String spittle(
            @PathVariable("spittleId") long spittleId,
            Model model) {
        Spittle spittle = spittleRepository.findOne(spittleId);
        if (spittle == null) {
            throw new SpittleNotFoundException();
        }
        model.addAttribute(spittle);
        return "spittle";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveSpittle(SpittleForm form, Model model) {
        // 只需要编写正常的逻辑即可，可能抛出的异常
        spittleRepository.save(new Spittle(null, form.getMessage(), new Date(), form.getLongitude(), form.getLatitude()));
        return "redirect:/spittles";
        // 一般来说可以直接在业务代码里面设置遇到DuplicateSpittleException就跳转到错误提示页面
        //        try {
        //            spittleRepository.save(new Spittle(null, form.getMessage(), new Date(),
        //                    form.getLongitude(), form.getLatitude()));
        //            return "redirect:/spittles";
        //        } catch (DuplicateSpittleException e) {
        //            return "error/duplicate";
        //        }
    }

    // Spring的异常处理之二：使用ExceptionHandler
    // 使用@ExceptionHandler来处理异常抛出时的逻辑
    // 它能够捕获的此Controller的各方法中抛出的DuplicateSpittleException，但是如果其他的Controller中抛出DuplicateSpittleException就无能为力
//    @ExceptionHandler(DuplicateSpittleException.class)
    public String handleDuplicateSpittle() {
        return "error/duplicate";
    }

}
