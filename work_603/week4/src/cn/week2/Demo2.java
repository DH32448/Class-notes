package cn.week2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

//采用字节流去处理， 无法用记事本打开的文件
//图片  视频   可以运行的程序包  压缩文件

// 图片 a.jpg  --> b.jpg
//     44.5K
public class Demo2 {
    public static void main(String[] args) throws Exception {
        //输入流
        InputStream is = new FileInputStream("d:/work_605/a.jpg");
        //输出流 把内存写到硬盘文件
        OutputStream os = new FileOutputStream("d:/work_605/b.jpg");

        byte[] buf = new byte[1024];
        for(;;) {
            int len = is.read(buf);  // 读 1024， 1K
            if (len > 0) {   // len = -1 的情形
                os.write(buf, 0, len);  // 每次要输出的长度， 因为最后一个是 0.5K
            }
            System.out.println("len=" + len);
            if (len<1024)  {
                System.out.println("读到最后 0.5K");
                break;  //退出循环
            }
        }
        os.flush();  //强制把缓存的内容刷新到硬盘, 输出加这条不犯错
        os.close();
        is.close();
    }
}
