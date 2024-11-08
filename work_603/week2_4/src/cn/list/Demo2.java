package cn.list;

import java.util.ArrayList;
import java.util.List;

public class Demo2 {
    public static void main(String[] args) {


        List<Double> lst = new ArrayList<Double>();
        double x = 100.01;

        lst.add(  x  );
        lst.add(new Double(200.02));  //下标 1

        double y = lst.get(1);  //Double ---> double

        List<String> lst2 = new ArrayList<String>();

        List<Pig> lst3 = new ArrayList<Pig>();


    }
}
