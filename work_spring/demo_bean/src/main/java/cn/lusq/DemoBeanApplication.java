package cn.lusq;

import cn.lusq.dao.UserDao;
import cn.lusq.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import xxx.xxx.service.ClzService;

@SpringBootApplication
public class DemoBeanApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext ioc = SpringApplication.run(DemoBeanApplication.class, args);

        DispatcherServlet obj = ioc.getBean(DispatcherServlet.class);
        System.out.println(obj);

        UserDao userDao = ioc.getBean(UserDao.class);
        System.out.println("UserDao=" + userDao);

        UserService u = ioc.getBean(UserService.class);
        System.out.println("userService=" + u);

        System.out.println("============userService.add==============");
        u.add();
        /*
        @Bean   //调用 clzService() 方法， 并且返回值类型对象装配到 IOC 容器
         public ClzService clzService() {
        System.out.println("调用：ClzServiceConfig.clzService()");
        return new ClzService();
    }
         */

        System.out.println("============第三方法 clzService 对象==============");
        System.out.println("按照类型获取");
        ClzService clzService = ioc.getBean(ClzService.class);
        clzService.add();

    }

}
