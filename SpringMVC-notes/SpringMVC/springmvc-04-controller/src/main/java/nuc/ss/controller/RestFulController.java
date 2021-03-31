package nuc.ss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RestFulController {
    //1.原来的风格：http://localhost:8080/springmvc_04_controller/add?a=2&b=3
    //@RequestMapping("/add")
    //2.RestFul风格：http://localhost:8080/springmvc_04_controller/add/2/3
    //@RequestMapping("/add/{a}/{b}")

    //@RequestMapping(value = "/add/{a}/{b}", method = RequestMethod.GET)
    //@RequestMapping(value = "/add/{a}/{b}", method = RequestMethod.DELETE)

    @RequestMapping(value = "/hello",method = {RequestMethod.GET})
    public String index2(Model model){
        model.addAttribute("msg", "hello!");
        return "test";
    }

    @GetMapping("/add/{a}/{b}")
    public String test1(@PathVariable int a, @PathVariable String b, Model model) {

        model.addAttribute("msg","结果为："+ (a+b));
        return "test";
    }

    @PostMapping("/add/{a}/{b}")
    public String test2(@PathVariable int a, @PathVariable int b, Model model) {

        model.addAttribute("msg","结果为："+ (a+b));
        return "test";
    }
}
