package cn.tom.week1;

public class Demo1 {
    public static void main(String[] args) {
        double x = 1.01;        //1.01
        int n = (int) x;
        System.out.println(n);  //1
        double x2 =   n;  //无需转型
        System.out.println(x2);  //1.0
        
    }
}
