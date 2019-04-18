package com.naonao.juc;

/**
 * @Description:
 * @Author: HuangHaodong
 * @Date: 2019-04-07 11:39
 */
public class TestAtomicDemo {

    public static void main(String[] args) {
        AtomicDemo atomicDemo = new AtomicDemo();
        for (int i = 0; i < 10; i++) {
            new Thread(atomicDemo).start();
        }
    }


}

class AtomicDemo implements Runnable {

    private int serialNum = 0;

    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + ":" + getSerialNum());


    }

    public int getSerialNum() {
        return serialNum++;
    }
}
