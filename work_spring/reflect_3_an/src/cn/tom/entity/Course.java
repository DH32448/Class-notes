package cn.tom.entity;

import cn.tom.anno.Table;

@Table("t_ke")
public class Course {
    private String cno;
    private String cname;
    public Course() {
        cno = "";
        cname = "";
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
        return "Course{" +
                "cno='" + cno + '\'' +
                ", cname='" + cname + '\'' +
                '}';
    }
}
