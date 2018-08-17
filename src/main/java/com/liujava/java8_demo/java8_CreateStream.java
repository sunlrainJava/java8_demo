package com.liujava.java8_demo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class java8_CreateStream {


    /**
     * Stream是
     * @param args
     */
    public static void main(String[] args) {


        /**
         * 从数组创建流
         */
        int[] a = {1,2,3,4,5,6,7,8,9};
        List rs  = new ArrayList();
        Stream stream= Arrays.stream(a)
                .filter(b-> b>0) //中间操作
                .map(c->c*c).boxed();       //中间操作

        stream.collect(Collectors.toList());   //终止操作


        /**
         * 从集合创建
         */
        List<String> list = new ArrayList<String>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");

        list.stream().peek(l-> System.out.println("打印流中元素"+l))
                .flatMap(s->{
                    String [] ss= s.split("");
                    return Arrays.stream(ss);
                })
                .distinct()
                .peek(b-> System.out.println(b))
                .collect(Collectors.toList());


        /**
         * 从数字创建流,从random创建的是无限流，需要用limit截断
         */
        new Random().ints().limit(10);
        IntStream.rangeClosed(1,10);
        Stream.generate(()->IntStream.rangeClosed(1,10));

    }

}
