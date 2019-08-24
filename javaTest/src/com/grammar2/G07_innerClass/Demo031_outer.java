package com.grammar2.G07_innerClass;

/**
 *  如果一个类是定义在一个方法内部的，那么这就是一个局部内部类。
 *  “局部”：只有当前所属的方法才能使用它，出了这个方法外面就不能用了。
 *
 *  定义格式：
 *      修饰符 class 外部类名称{
 *          修饰符 放回值类型 外部类方法名称（参数列表）{
 *              class 局部内部类名称{
 *                  //...
 *              }
 *          }
 *      }
 *
 *  总结一下类的权限修饰符：
 *      public > protected > (default) > private
 *  定义一个类的时候，权限修饰符规则：
 *      1.外部类：public / (default)
 *      2.成员内部类：public / protected / (default) / private
 */
public class Demo031_outer {

    //在方法内定义一个类
    public void outerMethod(){
        //局部内部类
        class Inner{
            int num = 10;
            public void innerMethod(){
                System.out.println(num);
            }
        }
        //想要调用内部类的方法，还必须在该方法内创建内部类对象，然后调用内部类的方法。
        new Inner().innerMethod();
    }

}
