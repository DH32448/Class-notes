package cn.list;


import java.util.*;

//public interface Collection<E>

/**
public class ArrayList<E> extends AbstractList<E>
        implements List<E>,
**/

/**
 * public interface List<E> extends Collection<E>
 */
public class Demo1 {
    public static void main(String[] args) {

        Collection<Integer> cols;

        List<Integer> lst = new ArrayList<>();  // < 对象类型 >   泛型
        Collection<String> cols2 = new ArrayList<>();
        Collection<String> cols3 = new HashSet<>();

        cols2.add("hello");
        cols3.add("hello");
    }
}
/*
  Colleaction.add(E e) ；
 */
/*
 ArrayList.add( E e ) {
   public boolean add(E e) {
        ensureCapacityInternal(size + 1);  // Increments modCount!!
        elementData[size++] = e;
        return true;
  }
 */

/*
HashSet.add
public boolean add(E e) {
        return map.put(e, PRESENT)==null;
 }

 */



