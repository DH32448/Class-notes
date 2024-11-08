package cn.tom;

public class AgeException extends Exception {
    public AgeException(String msg) {
        // msg ---> getMessage
        super(msg);  //指明调用父类的有参数构造方法
    }
}
