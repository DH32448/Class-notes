package cn.tom;

public class Demo3 {
    public static void main(String[] args) {

        Pig pig = new Pig();
        try {
            pig.setAge(10);
            pig.setSex(1);
            System.out.println(1/0);
        } catch (SexException e) {
            System.out.println("性别:" + e.getMessage());
        } catch (AgeException e) {
            System.out.println("年龄:" + e.getMessage());
        } catch (Exception e) {
            System.out.println("其他:" + e.getMessage());
        }
    }
}
