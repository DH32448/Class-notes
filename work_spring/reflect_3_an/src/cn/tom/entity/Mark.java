package cn.tom.entity;

import java.util.Date;

public class Mark {
    private int id;
    private String sno;   //t_user.phone
    private String cno;   //课程编号
    private double score;  //分数
    private Date tpost;    //登分时间
    private int  tid;      //登分教师ID

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

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
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

    @Override
    public String toString() {
        return "Mark{" +
                "id=" + id +
                ", sno='" + sno + '\'' +
                ", cno='" + cno + '\'' +
                ", score=" + score +
                ", tpost=" + tpost +
                ", tid=" + tid +
                '}';
    }
}
