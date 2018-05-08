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

    /**
     * model实际上是一个k-v结构的map，用于传输到视图中渲染数据
     * 编写Controller的时候可以选择传入Model类型的对象来作为传输数据的map，也可以在方法中新建Model，再或者直接使用Map也可以，最终MVC都会解析
     */

    @RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittles(
            @RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max,
            @RequestParam(value = "count", defaultValue = "20") int count) {
        return spittleRepository.findSpittles(max, count);
    }

//    /**
//     * 情形一：完整的声明model中attribute的key和视图名
//     * 返回的视图名称默认和请求的路径一致，也可以显式地声明视图名
//     * 视图中的model中attribute的key会根据类型进行推断，也可以显式地声明key
//     */
//    @RequestMapping(method = RequestMethod.GET)
//    public String spittles(
//            Model model,
//            @RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max,
//            @RequestParam(value = "count", defaultValue = "20") int count) {
//        List<Spittle> spittles = spittleRepository.findSpittles(max, count);
//        model.addAttribute("spittleList", spittles);
//        return "spittles";
//    }
//
//    /**
//     * 情形二：使用默认的model中attribute的key
//     */
//    @RequestMapping(method = RequestMethod.GET)
//    public String spittles(
//            Model model,
//            @RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max,
//            @RequestParam(value = "count", defaultValue = "20") int count) {
//        List<Spittle> spittles = spittleRepository.findSpittles(max, count);
//        model.addAttribute(spittles);
//        return "spittles";
//    }
//
//    /**
//     * 情形三：使用默认的视图名
//     */
//    @RequestMapping(method = RequestMethod.GET)
//    public Model spittles(
//            Model model,
//            @RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max,
//            @RequestParam(value = "count", defaultValue = "20") int count) {
//        List<Spittle> spittles = spittleRepository.findSpittles(max, count);
//        model.addAttribute(spittles);
//        return model;
//    }
//
//    /**
//     * 情形四：直接返回model中的attribute
//     */
//    @RequestMapping(method = RequestMethod.GET)
//    public List<Spittle> spittles(
//            @RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max,
//            @RequestParam(value = "count", defaultValue = "20") int count) {
//        return spittleRepository.findSpittles(max, count);
//    }

    @RequestMapping(value = "/{spittleId}", method = RequestMethod.GET)
    public String spittle(
            // @PathVariable用于url路径传参
            @PathVariable("spittleId") long spittleId,
            Model model) {
        model.addAttribute(spittleRepository.findOne(spittleId));
        return "spittle";
    }

//    @RequestMapping(value = "/spittle", method = RequestMethod.GET)
//    public String spittle(
//            // @RequestParam用于请求参数传参，最终的url形如/spittle?spittleId=1000
//            @RequestParam("spittleId") long spittleId,
//            Model model) {
//        model.addAttribute(spittleRepository.findOne(spittleId));
//        return "spittle";
//    }

    // url路径传参和请求参数传参无优劣之分，但是url路径传参更符合Restful面向资源API的思想


    // SpittleForm参数form中的各个字段将会由请求中的同名参数进行填充，这被称为参数同bean字段的自动绑定
    @RequestMapping(method = RequestMethod.POST)
    public String saveSpittle(SpittleForm form) throws Exception {
        spittleRepository.save(new Spittle(null, form.getMessage(), new Date(),
                form.getLongitude(), form.getLatitude()));
        // 携带redirect:的视图名用于重定向（响应后跳转），最终的httpcode会是302，这样做的好处是请求结束后刷新页面也不会重复提交
        // 携带forward:的视图名用于前往跳转（响应中跳转），最终的httpcode会是200
        return "redirect:/spittles";
    }

}
