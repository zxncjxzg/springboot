package com.zx;

import com.zx.web.HelloController;
import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.exceptions.ExceptionIncludingMockitoWarnings;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * 在类的上面添加 @SpringBootTest，系统会自动加载 Spring Boot 容器。在日常测试中，可以注入 bean 来做一些局部的业务测试。
 * MockMvcRequestBuilders 可以支持 post、get 请求，使用 print() 方法会将请求和相应的过程都打印出来
 */
@SpringBootTest
public class HelloTest {
    private MockMvc mockMvc;

    //@Before 注解的方法表示在测试启动的时候优先执行，一般用作资源初始化。
    @Before
    public void setUp() throws Exception{
        mockMvc= MockMvcBuilders.standaloneSetup(new HelloController()).build();
    }

    //.accept(MediaType.APPLICATION_JSON_UTF8)) 这句是设置 JSON 返回编码，避免出现中文乱码的问题。
    @Test
    public void getHello() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/hello").accept(MediaType.APPLICATION_JSON_UTF8)).andDo(print());
    }
}
