package com.zx.web.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 11790 on 2019/1/27.
 */
@Configuration
public class WebConfiguration {

    @Bean
    public FilterRegistrationBean testFilterRegistration(){
        FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new MyFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setName("MyFilter");
        filterRegistrationBean.setOrder(6);
        return filterRegistrationBean;
    }

}
