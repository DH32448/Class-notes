package cn.tom.dao;

import cn.tom.entity.Course;
import cn.tom.tool.Jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            sql.append("insert into t_course(cno, cname) values (?,?)");
            ps = cn.prepareStatement(sql.toString());
            ps.setObject(1, c.getCno());
            ps.setObject(2, c.getCname());
            // 执行 更新
            ret = ps.executeUpdate();   //execute 执行 Update 更新
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        Jdbc.close(cn, ps, rs);
        return ret;
    }

    public int update(Course c) {
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int ret = 0;
        try {
            cn = Jdbc.getCn();
            // 发送 SQL 语句
            StringBuilder sql = new StringBuilder();
            sql.append("update t_course set  cname = ?  where cno=?");
            ps = cn.prepareStatement(sql.toString());
            ps.setObject(2, c.getCno());
            ps.setObject(1, c.getCname());
            // 执行 更新
            ret = ps.executeUpdate();   //execute 执行 Update 更新
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            Jdbc.close(cn, ps, rs);
        }
        return ret;
    }

    public Course findByCno(String cno)  {
        List<Course> lst = new ArrayList<>();
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Course c = null;
        try {
            cn = Jdbc.getCn();
            // 发送 SQL 语句
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT * FROM t_course where cno='" + cno + "'");
            ps = cn.prepareStatement(sql.toString());
            // 执行 SELECT  查询
            rs = ps.executeQuery();   //execute 执行 Query 查询
            // Result 结果， set 集合， 遍历

            if (rs.next()) {
                c = new Course();
                c.setCno(rs.getString("cno"));
                c.setCname(rs.getString("cname"));
                return  c;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            Jdbc.close(cn, ps, rs);
        }
        return c;
    }

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
                lst.add(c);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        Jdbc.close(cn, ps, rs);
        return lst;
    }

    public List<Map<String, Object>> findInfo()  {
        List<Map<String, Object>> lst = new ArrayList<>();
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            cn = Jdbc.getCn();
            // 发送 SQL 语句
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT c.cno, c.cname FROM t_course c");
            ps = cn.prepareStatement(sql.toString());
            // 执行 SELECT  查询
            rs = ps.executeQuery();   //execute 执行 Query 查询
            // Result 结果， set 集合， 遍历

            while (rs.next()) {
                Map<String, Object> m = new HashMap<>();
                m.put("cno", rs.getString("cno"));
                m.put("cname", rs.getString("cname"));
                lst.add(m);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            Jdbc.close(cn, ps, rs);
        }
        return lst;
    }
}
