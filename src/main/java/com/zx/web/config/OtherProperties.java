package com.zx.web.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by 11790 on 2019/2/23.
 */
@Component
@ConfigurationProperties(prefix="other")
@PropertySource("classpath:other.properties")//相对于springboot的默认配置文件，需要指定自定义配置文件的名称路径
public class OtherProperties {
    private String title;
    private String blog;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }
}
