package cn.itcast.xml.Jsoup;

/**
 * @author superLin
 * @date 2021-04-08 18:31
 */

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.IOException;

/**
 * Jsoup快速入门
 */
public class JsoupDemo1 {
    public static void main(String[] args) throws IOException {
        //2.获取Document对象，根据xml文档获取
        // 2.1获取student.xml的path
        String path = JsoupDemo1.class.getClassLoader().getResource("student.xml").getPath();
        //2.2解析xml文档，加载文档进内存，获取dom树--->Document
        Document doc = null;
        doc = Jsoup.parse(new File(path), "utf-8");

        //3.获取元素对象 Element
        //3.1获取第一个name的Element对象
        Element element01 = doc.getElementById("itcast");
        //3.2获取数据
        System.out.println(element01.html());

    }
}
