package java_basics;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * Created by Json Wan on 2018/10/17.
 */
public class AtomicIntegerArrayDemo {
    //ʹ��ԭ�����飨�̰߳�ȫ��������
    static AtomicIntegerArray arr = new AtomicIntegerArray(10);

    //�̲߳���ȫ������
//    static int[] arr = new int[10];

    public static class AddThread implements Runnable {
        public void run() {
            for (int k = 0; k < 10000; k++)
                arr.getAndIncrement(k % arr.length());
                //�̲߳���ȫ������
//                arr[k % arr.length]+=1;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] ts = new Thread[10];
        for (int k = 0; k < 10; k++) {
            ts[k] = new Thread(new AddThread());
        }
        for (int k = 0; k < 10; k++) {
            ts[k].start();
        }
        for (int k = 0; k < 10; k++) {
            ts[k].join();
        }
        System.out.println(arr);
        //�̲߳���ȫ������
//        for (int x:arr) {
//            System.out.print(x + " ");
//        }
    }
}
