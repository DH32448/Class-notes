package cn.tom.entity;

public class Pig  extends cn.tom.entity.Pet {
    private int age;
    public void setAge(int a) {
        this.age = a;
    }
    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        String s = this.getName() + "\t" + this.getAge();
        return s;
    }
    @Override
    public boolean equals(Object  obj) {
        // 可能是真的 true
        // p2 --- 向上转型 ---> obj  --- 向下转型--> pet --->pig
        if (obj == null) return false;  //避免空指针异常
        // Object.getClass() 判断对象的类型， 避免强制转换出异常
        System.out.println("参数类型：" +  obj.getClass());  // 类型  cn.tom.Pig

        System.out.println("this类型:" +  this.getClass());  // 类型  cn.tom.Pig

        // instanceOf 该对象是不是某个类型
        if ( ! (obj instanceof Pig))  {
            System.out.println("判断 obj 不是 Pig， 返回 false");
           return false;
        }
        Pig pig = (Pig) obj;
        if ( this.age ==  pig.getAge() )  {
            return true;
        }
        return false;  //假设是假的， 假设一种悲观情形
    }


    public static void main(String[] args) {
        Pig p1 = new Pig();
        p1.setAge(20);
        Pig p2 = new Pig();
        p2.setAge(20);
        boolean b1 = p1.equals(null); //空指针的情形
        boolean b2 = p1.equals(new Dog()); //空指针的情形
        boolean b = p1.equals(p2);  // equals 找自身， 找 Pet  找 Object
        //Object.equals { this == object;   } --->   p1 == p2 (币地址)
        System.out.println("b=" + b);  //



        System.out.println(new Pig());
    }

    public static void a(Pet x1, Object obj) {
        System.out.println("============a============");
        System.out.println(x1.equals(obj));
        System.out.println("============a============");
    }
}

