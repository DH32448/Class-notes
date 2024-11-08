package cn.tom;

import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) throws Exception{
        Pig pig = new Pig();
        Scanner sc = new Scanner(System.in);
        for(;;) {
            try {
                System.out.println("请输入年龄");
                int age = sc.nextInt();
                pig.setAge(age);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("继续输入 0=放弃 1=继续");
                int x = sc.nextInt();
                if (x ==0 ) break;
            }
        }


        //test1();
        System.out.println("========================");
    }
    public static void test1() {
        String 是= null;
        try {  //开始监听， 开始监控
            System.out.println(5 / 0);


        } catch( Exception e  ) {  //JVM 主动调用方法
            System.out.println( e  );  //e.toString()
            System.out.println("----------getMessage-----------");
            System.out.println( e.getMessage());
            System.out.println("----------stackTrace-----------");
            e.printStackTrace();
        }
        System.out.println("========================");
    }
}
