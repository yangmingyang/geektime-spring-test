package com.mego.w02_anno.ctrl;

import com.mego.w02_anno.dao.Student;
import com.mego.w02_anno.service.impl.StudentServiceImpl;
import com.mego.w02_anno.service.impl.StudentServiceImpl2;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 曾经XML的配置：
     <bean id="" class="" scope="" init-method="" destroy-method="">
        <property name="" value="" | ref=""></property>
     </bean>
 用于创建对象。

 1.注解：
    他们的作用和在XML配置文件中编写一个<bean>标签实现的功能是一样的。
    @Component
        作用：用于把当前类对象存入spring容器中。
        属性；value：用于指定bean的id。当我们不写时，他的默认值是当前类名，且首字母改小写。
     @Controller：y一般用在表现层
     @Service：一般用在业务层
     @Repository：一般用在持久层
    以上三个注解他们的作用和属性与Component是一模一样的。他们三个是spring框架为我们提供明确的三层架构使用的注解，使我们的三层对象更加清晰。

 2.用于注入数据
    他们的作用就和在xml配置文件中的bean标签中写一个<property>标签的作用是一样的。
    @Autowired
        作用：自动按照类型注入。只要容器中有唯一的一个bean对象类型和要注入的变量类型匹配，就可以注入成功。
            如果ioc容器中没有任何bean的类型和要注入的变量类型匹配，则报错。
            如果IOC容器中有多个类型匹配时：
        出现位置：
            可以是变量上，也可以是方法上。
        细节：
            在使用注解注入时，set方法就不是必须的了。
    @Qualifier:
        作用；在按照类中注入的基础之上再按照名称注入。它在给类成员注入时不能单独使用，要配合@Autowired一起使用。但是在给方法参数注入时可以单独使用。
        属性：
            value：用于指定注入bean的id.
    @Resource:
        作用：直接按照bean的id注入。它可以独立使用。
        属性；
            name：用于指定bean的id.
    以上三个注入都只能注入其他bean类型的数据，而基本类型和String类型无法使用上述注解实现。
    另外，集合类型的注入只能通过xml来实现。
    @Value;
        作用：用于注入基本类型和String类型的数据。
        属性：
            value：用于指定数据的值。它可以使用spring中的SpEL(也就是spring的el表达式)
                    SpEL的写法：${表达式}

 3.用于改变作用范围
    他们的作用就和在bean标签中使用scope属性实现的功能是一样的。
    @Scope
        作用：用于指定bean的作用范围。
        属性：
            value：指定范围的取值。常用取值：singleton    prototype

 4.和生命周期相关
    他们的作用就和在bean标签中使用init-method和destroy-method的作用是一样的。
    @PreDestroy
        作用：用于指定销毁方法。
    @PostConstruct
        作用：用于指定初始化方法

 */
public class StudentCtrl {
    @Test
    public void test01(){
        // 1.注解
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("anno.xml");
        StudentServiceImpl studentServiceImpl1 = (StudentServiceImpl) classPathXmlApplicationContext.getBean("studentServiceImpl");
        studentServiceImpl1.saveStudent();

        Student student = classPathXmlApplicationContext.getBean("student", Student.class);
        student.setAge(18);
        student.setName("小明");
    }

    @Test
    public void test02(){
        //2.用于注入数据
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("anno.xml");
        StudentServiceImpl2 studentService2 = classPathXmlApplicationContext.getBean("studentService2", StudentServiceImpl2.class);
        studentService2.saveStudent();
        classPathXmlApplicationContext.close();
        /**
         思考一个问题：
            现在公司的项目，都是直接通过注入service，通过接口去调用实现类的方法，如果同样的接口，有两个实现类，那么spring
         第一步就是先把相同类型找出来，然后再根据名称去匹配，如果名称匹配不到就会报错误。
         */
    }

}
