package com.mingYang.Reflect;

import com.mingYang.Reflect.domain.Person;
import org.junit.Test;

import java.lang.reflect.Field;

/**
 *  反射：构造设计的灵魂
 *      框架：半成品软件。可以再框架的基础上进行软件开发，简化代码。
 *      反射：将类的各个组成部分封装为其他对象，这就是反射机制
 *          好处：
 *              1.可以在程序运行过程中，操作这些对象。
 *              2.可以解耦，提高程序得可扩展性。
 *
 *      获取Class对象的方式：
 *          1.Class.forName("全类名")：将字节码文件加载进内存，返回Class对象。
 *              多用于配置文件，将类名定义在配置文件中。读取文件，加载类。
 *          2.类名.class:通过类名的属性class获取
 *              多用于参数的传递。
 *          3.对象.getClass():getClass()方法在object类中定义的。
 *              多用于对象的获取字节码的方式。
 *       结论：
 *          同一个字节码文件（*.class）在一次程序运行过程中，只会被加载一次，无论通过哪一种方式获取得class对象都是同一个对象。
 *
 *  Class对象功能：
 *      1.获取成员变量们：
 *          Field[] getFields() :获取所有public修饰的成员变量；
 *          Field getField(String name) ：获取指定名称的public修饰的成员变量；
 *
 *          Field[] getDeclaredFields() :获取所有的成员变量，不考虑修饰符
 *          Field getDeclaredField(String name) ：获取指定名称的成员变量，不考虑修饰符
 *
 *      2.获取构造方法们：
 *          Constructor<?>[] getConstructor()
 *          Constructor<T> getConstructor(类<?>...parameterTypes)
 *
 *          Constructor<T> getDeclaredConstructor(类<T>...parameterTypes)
 *          Constructor<?>[] getDeclaredConstructors()
 *
 *      3.获取成员方法们：
 *          Method[] getMethods()
 *          Method getMethod(String name,类<？>... parameterTypes)
 *
 *          Method[] getDeclaredMethods()
 *          Method getDeclaredMethod(String name,类<？>...parameterTypes)
 *
 *      4.获取类名
 *          String getName()
 */
public class Demo01Reflect {
    public static void main(String[] args) throws Exception {
        Class aClass = Class.forName("com.mingYang.Reflect.domain.Person");
        System.out.println(aClass);

        Class<Person> personClass = Person.class;
        System.out.println(personClass);

        Person p = new Person();
        System.out.println(p.getClass());

        System.out.println(aClass==personClass);
        System.out.println(aClass==p.getClass());

    }

    /**
     * 获取成员变量的方式
     */
    @Test
    public void field() throws NoSuchFieldException {
        Class<Person> personClass = Person.class;
        //Field[] getFields() :获取所有public修饰的成员变量；
        Field[] fields = personClass.getFields();
        for (Field f : fields){
            System.out.println(f);//public java.lang.String com.mingYang.Reflect.domain.Person.a
        }
        System.out.println("==getField==============================");

        //Field getField(String name) ：获取指定名称的public修饰的成员变量；
        Field a = personClass.getField("a");
        System.out.println(a);//public java.lang.String com.mingYang.Reflect.domain.Person.a

        System.out.println("==getDeclaredFields==============================");
        //Field[] getDeclaredFields() :获取所有的成员变量，不考虑修饰符
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field dfd : declaredFields){
            System.out.println(dfd);
            /**
             * 结果：把所有的成员变量都打印出来了
             * private java.lang.Integer com.mingYang.Reflect.domain.Person.id
             * private java.lang.String com.mingYang.Reflect.domain.Person.name
             * public java.lang.String com.mingYang.Reflect.domain.Person.a
             * protected java.lang.String com.mingYang.Reflect.domain.Person.b
             * java.lang.String com.mingYang.Reflect.domain.Person.c
             * private java.lang.String com.mingYang.Reflect.domain.Person.d
             */
        }

        System.out.println("===================================");
        //Field getDeclaredField(String name) ：获取指定名称的成员变量，不考虑修饰符
    }
}
