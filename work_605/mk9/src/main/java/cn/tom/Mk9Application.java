package cn.tom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


// Generated by https://start.springboot.io
// 优质的 spring/boot/data/security/cloud 框架中文文档尽在 => https://springdoc.cn

@SpringBootApplication
public class Mk9Application {

    public static void main(String[] args) {

        ConfigurableApplicationContext ioc =
                SpringApplication.run(Mk9Application.class, args);

        DispatcherServlet obj = ioc.getBean(DispatcherServlet.class);

        System.out.println(obj);


    }

}
