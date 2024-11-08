package cn.week1;

//IO  I input 输入   O Output 输出
// 文件夹
import java.io.File;
import java.util.Date;

public class Demo1 {
    private static  String xx = "-";
    public static void main(String[] args) {
        //File file = new File("文件夹名称");//文件夹
//        File file = new File("D:\\work_603");//文件夹
        // 现代语言中  "\"  转义符号  d:\work_603
        //文件路径建议 d:/work_603 (Linux)
//        File file2 = new File("D:/work_603"); //文件夹
//        System.out.println("判断文件夹是不是存在：" + file2.exists());
//        File file3 = new File("D:/work_605"); //文件夹
//        System.out.println("判断文件夹是不是存在：" + file3.exists());
//        boolean b = file3.mkdir();   //mkdir() 创建 work_605 文件夹
          //showDir("d:/work_605");
          showDir2("d:/work_605");

    }

    private static void showDir3(File[] files) {
        xx = xx + "---";
        //调试输出
        for(File f : files) {
            //System.out.println(f.toString());
            System.out.print(xx);
            System.out.print(f.getName());
            System.out.print("\t" +
                    f.length());
            long t = f.lastModified();
//            System.out.println("最新更新日期" + t);
            Date date = new Date(t);
            System.out.print("\t" + date);
            if (f.isDirectory() == true) {
                System.out.print("\t" + "文件夹");
                showDir3(f.listFiles());
            }
            if (f.isFile()==true) System.out.print("\t" + "普通文件");
            System.out.println();
        }
    }

    private static void showDir2(String s) {
        System.out.println("s=" +s);
        File file = new File(s);
        File[] files = file.listFiles();
        System.out.println();
        xx = xx + "---";
        //调试输出
        for(File f : files) {
            //System.out.println(f.toString());
            System.out.print(xx);
            System.out.print(f.getName());
            System.out.print("\t" +
                    f.length());
            long t = f.lastModified();
//            System.out.println("最新更新日期" + t);
            Date date = new Date(t);
            System.out.print("\t" + date);
            if (f.isDirectory() == true) {
                System.out.print("\t" + "文件夹");
                showDir2(f.toString());
            }
            if (f.isFile()==true) System.out.print("\t" + "普通文件");
            System.out.println();
        }
    }


    //列出文件夹下的文件 或 子文件夹
   private static String[] showDir(String sDir) {
       System.out.println("sDir=" + sDir);
       File file2 = new File(sDir); //文件夹
       boolean b = file2.exists();
       System.out.println("判断文件夹是不是存在：" + b);
       if (b == false) return new String[0];
       String[] list = file2.list();
       //调试输出

       return list;
   }


}
