package com.example.demoThymeleaf;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("/home")
    public  String hello(){
        return "hello";
    }
    @GetMapping(value = "/hi", produces = MediaType.TEXT_HTML_VALUE) // dang text html
    @ResponseBody
    public String hello() {
        return "<h1>Hello World</h1><h3>Cool</h3>";
    }

}
