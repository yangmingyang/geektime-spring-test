package com.mingYang.Reflect;

import com.mingYang.Reflect.domain.Person;
import org.junit.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 *  获取构造方法们：
 *      Constructor<?>[] getConstructor(): 获取所有public修饰的构造方法
 *      Constructor<T> getConstructor(类<?>...parameterTypes)：获取指定参数的public修饰的构造方法；
 *
 *      Constructor<T> getDeclaredConstructor(类<T>...parameterTypes)：获取指定参数的构造方法,不考虑修饰符；
 *      Constructor<?>[] getDeclaredConstructors()：取所有的构造方法，不考虑修饰符
 *
 *  思考：创建构造方法的作用是什么？
 *      答：构造方法就是可以创建对象。
 *          创建对象：
 *              T newInstance(Object... initArgs)
 *              如果使用空参数构造方法创建对象，操作可以简化：Class对象的newInstance方法。
 */
public class Demo03Reflect_Constructor {

    /**
     * Constructor<T> getConstructor(类<?>...parameterTypes)：获取指定参数的public修饰的构造方法；
     */
    @Test
    public void getConstructorTest() throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Class<Person> personClass = Person.class;
        //Constructor<T> getConstructor(类<?>...parameterTypes)：获取指定参数的public修饰的构造方法；
        Constructor<Person> c = personClass.getConstructor(Integer.class,String.class);
        //java.lang.NoSuchMethodException: com.mingYang.Reflect.domain.Person.<init>(java.lang.Integer, java.lang.String)如果构造方法是私有的，则会报这个错误
        Person person = c.newInstance(1,"my");
        System.out.println(person);
    }

    /**
     * Constructor<?>[] getConstructor(): 获取所有public修饰的构造方法
     */
    @Test
    public void getConstructorsTest(){
        Class<Person> personClass = Person.class;
        //Constructor<?>[] getConstructor(): 获取所有public修饰的构造方法
        Constructor<Person>[] constructors = (Constructor<Person>[]) personClass.getConstructors();
        for (Constructor<Person> c:  constructors){
            System.out.println(c);
            /**
             * 结果：两个构造方法都打印出来了，注意只能是public构造方法
             *  public com.mingYang.Reflect.domain.Person()
             *  public com.mingYang.Reflect.domain.Person(java.lang.Integer,java.lang.String)
             */
        }
    }

    /**
     *  Constructor<T> getDeclaredConstructor(类<T>...parameterTypes)：获取指定参数的构造方法,不考虑修饰符；
     */
    @Test
    public void getDeclaredConstructorTest() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Person> personClass = Person.class;
        //Constructor<T> getDeclaredConstructor(类<T>...parameterTypes)：获取指定参数的构造方法,不考虑修饰符；
        Constructor<Person> declaredConstructor = personClass.getDeclaredConstructor(Integer.class, String.class);
        //忽略访问权限修饰符的安全检查
        declaredConstructor.setAccessible(true);
        Person xYang = declaredConstructor.newInstance(1, "xYang");
        System.out.println(xYang);//Person{id=1, name='xYang', a='null', b='null', c='null', d='null'}
    }

    /**
     * Constructor<?>[] getDeclaredConstructors()：取所有的构造方法，不考虑修饰符
     */
    @Test
    public void getDeclaredConstructorsTest(){
        Class<Person> personClass = Person.class;
        Constructor<Person>[] declaredConstructors = (Constructor<Person>[]) personClass.getDeclaredConstructors();
        for (Constructor<Person> c : declaredConstructors){
            System.out.println(c);
            /**
             * 获取的结果：把所有的构造方法都获取到了
             * public com.mingYang.Reflect.domain.Person(java.lang.String)
             * private com.mingYang.Reflect.domain.Person(java.lang.Integer,java.lang.String)
             * public com.mingYang.Reflect.domain.Person()
             */
        }
    }

}
