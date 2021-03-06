package com.zx.controller;

import com.zx.model.User1;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 11790 on 2019/1/15.
 */
@RestController
public class WebController {

    /**
     * @param user
     * @param result
     * 参数前面添加 @Valid 注解，代表此对象使用了参数校验
     * 参数校验的结果会存储在BindingResult对象中，可以根据属性判断是否校验通过，校验不通过可以将错误信息打印出来。
     */
    @RequestMapping("/saveUser")
    public void saveUser(@Valid User1 user, BindingResult result){
        System.out.println("user:"+user);
        if(result.hasErrors()){
            List<ObjectError> list=result.getAllErrors();
            for(ObjectError error:list){
                System.out.println(error.getCode()+"-"+error.getDefaultMessage());
            }
        }
    }

    @RequestMapping(name="/getUser", method= RequestMethod.GET)
    public User1 getUser() {
        User1 user=new User1();
        user.setName("小明");
        user.setAge(12);
        user.setPassword("123456");
        return user;
    }

    @RequestMapping("/getUsers")
    public List<User1> getUsers() {
        List<User1> users=new ArrayList<User1>();
        User1 user1=new User1();
        user1.setName("neo");
        user1.setAge(30);
        user1.setPassword("neo123");
        users.add(user1);
        User1 user2=new User1();
        user2.setName("小明");
        user2.setAge(12);
        user2.setPassword("123456");
        users.add(user2);
        return users;
    }
}
