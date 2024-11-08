package cn.tom.entity;

//课程的实体类  在 entity 的包下
public class Course {
    private int cid;      //主键
    private String cname;  //课程名称
    private int score;    //学分

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
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
