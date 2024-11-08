package cn.tom.entity;

import java.util.Date;

public class Mark {
    private int id;
    private String sno;
    private String cno;
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

    @Override
    public String toString() {
        return "Mark{" +
                "id=" + id +
                ", sno='" + sno + '\'' +
                ", cno='" + cno + '\'' +
                ", score=" + score +
                ", tpost=" + tpost +
                '}';
    }
}
