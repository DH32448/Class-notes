package cn.week2;

import java.io.BufferedReader;
import java.io.FileReader;

//如果没有编码的问题， 默认就是 UTF-8
public class Demo4 {
    public static void main(String[] args) throws Exception {
        FileReader fr = new FileReader("D:/work_605/Dog.java");

        //装修一下 BufferReader , 行流
        BufferedReader br = new BufferedReader(fr);

        //.....
    }
}
