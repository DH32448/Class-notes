package cn.week3;

import java.net.*;
public class Demo1 {

        public static void main(String[] args) throws Exception {
            //1.获取本机地址ip对象
            InetAddress ip1 = InetAddress.getLocalHost();
            System.out.println(ip1.getHostName());//获取主机名字
            System.out.println(ip1.getHostAddress());//获取ip地址
            //2.获取域名ip对象
            InetAddress ip2 = InetAddress.getByName("www.baidu.com");
            System.out.println(ip2.getHostName());//获取域名
            System.out.println(ip2.getHostAddress());//获取域名的ip地址
            //3.获取公网对象
            InetAddress ip3 = InetAddress.getByName("114.114.114.114");  //8.8.8.8
            System.out.println(ip3.getHostName());//获取公网名字
            System.out.println(ip3.getHostAddress());//获取公网ip地址
            //判断网络是否能连接通信 ping 5s之前测试是否能通过
            System.out.println(ip3.isReachable(5000));//通过会返回true
        }

}
