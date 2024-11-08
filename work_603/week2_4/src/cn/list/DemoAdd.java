package cn.list;

import java.util.ArrayList;
import java.util.List;

public class DemoAdd {
    public static void main(String[] args) {

        List<Double> lst = new ArrayList();
        for(int i=0; i<10; i++) {
            lst.add((i+1)*1.0);  //1.0 ~10.0
        }
        System.out.println(lst.toString());
        lst.add(5, 5.5);
        System.out.println(lst.toString());
        lst.remove(1);
        System.out.println(lst.toString());




        System.out.println("连表长度="  +lst.size());
        Double x = lst.get(10);  //??????

    }
}
