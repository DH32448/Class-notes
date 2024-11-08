package week4;

public class DemoPig {
    public static void main(String[] args) {


        Pet pig = new Pig();
        //宠物类型   <==== Pig 的对象
        //用父类声明变量 指向 子类 对象


        pig.setName("Tom");
        pig.setPrice(100);
        System.out.println(pig.getName());

        Pet dog = new Dog("1", 1, "1");
        dog.setName("Mike-dog");
        //向下转型
        Dog dog2 = (Dog) dog;
        System.out.println(("======狗转成猪======"));
        Pig pig2 = (Pig) dog;

        System.out.println(dog.toString());
        System.out.println(pig.toString());
    }
}
