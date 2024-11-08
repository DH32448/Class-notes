package week2;

import java.util.List;

public class Student {
    public String name;
    public int height;
    public int weight;
    List<String> lst;
    public Student() {}
    public Student(String name, int h, int w) {
        this.name = name;
        this.height = h;
        this.weight = w;
    }
    public void play(Student p2) {
        System.out.println("p2=" + p2.name);
        System.out.println(this.name + "-"  + this.weight);
        System.out.println(this.name + "正在打篮球" );
    }
    public void study() {
        System.out.println(name + "正在学习");
    }
}
