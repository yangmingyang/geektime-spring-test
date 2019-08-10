package com.mingYang.Reflect;

import com.mingYang.Reflect.domain.Person;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *  获取成员方法们：
 *      Method[] getMethods()：获取所有public修饰的成员方法；
 *      Method getMethod(String name,类<？>... parameterTypes)：获取指定参数public修饰的成员方法；
 *
 *      Method[] getDeclaredMethods()：取所有的成员方法，不考虑修饰符
 *      Method getDeclaredMethod(String name,类<？>...parameterTypes)：取指定的成员方法，不考虑修饰符
 *
 *  思考：获取方法，我们有什么作用呢？
 *      答：获取到方法，就是要调用执行方法。
 *
 */
public class Demo04Reflect_Method {
    /**
     *  Method getMethod(String name,类<？>... parameterTypes)：获取指定参数public修饰的成员方法；
     */
    @Test
    public void getMethodTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<Person> personClass = Person.class;
        //获取的是一个无参数的方法
        /* Method eat = personClass.getMethod("eat");
        Person p = new Person();
        eat.invoke(p);*/

        Method eat = personClass.getMethod("eat", String.class);
        Person p = new Person();
        eat.invoke(p,"饭");
    }

    /**
     * Method getMethod(String name,类<？>... parameterTypes)：获取指定参数public修饰的成员方法；
     */
    @Test
    public void getMethodsTest(){
        Class<Person> personClass = Person.class;
        Method[] methods = personClass.getMethods();
        for (Method m : methods){
            /**
             *  注意：
             *  获取到的方法，会把父类的一些继承下来的方法也获取到。比如我们写的person类，默认是继承了Object类，
             *  所以会有Object类的一些方法
             */
            System.out.println(m);

        }
    }

    /**
     * Method getDeclaredMethod(String name,类<？>...parameterTypes)：取指定的成员方法，不考虑修饰符
     */
    @Test
    public void getDeclaredMethodMethod() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<Person> personClass = Person.class;
        Method eat = personClass.getDeclaredMethod("eat", String.class, String.class);
        Person p = new Person();
        //忽略访问权限修饰符的安全检查,这样私有方法才可以调用
        eat.setAccessible(true);
        eat.invoke(p,"名扬","苹果");
    }

    /**
     * Method[] getDeclaredMethods()：取所有的成员方法，不考虑修饰符
     */
    @Test
    public void getDeclaredMethodsTest(){
        Class<Person> personClass = Person.class;
        Method[] declaredMethods = personClass.getDeclaredMethods();
        for (Method m : declaredMethods){
            System.out.println(m);
            /**
             * 打印出来的结果：
             * public java.lang.String com.mingYang.Reflect.domain.Person.toString()
             * public java.lang.String com.mingYang.Reflect.domain.Person.getName()
             * public java.lang.Integer com.mingYang.Reflect.domain.Person.getId()
             * public void com.mingYang.Reflect.domain.Person.setName(java.lang.String)
             * public void com.mingYang.Reflect.domain.Person.eat()
             * private void com.mingYang.Reflect.domain.Person.eat(java.lang.String,java.lang.String)
             * public void com.mingYang.Reflect.domain.Person.eat(java.lang.String)
             * public java.lang.String com.mingYang.Reflect.domain.Person.getB()
             * public java.lang.String com.mingYang.Reflect.domain.Person.getA()
             * public void com.mingYang.Reflect.domain.Person.setB(java.lang.String)
             * public void com.mingYang.Reflect.domain.Person.setD(java.lang.String)
             * public void com.mingYang.Reflect.domain.Person.setA(java.lang.String)
             * public void com.mingYang.Reflect.domain.Person.setId(java.lang.Integer)
             * public java.lang.String com.mingYang.Reflect.domain.Person.getC()
             * public java.lang.String com.mingYang.Reflect.domain.Person.getD()
             * public void com.mingYang.Reflect.domain.Person.setC(java.lang.String)
             */
        }
    }
}
