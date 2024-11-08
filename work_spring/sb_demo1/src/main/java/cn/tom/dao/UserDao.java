package cn.tom.dao;

import org.springframework.stereotype.Component;

// id 默认值就是类名称，第一个改小写
@Component("userDao")
public class UserDao {
    public UserDao() {
        System.out.println("UserDao() 构造方法被调用了");
    }

    public void add() {
        System.out.println("添加一个用户...");
    }
}
