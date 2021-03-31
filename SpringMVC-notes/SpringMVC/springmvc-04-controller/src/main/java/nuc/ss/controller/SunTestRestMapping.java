package nuc.ss.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sun")
public class SunTestRestMapping {

    @RequestMapping(value = "/hello")
    public String hello(){
        return "hello";
    }
}
