package com.zx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 11790 on 2019/2/24.
 */
@Controller
public class NewController {
    @RequestMapping("/")
    public String index(ModelMap map) {
        map.addAttribute("message", "http://www.ityouknow.com");
        return "new";
    }
}
