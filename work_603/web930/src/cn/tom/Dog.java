package cn.tom;

public class Dog {
    private int id;
    private double price;
    public Dog() {}
    public Dog(int id, double price) {
        this.id = id;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                ", price=" + price +
                '}';
    }
}
