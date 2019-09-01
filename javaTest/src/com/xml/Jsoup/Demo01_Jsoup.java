package com.xml.Jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *  快速入门案例
 *  操作步骤：
 *      1。引入jar包：jsoup-1.11.2.jar
 *
 *  对象的使用：
 *      1.Jsoup：工具类，可以解析html或xml文档，返回Document
 *          Document parse(File in, String charsetName)：解析xml或html文件。
 *          Document parse(String html)：解析xml或者html字符串。
 *          Document parse(URL url, int timeoutMillis)：通过网络路径获取指定的html或者xml的文档对象。
 *
 *      2.Document：文档对象。代表内存中的dom树。
 *          Element getElementById(String id)：根据id属性值获取唯一的element对象。
 *          Elements getElementsByTag(String tagName)：根据标签名称获取元素对象集合。
 *          Elements getElementsByAttribute(String key)：根据属性名称获取元素对象集合。
 *          Elements getElementsByAttributeValue(String key, String value)；根据对应的属性名和属性值获取元素对象集合。
 *
 *      3.Elements：元素Element对象的集合。可以当做ArrayList<Element>来使用。
 *
 *      4.Element：元素对象。
 *          1.获取子元素对象
 *              Element getElementById(String id)：根据id属性值获取唯一的element对象。
 *              Elements getElementsByTag(String tagName)：根据标签名称获取元素对象集合。
 *              Elements getElementsByAttribute(String key)：根据属性名称获取元素对象集合。
 *              Elements getElementsByAttributeValue(String key, String value)；根据对应的属性名和属性值获取元素对象集合
 *          2.获取属性值
 *              String attr(String key)：根据属性名称获取属性值
 *          3.获取文本内容
 *              String text()：获取文本内容
 *              String html()：获取标签体的所有内容（包括子标签的字符串内容）
 *
 *      5.Node：节点对象。
 *          是Document和Element的父类。
 *
 *  快速查询方法：
 *      1.selector：选择器
 *          使用方法：Elements select(String cssQuery)
 *              语法：参考Selector类中定义的语法
 *
 *      2.XPath：XPath即为XML路径语言（XML Path Language），它是一种用来确定XML文档中某部分位置的语言。
 *          使用Jsoup的Xpath需要额外的导入jar包。
 *          查询w3cshool参考手册，使用Xpath的语法完成查询。
 *
 */
public class Demo01_Jsoup {
    public static void main(String[] args) throws IOException {
        //2.获取Document对象，根据xml文档获取
        String path = Demo01_Jsoup.class.getClassLoader().getResource("student.xml").getPath().toString();
        //3.解析xml文档，加载文档进内存，获取dom树--》Document
        Document document = Jsoup.parse(new File(path),"UTF-8");
        //获取元素对象 Element
        Elements elements = document.getElementsByTag("name");

        System.out.println(elements.size());
        Element element = elements.get(0);
        System.out.println(element.text());
    }

    /**
     * Document parse(String html)：解析xml或者html字符串。
     */
    @Test
    public void parseDemo01(){
        String xml="<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
                " <students>\n" +
                " \t<student number=\"heima_0001\">\n" +
                "\t\t<name>tom</name>\n" +
                "\t\t<age>18</age>\n" +
                "\t\t<sex>male</sex>\n" +
                "\t</student>\n" +
                "\t<student number=\"heima_0002\">\n" +
                "\t\t<name>jack</name>\n" +
                "\t\t<age>18</age>\n" +
                "\t\t<sex>female</sex>\n" +
                "\t</student>\n" +
                " </students>";
        //Document parse(String html)：解析xml或者html字符串。
        Document document = Jsoup.parse(xml);
        System.out.println(document);
    }

    /**
     * Document parse(URL url, int timeoutMillis)：通过网络路径获取指定的html或者xml的文档对象。
     * 使用的场景，可以做网络爬虫，获取到某个网页的信息，然后获取固定的某个值，比如比价网就是这样实现的
     */
    @Test
    public void parseDemo02() throws IOException {
        URL url = new URL("https://www.baidu.com/");
        Document document = Jsoup.parse(url,10000);
        System.out.println(document);
    }
}
