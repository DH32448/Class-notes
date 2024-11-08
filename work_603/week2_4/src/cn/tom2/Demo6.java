package cn.tom2;

public class Demo6 {
    public static void main(String[] args) {
        // byte
        //sout(255*225*225*255/2)
        System.out.println("基本类型：byte 二进制位数：" + Byte.SIZE);
        System.out.println("包装类：java.lang.Byte");
        System.out.println("最小值：Integer.MIN_VALUE=" + Integer.MIN_VALUE);
        System.out.println("最大值：Intger.MAX_VALUE=" + Integer.MAX_VALUE);
        System.out.println();
        // char 单一的 16 位 Unicode 字符；
        System.out.println("基本类型：char 二进制位数：" + Character.SIZE);
        System.out.println("包装类：java.lang.Character");
        // 以数值形式而不是字符形式将Character.MIN_VALUE输出到控制台 \u0000（十进制等效值为 0）；
        System.out.println("最小值：Double.MIN_VALUE=" + (int) Character.MIN_VALUE);
        // 以数值形式而不是字符形式将Character.MAX_VALUE输出到控制台 \uffff（即为 65535）；
        System.out.println("最大值：Double.MAX_VALUE=" + (int) Character.MAX_VALUE);
    }
}
