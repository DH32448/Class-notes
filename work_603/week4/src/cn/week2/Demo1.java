package cn.week2;

import java.io.FileInputStream;
import java.io.InputStream;

//流  最小单位 1 个字节， 效率低
//流  用字节数组作为 流， 一般大小 1024  或者是 1024 的倍数 1K=1024字节
public class Demo1 {
    public static void main(String[] args) throws Exception {
        InputStream is = new FileInputStream("d:/work_605/Dog.java");
        byte[] buf = new byte[1024];
        int len= is.read( buf );
        // buf  引用传递  len 实际读取的内容长度
        // 预期读 1024 个字节， len < 1024 表示读完

        is.close();  //读取完毕， 关闭流操作

        System.out.println("length 长度=" + len);  //len 是 length 缩写

        System.out.println("====================UTF-8=====================");
        //String 构造方法， 可以把字节数组转为字符串
        String s = new String(buf, "UTF-8");
        //Java 默认 UTF-8 字符编码格式
        System.out.println(s);

        System.out.println("====================GBK=====================");
         s = new String(buf, "GBK"); //GBK 中国的国标码
        //Java 默认 UTF-8 字符编码格式
        System.out.println(s);

    }
}
