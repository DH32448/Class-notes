package cn.lusq.service;

// @Compoent  通用注解
// 服务层  @Service

import cn.lusq.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

// @Compoent  通用注解
// 服务层  @Service
@Service
public class UserService {
    //UserDao userDao = ioc.getBean(UserDao.class);
    @Autowired
    UserDao userDao;


    //UserDao userDao2 = ioc.getBean("userDao");
    @Resource(name="userDao")
    UserDao userDao2;

    public UserService() {
        System.out.println("UserService().....");
    }
    public void add() {
        System.out.println("UserService.add()..");
        userDao.add();
    }
}
