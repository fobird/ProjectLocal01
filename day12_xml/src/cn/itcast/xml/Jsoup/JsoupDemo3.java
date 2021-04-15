package cn.itcast.xml.Jsoup;

/**
 * @author superLin
 * @date 2021-04-08 18:48
 */

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * Document/Element对象功能
 */
public class JsoupDemo3 {
    public static void main(String[] args) {
        //1.获取student.xml的path
        String path = JsoupDemo3.class.getClassLoader().getResource("student.xml").getPath();
        //2.获取Document对象
        Document doc = null;
        try {
            doc = Jsoup.parse(new File(path), "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //3.获取元素对象了。
        //3.1获取所有student对象
        Elements student = doc.getElementsByTag("student");
        System.out.println(student);
        System.out.println("-------------------------");
        //3.2 获取属性名为id的元素对象们
        Elements idElements = doc.getElementsByAttribute("id");
        System.out.println(idElements);
        System.out.println("-------------------------");
        //3.2获取 number属性值为heima_0001的元素对象
        Elements heima_0001 = doc.getElementsByAttributeValue(" number", "heima_0001");
        System.out.println(heima_0001);

        System.out.println("-------------------------");
        //3.3获取id属性值的元素对象
        Element itcast = doc.getElementById("itcast");
        System.out.println(itcast);
        System.out.println("-------------------------");

    }
}
