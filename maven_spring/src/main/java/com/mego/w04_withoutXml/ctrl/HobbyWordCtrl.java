package com.mego.w04_withoutXml.ctrl;

import com.mego.w03_case.domain.Hobby_word;
import com.mego.w03_case.service.HobbyWordService;
import com.mego.w04_withoutXml.config.SpringConfiguration;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class HobbyWordCtrl {
    @Test
    public void test01(){
        //ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("w03_case.xml");
        //HobbyWordService hobbyWordService = (HobbyWordService) classPathXmlApplicationContext.getBean("hobbyWordService");

        //使用AnnotationConfigApplicationContext类来加载配置类
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        HobbyWordService hobbyWordService = (HobbyWordService) ac.getBean("hobbyWordService");
        List<Hobby_word> wordList = hobbyWordService.findAllWord();
        for (Hobby_word word : wordList){
            System.out.println(word);
        }
    }

    @Test
    public void test02(){
        /*ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("w03_case.xml");
        HobbyWordService hobbyWordService = (HobbyWordService) classPathXmlApplicationContext.getBean("hobbyWordService");*/

        //使用AnnotationConfigApplicationContext类来加载配置类
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        HobbyWordService hobbyWordService = (HobbyWordService) ac.getBean("hobbyWordService");
        Hobby_word hobbyWord = hobbyWordService.getHobbyWord();
        System.out.println(hobbyWord);
    }
}
