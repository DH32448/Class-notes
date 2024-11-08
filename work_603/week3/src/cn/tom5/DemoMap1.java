package cn.tom5;

import jdk.nashorn.internal.ir.CallNode;

import java.util.*;

public class DemoMap1 {
    public static void main(String[] args) {
        //创建集合对象
        //interface Map<K,V>
        //public class HashMap<K,V>

        Map<String,String> map = new HashMap<String,String>();  //向上转型
        //请解释， 这里发生面向对象啥现象
        //V put(K key, V value) 将指定的值与该映射中的指定键相关联
        map.put("qinsh","秦始皇");   // put 是哪个类的方法
        map.put("liub","刘邦");
        map.put("caoc","曹操");
        map.put("yanj","杨坚");
        map.put("lism","李世民");
        map.put("zuyz","朱元璋");

        //输出集合对象
        System.out.println(map);   //这里使用面向对象哪些技术

        String  liuban = map.put("liub", "刘备");// put 根据 Key 直接修改
        System.out.println("liuban=" + liuban);

        System.out.println(map);

        System.out.println("===================1=============");
        String liub = findById(map,"liub");
        System.out.println("liub=" + liub);
        System.out.println("===================2==============");


        System.out.println("===================3333=============");
        String tom = findById(map,"tom");
        System.out.println("tom=" + tom);  //?  null
        System.out.println("===================4444==============");

        System.out.println("==================如何遍历整个 Map 集合===================");
        System.out.println("============1. 获取所有的主键集合 ===========================");
        Set<String>  keys = map.keySet();
        System.out.println("所有的主键的集合=" + keys);
        System.out.println("============2. 再去遍历所有主键的集合， 利用 map.get 获取对应的值===========");
        // foreach 循环

        /*****
         Dog maxDog = mapDogs.get(100);
         如果后面 mapDogs.remove(100);
         mapDogs.get(100);   null
         ****/

        /***
         *  mapDogs  可能是空的  1   2  3 。。。
         */
        Set<Integer> keys = mapDogs.keySet();
        Integer maxKey = null;   //(int  x = null)
        Integer minKey = null;
        for (Integer k : keys) {
            if (maxKey== null) maxKey = k;
            if (minKey== null) minKey = k;
            if ( mapDogs.get(k).getPrice() > mapDogs.get(maxKey).getPrice()) {
                maxKey = k;
            }

        }

        Set<Integer> keys = mapDogs.keySet()
        Dog maxDog = null;   //(int  x = null)
        Dog minDog = null;
        for (Integer k : keys) {
            if (maxDog== null) maxDog = mapDogs.get(k);
            if (minDog== null) minDog = mapDogs.get(k);
            if ( mapDogs.get(k).getPrice() > mapDogs.get(maxKey).getPrice()) {
                maxKey = k;
            }

        }
    }

    private static String findById(Map<String, String> map, String key) {
        System.out.println(map);
        System.out.println(key);
        String s = map.get(key);
        System.out.println("查找结果" + s);
        return s;
    }
}
