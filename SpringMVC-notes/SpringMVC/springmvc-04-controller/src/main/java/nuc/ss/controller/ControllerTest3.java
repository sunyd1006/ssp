package nuc.ss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


//代表这个类会被Spring接管，
// 被这个注解的类，中的所有方法，如果返回值是String，并且有具体页面可以跳转，那么就会被视图解析器解析
@Controller
@RequestMapping("/c2")
public class ControllerTest3 {

    @RequestMapping("/t2")
    public String test1(Model model) {
        model.addAttribute("msg","ControllerTest3");
        return "test";
    }

}
