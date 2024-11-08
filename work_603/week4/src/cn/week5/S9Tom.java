package cn.week5;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

//Tomcat 基于 Socket 实现， 传输数据格式是 HTTP 协议
// HTTP  协议（约定） 浏览器和Tomcat  SpringBoot  分布式  大数据  APP
// HTTP  走的都是字符
public class S9Tom {
    private static final int PORT = 8899;  //常量 监听的端口
    public static void main(String[] args) throws Exception {
        System.out.println("服务端： " + PORT );
        ServerSocket serverSocket = new ServerSocket(PORT);
        // 1. 相当接待小姐
        System.out.println("准备接待客人， 浏览器");
        //循环加哪里 位置1
        for(;;) {
            System.out.println("准备接待客人， 浏览器");
            Socket accept = serverSocket.accept();
            //创建一个线程， 找个人服务客人
            Thread s9Tread = new S9Tread(accept);
            s9Tread.start(); //启动线程
            System.out.println("------ 启动线程----------------------");
        }
        //serverSocket.close();
   }
   // 响应要打 HTTP  包
    // request  请求-输入流， response 响应 - 输出流  content 内容  Type 格式

}
