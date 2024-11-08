package cn.week1;

import java.io.FileInputStream;
import java.io.InputStream;

public class Demo2 {
    public static void main(String[] args)  throws Exception{
        InputStream is = new FileInputStream("D:/work_605/Dog.java");

        //从头读到尾   is.read()  读到最后一个再去读（没有内容）返回 -1
        // 循环
        for (int i = 0;  ; i++) {
            int c = is.read();
            if (c  == -1) {   //读到最后一个， 再去读 -1 表示到文件的尾部
                System.out.println("读了几个字节:" + i);
                break;
            }
            System.out.print((char) c);
        }
        //用玩， 结束时候  关闭文件
        is.close();


//        int c = is.read();
//        System.out.println(c  + "==" + (char) c);
//        c = is.read();
//        System.out.println(c  + "==" + (char) c);
//        c = is.read();
//        System.out.println(c  + "==" + (char) c);
//        c = is.read();
//        System.out.println(c  + "==" + (char) c);
//        c = is.read();
//        System.out.println(c  + "==" + (char) c);
//        c = is.read();
//        System.out.println(c  + "==" + (char) c);
//        c = is.read();
//        System.out.println(c  + "==" + (char) c);

    }
}
