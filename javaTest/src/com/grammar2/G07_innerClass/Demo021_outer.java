package com.grammar2.G07_innerClass;

/**
 * 如果出现重名的成员变量现象，那么格式是：外部类名称.this.外部类成员变量名
 */
public class Demo021_outer {
    int num =10;

    public class Inner{
        int num = 20;
        public void innerMethod(){
            //内部类方法的局部变量
            int num = 30;
            //局部变量，就近原则
            System.out.println(num);
            //内部类的成员变量
            System.out.println(this.num);
            //外部类的成员变量
            System.out.println(Demo021_outer.this.num);
        }
    }
}
