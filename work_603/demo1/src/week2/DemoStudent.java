package week2;

public class DemoStudent {
    public static void main(String[] args) {

        Student t1= new Student("Tom", 160, 100);
        System.out.println(t1.name);   //Tom

        Student t2= new Student("Mike",170 , 120);
        System.out.println(t2.name);  //Mike

        //t1 和 t2 正在 篮球单挑

        // 体重 xxx 的 Mike 和 身高XXX 的Tom 正在单挑
        // this 指向成员变量   指向正在创建的对象  指向正在使用的对象
        t1.play(t2);

        t2.play(t1);


        System.out.println("================构造方法初始化成员变量========================");
        Student t3 = new Student();
        System.out.println("name=" + t3.name);
        System.out.println("height=" + t3.height);
        System.out.println("lst=" + t3.lst);
        // 对象方法， 先创建它所在的类的对象， 才能调用
        DemoStudent demo = new DemoStudent();
        demo.pk(t1, t2);
        //DemoStudent.pk(t1, t2);  对象方法， 必须先创建对象
        DemoStudent.pkx(t1, t2); // 同一个类里面， DemoStudent 可以省略

    }
    // 没有 static 修饰， 对象方法， 先创建对象才能使用
    public void pk(Student p1, Student p2) {

    }
    // 有 static 修饰的 称之为 类方法  静态方法
    public static void pkx(Student p1, Student p2) {

    }

}
