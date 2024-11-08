package cn.tom.dao;

import cn.tom.entity.Mark;
import cn.tom.entity.MarkInfo;
import cn.tom.tool.Jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MarkDao {
    Connection cn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    public void update(int id, double score) {
        try {
            cn = Jdbc.getCn();
            StringBuilder sql = new StringBuilder();
            sql.append("update t_mark set score=?  where id=?");
            System.out.println(sql.toString());
            ps = cn.prepareStatement(sql.toString());
            ps.setObject(1, score);
            ps.setObject(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Jdbc.close(cn, ps, rs);
        }
    }
    public void add(String sno, String cno, double score, Date tpost) {
        try {
            cn = Jdbc.getCn();
            StringBuilder sql = new StringBuilder();
            sql.append("insert into t_mark(sno, cno, score, tpost)");
            sql.append(" values(?,?,?,?) ");
            System.out.println(sql.toString());
            ps = cn.prepareStatement(sql.toString());
            ps.setObject(1, sno);
            ps.setObject(2, cno);
            ps.setObject(3, score);
            ps.setObject(4, tpost);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Jdbc.close(cn, ps, rs);
        }
    }
    public Mark findOne(String sno, String cno) {
            Mark m = null;
            try {
                cn = Jdbc.getCn();
                // 发送 SQL 语句
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT * FROM t_mark where sno= '" + sno + "' and cno='" + cno + "'");
                System.out.println(sql.toString());
                ps = cn.prepareStatement(sql.toString());
                // 执行 SELECT  查询
                rs = ps.executeQuery();   //execute 执行 Query 查询
                // Result 结果， set 集合， 遍历
                if (rs.next()) {
                    m = new Mark();
                    m.setId(rs.getInt("id"));
                    m.setSno( rs.getString("sno"));
                    m.setCno( rs.getString("cno"));
                    m.setScore( rs.getDouble("score"));
                    m.setTpost(rs.getDate("tpost"));
                    return m;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                Jdbc.close(cn, ps, rs);
            }
            return null;
    }
    /*
    SELECT t.*, z.clzname, m.id,m.`cno`,m.`score`,c.`cname` FROM t_student t
    INNER JOIN t_clz z ON t.`clzno` = z.`clzno`
    LEFT JOIN t_mark m ON  t.sno = m.sno
    LEFT JOIN t_course c ON m.`cno` = c.`cno`
    ORDER BY t.`clzno`, m.`cno`;
     */
    public List<MarkInfo> findInfo() {

        List<MarkInfo> lst = new ArrayList<>();
        try {
            cn = Jdbc.getCn();
            // 发送 SQL 语句
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT t.*, z.clzname, m.id,m.`cno`,m.`score`, m.tpost, c.`cname` FROM t_student t ");
            sql.append(" INNER JOIN t_clz z ON t.`clzno` = z.`clzno` ");
            sql.append(" LEFT JOIN t_mark m ON  t.sno = m.sno  ");
            sql.append(" LEFT JOIN t_course c ON m.`cno` = c.`cno` ");
            sql.append(" ORDER BY t.`clzno`, m.`cno` ");
            System.out.println(sql.toString());
            ps = cn.prepareStatement(sql.toString());
            // 执行 SELECT  查询
            rs = ps.executeQuery();   //execute 执行 Query 查询
            // Result 结果， set 集合， 遍历
            while (rs.next()) {
                MarkInfo m = new MarkInfo();
                m.setId(rs.getInt("id"));
                m.setScore(rs.getDouble("score"));
                m.setCname(rs.getString("cname"));
                m.setClzname(rs.getString("clzname"));
                m.setClzno(rs.getString("clzno"));
                m.setCno(rs.getString("cno"));
                m.setSno(rs.getString("sno"));
                m.setSname(rs.getString("sname"));
                m.setTpost(rs.getDate("tpost"));
                lst.add(m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Jdbc.close(cn, ps, rs);
        }
        return lst;
    }
}
