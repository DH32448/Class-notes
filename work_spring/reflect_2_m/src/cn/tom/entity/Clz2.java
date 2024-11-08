package cn.tom.entity;

public class Clz2 {
    private String clzno;
    private String clzname;
    private String department;

    public String getClzno() {
        return clzno;
    }

    public void setClzno(String clzno) {
        this.clzno = clzno;
    }

    public String getClzname() {
        return clzname;
    }

    public void setClzname(String clzname) {
        this.clzname = clzname;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Clz2{" +
                "clzno='" + clzno + '\'' +
                ", clzname='" + clzname + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
