package cn.week4;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

// S  Sever 服务端
public class S7Talk {
    public static void main(String[] args) throws Exception{
        //打开定义带某个端口 ServerSocket
        System.out.println("打开定义带某个端口 ServerSocket 9999");
        ServerSocket serverSocket =
                new ServerSocket(9999);
        for(;;) {
            System.out.println("准备接待客人");
            Socket accept = serverSocket.accept();
            System.out.println("有客人：" + accept.getRemoteSocketAddress());
            //读取 客户说了什么
            System.out.println("获取输入流....");
            InputStream is = accept.getInputStream();  //字节流
            byte[] buf = new byte[1024 * 8];
            int len = is.read(buf);
            System.out.println(new String(buf));  //把 buf 转成字符串
            //响应 客户端， 我知道了

            System.out.println("获取输出流");
            OutputStream os = accept.getOutputStream();
            String s = new Date() + "\r\n";
            s = s+ new String(buf) +"\r\n";
            s= s + "你来做什么???\r\n";
            System.out.println(s);
            os.write( s.getBytes());
            os.flush();
            os.close();
            is.close();
            accept.close();
        }
       // serverSocket.close();
    }
}
