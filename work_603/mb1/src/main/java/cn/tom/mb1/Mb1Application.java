package cn.tom.mb1;

import cn.tom.mb1.entity.ClzDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


// Generated by https://start.springboot.io
// 优质的 spring/boot/data/security/cloud 框架中文文档尽在 => https://springdoc.cn
@SpringBootApplication
public class Mb1Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(Mb1Application.class, args);
        ClzDao clzDao = ((ConfigurableApplicationContext) ioc).getBean(ClzDao.class);
        System.out.println(clzDao.findAll());
    }
}
