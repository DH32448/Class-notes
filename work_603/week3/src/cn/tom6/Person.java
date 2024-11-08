package cn.tom6;

public class Person {
    private String phone;
    private String name;
    private double money;

    public Person() {
    }

    public Person(String phone, String name, double money) {
        this.phone = phone;
        this.name = name;
        this.money = money;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Person{" +
                "phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}
