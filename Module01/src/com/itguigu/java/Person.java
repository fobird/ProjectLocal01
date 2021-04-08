package com.itguigu.java;

/**
 * @author superLin
 * @date 2021-04-08 12:09
 */
public class Person {
    public Person() {
    }

    public void eat() {
        try {
            System.out.println("吃饭");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
