package cn.tom;

public class Demo {
    public static void main(String[] args) {
        String  s1 = "中华人民";
        char c1= '中';
        char c2= '人';
        int  clzno = 101;
        String clzname = "IT1班";
        int num = 38;
        int[] arr = new int[10];
        System.out.println(arr.length  == 10);   // true
        arr[9] = 9;
        arr[10] = 10;   //IndexOutofBoundException 数组下标越界遗产

        Clz[] arr2 = new Clz[10];

        arr2[0].n  =  10;   //这样写可以吗？

        System. out.println("AAAAAAAA");
    }
}
