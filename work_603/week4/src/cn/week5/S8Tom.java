package cn.week5;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

//Tomcat 基于 Socket 实现， 传输数据格式是 HTTP 协议
// HTTP  协议（约定） 浏览器和Tomcat  SpringBoot  分布式  大数据  APP
// HTTP  走的都是字符
public class S8Tom {
    private static final int PORT = 8899;  //常量 监听的端口
    public static void main(String[] args) throws Exception {
        System.out.println("服务端： " + PORT );
        ServerSocket serverSocket = new ServerSocket(PORT);
        // 1. 相当接待小姐
        System.out.println("准备接待客人， 浏览器");
        Socket accept = serverSocket.accept();  //准备接待客人， 浏览器
        System.out.println("有客人来了， 输入流输出流");
        InputStream is = accept.getInputStream();  //输入字节流
        System.out.println("把字节流转成字符【行】流， HHTP协议走的就是字符 行流");
        InputStreamReader isr = new InputStreamReader(is); //字符流
        BufferedReader br = new BufferedReader(isr); // 转成一行一行的读
        for(;;) {
            String s = br.readLine();
            if (s == null || s.length()==0 ) {
                System.out.println("==============结束====================");
                break;
            }
            System.out.println(s);
        }
        // 只读取没有响应， 浏览器在等待你响应
        System.out.println("如何响应浏览器..... (HTTP)");

        Date d = new Date();
        String content="<h2>Hello.....</h2> + <h4>" + d.toString() + "<h4>";

        responseText(accept.getOutputStream(), content);

        accept.close();
        serverSocket.close();
   }
   // 响应要打 HTTP  包
    // request  请求-输入流， response 响应 - 输出流  content 内容  Type 格式
    public static void  responseText(OutputStream os, String content)  throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("HTTP/1.1 200 OK \r\n");    //append  追加, split
        sb.append("Content-Type:text/html;\r\n");
        sb.append("Content-length:" + content.length() + "\r\n" );
        sb.append("\r\n");
        sb.append(content);
        System.out.println("响应给浏览器的内容是");
        System.out.println(sb.toString());
        String  msg = sb.toString();
        //字符串转成 字节流
        byte[] buf = msg.getBytes();
        os.write(buf);
        os.flush();
    }
}
