package cn.week5;

//Thread 线程
public class ThreadA extends Thread {
    @Override
    public void run() {
        for(int i=0; i<100; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
