package cn.tom.entity;

import java.util.Date;

public class MarkInfo {
    private int id;
    private String sno;
    private String sname;
    private String clzno;
    private String clzname;
    private String cno;
    private String cname;
    private double score;
    private Date tpost;

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
                '}';
    }
}
