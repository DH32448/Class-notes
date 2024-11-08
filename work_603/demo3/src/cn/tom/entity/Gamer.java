package cn.tom.entity;

//抽象类强迫你必须继承
//抽象方法强迫你必须重写
public class Gamer extends Person {

   @Override
   public void play() {
       System.out.println(this.getName() + "正在王黑悟空");
   }
}
