package com.mingYang.Reflect;

import com.mingYang.Reflect.domain.Person;
import org.junit.Test;

import java.lang.reflect.Field;

/**
 *  反射之成员变量
 *  1.获取成员变量们：
 *      Field[] getFields() :获取所有public修饰的成员变量；
 *      Field getField(String name) ：获取指定名称的public修饰的成员变量；
 *
 *      Field[] getDeclaredFields() :获取所有的成员变量，不考虑修饰符
 *      Field getDeclaredField(String name) ：获取指定名称的成员变量，不考虑修饰符
 *  思考一个问题：
 *      那就是我们获取到了成员变量，然后我们又能操作一些什么事情呢？
 *      Field:成员变量
 *          操作：
 *              1.设置值 void set(Object obj, Object value)
 *              2.获取值 get(Object obj)
 *              3.忽略访问权限修饰符的安全检查： setAccessible(true):这也叫暴力反射
 *
 */
public class Demo02Reflect_Field {
    /**
     * 获取成员变量的方式
     */
    @Test
    public void getFields(){
        Class<Person> personClass = Person.class;
        //Field[] getFields() :获取所有public修饰的成员变量；
        Field[] fields = personClass.getFields();
        for (Field f : fields){
            System.out.println(f);//public java.lang.String com.mingYang.Reflect.domain.Person.a
        }
    }

    @Test
    public void getField() throws NoSuchFieldException {
        Class<Person> personClass = Person.class;
        //Field getField(String name) ：获取指定名称的public修饰的成员变量；
        Field a = personClass.getField("a");
        System.out.println(a);//public java.lang.String com.mingYang.Reflect.domain.Person.a
    }

    @Test
    public void getDeclaredFields(){
        Class<Person> personClass = Person.class;
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
    }
    @Test
    public void getDeclaredField() throws NoSuchFieldException, IllegalAccessException {
        Class<Person> personClass = Person.class;
        //Field getDeclaredField(String name) ：获取指定名称的成员变量，不考虑修饰符
        Field d = personClass.getDeclaredField("d");
        System.out.println(d);//private java.lang.String com.mingYang.Reflect.domain.Person.d

        //获取成员之中的值，默认值为null
        Person p = new Person();
        //默认私有方法会报错，我们需要暴力破解一下
        /**
         *  忽略访问权限修饰符的安全检查
         *  d.setAccessible(true);
         */
        d.setAccessible(true);
        Object o = d.get(p);//java.lang.IllegalAccessException: Class com.mingYang.Reflect.Demo02Reflect_Field can not access a member of class com.mingYang.Reflect.domain.Person with modifiers "private"
        System.out.println(o);

        d.set(p,"mingYang");
        System.out.println(p);//Person{id=null, name='null', a='null', b='null', c='null', d='mingYang'}

    }

}
