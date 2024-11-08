package week2;

import java.util.List;

public class Stux {
    public String name;
    public int height;
    private int weight;
    private List<String> lst;

    public void setLst(List<String> lstx) {
        this.lst = lstx;
    }
    public List<String> getLst() {
        return this.lst;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
}
