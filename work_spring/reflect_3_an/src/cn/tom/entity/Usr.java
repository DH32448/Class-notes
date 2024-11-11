package cn.tom.entity;

// 假设你数据库表名称 和 类没有对应关系

// 类对象.getSimplaeName() --->.  Usr  --> usr  --> t_usr  t_user

import cn.tom.anno.Table;

@Table(value = "t_user")
public class Usr {
    private int uid;

//    @Table("kkk")  //@Target   TYPE
    private String uname;
    private String phone;
    private String pwd;
    private Clz clz;
    private int role;
    public Usr() {
        uid= 0;
        uname = "";
        phone = "";
        pwd = "";
        role = 0;

    }

    public Clz getClz() {
        return clz;
    }

    public void setClz(Clz clz) {
        this.clz = clz;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
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


    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Usr{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", phone='" + phone + '\'' +
                ", pwd='" + pwd + '\'' +
                ", clz=" + clz +
                ", role=" + role +
                '}';
    }
}
