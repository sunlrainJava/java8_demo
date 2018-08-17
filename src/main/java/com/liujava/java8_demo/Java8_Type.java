package com.liujava.java8_demo;

public class Java8_Type {


    interface MyInter1{
        String add(String s);
    }
    interface MyInter2{
        String sup(String a);
    }

    public static void main(String[] args) {

        /**
         * 最常见的类型推断，通过声明变量类型找到实现的接口
         */
        MyInter1 my = (a)->"";
        my.add("");


        /**
         * 强转
         */
        Object ob = (MyInter1)(a)->"";

        /**
         * 方法返回类型
         */
         test().add("");


        /**
         * 当方法重载之后，lambda就会报两重性的错，因为lambda找不到要实现那个接口，最简单的解决办法使用强转
         */
         Java8_Type java8_type = new Java8_Type();
        java8_type.refactMethor((MyInter1) (a)->"");

    }

    public static MyInter1 test(){
        return (a)->"";
    }

    public void  refactMethor(MyInter1 myInter1){

    }

    public void  refactMethor(MyInter2 myInter1){

    }
}
