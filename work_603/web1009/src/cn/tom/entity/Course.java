package cn.tom.entity;

public class Course {
    private Integer cid;
    private String cname;
    private int score;

    public void setCid(int cid) {
        this.cid = cid;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getCid() {
        return cid;
    }

    public String getCname() {
        return cname;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", score=" + score +
                '}';
    }
}
