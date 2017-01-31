package com.heroku.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/debug")
public class DebugController {


    @RequestMapping
    public String debug() {
        return "debugging page?";
    }
}
