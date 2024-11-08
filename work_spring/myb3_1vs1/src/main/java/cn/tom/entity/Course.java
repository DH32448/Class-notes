package cn.tom.entity;

//嵌套类
public class Course {
    private String cno;   // 初始化 null
    private String cname; // 初始化 null
    //private int tid;
    private Teacher teacher; // 初始化 null

    //写个无参数构造方法
    public Course() {
        System.out.println("Course() 构造方法.....");
        teacher = new Teacher();
        //初始化创建对象， 避免空指针
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

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cno='" + cno + '\'' +
                ", cname='" + cname + '\'' +
                ", teacher=" + teacher +
                '}';
    }
}

// new Course()   --->  teacher = null