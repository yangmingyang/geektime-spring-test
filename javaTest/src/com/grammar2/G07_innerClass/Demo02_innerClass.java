package com.grammar2.G07_innerClass;

/**
 *  如果出现重名的成员变量现象，那么格式是：外部类名称.this.外部类成员变量名
 *
 */
public class Demo02_innerClass {
    public static void main(String[] args) {
        //直接使用外部类公式调用
        Demo021_outer.Inner obj = new Demo021_outer().new Inner();
        obj.innerMethod();
    }
}
