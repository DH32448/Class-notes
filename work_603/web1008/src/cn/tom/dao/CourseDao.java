package cn.tom.dao;

import cn.tom.entity.Course;
import cn.tom.tool.Jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//DAO  data  access  object  数据访问对象
//别使用 static  方法 .....
public class CourseDao {
    //根据主键修改如何写
    //update t_course set cname='KKKKKK', score=10 where cid=2;
    public  int update(Course c) throws Exception{
        //1. 获取连接
        Connection cn = Jdbc.getConnection();   //获取 abc 数据库连接
        //2. 写  SQL 语句
        String sql = "update t_course set cname=?, score=? where cid=?";
        //3. 创建 preparedStatement 对象 // 连接表
        PreparedStatement ps = cn.prepareStatement(sql);
        //4.给 ？  赋值， 如果多个 ？  从 1 开始数
        ps.setObject(1, c.getCname());
        ps.setObject(2, c.getScore());
        ps.setObject(3, c.getCid());
        //5. 发出更新指令(insert delete update） 【executeUpdate】 execute 执行  update 更新
        int ret = ps.executeUpdate();  //添加  删除  修改 都是用 executeUpdate();
        Jdbc.close(cn, ps, null);  // 关闭
        return ret;   // 被修改的记录数  0 表示没有修改成功  1 修改了 1 条 ， 2 修改了 2 条
    }

    //单条查询， 根据主键， 账号， 手机号， 身份证
    public  Course findByCid(int cid) throws Exception {
        //1. 获取连接
        Connection cn = Jdbc.getConnection();   //获取 abc 数据库连接
        //2. 写  SQL 语句
        String sql = "select cid, cname, score from t_course where cid=?";
        //3. 创建 preparedStatement 对象 // 连接表
        PreparedStatement ps = cn.prepareStatement(sql);
        //4.给 ？  赋值， 如果多个 ？  从 1 开始数
        ps.setObject(1, cid);
        //5. 发出查询指令 【executeQuery】 execute 执行  query 查询
        ResultSet rs = ps.executeQuery();  //查询的结果是一个集合
        //6. 判断结果里面是不是有记录
        if (rs.next()) {   // .next()  读取第一条, 别循环
            // 7.1 创建一个对象
            Course c = new Course();
            int cid2 = rs.getInt("cid");
            String cname = rs.getString("cname");
            int score = rs.getInt("score");
            c.setCid(cid2);
            c.setCname(cname);
            c.setScore(score);
            Jdbc.close(cn, ps, rs);   //关闭连接 Socket
            return c;
        }
        return null;   //没有的话的 null
    }

    //多条查询， 根据主键， 账号， 手机号， 身份证
    public  List<Course> findAll() throws Exception {

        List<Course> lst = new ArrayList<>();  // new 一次
        //1. 获取连接
        Connection cn = Jdbc.getConnection();   //获取 abc 数据库连接
        //2. 写  SQL 语句
        String sql = "select cid, cname, score from t_course";  //无条件
        //3. 创建 preparedStatement 对象 // 连接表
        PreparedStatement ps = cn.prepareStatement(sql);
        //4.给 ？  赋值， 如果多个 ？  从 1 开始数
        //ps.setObject(1, cid);
        //5. 发出查询指令 【executeQuery】 execute 执行  query 查询
        ResultSet rs = ps.executeQuery();  //查询的结果是一个集合
        //6. 判断结果里面是不是有记录
        while (rs.next()) {   // .next()  通过循环操作
            // 7.1 创建一个对象
            Course c = new Course();
            int cid2 = rs.getInt("cid");
            String cname = rs.getString("cname");
            int score = rs.getInt("score");
            c.setCid(cid2);
            c.setCname(cname);
            c.setScore(score);
            lst.add(c);
        }
        Jdbc.close(cn, ps, rs);   //关闭连接 Socket
        return lst;
    }
}
