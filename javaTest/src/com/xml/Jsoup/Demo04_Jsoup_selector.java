package com.xml.Jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 *
 *  快速查询方法：
 *      1.selector：选择器
 *          使用方法：Elements select(String cssQuery)
 *              语法：参考Selector类中定义的语法,可以根据下载出来的jar包文档去查询Selector类中定义的语法。
 */
public class Demo04_Jsoup_selector {
    @Test
    public void demo01() throws IOException {
        String path = Demo01_Jsoup.class.getClassLoader().getResource("student.xml").getPath().toString();
        //3.解析xml文档，加载文档进内存，获取dom树--》Document
        Document document = Jsoup.parse(new File(path),"UTF-8");
        //要求查询出student标签下number="heima_0001"的标签
        Elements elements = document.select("student[number=\"heima_0001\"]");
        System.out.println(elements);
        /**
         * <student number="heima_0001">
         *  <name id="xiaoYang">
         *   tom
         *  </name>
         *  <age>
         *   18
         *  </age>
         *  <sex>
         *   male
         *  </sex>
         * </student>
         */

        System.out.println("========================");
        //要求查询出student标签下number="heima_0001"的标签元素下的age元素
        Elements elements2 = document.select("student[number=\"heima_0001\"] age");
        System.out.println(elements2);
        /**
         * <age>
         *  18
         * </age>
         */
    }
}
