package com.mego.w01_bean.ctrl;

import com.mego.w01_bean.dao.Account;
import com.mego.w01_bean.service.impl.AccountServiceImpl;
import com.mego.w01_bean.service.impl.StudentServiceImpl;
import com.mego.w01_bean.service.impl.StudentServiceImpl2;
import com.mego.w01_bean.service.impl.StudentServiceImpl3;
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
        //ApplicationContext applicationContext = new ClassPathXmlApplicationContext("w01_bean.xml");
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("D:\\code\\myselfCode\\geektime-spring-test\\maven_spring\\src\\main\\resources\\w01_bean.xml");
        Account account = (Account) applicationContext.getBean("account");
        account.setId(1);
        account.setName("mingYang");
        System.out.println(account + ":" + account.getName());

        AccountServiceImpl accountServiceImpl = applicationContext.getBean("accountService", AccountServiceImpl.class);
        accountServiceImpl.getAccounts();


    }

    @Test
    public void beanFactoryTest(){
        Resource resource = new ClassPathResource("w01_bean.xml");
        BeanFactory beanFactory = new XmlBeanFactory(resource);
        Account account = (Account) beanFactory.getBean("account");
        System.out.println(account);
    }

    /**
        1.创建Bean的三种方式
            第一种：适用默认构造函数创建。
                在spring的配置文件中使用bean标签，配以id和class属性之后，且没有其他属性和标签时。
                采用的就是默认构造函数创建bean对象，此时如果类中没有默认构造函数，则对象无法创建。
                <bean id="account" class="com.mego.w01_bean.dao.Account"></bean>

            第二种：使用普通工厂中的方法创建对象（使用某个类中的方法创建对象，并存入spring容器）
             <bean id="instanceFactory" class="com.mego.w01_bean.factory.InstanceFactory"></bean>
             <bean id="accountService1" factory-bean="instanceFactory" factory-method="getAccountService"></bean>

            第三种：使用工厂中的静态方法创建对象（使用某个类中的静态方法创建对象，并存入spring容器）
            <bean id="accountService2" class="com.mego.w01_bean.factory.StaticFactory" factory-method="getAccountService"></bean>

        2.bean的作用范围调整
            bean标签的scope属性：
                作用：用于指定bean的作用范围。
                取值：常用的就是单例和多例
                    singleton：单例的（默认值）
                    prototype：多例的
                    request：作用于web应用的请求范围。
                    session：作用于web应用的会话范围。
                    global-session：作用于集群环境的会话范围（全局会话范围），当不是集群环境时，它就是session
            <bean id="account" class="com.mego.w01_bean.dao.Account" scope="singleton"></bean>

        3.bean对象的生命周期
            单例对象
                出生：当容器创建时对象出生。
                活着：只要容器还在，对象一直活着。
                死亡：容器销毁，对象消亡。
                总结：单例对象的生命周期和容器相同。
            多例对象：
                出生：当我们使用对象时spring框架为我们创建。
                活着：对象只要是在使用过程中就一直活着。
                死亡：当对象长时间不用，且没有别的对象引用时，由Java的垃圾回收器回收。
        4.spring中的依赖注入
            依赖注入：Dependency Injection
            IOC的作用：降低程序间的耦合（依赖关系）
            依赖关系的管理：以后都交给spring来维护。
                在当前类需要用到其他类的对象，由spring为我们提供，我们只需要在配置文件中说明。
            依赖关系的维护：就称之为依赖注入。
            依赖注入：
                有三类能注入的数据：
                    基本类型和String
                    其他bean类型（在配置文件中或者注解配置过的bean）
                    复杂类型/集合类型
                三种注入方式：
                    1.使用构造函数提供。
                        使用的标签：constructor-arg
                        标签出现的位置：bean标签的内部
                        标签中的属性
                            type：用于指定要注入的数据的数据类型，该数据类型也是构造函数中某个或某些参数的类型。
                            index：用于指定要注入的数据给构造函数中指定索引位置的参数赋值。索引的位置是从0开始。
                            name：用于指定给构造函数中指定名称的参数赋值。
                            value：用于提供基本类型和String类型的数据。
                            ref：用于指定其他的bean类型数据。它指的就是在spring的IOC核心容器中出现过的bean对象。
                        优点：
                            在获取bean对象时，注入数据是必须的操作，否则对象无法创建成功。
                        弊端：
                            改变了bean对象的实例化方法，使我们在创建对象时，如果用不到这些数据，也必须提供。
                    2.使用set方法提供。
                        set方法注入
                            涉及的标签：property
                            出现的位置：bean标签的内部。
                            标签的属性
                                name：用于指定注入时所调用的set方法名称。
                                value：用于提供基本类型和String类型的数据。
                                ref：用于指定其他的bean类型数据。它指的就是在spring的IOC核心容器中出现过的bean对象。
                        优势：
                            创建对象时没有明确的限制，可以直接使用默认构造函数。
                        弊端：
                            如果有某个成员必须有值，则获取对象是由可能set方法没有执行。
                    3.复杂类型的注入/结合类型的注入
                        用于给List结构集合煮的标签
                            list    array   set
                        用于给Map结构集合注入的标签
                            map     props
                        总结：结构相同，标签可以互换
     */

    @Test
    public void beanTest02(){
        //第二种：使用普通工厂中的方法创建对象（使用某个类中的方法创建对象，并存入spring容器）
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("w01_bean.xml");
        AccountServiceImpl accountService1 = (AccountServiceImpl)applicationContext.getBean("accountService1");
        System.out.println(accountService1);
    }

    @Test
    public void beanTest03(){
        // 第三种：使用工厂中的静态方法创建对象（使用某个类中的静态方法创建对象，并存入spring容器）
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("w01_bean.xml");
        AccountServiceImpl accountService2 = (AccountServiceImpl)applicationContext.getBean("accountService2");
        System.out.println(accountService2);
    }

    @Test
    public void DITest04(){
        /**
         1.使用构造函数提供。
         使用的标签：constructor-arg
         标签出现的位置：bean标签的内部
         标签中的属性
             type：用于指定要注入的数据的数据类型，该数据类型也是构造函数中某个或某些参数的类型。
             index：用于指定要注入的数据给构造函数中指定索引位置的参数赋值。索引的位置是从0开始。
             name：用于指定给构造函数中指定名称的参数赋值。
             value：用于提供基本类型和String类型的数据。
             ref：用于指定其他的bean类型数据。它指的就是在spring的IOC核心容器中出现过的bean对象。
         优点：
            在获取bean对象时，注入数据是必须的操作，否则对象无法创建成功。
         弊端：
            改变了bean对象的实例化方法，使我们在创建对象时，如果用不到这些数据，也必须提供。
         */
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("w01_di.xml");
        StudentServiceImpl studentServiceImpl = (StudentServiceImpl) classPathXmlApplicationContext.getBean("studentService");
        studentServiceImpl.saveStudent();
    }

    @Test
    public void DITest05(){
        /**
         2.使用set方法提供。
         set方法注入
         涉及的标签：property
         出现的位置：bean标签的内部。
         标签的属性
             name：用于指定注入时所调用的set方法名称。
             value：用于提供基本类型和String类型的数据。
             ref：用于指定其他的bean类型数据。它指的就是在spring的IOC核心容器中出现过的bean对象。
         优势：
            创建对象时没有明确的限制，可以直接使用默认构造函数。
         弊端：
            如果有某个成员必须有值，则获取对象是由可能set方法没有执行。
         */
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("w01_di.xml");
        StudentServiceImpl2 studentServiceImpl = (StudentServiceImpl2) classPathXmlApplicationContext.getBean("studentService2");
        studentServiceImpl.saveStudent();
    }

    @Test
    public void DITest06(){
        /**
         3.复杂类型的注入/结合类型的注入
             用于给List结构集合煮的标签
                list    array   set
             用于给Map结构集合注入的标签
                 map     props
         总结：结构相同，标签可以互换
         */
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("w01_di.xml");
        StudentServiceImpl3 studentServiceImpl = (StudentServiceImpl3) classPathXmlApplicationContext.getBean("studentService3");
        studentServiceImpl.saveStudent();
    }
}
