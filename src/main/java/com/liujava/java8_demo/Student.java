package com.liujava.java8_demo;

import java.util.List;

public class Student {

    private String name;
    private String age;

    private List<String> propert;

    public List<String> getPropert() {
        return propert;
    }

    public void setPropert(List<String> propert) {
        this.propert = propert;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public String setName(String name) {
        return name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Student(String age) {
        this.age = age;
    }
    public static String staticMethor(String age){
        return age;
    }
}
