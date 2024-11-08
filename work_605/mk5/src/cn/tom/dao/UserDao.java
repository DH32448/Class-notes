package cn.tom.dao;

import cn.tom.entity.User;
import cn.tom.tool.Jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDao {
    public int update(User u) {
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int ret = 0;
        try {
            cn = Jdbc.getCn();
            // 发送 SQL 语句
            StringBuilder sql = new StringBuilder();
            sql.append("update t_user set " );
            sql.append(" uname=?, " );
            sql.append(" phone=?, " );
            sql.append(" pwd=?, " );
            sql.append(" role=?, " );
            sql.append(" clzno=? " );
            sql.append(" where uid=?" );
            ps = cn.prepareStatement(sql.toString());
            ps.setObject(1, u.getUname());
            ps.setObject(2, u.getPhone());
            ps.setObject(3, u.getPwd());
            ps.setObject(4, u.getRole());
            ps.setObject(5, u.getClzno());
            ps.setObject(6, u.getUid());
            // 执行 更新
            ret = ps.executeUpdate();   //execute 执行 Update 更新
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            Jdbc.close(cn, ps, rs);
        }
        return ret;
    }

    public int add(User u) {
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int ret = 0;
        try {
            cn = Jdbc.getCn();
            // 发送 SQL 语句
            StringBuilder sql = new StringBuilder();
            sql.append("insert into t_user(uname,phone,pwd,clzno , role) " );
            sql.append(" values (?, ?,?,?,?) ");
            ps = cn.prepareStatement(sql.toString());
            ps.setObject(1, u.getUname());
            ps.setObject(2, u.getPhone());
            ps.setObject(3, u.getPwd());
            ps.setObject(4, u.getClzno());
            ps.setObject(5, u.getRole());

            // 执行 更新
            ret = ps.executeUpdate();   //execute 执行 Update 更新
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        Jdbc.close(cn, ps, rs);
        return ret;
    }


    public int remove(int uid) {
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int ret = 0;
        try {
            cn = Jdbc.getCn();
            // 发送 SQL 语句
            StringBuilder sql = new StringBuilder();
            sql.append("delete from t_user where uid=?");
            ps = cn.prepareStatement(sql.toString());
            ps.setObject(1, uid);
            // 执行 更新
            ret = ps.executeUpdate();   //execute 执行 Update 更新
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        Jdbc.close(cn, ps, rs);
        return ret;
    }

    // clzno == null or clzno == ""   查询全部
    public User findOne( Integer uid, String phone)  {
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User u = null;
        try {
            cn = Jdbc.getCn();
            // 发送 SQL 语句
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT * FROM t_user where 1=1");
            if (uid!=null ) {
                sql.append(" AND uid= " + uid + "");
            }
            if (phone!=null && phone.length()>0) {
                sql.append(" AND phone= '" + phone + "'");
            }
            System.out.println(sql.toString());
            ps = cn.prepareStatement(sql.toString());
            // 执行 SELECT  查询
            rs = ps.executeQuery();   //execute 执行 Query 查询
            // Result 结果， set 集合， 遍历

            if (rs.next()) {
                u = new User();
                u.setUid(rs.getInt("uid"));
                u.setUname(rs.getString("uname"));
                u.setPhone(rs.getString("phone"));
                u.setPwd(rs.getString("pwd"));
                u.setClzno(rs.getString("clzno"));
                u.setRole(rs.getInt("role"));
                return u;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Jdbc.close(cn, ps, rs);
        }
        return u;
    }

    // clzno == null or clzno == ""   查询全部
    public List<User> findAll( String  clzno, Integer role)  {
        List<User> lst = new ArrayList<>();
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            cn = Jdbc.getCn();
            // 发送 SQL 语句
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT * FROM t_user where 1=1 ");
            if (clzno!=null && clzno.length()>0) {
                sql.append(" AND clzno= '" + clzno + "'");
            }
            if (role!=null ) {
                sql.append(" AND  role= " + role );
            }
            ps = cn.prepareStatement(sql.toString());
            // 执行 SELECT  查询
            rs = ps.executeQuery();   //execute 执行 Query 查询
            // Result 结果， set 集合， 遍历

            while (rs.next()) {
                User u = new User();
                u.setUid(rs.getInt("uid"));
                u.setUname(rs.getString("uname"));
                u.setPhone(rs.getString("phone"));
                u.setPwd(rs.getString("pwd"));
                u.setClzno(rs.getString("clzno"));
                u.setRole(rs.getInt("role"));
                lst.add(u);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        Jdbc.close(cn, ps, rs);
        return lst;
    }

    // 采用动态条件查询 + 表连接
    public List<Map<String, Object>> findStudents( String  clzno, String phone, String name)  {
        List<Map<String, Object>> lst = new ArrayList<>();
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            cn = Jdbc.getCn();
            // 发送 SQL 语句
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT s.*, c.clzname FROM t_user s, t_clz c where s.clzno = c.clzno  and role = 1 ");
            if (clzno!=null && clzno.length()>0) {
                sql.append(" AND s.clzno= '" + clzno + "' ");
            }
            if (phone!=null && phone.length()>0) {
                sql.append(" AND s.phone like '" + phone + "%' ");
            }
            if (name!=null && name.length()>0) {
                sql.append(" AND s.sname like '" + name + "%' ");
            }
            System.out.println(sql.toString());
            ps = cn.prepareStatement(sql.toString());
            // 执行 SELECT  查询
            rs = ps.executeQuery();   //execute 执行 Query 查询
            // Result 结果， set 集合， 遍历

            while (rs.next()) {
                Map<String, Object> m = new HashMap<>();
                m.put("uid", rs.getInt("uid"));
                m.put("uname", rs.getString("uname"));
                m.put("phone",rs.getString("phone"));
                m.put("pwd", rs.getString("pwd"));
                m.put("clzno", rs.getString("clzno"));
                m.put("clzname", rs.getString("clzname"));
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
