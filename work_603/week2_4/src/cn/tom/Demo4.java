package cn.tom;

public class Demo4 {
    public static void main(String[] args) {

        Pig pig = new Pig();
        try {
            pig.setAge(10);
            pig.setSex(1);
            System.out.println(1/0);
        } catch (Exception e) {
            //instanceOf 去识别
            if (e instanceof AgeException) {

            }
            else if (e instanceof SexException) {

            } else {

                System.out.println("其他:" + e.getMessage());
            }
        }
    }
}
