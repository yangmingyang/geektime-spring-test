package com.mego.w03_case.ctrl;

import com.mego.w03_case.domain.Hobby_word;
import com.mego.w03_case.service.HobbyWordService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class HobbyWordCtrl {
    @Test
    public void test01(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("case.xml");
        HobbyWordService hobbyWordService = (HobbyWordService) classPathXmlApplicationContext.getBean("hobbyWordService");
        List<Hobby_word> wordList = hobbyWordService.findAllWord();
        for (Hobby_word word : wordList){
            System.out.println(word);
        }
    }

    @Test
    public void test02(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("case.xml");
        HobbyWordService hobbyWordService = (HobbyWordService) classPathXmlApplicationContext.getBean("hobbyWordService");
        Hobby_word hobbyWord = hobbyWordService.getHobbyWord();
        System.out.println(hobbyWord);
    }
}
