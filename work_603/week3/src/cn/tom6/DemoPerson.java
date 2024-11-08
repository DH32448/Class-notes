package cn.tom6;

import java.util.*;
public class DemoPerson {
    public static void main(String[] args) {
        List<Person> lst = new ArrayList<>();

        lst.add(new Person("131001",
                "秦始皇",
                300));

        lst.add(new Person("131002",
                "李世民",
                500));

        lst.add(new Person("139003",
                "刘备",
                200));

        System.out.println(lst);
    }
}
