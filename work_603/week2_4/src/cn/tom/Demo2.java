package cn.tom;

public class Demo2 {
    public static void main(String[] args) {
        int n =50;
        try {
            n= 40;

            //System.out.println(1/0);
        } catch (Exception e) {
            System.out.println("catch");
            n=30;
            return;
        } finally {
            System.out.println("finally。。。");
            n=20;
        }
        System.out.println("n=" + n);
    }
}
