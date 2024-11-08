package cn.tom.entity;

public class User {
    private int uid;
    private String uname;
    private String phone;
    private String pwd;
    private Clz clz;
    private int role;
    public User() {
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
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", phone='" + phone + '\'' +
                ", pwd='" + pwd + '\'' +
                ", clz=" + clz +
                ", role=" + role +
                '}';
    }
}
