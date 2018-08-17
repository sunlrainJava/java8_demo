package com.liujava.java8_demo;

public class java8_Lambda_ThisDemo {

    private String name = "ThisDemo";

    public  void test() {

        //匿名内部类
        new Thread(new Runnable() {
            private String name = "Runable";
            @Override
            public void run() {
                System.out.println("匿名内部类的this" +this.name);

            }
        }).start();

        //lambda

        new Thread(()-> System.out.println("lambda的this"+this.name)).start();
        new Thread(()-> System.out.println("lambda不调用this")).start();

    }

    public static void main(String[] args) {
        java8_Lambda_ThisDemo java = new java8_Lambda_ThisDemo();
        java.test();
    }
}
