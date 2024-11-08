package cn.tom.dao;

import cn.tom.entity.Clz;
import cn.tom.tool.Jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClzDao {
    public int add(Clz c) {
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int ret = 0;
        try {
            cn = Jdbc.getCn();
            // 发送 SQL 语句
            StringBuilder sql = new StringBuilder();
            sql.append("insert into t_clz(clzno, clzname) values (?,?)");
            ps = cn.prepareStatement(sql.toString());
            ps.setObject(1, c.getClzno());
            ps.setObject(2, c.getClzname());
            // 执行 更新
            ret = ps.executeUpdate();   //execute 执行 Update 更新
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        Jdbc.close(cn, ps, rs);
        return ret;
    }
    public  Clz findByClzno(String clzno)  {
        System.out.println("clzno=" + clzno);
        List<Clz> lst = new ArrayList<>();
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Clz c = null;
        try {
            cn = Jdbc.getCn();
            // 发送 SQL 语句
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT * FROM t_clz  where clzno = '" + clzno + "'");
            ps = cn.prepareStatement(sql.toString());
            // 执行 SELECT  查询
            rs = ps.executeQuery();   //execute 执行 Query 查询
            // Result 结果， set 集合， 遍历

            if (rs.next()) {
                c = new Clz();
                c.setClzno(rs.getString("clzno"));
                c.setClzname(rs.getString("clzname"));

            }
            return c;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            Jdbc.close(cn, ps, rs);
        }
        return c;
    }

    public int update(Clz c) {
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int ret = 0;
        try {
            cn = Jdbc.getCn();
            // 发送 SQL 语句
            StringBuilder sql = new StringBuilder();
            sql.append("update t_clz set clzname=? where clzno=?");
            ps = cn.prepareStatement(sql.toString());
            ps.setObject(2, c.getClzno());
            ps.setObject(1, c.getClzname());
            // 执行 更新
            ret = ps.executeUpdate();   //execute 执行 Update 更新
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            Jdbc.close(cn, ps, rs);
        }
        return ret;

    }
    public int remove(String clzno) {
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int ret = 0;
        try {
            cn = Jdbc.getCn();
            // 发送 SQL 语句
            StringBuilder sql = new StringBuilder();
            sql.append("delete from t_clz where clzno=?");
            ps = cn.prepareStatement(sql.toString());
            ps.setObject(1, clzno);
            // 执行 更新
            ret = ps.executeUpdate();   //execute 执行 Update 更新
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            Jdbc.close(cn, ps, rs);
        }
        return ret;

    }
    public  Clz findOne( String clzno)  {
        List<Clz> lst = new ArrayList<>();
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Clz c = null;
        try {
            cn = Jdbc.getCn();
            // 发送 SQL 语句
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT * FROM t_clz");
            ps = cn.prepareStatement(sql.toString());
            // 执行 SELECT  查询
            rs = ps.executeQuery();   //execute 执行 Query 查询
            // Result 结果， set 集合， 遍历

            if (rs.next()) {
                c = new Clz();
                c.setClzno(rs.getString("clzno"));
                c.setClzname(rs.getString("clzname"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            Jdbc.close(cn, ps, rs);
        }
        return c;
    }

    public  List<Clz> findAll()  {
        List<Clz> lst = new ArrayList<>();
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            cn = Jdbc.getCn();
            // 发送 SQL 语句
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT * FROM t_clz");
            ps = cn.prepareStatement(sql.toString());
            // 执行 SELECT  查询
            rs = ps.executeQuery();   //execute 执行 Query 查询
            // Result 结果， set 集合， 遍历

            while (rs.next()) {
                Clz c = new Clz();
                c.setClzno(rs.getString("clzno"));
                c.setClzname(rs.getString("clzname"));
                lst.add(c);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        Jdbc.close(cn, ps, rs);
        return lst;
    }
}
