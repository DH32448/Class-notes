package cn.tom;

import java.util.Locale;

public class DemoIndexOf {
    public static void main(String[] args) {
        // indxOf(int)
        // indxOf(String )
        String  s = "123xyzABC";
        // 有 y 字符吗？
        int n = s.indexOf('y');
        System.out.println("y的位置（下标）=" + n);

        // 有 xyz
        n = s.indexOf("xyz");
        System.out.println("xyz的x位置（下标）=" + n);

        // 有 你好, -1
        n = s.indexOf("你好");
        System.out.println("你好的x位置（下标）=" + n);  //-1

        //转大写 ， 用返回值
        String s2 = s.toUpperCase();
        System.out.println("s2 转大写:" + s2);

        //转小写， 用返回值
        s2 = s.toLowerCase();
        System.out.println("s2 转小写:" + s2);

        //替换 单个和多个字符
        String newStr = s.replace("xyz", "456");
        System.out.println("s=" + s);
        System.out.println("newStr=" + newStr);
        //干掉你不用的内容， 用替换成 ""
        newStr = s.replace("xyz", "");
        System.out.println("s=" + s);
        System.out.println("newStr=" + newStr);
        //Java正则表达式， 非常强大的字符串处理功能





    }
}
