package cn.tom.entity;

public class TaskInfo {
    private int kid;
    private int tid;   //教师编号
    private String uname;  //教师名称
    private String clzno;   //班级编号
    private String clzname;  //班级名称
    private String cno;      //课程编号
    private String cname;   //课程名称

    public int getKid() {
        return kid;
    }

    public void setKid(int kid) {
        this.kid = kid;
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

    @Override
    public String toString() {
        return "TaskInfo{" +
                "kid=" + kid +
                ", tid=" + tid +
                ", uname='" + uname + '\'' +
                ", clzno='" + clzno + '\'' +
                ", clzname='" + clzname + '\'' +
                ", cno='" + cno + '\'' +
                ", cname='" + cname + '\'' +
                '}';
    }
}
