package cn.tom.entity;

import java.text.SimpleDateFormat;
import java.util.*;

public class Teacher {
    private int tid;    //自动增长的主键 >0, 如果是 0 ， 表示添加， 如果>=1 , 表示修改， 不用包装类
    private String tname;
    private String phone;
    private String pwd;
    private Double sal;  //工资   0.0  也是一个正常的工资
    private Date birth;   //生日
    public Teacher() {
        System.out.println("Teacher()。。。。");
        birth = new Date(0);
    }

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

    public void setSal(double sal) {
        System.out.println("setSal().....=" + sal);
        sal = sal*10;
        this.sal = sal;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(String birth) throws Exception {
        System.out.println("setBirth().....");
        if (birth == null || birth.length()<10) {
            throw new Exception("日期空指针 或者日期输入长度不够" + birth);
        }
        SimpleDateFormat sdf;
        if (birth.indexOf("/")>0) {
            sdf = new SimpleDateFormat("MM/dd/yyyyy");
        } else {
            sdf = new SimpleDateFormat("yyyy-MM-dd");
        }
        Date date = sdf.parse(birth);
        this.birth = date;
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