package cn.week2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

//如何字符流读取文件，
//方式一： 支持指定编码方式
public class Demo3 {
    public static void main(String[] args) throws Exception {
        // 1. 字节流去读
        InputStream is = new FileInputStream("D:/work_605/Dog.java");

        // 2. 把字节流转为字符流（ 装饰模式 ）， 指定 字符编码 GBK/UTF-8
        InputStreamReader isr = new InputStreamReader(is, "GBK");

        // 3. 字符行流， 读取文本文件， 通常是一行一行的读 \r\n
        BufferedReader br =
                new BufferedReader(isr);

        String s = null;   //对象变量就是保存对象地址（整数）
        for (; ; ) {
            s = br.readLine();  //返回  null 表示读到文件最后一行的后面
           System.out.println(s);
           if (s == null) { //读取完毕
               break;
           }
        }
        br.close();
        isr.close();
        is.close();  //关闭文件
    }
}
