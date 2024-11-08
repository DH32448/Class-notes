package cn.tom;

public class MaoDemo {
    public static void main(String[] args) {
        int[] a= {4,5,6,3,2,1};
        // 内循环 把上面写成循环
        for( int j = 0 ; j< 5;  j++ ) {   //j < 数组的长度   -1  - 外循环的下标    a.length - i  -1
            if (a[j] > a[j + 1]) {   // 0 1   1 2   2 3  3 4   4 5
                int tmp = a[j];
                a[j] = a[j + 1];
                a[j + 1] = tmp;
            }
        }
        for(int i=0; i<a.length; i++) {
            System.out.print(a[i] + "  ");
        }
        System.out.println();


        for( int j = 0 ; j< 4;  j++ ) {   //j < 数组的长度   -1  - 外循环的下标    a.length - i  -1
            if (a[j] > a[j + 1]) {   // 0 1   1 2   2 3  3 4   4 5
                int tmp = a[j];
                a[j] = a[j + 1];
                a[j + 1] = tmp;
            }
        }
        for(int i=0; i<a.length; i++) {
            System.out.print(a[i] + "  ");
        }
        System.out.println();
    }
}
