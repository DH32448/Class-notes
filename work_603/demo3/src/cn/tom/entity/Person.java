package cn.tom.entity;

//abs 绝对值  abs-tra-ct 抽象
abstract public class Person {
    private String name;
    private int age;
    abstract public void play();   // {  } 方法就是抽象方法
    public void setName(String name) {
        this.name = name;
    }
    public String  getName() {
        return this.name ;
    }
}
