package com.naonao.juc;

/**
 * @Description: volatile:当多个线程进行操作共享数据时,可以保证内存中的数据是可见的.
 *
 * 重排序
 *
 * 相对于synchronized 是一种交轻量级的同步策略
 *
 * 注意:
 * 1. volatile 不具备互斥性
 * 2. volatile 不能保证变量的原子性.
 *
 * @Author: HuangHaodong
 * @Date: 2019-04-07 11:28
 */
public class TestVolatile {
    public static void main(String[] args) {

        ThreadDemo threadDemo = new ThreadDemo();

        new Thread(threadDemo).start();
        while (true) {
                if (threadDemo.isFlag()) {
                    System.out.println("========");
                    break;
                }
        }
    }
}

class ThreadDemo implements  Runnable {

    private volatile boolean flag = false;

    boolean isFlag() {
        return flag;
    }

    public ThreadDemo setFlag(boolean flag) {
        this.flag = flag;
        return this;
    }

    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;

        System.out.println(isFlag());
    }
}