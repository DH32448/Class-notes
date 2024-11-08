package cn.tom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@SpringBootApplication
public class Myb31vs1Application {

    public static void main(String[] args) {

        ConfigurableApplicationContext ioc =
                SpringApplication.run(Myb31vs1Application.class, args);

        /**  starter  启动器
         *  <dependency>
         *             <groupId>org.springframework.boot</groupId>
         *             <artifactId>spring-boot-starter-web</artifactId>
         *         </dependency>
         */
        DispatcherServlet bean = ioc.getBean(DispatcherServlet.class);

        System.out.println(bean);
        //org.springframework.web.servlet.DispatcherServlet@7daa61f3
    }

}
