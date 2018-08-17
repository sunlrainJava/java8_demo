package com.liujava.java8_demo;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class java8_ParallelStream {

    public static void main(String[] args) {

        //调用parallel产生一个并行流
        //IntStream.range(1,100).parallel().peek(java8_ParallelStream::debug).count();

        //实现先并行在串行
        //IntStream.range(1,100).parallel().peek(java8_ParallelStream::debug).sequential().peek(java8_ParallelStream::debug2).count();



        //查看并行时线程名
        //System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism","20");
       // IntStream.range(1,100).parallel().peek(java8_ParallelStream::debug3).count();


        //使用自己的线程池防止线程阻塞
        ForkJoinPool pool = new ForkJoinPool(10);
        pool.submit(()->IntStream.range(1,100).parallel().peek(java8_ParallelStream::debug3).count());
        pool.shutdown();
        synchronized (pool){
            try {
                pool.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void debug(int i){
        System.out.println("debug" +i);
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void debug2(int i){
        System.err.println("debug2 " +i);
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void debug3(int i){
        System.out.println("debug2 " +i+" 线程名："+Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
