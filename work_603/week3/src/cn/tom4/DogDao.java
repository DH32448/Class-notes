package cn.tom4;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//DAO Data acess Object（数据层）  运行服务器，
// 完成  增删改查 的功能
public class DogDao {
    private static int id=0;  //自增长字段
    private static List<Dog> dogs = new ArrayList<>();
    //数据库只有 一张狗的表，所以用 static 修饰：  静态（单个实例）， 单例， 单例模式
    //static 修饰变量也叫 类变量， 所有该类型对象都可以共享
    static{
        //Date d = date2Str("2022-11-22");
        dogs.add(new Dog(++id, 100.1, "狗1" ) );
        dogs.add(new Dog(++id, 100.2, "狗2" ) );
        //d = date2Str("2022-11-190");
        dogs.add(new Dog(++id, 100.3, "狗3" ) );
        //d = date2Str("2022-11-22");
        dogs.add(new Dog(++id, 99.9, "狗4" ) );
    }


    private Date date2Str(String sDate) throws Exception {
        Date d = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        d = sdf.parse(sDate);
        return d;
    }
    public List<Dog> findAll() {

        return new ArrayList<>();
    }
    public Dog findByName(String name) {
        Dog d = null;  //假设一种情形找不到
        if (name == null) return null;  // null 表示找不到
        for(Dog dog : dogs) {
            if (name.equals(dog.getName())) {  //name 如果是 空指针
                System.out.println(dog); //可以输出调试信息
                return dog;
            }
        }
        return null;
    }

    public  Dog[] getMaxMin() {
       Dog max = dogs.get(0);
       Dog min = dogs.get(0);

        // ...
       Dog[] arr = new Dog[2];
       arr[0] = max;
       arr[1] = min;
       return arr;
    }

    @Override
    public String toString() {
        String s ="";
        for(Dog d : dogs) {
            s= s+ d.getId() + "\t\t" +  d.getName()+  "\t\t" + d.getPrice() + "\r\n";
        }
        return s;
    }
    // 尽量返回对象， 参数尽量使用对象

}
