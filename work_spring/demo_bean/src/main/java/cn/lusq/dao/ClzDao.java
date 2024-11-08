package cn.lusq.dao;

import org.springframework.stereotype.Repository;

//@Component
// DAO  mybtais @Mapper
// DAO 通用注解 @Repository
@Repository   //id = 默认就是类名称（第一字母小写）
public class ClzDao {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ClzDao() {

        System.out.println("UserDao()....");
    }
    public void add() {
        System.out.println("Clz.add（）.....");
    }
    public void del() {
        System.out.println("Clz.del（）.....");
    }
}
