package com.itguigu.cn;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author superLin
 * @date 2021-04-08 13:32
 */
public class TemplateTest {
    //模板6  prsf：可生成 private static final
    private static final int NUMBER = 10;
    public static final int CODE = 500;
    public static final String NAME = "张三";
    public static final String WEATHER = "晴天";

    /*
    psf：可生成 public static final
    psfi：可生成 public static final int
    psfs：可生成 public static final string*/
    //模板1  psvm : 可生成 main 方法
    public static void main(String[] args) {
        //模板2 sout : System.out.println() 快捷输出
        System.out.println("输出第一条");
       /* soutp = System.out.println("方法形参名 = " + 形参名);
        soutv = System.out.println("变量名 = " + 变量);
        soutm = System.out.println("当前类名.当前方法");
        “abc”.sout =>System.out.println("abc")*/
        System.out.println("args = " + Arrays.deepToString(args));
        System.out.println("TemplateTest.main");
        method();
        int num1 = 10;
        System.out.println("num1 = " + num1);
        int num2 = 20;
        System.out.println("num2 = " + num2);
        System.out.println(num1);

        System.out.println("------------------------------");
        String[] arr = {"aa", "bb", "cc"};
        //模板3 fori
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
//        iter：可生成增强 for 循环
        for (String s : arr) {
            System.out.println(s);
        }
//        itar：可生成普通 for 循环
        for (int i = 0; i < arr.length; i++) {
            String s = arr[i];
            System.out.println(s);
        }
        System.out.println("------------------------------");
        //模板4 list.for : 可生成集合 list 的 for 循环
        ArrayList<Integer> list = new ArrayList<>();
        list.add(123);
        list.add(321);
        list.add(111);
        for (Integer integer : list) {
            System.out.println(integer);
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.println(list.get(i));
        }
    }


    private static void method() {
        // 模板5：ifn：可生成 if(xxx = null)
        ArrayList<Integer> list = new ArrayList<>();
        list.add(123);
        list.add(321);
        list.add(111);
        if (list != null) {

        }
        if (list == null) {

        }
        if (list == null) {

        }
        if (list != null) {

        }
        System.out.println("TemplateTest.method");
    }
}
