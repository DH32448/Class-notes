package cn.tom.entity;


public class Course {
    private String cno;   // 初始化 null
    private String cname; // 初始化 null

    //写个无参数构造方法
    public Course() {
        System.out.println("Course() 构造方法.....");
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
                '}' + "\r\n";
    }
}

// new Course()   --->  teacher = null