package cn.tom;

//字符串切割
public class DemoSplit {
    public static void main(String[] args) {
        String msg = "abc-xyz-123-456";
        // 用 - 分隔
        String[] arr = msg.split("-");
        //arr[0] ="abc"  arr[1] = "xyz"  arr[2]="123"  arr[3] = "456"
        for(int i=0; i<arr.length; i++) {
            System.out.println(arr[i]);
        }

        msg = "www.baidu.com";
        String msg2 = "www.163.com";

        String[] a2 = msg.split("\\.");
        for(int i=0; i<a2.length; i++) {
            System.out.println(a2[i]);
        }
        // . \  ?  * d  正则表达式
        msg = "aa1bbb2cccc3dddddd4fffffff5";  //按照数字切割
        a2 = msg.split("\\d");  //d 代表 0-9
        for(int i=0; i<a2.length; i++) {
            System.out.println(a2[i]);
        }

        //学习字符串牢记 下标
        String s3 = msg.substring(2, 2 + 4);
        System.out.println("subString=" + s3);  //1bbb
    }
}
