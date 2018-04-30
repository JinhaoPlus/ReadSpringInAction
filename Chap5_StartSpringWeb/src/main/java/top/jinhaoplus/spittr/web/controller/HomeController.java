package top.jinhaoplus.spittr.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

// @Controller效果和@Component一样，只是表意性强说明这是一个控制器
@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping(method = GET)
    public String home(Model model) {
        // 返回的是视图名称
        return "home";
    }

}
