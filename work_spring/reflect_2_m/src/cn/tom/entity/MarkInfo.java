package cn.tom.entity;

import java.util.Date;

public class MarkInfo {
    private int id;
    private String sno;   //t_user.phone
    private String sname;    //学生姓名
    private String clzno;  //班级名称
    private String clzname;  //班级编号
    private String cno;//课程编号
    private String cname;  //课程名称
    private double score;  //分数
    private Date tpost;
    private int  tid;      //登分教师ID
    private String  uname;      //登分教师名称

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getClzno() {
        return clzno;
    }

    public void setClzno(String clzno) {
        this.clzno = clzno;
    }

    public String getClzname() {
        return clzname;
    }

    public void setClzname(String clzname) {
        this.clzname = clzname;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Date getTpost() {
        return tpost;
    }

    public void setTpost(Date tpost) {
        this.tpost = tpost;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    @Override
    public String toString() {
        return "MarkInfo{" +
                "id=" + id +
                ", sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                ", clzno='" + clzno + '\'' +
                ", clzname='" + clzname + '\'' +
                ", cno='" + cno + '\'' +
                ", cname='" + cname + '\'' +
                ", score=" + score +
                ", tpost=" + tpost +
                ", tid=" + tid +
                ", uname='" + uname + '\'' +
                '}';
    }
}
