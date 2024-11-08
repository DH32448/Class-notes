package cn.tom.entity;

public class Pet extends Object {

    private String name;
    private double price;

    public Pet() {
        System.out.println("Pet 构造方法...");
    }

    public Pet(String name) {
        this.name = name;
        this.price = 1;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public double getPrice() {
        return this.price;
    }
}
