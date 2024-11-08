package week3;

import week2.Stux;

public class DemoCaller {
    public static void main(String[] args) {
        //private final char value[];   //final 最终， 不可以改变它
        // 8 大基本数据类型 + String 都是值传递
        int n=100; double d=100.0; String s= "100";
        test1(n, d, s);
        System.out.println("n=" + n + "\td=" +d + "\ts=" +s );
        // 100 100.0 100  不变

        // 只要是 new 出来的（除 String）, 都是引用传递-地址传递
        int[] a={1,2,3};
        test2(a);
        for(int i=0;i <a.length; i++) System.out.println(a[i]);
        // 10 20 30
        Stux stux = new Stux();
        stux.name = "Tom";
        stux.height = 160;
        test3(stux);
        System.out.println(stux.getName());  //李世民
    }

    public static void test3(Stux x) {
        x.name= "李世民"; x.height=180;
    }
    public static void  test2(int[] a) {
        for(int i=0;i <a.length; i++) a[i] = a[i]*10;
    }
    public static void test1(int n, double d, String s) {
        n=101; d=101.0; s="101";
    }
}
