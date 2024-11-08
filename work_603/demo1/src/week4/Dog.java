package week4;

public class Dog extends Pet {
    //强制指定父类构造方法
    private String color;
    public void setColor(String color) {

    }
    public Dog(String name,
                double price,
               String color) {
        super(name);  //只能写在第一行
        this.setPrice(price);
        //this 指向自身， 自身没有找父亲
        this.color = color;
    }
    @Override
    public String toString() {
        return this.getName() + "\t" +
                this.getPrice() + "\t" +
                this.color;
    }
}
