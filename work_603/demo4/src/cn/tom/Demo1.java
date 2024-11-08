package cn.tom;

public class Demo1 {
    public static void main(String[] args) {
        String s = "";  // ctrl + 鼠标左键
        Object obj= new Object();

        String[] a = new String[1];

        a[0]= "abc"; //?

        String msg = "abc";

        System.out.println("没有 new 的时候， == 打印出来可能是 true");
        System.out.println(a[0] == msg);
        System.out.println(" new 的时候，  == 打印出来可能是 false");
        String s2 = new String("abc");
        System.out.println("s2=" +s2);
        System.out.println(a[0] == s2);
        System.out.println(" new 的时候，  equals 打印出来是 true");
        System.out.println(a[0].equals(s2));


        System.out.println("传递前:" + msg  + "数组a=" + a[0]);  //abc
        doA(msg, a);
        System.out.println("传递后:" + msg  + "数组a=" + a[0]);  //abc
    }
    public static void  doA(String msg, String[] a ) {
        msg = "000";
        a[0] = "000";
    }
}
