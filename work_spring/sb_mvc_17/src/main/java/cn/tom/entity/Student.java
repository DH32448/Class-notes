package cn.tom.entity;

import java.util.Date;

public class Student {
    private String sno;
    private String sname;
    private String phone;
    private String clzno;
    private Date birthday;

    public Student() {
        System.out.println("Student() 构造方法");
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getClzno() {
        return clzno;
    }

    public void setClzno(String clzno) {
        this.clzno = clzno;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                ", phone='" + phone + '\'' +
                ", clzno='" + clzno + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
