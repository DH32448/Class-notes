package cn.tom.demo;

import java.lang.reflect.Method;
import java.util.*;

public class Demo2 {
    private static Map<String, Method> map
            = new HashMap<>();
    private static Map<String, Object> mapCtl     //请求路径---》 控制器对象关系
            = new HashMap<>();

    // key = 方法名称   值= 方法对象
    static {
        System.out.println("初始化....");
        init();
    }

    public static void main(String[] args) throws Exception {
        // 通过 DemoScan  我们可以获取到如下的结果
        System.out.println("main");
        //  "/clz/add,do"   -->   add
        String action = "/clz/update.do";
        Method m = map.get(action);
        Object ctl =  mapCtl.get(action);
        System.out.println(m);
//        Object 返回值 = method.invoke(Object  当前方法所在的对象, Object 参数1， Object 参数2)
//        方法对象
//        m.invoke(ctl, request, response);

        //clzControoler.add(HttpServletRequest request, HttpServletResponse response)

    }

    public static void init() {
        String ctls[] = {"cn.tom.controller.ClzController", "cn.tom.controller.UserController"};
        // 学习 反射如何获取类对象
        try {
            Class<?> aClass =
                    Class.forName("cn.tom.controller.ClzController");
            Method[] mm = aClass.getDeclaredMethods();
            // 列表
            for (Method m : mm) System.out.println(m);

            for (Method m : mm) System.out.println(m.getName());

            //Object 返回值 = method.invoke(Object  当前方法所在的对象, Object 参数1， Object 参数2)
//            java.util.Map<String, Method> map
//                    = new HashMap<>();
            // key = 方法名称   值= 方法对象
            Object ctl = aClass.newInstance();
            for (Method m : mm) {
                String path = "/clz/" + m.getName() + ".do";
                System.out.println("path=" + path  + "---->"  + m.toString()) ;
                map.put(path, m);
                mapCtl.put(path, ctl );

            }
        } catch (Exception e) {
            System.out.println();
        }
    }
}
