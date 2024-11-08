package cn.tom;

import cn.tom.controller.StuController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication
public class SbMvc17Application {

    public static void main(String[] args) throws SQLException {
        ConfigurableApplicationContext ioc = SpringApplication.run(SbMvc17Application.class, args);

        //Dis-pa-tcher ser-let
        DispatcherServlet bean = ioc.getBean(DispatcherServlet.class);
        StuController bean1 = ioc.getBean(StuController.class);
        System.out.println(bean1);
    }

}
