package com.megoai.test;

import com.megoai.dao.ItemsDao;
import com.megoai.domain.Items;
import com.megoai.service.ItemsService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ItemsTest {
    @Test
    public void test01(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        ItemsDao itemsDao = applicationContext.getBean(ItemsDao.class);
        Items items = itemsDao.findById(1);
        System.out.println(items.getName());
    }

    @Test
    public void test02(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        ItemsService itemsService = applicationContext.getBean(ItemsService.class);
        Items items = itemsService.findById(1);
        System.out.println(items.getName());
    }
}
