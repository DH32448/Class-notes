package cn.tom6;

import javax.naming.event.ObjectChangeListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//无需 Person 这个类， 用 Map 去替代
public class MapPerson {
    public static void main(String[] args) {

        //创建一个人  电话 phone, 姓名 name , 钱 money
        Map<String, Object> m = new HashMap();
        m.put("phone", "131001");  //把成员变量当成 Key
        m.put("name", "秦始皇");  //把成员变量当成 Key
        m.put("money", 300.0);  //把成员变量当成 Key

        // 把这个对象， 追加到某个 List
        //这个 List  如何写？
        //List<Person> lst = new ArrayList<>();
        List<Map<String, Object >> maps=new ArrayList<>();
        maps.add(m);
        /***  如何用 Map 完成如下 2 行的添加
        lst.add(new Person("131002", "李世民", 500));

        lst.add(new Person("139003", "刘备", 200));
        ***/
        m = new HashMap<>();
        m.put("phone", "131002");  //把成员变量当成 Key
        m.put("name", "李世民");  //把成员变量当成 Key
        m.put("money", 500.0);  //把成员变量当成 Key

        maps.add(m);

        m = new HashMap<>();
        m.put("phone", "139003");  //把成员变量当成 Key
        m.put("name", "刘备");  //把成员变量当成 Key
        m.put("money", 200.0);  //把成员变量当成 Key

        maps.add(m);

        System.out.println(maps);

        //根据名字找出某个人工资


        for (int i = 0; i < maps.size(); i++) {
            Map<String, Object>  person = maps.get(i);
            System.out.println("Person =" + person);
            if ("刘备".equals(person.get("name"))) {
                System.out.println( person.get("name") + " 的工资=" +
                        person.get("money"));
                break;
            }
//            if ("刘备".equals(maps.get(i).get("name")))
        }
    }

}
