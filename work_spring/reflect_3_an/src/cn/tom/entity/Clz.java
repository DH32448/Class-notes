package cn.tom.entity;

import cn.tom.anno.Table;

@Table("t_banji")
public class Clz {
    private String clzno;
    private String clzname;
    public Clz() {
        clzno= "";
        clzname = "";
    }
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

    @Override
    public String toString() {
        return "Clz{" +
                "clzno='" + clzno + '\'' +
                ", clzname='" + clzname + '\'' +
                '}';
    }
}
