package com.springbank.user.core.configuration;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RouterController {

    @RequestMapping({"/"})
    public String app() {
        return "forward:/swagger-ui.html";
    }
}