package cn.tom;

public class DemoAt {
    public static void main(String[] args) {
        //charAt 遍历字符串
        String  s = "123xyzABC";

        for(int i=0; i< s.length(); i++) {

            char ch = s.charAt(i);

            System.out.print(ch);
            if (ch>='0' && ch<='9') System.out.println("我是数字");
            if (ch>='a' && ch<='z') System.out.println("我是小写字母");
            if (ch>='A' && ch<='Z') System.out.println("我是大写字母");
        }

    }
}
