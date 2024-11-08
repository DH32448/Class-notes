package week4;

// Ctrl + 鼠标左键
public class Pig extends Pet  {

   public Pig() {
       super() ;  //这一行可以不写, 系统会给加. 默认调用父类无参数构造方法
       System.out.println("Pig 构造方法");
   }
    public Pig(int weight) {
        super();  //这一行可以不写, 系统会给加. 默认调用父类无参数构造方法
        System.out.println("Pig 构造方法");
    }

}
