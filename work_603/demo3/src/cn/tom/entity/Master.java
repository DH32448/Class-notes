package cn.tom.entity;

public class Master extends Person {  //Master 精通
    @Override
    public void play() {
        System.out.println("看不起 newbie 新手");
        System.out.println("总觉的投篮肯定会进， 喜欢单干");
    }
}
