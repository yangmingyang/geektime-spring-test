package com.mego.w04_withoutXml.ctrl;

import com.mego.w03_case.domain.Hobby_word;
import com.mego.w03_case.service.HobbyWordService;
import com.mego.w04_withoutXml.config.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 spring整合Junit
    1.应用程序的入口
        main方法
    2.junit单元测试中，没有main方法也能执行
        原因是junit集成了一个main方法
        该方法就会判断当前测试类中哪些方法有@Test注解
    3.junit不会管我们是否采用spring框架
        在执行测试方法时，junit根本不知道我们是不是使用了spring框架
        所以也就不会为我们读取配置文件/配置类创建spring核心容器
    4.由以上三点可知
        当测试方法执行时，没有IOC容器，就算写了Autowired注解，也无法实现注入。

 使用Junit单元测试：测试我们的配置
 Spring整合junit的配置
    1.导入spring整合junit的jar(坐标)
     <dependency>
         <groupId>org.springframework</groupId>
         <artifactId>spring-test</artifactId>
         <version>5.2.1.RELEASE</version>
         <scope>test</scope>
     </dependency>
    2.使用Junit提供的一个注解把原有的main方法替换了，替换成spring提供的
        @RunWith
    3.告知spring的运行器，spring和ioc创建时基于xml还是注解的。并且说明位置。
        @ContextConfiguration
            locations：指定xml文件的位置，加上classpath关键字，表示在类路径下
            classes：指定注解类所在的位置。
    当我们使用spring5.x版本的时候，要求junit的jar必须是4.12及以上。
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
//@ContextConfiguration(locations = "classpath:w03_case.xml")
public class JunitTest {
    @Autowired
    HobbyWordService hobbyWordService;

    @Test
    public void test01(){
        //使用AnnotationConfigApplicationContext类来加载配置类
        // AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
       // HobbyWordService hobbyWordService = (HobbyWordService) ac.getBean("hobbyWordService");
        List<Hobby_word> wordList = hobbyWordService.findAllWord();
        for (Hobby_word word : wordList){
            System.out.println(word);
        }
    }

    @Test
    public void test02(){
        //使用AnnotationConfigApplicationContext类来加载配置类
        //AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //HobbyWordService hobbyWordService = (HobbyWordService) ac.getBean("hobbyWordService");
        Hobby_word hobbyWord = hobbyWordService.getHobbyWord();
        System.out.println(hobbyWord);
    }
}
