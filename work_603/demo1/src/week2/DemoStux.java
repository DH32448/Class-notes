package week2;

public class DemoStux {
    public static void main(String[] args) {
        Stux x1 = new Stux();
        x1.height = 100;

        x1.name = "Tom";
        System.out.println("x1.name=" + x1.name);
        //用下列语句完成
        x1.setName("Tomx");
        System.out.println("x1.name=" + x1.name);
        System.out.println("x1.name=" + x1.getName());

        Stux[] arr = new Stux[10];

        avg( arr );
        System.out.println(arr[0].getName()); // Mike
        int n = 100; double d= 100.0;
        avg2( n, d);
        System.out.println("n=" + n + "   d=" + d);  // n =? d=?
    }
    public static void avg2(int n, double d) {
        n=101; d=101.0;
    }

    public static void avg(Stux[] a) {
        System.out.println("avg .................");
        System.out.println(a.length);  // 10
        a[0] = new Stux(); // 注意每个数组对象元素， 要创建对象
        a[0].setName("Mike");
    }
}
