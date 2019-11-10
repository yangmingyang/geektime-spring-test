package com.mego.w01_bean.ui;

import com.mego.w01_bean.dao.Account;
import com.mego.w01_bean.service.impl.AccountServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 1、spring的概述
     spring是什么
     spring的两大核心
     spring的发展历程和优势
     spring体系结构
 2、程序的耦合及解耦
     曾经案例中问题
     工厂模式解耦
 3、IOC概念和spring中的IOC
    spring中基于XML的IOC环境搭建
 4、依赖注入（Dependency Injection）
 */
public class Client {
    public static void main(String[] args) {
        /**
         ApplicationContext三个常用的实现类：
            1.ClassPathXmlApplicationContext：它可以加载类路径下的配置文件，要求配置文件必须在类路径下。(更常用)
            2.FileSystemXmlApplicationContext：它可以加载磁盘任意路径下的配置文件（必须有访问权限）
            3.AnnotationConfigApplicationContext：它是用于读取注解创建容器的。

         核心容器的两个接口引发出的问题：
            ApplicationContext：适用于单例对象
                它在构建核心容器时，创建对象采取的策略是采用立即加载的方式。也就是说，只要一读取完配置文件马上就创建配置文件中配置的对象。

            BeanFactory：适用于多例对象
                它在构建核心容器时，创建对象采取的策略是采用延迟加载方式。也就是说，什么时候根据id获取对象了，什么时候才真正的创建对象。

         */
        //获取springIoc的核心容器，并根据bean名称获取对应的对象
        //ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("D:\\code\\myselfCode\\geektime-spring-test\\maven_spring\\src\\main\\resources\\bean.xml");
        Account account = (Account) applicationContext.getBean("account");
        account.setId(1);
        account.setName("mingYang");
        System.out.println(account + ":" + account.getName());

        AccountServiceImpl accountServiceImpl = applicationContext.getBean("accountService", AccountServiceImpl.class);
        accountServiceImpl.getAccounts();


    }

    @Test
    public void beanFactoryTest(){
        Resource resource = new ClassPathResource("bean.xml");
        BeanFactory beanFactory = new XmlBeanFactory(resource);
        Account account = (Account) beanFactory.getBean("account");
        System.out.println(account);
    }

    /**
        创建Bean的三种方式
            第一种：适用默认构造函数创建。
                在spring的配置文件中使用bean标签，配以id和class属性之后，且没有其他属性和标签时。
                采用的就是默认构造函数创建bean对象，此时如果类中没有默认构造函数，则对象无法创建。
                <bean id="account" class="com.mego.w01_bean.dao.Account"></bean>

            第二种：使用普通工厂中的方法创建对象（使用某个类中的方法创建对象，并存入spring容器）

            第三种：使用工厂中的静态方法创建对象（使用某个类中的静态方法创建对象，并存入spring容器）
     */

    @Test
    public void beanTest02(){
        //第二种：使用普通工厂中的方法创建对象（使用某个类中的方法创建对象，并存入spring容器）
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        AccountServiceImpl accountService1 = (AccountServiceImpl)applicationContext.getBean("accountService1");
    }

    @Test
    public void beanTest03(){
        // 第三种：使用工厂中的静态方法创建对象（使用某个类中的静态方法创建对象，并存入spring容器）
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        AccountServiceImpl accountService2 = (AccountServiceImpl)applicationContext.getBean("accountService2");
    }
}
