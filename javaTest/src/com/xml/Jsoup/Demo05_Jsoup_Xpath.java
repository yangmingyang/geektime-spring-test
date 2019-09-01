package com.xml.Jsoup;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 *  2.XPath：XPath即为XML路径语言（XML Path Language），它是一种用来确定XML文档中某部分位置的语言。
 *      使用Jsoup的Xpath需要额外的导入jar包:JsoupXpath-0.3.2.jar
 *      查询w3cshool参考手册，使用Xpath的语法完成查询。
 */
public class Demo05_Jsoup_Xpath {
    @Test
    public void demo01() throws IOException, XpathSyntaxErrorException {
        //2.获取Document对象，根据xml文档获取
        String path = Demo01_Jsoup.class.getClassLoader().getResource("student.xml").getPath().toString();
        //3.解析xml文档，加载文档进内存，获取dom树--》Document
        Document document = Jsoup.parse(new File(path),"UTF-8");
        //4.根据Document对象，创建JXDocument对象
        JXDocument jxDocument = new JXDocument(document);

        //查询出所有student标签
        List<JXNode> jxNodes = jxDocument.selN("//student");
        for (JXNode jxNode : jxNodes) {
            System.out.println(jxNode);
        }
        System.out.println("=============================");

        //查询所有student标签下的name标签
        List<JXNode> jxNodes2 = jxDocument.selN("//student/name");
        for (JXNode jxNode : jxNodes2) {
            System.out.println(jxNode);
        }
        System.out.println("=============================");

        //查询student标签下啊带有id属性的name标签
        //title[@lang]	选取所有拥有名为 lang 的属性的 title 元素。
        List<JXNode> jxNodes3 = jxDocument.selN("//student/name[@id]");
        for (JXNode jxNode : jxNodes3) {
            System.out.println(jxNode);
        }

        System.out.println("=============================");

        //查询student标签下啊带有id属性的name标签，并且id属性值为itcast
        ////title[@lang='eng']	选取所有 title 元素，且这些元素拥有值为 eng 的 lang 属性。
        List<JXNode> jxNodes4 = jxDocument.selN("//student/name[@id='xiaoYang']");
        for (JXNode jxNode : jxNodes4) {
            System.out.println(jxNode);
        }
    }
}

