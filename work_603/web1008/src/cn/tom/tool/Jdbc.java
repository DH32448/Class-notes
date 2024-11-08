package cn.tom.tool;

import java.sql.*;

//JDBC 测试类
/* 0. 加载驱动， 只需加载
   1.建立连接
   2. 创建 SQL 指令  PreparedStatement
 */
// 查询
/*  executeQuery();
    单个对象

    多个对象
*/
// 增加  修改  删除
/*
   executeUpdate();
   单条操作为主
 */
// 关闭


//工具类的一般用 static 修饰成员变量和方法
public class Jdbc {
    private final static String db="abc";
    private final static String driver = "com.mysql.jdbc.Driver";  //Driver 驱动程序
    private static String url = "jdbc:mysql://127.0.0.1:3305/";
    private final static String username="root";
    private final static String password="123456";
    //0. 加载驱动
    static {
        try {
            System.out.println("加载驱动");
            url = url + db + "?useUnicode=true&characterEncoding=utf8&useSSL=false";
            Class.forName(driver);
        } catch (Exception e) {
            System.out.println("加载驱动失败。。。 mysql-connnector-java 没有添加到库");
        }
    }

    //1. 获取连接
    // 获取连接
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    // 最后释放连接资源
    public static void close(Connection conn, PreparedStatement ps, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
