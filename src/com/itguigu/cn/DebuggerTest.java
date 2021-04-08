package com.itguigu.cn;

import java.util.HashMap;

/**
 * @author superLin
 * @date 2021-04-08 16:58
 */
public class DebuggerTest {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("name", "tom");
        map.put("age", "12");
        map.put("code", "001");
        map.put("gender", "male");

        String age = map.get("age");
        System.out.println("age = " + age);

        map.remove("code");
        System.out.println(map);
    }
}
