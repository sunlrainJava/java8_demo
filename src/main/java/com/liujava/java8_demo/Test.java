package com.liujava.java8_demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) {
        /**
         * Stream是一个链式调用
         */
        List<String> list = new ArrayList<String>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");

       Stream stream=  list.stream().peek(l-> System.out.println("打印流中元素"+l))
                .flatMap(s->{
                    String [] ss= s.split("");
                    return Arrays.stream(ss);
                })
                .peek(b-> System.out.println(b));


        stream.collect(Collectors.toList());



    }
}
