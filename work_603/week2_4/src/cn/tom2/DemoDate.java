package cn.tom2;

import java.util.Date;

public class DemoDate {
    public static void main(String[] args) {
        Date d = new Date();
        System.out.println(d);
        System.out.println(System.currentTimeMillis());  // current 当前的  简写 cur
        System.out.println(d.getTime());  //1970 01 01 到现在毫秒数

        d = new Date(System.currentTimeMillis()-100000000000L);
        System.out.println(d);
    }
}
