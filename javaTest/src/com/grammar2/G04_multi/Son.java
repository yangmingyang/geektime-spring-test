package com.grammar2.G04_multi;

public class Son extends Father{
    String str ="son";

    /**
     * 重新父类的showString方法
     */
    @Override
    public void showString(){
        System.out.println(str);
    }

    /**
     * 子类特有的方法
     */
    public void sonMethod(){
        System.out.println("子类特有的方法");
    }
}
