package com.zx.web.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by 11790 on 2019/2/23.
 */
@Component//实例化加载进springboot容器中
@ConfigurationProperties(prefix = "neo")//通过该注解将springboot中配置文件中的对应参数组与以下类建立对应
public class NeoProperties {
    private String title;
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
