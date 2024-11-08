package cn.week2;

import java.io.IOException;
import java.io.PrintWriter;

//字符写文件， PrintWriter, UTF-8 编码
public class Demo5 {
    public static void main(String[] args) throws IOException {
        PrintWriter pr =
                new PrintWriter("D:/work_605/22.txt");

        for(int i=0; i<100; i++) {
            System.out.println("AA"+ (i+1));
            pr.println("AA"+ (i+1));
        }
        pr.flush();  //把缓存刷新到硬盘
        pr.close();
    }
}
