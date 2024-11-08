package cn.lusq.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component
// DAO  mybtais @Mapper
// DAO 通用注解 @Repository
@Repository("userDao")   //id = 默认就是类名称（第一字母小写）
public class UserDao {
    public UserDao() {

        System.out.println("UserDao()....");
    }
    public void add() {
        System.out.println("UserDao.add（）.....");
    }
}
