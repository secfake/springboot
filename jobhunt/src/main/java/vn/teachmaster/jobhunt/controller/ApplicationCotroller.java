package vn.teachmaster.jobhunt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationCotroller {

    @GetMapping("/")
    public String getHome(){
        return "index";
    }
}
