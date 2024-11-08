package cn.tom;

import  java.util.*;
public class Demo31 {
    public static void main(String[] args) {

        List<Double> lst = new ArrayList<>();

        List<Double> lst2 = new LinkedList<>();

        List<Double> lst3 = new Stack<>();  // Stack 栈（数据结构）

        List<Double> lst4 = new MyList();

        //lst4.add(9999.0);

        lst3.add(10000.00001);

        lst.add(1.01);

        lst2.add(100.001);


    }
}
/***
 * public class MyList implements List {
 *     @Override
 *     public void add(int index, Object element) {
 *
 *     }
 *     @Override
 *     public void add(Object element) {
 *
 *     }
 *
 */