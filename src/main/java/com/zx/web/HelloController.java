package com.zx.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 11790 on 2019/1/15.
 * @RestController 的意思是 Controller 里面的方法都以 JSON 格式输出，不需要有其他额外的配置；如果配置为 @Controller，代表输出内容到页面
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "Hello world";
    }

}
