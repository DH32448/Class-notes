package cn.tom.dao;

import org.springframework.stereotype.Component;

//Component 组件
@Component
public class ClzDao {
    //无参数构造方法： 和类同名， 创建对象时会被调用
    // 对象变量 =  new 构造方法（）;

    public ClzDao() {

        System.out.println("ClzDao() 无参数构造被调用...");
    }
    public void add() {
        System.out.println("班级保存....");
    }
}
