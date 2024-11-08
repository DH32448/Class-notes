package cn.tom.cn.tom.dao;

import cn.tom.entity.Course;
import cn.tom.tool.Jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CourseDao {
    public int add(Course c) {
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int ret = 0;
        try {
            cn = Jdbc.getCn();
            // 发送 SQL 语句
            StringBuilder sql = new StringBuilder();
            sql.append("insert into t_course(cno, cname, tid) values (?,?,?)");
            ps = cn.prepareStatement(sql.toString());
            ps.setObject(1, c.getCno());
            ps.setObject(2, c.getCname());
            ps.setObject(3, c.getTid());
            // 执行 更新
            ret = ps.executeUpdate();   //execute 执行 Update 更新
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        Jdbc.close(cn, ps, rs);
        return ret;
    }
    //更新
    public int update(Course c) {
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int ret = 0;
        try {
            cn = Jdbc.getCn();
            // 发送 SQL 语句
            StringBuilder sql = new StringBuilder();
            sql.append("update t_course set cname=?, tid=? where cno=?");
            ps = cn.prepareStatement(sql.toString());
            ps.setObject(3, c.getCno());
            ps.setObject(1, c.getCname());
            ps.setObject(2, c.getTid());
            // 执行 更新
            ret = ps.executeUpdate();   //execute 执行 Update 更新
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        Jdbc.close(cn, ps, rs);
        return ret;
    }
    //删除
    public int removeByID(String cno) {
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int ret = 0;
        try {
            cn = Jdbc.getCn();
            // 发送 SQL 语句
            StringBuilder sql = new StringBuilder();
            sql.append("delete  from t_course  where cno=?");
            ps = cn.prepareStatement(sql.toString());
            ps.setObject(1, cno);
            // 执行 更新
            ret = ps.executeUpdate();   //execute 执行 Update 更新
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        Jdbc.close(cn, ps, rs);
        return ret;
    }
    //查找单条
    public Course findById(String cno)  {
        List<Course> lst = new ArrayList<>();
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            cn = Jdbc.getCn();
            // 发送 SQL 语句
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT * FROM t_course where cno=?");
            ps = cn.prepareStatement(sql.toString());
            ps.setObject(1, cno);
            // 执行 SELECT  查询
            rs = ps.executeQuery();   //execute 执行 Query 查询
            // Result 结果， set 集合， 遍历

            if (rs.next()) {
                Course c = new Course();
                c.setCno(rs.getString("cno"));
                c.setCname(rs.getString("cname"));
                c.setTid(rs.getString("tid"));
                return c;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        Jdbc.close(cn, ps, rs);
        return null;
    }

    //查找所有
    public List<Course> findAll()  {
        List<Course> lst = new ArrayList<>();
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            cn = Jdbc.getCn();
            // 发送 SQL 语句
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT * FROM t_course");
            ps = cn.prepareStatement(sql.toString());
            // 执行 SELECT  查询
            rs = ps.executeQuery();   //execute 执行 Query 查询
            // Result 结果， set 集合， 遍历

            while (rs.next()) {
                Course c = new Course();
                c.setCno(rs.getString("cno"));
                c.setCname(rs.getString("cname"));
                c.setTid(rs.getString("tid"));
                lst.add(c);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        Jdbc.close(cn, ps, rs);
        return lst;
    }
}
