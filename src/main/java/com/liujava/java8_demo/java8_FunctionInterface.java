package com.liujava.java8_demo;

import org.omg.PortableInterceptor.INACTIVE;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.function.*;

public class java8_FunctionInterface {

    public static void main(String[] args) {

    }

    public void someInerface(){

        /**
         * 断言函数
         * 入参是一个泛型，返回一个boolean类型
         */
        Predicate<Integer> predicate = (a)->a>0;
        predicate.test(1);
        /**
         * 消费函数
         * 消费一个数据，没有返回值
         */
        Consumer<String> consumer = (a)-> System.out.println(a);
        consumer.accept("consumer消费这函数");
        /**
         * 函数
         * 输入T类型，返回R类型
         */
        Function<Integer,String> function = (a)->a.toString();

        /**
         * 工厂函数
         * 无输入参数，返回一个T类型，多用于构造方法
         */
        Supplier<ArrayList> supplier = ()->new ArrayList();
        Supplier<ArrayList> supplier1 = ArrayList::new;

        /**
         * 静态方法的方法引用
         * 静态方法直接用 类名::方法名
         */
        Function<String,String> ff = Student::staticMethor;
        ff.apply("入参");

        /**
         * 成员方法的方法引用
         * 成员方法引用需要实例化一个类的对象 通过 对象::方法名
         */
         Student student = new Student();
         Supplier<String> ss = student::getAge;

         /**
         * 之前说过，成员方法的第一个参数都是this，所以上面这个get方法的入参其实是Student，返回的是String
         * 所以可以使用Function函数直接通过类名进行方法引用
         * 这也是之后要说的StreamApi的map的方法的原理
         */
         Function<Student,String> sf = Student::getAge;
        /**
         * 如果成员方法已经有一个入参了，可以通过BiFunction方法直接通过类名方法引用
         */
        BiFunction<Student,String,String> biFunction = Student::setName;

    }
}
