package cn.tom;

import cn.tom.dao.ClzDao;
import cn.tom.entity.Clz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;


@SpringBootApplication    //Ctrl + 鼠标
public class Mark31Application {
    public static void main(String[] args) {
        //ConfigurableApplicationContext ioc = SpringApplication.run(Mark31Application.class, args);

        ConfigurableApplicationContext ioc = SpringApplication.run(Mark31Application.class, args);//启动 IOC 容器
////        @Autowired
////        ClzDao clzDao; //从 IOC 容器取出clzDao 这个类型对象
//        ClzDao clzDao = ioc.getBean(ClzDao.class);
//        System.out.println("clzDao=" + clzDao);  //代理对象， ClzDao 是个接口（无法创建对象)
//        List<Clz> all = clzDao.findAll();
//        System.out.println(all);
//        //jdbcTemplate
//        JdbcTemplate jdbc = ioc.getBean(JdbcTemplate.class);
//        List<Map<String, Object>> list = jdbc.queryForList("select * from t_teacher");
//        System.out.println("====================老师=========");
//        System.out.println(list);
//
//        System.out.println("========================================");
//        String[] names = ioc.getBeanDefinitionNames();
//        for(String name: names) System.out.println(name);
    }
}
