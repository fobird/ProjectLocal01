package cn.itcast.xml.Jsoup;

/**
 * @author superLin
 * @date 2021-04-08 18:43
 */

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Jsoup对象功能
 */
public class JsoupDemo2 {
    public static void main(String[] args) {
        //2.1获取student.xml的path
        String path = JsoupDemo2.class.getClassLoader().getResource("student.xml").getPath();
        //3.parse​(URL url, int timeoutMillis)：通过网络路径获取指定的html或xml的文档对象
        URL url = null;
        try {
            url = new URL("https://baike.baidu.com/item/jsoup/9012509?fr=aladdin");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Document doc = null;
        try {
            doc = Jsoup.parse(url, 50000);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(doc);
    }
}
