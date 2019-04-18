package com.naonao.juc;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @Description:
 * @Author: HuangHaodong
 * @Date: 2019-04-07 12:42
 */
public class ThreadPoolTest {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor1 = new ThreadPoolExecutor(3, 10, 100, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(10));

        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                3,
                10,
                100,
                TimeUnit.MINUTES,
                new LinkedBlockingQueue<Runnable>(1024),
                threadFactory,
                new ThreadPoolExecutor.AbortPolicy());

        threadPoolExecutor.submit();
    }

}

class TimerTaskThread extends Thread {

    public TimerTaskThread() {
        super.setName("TimerTaskThread");
        //do something;
    }
}
