package cn.week4;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

//客户端
public class C7Talk {
    public static void main(String[] args) throws Exception {
        System.out.println("和服务端建立连接");
        System.out.println("指定服务器及端口");
        Socket socket =
                new Socket("127.0.0.1", 9999);

        System.out.println("连接通道已经建立:" + socket);
        //获取输出流， 介绍自己

        OutputStream os =
                socket.getOutputStream();
        String msg = "我是陆世全...";
        byte[] bytes = msg.getBytes();
        os.write(bytes);
        os.flush();
        //读取内容
        InputStream is = socket.getInputStream();
        byte[] buf = new byte[1024*8];
        int len = is.read(buf);
        System.out.println(new String(buf));
        socket.close();
    }
}
