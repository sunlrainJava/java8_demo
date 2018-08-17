package com.liujava.java8_demo;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class java8_Lambda   {

    /**
     * 定义一个返回为boolean 输入为int的接口
     */
    @FunctionalInterface
    interface  Interface{
        boolean apply (int i);
    }

    interface  Interface2 {
        String change(int j);
    }

    public static void main(String[] args) {
        //java7CreateThread();
        //java8CreateThread();

        //将()-> System.out.println("java8开启新线程")表达式作为r参数传递给Thread
      // Runnable  r=  ()-> System.out.println("java8开启新线程");
       //new Thread(r).start();
        //createLambda2();
        checkFinal();


    }




    /**
     * java7实现多线程
     */
    public static void java7CreateThread(){

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("java7开启新线程");
            }
        }).start();
    }

    /**
     * java8实现多线程
     */
    public static void java8CreateThread(){
        new Thread(()-> System.out.println("java8开启新线程"));

    }

    /**
     * 手动创建一个lambda表达式
     */
    public static void createLambda(){

        /**
         * 最简单写法
         */
        Interface i = (a)-> true ;
        i.apply(1);

        /**
         * 加入一些逻辑的lambda
         */
        Interface2 j = (b)-> b>60 ? "合格":"不合格" ;

        System.out.println("lambda输出："+j.change(50));



    }

    public static void createLambda2() {
        /**
         * 更复杂的逻辑
         * lambda表达式如果只有一行，是隐式的return
         * 如果lambda表达式比较复杂，需要多行，则需要写显示的return
         *
         */
        Interface2 m = (h)->{
            String rs = "";
            switch (h){
                case 1:
                    rs = "入参为1";
                    break;
                case 2:
                    rs = "入参为2";
                    break;
                case 3:
                    rs = "入参为3";
                    break;
                default:
                    rs = "def";
            }

            return rs;
        };
        System.out.println("多行lambda:"+m.change(3));
    }


    /**
     * 在1、2位置分别修改lambda的外部变量a
     *
     */
    public static void checkFinal(){
        int a = 7;
        //a=0; 1
        Interface b = (c)-> c > a;
        boolean flag= b.apply(6);

        System.out.println("checkFinal 输出"+flag);

    }




}
