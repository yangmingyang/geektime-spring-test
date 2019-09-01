package com.xml.Jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 *  4.Element：元素对象。
 *      1.获取子元素对象
 *          Element getElementById(String id)：根据id属性值获取唯一的element对象。
 *          Elements getElementsByTag(String tagName)：根据标签名称获取元素对象集合。
 *          Elements getElementsByAttribute(String key)：根据属性名称获取元素对象集合。
 *          Elements getElementsByAttributeValue(String key, String value)；根据对应的属性名和属性值获取元素对象集合
 *      2.获取属性值
 *          String attr(String key)：根据属性名称获取属性值
 *      3.获取文本内容
 *          String text()：获取文本内容
 *          String html()：获取标签体的所有内容（包括子标签的字符串内容）
 */
public class Demo03_Jsoup_Element {
    @Test
    public void demo01() throws IOException {
        String path = Demo01_Jsoup.class.getClassLoader().getResource("student.xml").getPath().toString();
        //3.解析xml文档，加载文档进内存，获取dom树--》Document
        Document document = Jsoup.parse(new File(path),"UTF-8");
        Elements elements = document.getElementsByTag("student");
        Element element = elements.get(0);
        Element element1 = element.getElementById("xiaoYang");
        System.out.println(element1);
        System.out.println("============================");

        // String attr(String key)：根据属性名称获取属性值
        String name = element1.attr("id");
        System.out.println(name);

        System.out.println("===========================");

        String text = element1.text();
        System.out.println(text);

        System.out.println("==========================");

        String html = element1.html();
        System.out.println(html);
    }

}
