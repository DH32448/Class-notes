package cn.tom;

import cn.tom.dao.ClzDao;

public class DemoClzDao {

    ClzDao clzDao = new ClzDao();
    private int age=20;

    public DemoClzDao() {
        System.out.println("DemoClzDao()");
    }
    public static void main(String[] args) {

        System.out.println("main");

        System.out.println("new  DemoClzDao() ");
        new DemoClzDao();
    }
}
