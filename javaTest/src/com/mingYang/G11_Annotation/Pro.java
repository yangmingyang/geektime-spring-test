package com.mingYang.G11_Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Pro {
     String className();
     String methodName();
}
/**
 *   注意：我们实际上定义注解只是注意了一个抽象方法而已，但在实际使用的过程中，jvm会自动帮我们创建一个该子类的实现对象。
 */
/*public class ProImpl implements  Pro{
    public String className(){
        return "com.mingYang.G10_Reflect.domain.Person";
    }
    public String methodName(){
        return "eat";
    }
}*/
