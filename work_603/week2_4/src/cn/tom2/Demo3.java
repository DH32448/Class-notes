package cn.tom2;

import java.util.Random;

public class Demo3 {
    public static void main(String[] args) {
        Random rnd = new Random();

        for (int i = 0; i < 5; i++) {
            System.out.println(rnd.nextInt(10));  // 0 ~9
        }
        //产生 50 ~100 之间   5 个随机数
        for (int i = 0; i < 5; i++) {
            System.out.println(50+ rnd.nextInt(51));  // 0 ~9
        }

        String s= "采用四言体例对姓氏进行了排列而且句句押韵虽然它的内容没有文理";  //随机产生人的名字 3 个字
        //产生 100 个

        System.out.println(s.charAt(1));

        long t1 = System.currentTimeMillis();
         for(int i=0; i<3000; i++) {
             int n = rnd.nextInt(s.length());
             int n2 = rnd.nextInt(s.length());
             int n3 = rnd.nextInt(s.length());
             System.out.println( "" + s.charAt(n ) +
                     s.charAt( n2) +
                     s.charAt( n3));
         }
        long t2 = System.currentTimeMillis();
        System.out.println("t2=" + t2);  //t2  1970 1  1 到当前的毫秒数
        System.out.println(t2-t1);   // 1秒 == 1000 毫秒

        t2 = t2/1000;  //秒
        t2 = t2 /(24*60*60);  //天
        System.out.println("天=" + t2);
        System.out.println("年=" + (t2/365 + 1970));

    }
}
