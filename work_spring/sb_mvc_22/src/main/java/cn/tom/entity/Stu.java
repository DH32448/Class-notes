package cn.tom.entity;

public class Stu {
    private String sno;     //sno  ---> imgid
    private String sname;
    private String phone;
    private String imgid;   //uuid  作为 LargeFile.id 外键

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

    public String getImgid() {
        return imgid;
    }

    public void setImgid(String imgid) {
        this.imgid = imgid;
    }

    @Override
    public String toString() {
        return "Stu{" +
                "sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                ", phone='" + phone + '\'' +
                ", imgid='" + imgid + '\'' +
                '}';
    }
}
