package cn.week5;

//多线程
public class TheadDemo1 {
    public static void main(String[] args) {
        Thread x = new ThreadA();
        x.start();
        System.out.println("---------");
        Thread x2 = new ThreadA();
        x2.start();
        System.out.println("==========");

    }
}
