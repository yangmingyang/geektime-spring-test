package com.xml.Jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 *  2.Document：文档对象。代表内存中的dom树。
 *      Element getElementById(String id)：根据id属性值获取唯一的element对象。
 *      Elements getElementsByTag(String tagName)：根据标签名称获取元素对象集合。
 *      Elements getElementsByAttribute(String key)：根据属性名称获取元素对象集合。
 *      Elements getElementsByAttributeValue(String key, String value)；根据对应的属性名和属性值获取元素对象集合。
 */
public class Demo02_Jsoup {
    @Test
    public void demo01() throws IOException {
        String path = Demo01_Jsoup.class.getClassLoader().getResource("student.xml").getPath().toString();
        //3.解析xml文档，加载文档进内存，获取dom树--》Document
        Document document = Jsoup.parse(new File(path),"UTF-8");
        Element element = document.getElementById("xiaoYang");
        System.out.println(element);
        /**
         * 结果：如下
         * <name id="xiaoYang">
         *  tom
         * </name>
         */
    }

    @Test
    public void demo02() throws IOException {
        String path = Demo01_Jsoup.class.getClassLoader().getResource("student.xml").getPath().toString();
        //3.解析xml文档，加载文档进内存，获取dom树--》Document
        Document document = Jsoup.parse(new File(path),"UTF-8");
        Elements elements = document.getElementsByTag("name");
        System.out.println(elements);
        /**
         * 结果：如下
         *<name id="xiaoYang">
         *  tom
         * </name>
         * <name>
         *  jack
         * </name>
         */
    }


    /**
     * Elements getElementsByAttribute(String key)：根据属性名称获取元素对象集合。
     */
    @Test
    public void demo03() throws IOException {
        String path = Demo01_Jsoup.class.getClassLoader().getResource("student.xml").getPath().toString();
        //3.解析xml文档，加载文档进内存，获取dom树--》Document
        Document document = Jsoup.parse(new File(path),"UTF-8");
        Elements elements = document.getElementsByAttribute("id");
        System.out.println(elements);
        /**
         * 结果：如下
         * <name id="xiaoYang">
         *  tom
         * </name>
         */
    }

    /**
     * Elements getElementsByAttributeValue(String key, String value)；根据对应的属性名和属性值获取元素对象集合。
     */
    @Test
    public void demo04() throws IOException {
        String path = Demo01_Jsoup.class.getClassLoader().getResource("student.xml").getPath().toString();
        //3.解析xml文档，加载文档进内存，获取dom树--》Document
        Document document = Jsoup.parse(new File(path),"UTF-8");
        Elements elements = document.getElementsByAttributeValue("number","heima_0002");
        System.out.println(elements);
        /**
         * 结果：如下
         * <student number="heima_0002">
         *  <name>
         *   jack
         *  </name>
         *  <age>
         *   18
         *  </age>
         *  <sex>
         *   female
         *  </sex>
         * </student>
         */
    }
}
