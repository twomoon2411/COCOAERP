package kh.cocoa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/test")
    public String test() {
        return "document/c_writeDocument";
    }

    @RequestMapping("/test2")
    public String test2() {
        return "document/c_templateList";
    }
    @RequestMapping("/")
    public String home() {
        return "index";

    }

}