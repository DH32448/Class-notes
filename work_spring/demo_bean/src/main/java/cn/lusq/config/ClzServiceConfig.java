package cn.lusq.config;

// 桥接 不是 本项目包的类（第三方）--->需要创建对象， 并且装配到 IOC 容器

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import xxx.xxx.service.ClzService;

import java.util.Date;

//@Component
// 专用 注解  @Configuration  (配置)
@Configuration
public class ClzServiceConfig {
    public ClzServiceConfig() {

        System.out.println( "ClzServiceConfig() ...");
    }

    @Bean   //调用 clzService() 方法，
    // 并且返回值类型对象装配到 IOC 容器
            // getBean(id), id = 就是方法名称
    public ClzService clzService() {
        System.out.println("调用：ClzServiceConfig.clzService()");
        return new ClzService();  //创建第三方对象
    }

    @Bean
    public java.util.Date myDate() {
        return new Date();
    }
}
