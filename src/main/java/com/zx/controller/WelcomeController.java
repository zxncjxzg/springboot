package com.zx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by 11790 on 2019/2/23.
 */
@Controller
public class WelcomeController {

    @GetMapping("/user")//是@RequestMapping(method = RequestMethod.GET)的缩写
    public String user(Map<String,Object> model, HttpServletRequest request){
        model.put("username","neo");
        model.put("salary",666);
        request.getSession().setAttribute("count",6);
        return "user";//返回user.jsp页面
    }

}
