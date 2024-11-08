package cn.tom.tool;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Jdbc {
    //用户信息和url
    //xdx22 数据库名称， 根据需要改
    private static String url = "jdbc:mysql://localhost:3306/mark5" +
            "?useUnicode=true&characterEncoding=utf8&useSSL=false";
    private static String username = "root";
    private static String password = "123456";
    // 连接成功数据库对象
    static {
        // 加载驱动  com.mysql.jdbc.Driver
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            System.out.println("加载驱动失败");
        }
    }

    // 连接成功数据库对象
    public static  Connection getCn() throws Exception {
        Connection cn = DriverManager.getConnection(url, username, password);
        System.out.println("连接成功。。。。");
        return cn;
    }
    public static void close(Connection cn, PreparedStatement ps, ResultSet rs) {
        try {
            if ( rs!=null)  rs.close();
            if ( ps!= null) ps.close();
            if (cn!=null)  cn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
