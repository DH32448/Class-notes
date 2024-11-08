package cn.tom;

//不做异常处理， 抛出去给 Demo
public class Pig {
    private int age;
    private int sex; //0-母  1=公
    public void setAge(int age) throws AgeException {
        if (age<1)  {
//            System.out.println("非法年龄");
//            return;
            throw new AgeException("非法年龄");
        }
        this.age = age;
    }
    public void setSex(int sex) throws SexException{
        if (sex!=0 && sex !=1) {
            throw new SexException("性别异常");
        }
    }
}
