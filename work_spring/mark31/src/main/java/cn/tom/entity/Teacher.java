package cn.tom.entity;

import java.util.Date;

public class Teacher {
    private int tid;
    private String tname;
    private String phone;
    private String pwd;
    private double sal;
    private Date birth;

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public double getSal() {
        return sal;
    }

    public void setSalary(double sal) {
        this.sal = sal;
    }

    public Date getBirthday() {
        return birth;
    }

    public void setBirthday(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tid=" + tid +
                ", tname='" + tname + '\'' +
                ", phone='" + phone + '\'' +
                ", pwd='" + pwd + '\'' +
                ", sal=" + sal +
                ", birth=" + birth +
                '}';
    }
}
