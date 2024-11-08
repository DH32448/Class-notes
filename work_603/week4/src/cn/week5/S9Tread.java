package cn.week5;

import java.io.*;
import java.net.Socket;
import java.util.Date;

public class S9Tread extends Thread {
    private Socket accept = null;
    public S9Tread(Socket accept) {
        this.accept = accept;
    }

    @Override
    public void run()  {
       //获取输入流， 读， 写
       try {
           System.out.println("有客人来了， 输入流输出流");
           InputStream is = accept.getInputStream();  //输入字节流
           System.out.println("把字节流转成字符【行】流， HHTP协议走的就是字符 行流");
           InputStreamReader isr = new InputStreamReader(is); //字符流
           BufferedReader br = new BufferedReader(isr); // 转成一行一行的读
           ////循环加哪里 位置2
           for (; ; ) {
               String s = br.readLine();
               if (s == null || s.length() == 0) {
                   System.out.println("==============结束====================");
                   break;
               }
               System.out.println(s);
           }
           // 只读取没有响应， 浏览器在等待你响应
           System.out.println("如何响应浏览器..... (HTTP)");

           Date d = new Date();
           String content = "<h2>Hello.....</h2> + <h4>" + d.toString() + "<h4>";
           content = content + "<a href='/up'> 上页 </a>";
           content = content + "<a href='/next'> 下页 </a>";
           content = content + "<a> 首页</a>";
           content = content + "<a> 尾页 </a>";
           String  s3  = "<form method='GET' action='/move'>\n" +
                   "  <input type='submit' value-'第几页' /> \n" +
                   "  <input type='text' name='num' />\n" +
                   "</form>";
           content = content + s3;
           ////循环加哪里 位置3
           responseText(accept.getOutputStream(), content);
           accept.close();
           System.out.println("----------------------------");
       } catch (Exception e) {
           e.printStackTrace();
       }
    }

    public  void  responseText(OutputStream os, String content)  throws IOException {
        byte[] bytes = content.getBytes();

        StringBuilder sb = new StringBuilder();
        sb.append("HTTP/1.1 200 OK \r\n");    //append  追加, split
        sb.append("Content-Type:text/html; charset=UTF-8\r\n");
        sb.append("Content-length:" + bytes.length + "\r\n" );
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
