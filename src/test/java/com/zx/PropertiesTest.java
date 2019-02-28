package com.zx;

import com.zx.config.NeoProperties;
import com.zx.config.OtherProperties;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Created by 11790 on 2019/2/20.
 @RunWith就是一个运行器
 @RunWith(JUnit4.class)就是指用JUnit4来运行
 @RunWith(SpringJUnit4ClassRunner.class),让测试运行于Spring测试环境
 @RunWith(Suite.class)的话就是一套测试集合
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PropertiesTest {
    @Value("${neo.title}")
    private String title;
    @Test
    public void testSingle(){
        //1. 如果两者一致, 程序继续往下运行. 2. 如果两者不一致, 中断测试方法, 抛出异常信息 AssertionFailedError
        Assert.assertEquals(title,"纯洁的微笑");
    }


    @Resource//通过该注解注入NeoProperties对象
    private NeoProperties properties;
    @Test
    public void testMore() throws  Exception{
        System.out.println("title:"+properties.getTitle());
        System.out.println("description:"+properties.getDescription());
    }

    @Resource
    private OtherProperties otherProperties;
    @Test
    public void testOther() throws Exception {
        System.out.println("title:"+otherProperties.getTitle());
        System.out.println("blog:"+otherProperties.getBlog());
    }

}
