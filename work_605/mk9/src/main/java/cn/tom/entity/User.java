package cn.tom.entity;

public class User {
    private int uid;
    private String uname;
    private String phone;
    private String pwd;
    private String clzno;
    //学生班级名称
    private  String clzname;
    private int role;
    public User() {
        uid= 0;
        uname = "";
        phone = "";
        pwd = "";
        clzno= "";
        role = 0;
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

    public String getClzno() {
        return clzno;
    }

    public void setClzno(String clzno) {
        this.clzno = clzno;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getClzname() {
        return clzname;
    }

    public void setClzname(String clzname) {
        this.clzname = clzname;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", phone='" + phone + '\'' +
                ", pwd='" + pwd + '\'' +
                ", clzno='" + clzno + '\'' +
                ", clzname='" + clzname + '\'' +
                ", role=" + role +
                '}';
    }
}
