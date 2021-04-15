package cn.itcast.xml.Jsoup;

/**
 * @author superLin
 * @date 2021-04-08 19:06
 */

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * Element对象功能
 */
public class JsoupDemo4 {
    public static void main(String[] args) {
        //1.获取student.xml的path
        String path = JsoupDemo4.class.getClassLoader().getResource("student.xml").getPath();
        //2.获取Document对象
        Document document = null;
        try {
            document = Jsoup.parse(new File(path), "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
        Element：元素对象
				1. 获取子元素对象
					* getElementById​(String id)：根据id属性值获取唯一的element对象
					* getElementsByTag​(String tagName)：根据标签名称获取元素对象集合
					* getElementsByAttribute​(String key)：根据属性名称获取元素对象集合
					* getElementsByAttributeValue​(String key, String value)：根据对应的属性名和属性值获取元素对象集合

				2. 获取属性值
					* String attr(String key)：根据属性名称获取属性值
				3. 获取文本内容
					* String text():获取所有字标签的纯文本内容
					* String html():获取标签体的所有内容(包括子标签的标签和文本内容)
         */
        //通过Document对象获取name标签，获取所有的name标签，可以获取到两个
        Elements name = document.getElementsByTag("name");
        int name_size = name.size();
        System.out.println("name_size = " + name_size);
        System.out.println(name);
        //通过Element对象获取子标签对象
        Element firststudent = document.getElementsByTag("student").get(0);
        Elements firststudentname = firststudent.getElementsByTag("name");
        System.out.println("=--------------");
        System.out.println(firststudentname);
        //获取student对象的属性值
        System.out.println("=--------------");
        String number = firststudent.attr("number");
        System.out.println("numhber = " + number);
        System.out.println("=--------------");
        //获取文本内容
        String html = firststudent.html();
        System.out.println("html = " + html);
        System.out.println("=--------------");
        String text = firststudent.text();
        System.out.println("text = " + text);

    }
}
