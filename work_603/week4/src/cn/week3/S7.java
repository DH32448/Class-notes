package cn.week3;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

//服务端  Server  服务
public class S7 {
    public static void main(String[] args) throws IOException {
        System.out.println("========1.创建接收管道，注册端口============");
        //1.创建接收管道，注册端口, 0.0.0.0 IP 地址
        ServerSocket serverSocket = new ServerSocket(7777);//参数一：定义服务端口
        //2.等待管道连接
        System.out.println("========2.等待管道连接============");
        Socket accept = serverSocket.accept();
        // accept  接待客人
        //3.从管道中获取一个字节输入流
        System.out.println("========3. 有客户端连进来， 去读取网络内容， 用的输入流============");
        InputStream is = accept.getInputStream();
        //4.字节流升级生缓冲输入流
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        //5.按照行读取消息会更好
        String a;
        while ((a = br.readLine())!=null){
            System.out.println(accept.getRemoteSocketAddress()+"==>"+a);
        }
        is.close();
        accept.close();
        serverSocket.close();
    }
}