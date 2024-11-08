package cn.tom;

import java.io.File;
import java.net.URL;

//Scan  扫描
public class DemoScan {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        //反射方式创建 Controller 对象

        // 获取 DemoScan.class 字节码所在的文件夹
        // getClassLoader  获取字节码加载的路径
        URL url = DemoScan.class.getClassLoader().getResource("");
        System.out.println("url=" + url.toString());
        Class<?> c = DemoScan.class;
        System.out.println(c.getName());
        System.out.println(c.getSimpleName());

        // 获取 cn.tom
        String  s = c.getName();
        String aa[] = s.split("\\.");
        String  s2 = "";
        for(int i=0; i<aa.length-1; i++) {
            s2 = s2+  aa[i] +"/";
        }
        System.out.println("s2=" +  s2);

        s2 = url.getPath() + s2;
        System.out.println(s2);


        s2 = s2 +  "controller";
        System.out.println(s2);
/*
 String name = "cn.lusq.dao.UserDao";
         Class c1 = Class.forName(name);   //根据名称 产生类对象

         //发射创建对象： 根据类对象创建对象

        Object o = c1.newInstance();   //new  Instance(实例  对象)

 */
        String pack = "cn.tom.controller";
      //遍历文件夹
        File file = new File(s2);
        String[] list = file.list();
        for(String f : list) {
            System.out.println(f);
            //Class.forName(包名称.类名称)
            String x = pack + "." +
                    f.replace(".class", "");
            System.out.println("x=" + x);

            Class<?> aClass = Class.forName(x);
            System.out.println("================类对象---》 创建对象====");

            Object o = aClass.newInstance();

            System.out.println("================类对象---》 创建对象 结束====");
            System.out.println(o);
        }

    }
}
