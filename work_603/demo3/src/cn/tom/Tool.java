package cn.tom;

import java.util.Scanner;

public class Tool {
    static Scanner sc = new Scanner(System.in);
    public static int  getInt(String msg) {
        System.out.println(msg);
        int n= sc.nextInt();
        return n;
    }

    public static  String getSting(String msg) {
        System.out.println(msg);
        String s = sc.next();
        return s;
    }
    public static  double getDouble(String msg) {
        System.out.println(msg);
        double d = sc.nextDouble();
        return d;
    }
}

