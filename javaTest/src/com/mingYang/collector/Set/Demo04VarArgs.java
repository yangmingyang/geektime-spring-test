package com.mingYang.collector.Set;

/**
 *  可变参数：是JDK1.5之后出现的新特性
 *  使用前提：
 *      当方法的参数列表数据类型已经确定，但是参数的个数不确定，就可以适应可变参数。
 *  使用格式：定义方法时使用
 *      修饰符  返回值类型  方法名（数量类型...变量名）{ }
 *  可变参数的原理：
 *      可变参数底层就是一个数组，根据传递参数个数不同，会创建不同长度的数组，来存储这些参数
 *      传递的参数个数，可以是0个（不传递），1,2...多个
 *
 *   注意事项：
 *      1.一个方法的参数列表，只能有一个可变参数
 *      2.如果方法的参数有多个，那么可变参数必须写在参数列表的末尾
 *
 *      可变参数的特性（终极）写法
 *      public void methoed(Object ...obj){}
 */
public class Demo04VarArgs {
    public static void main(String[] args) {
        int r = sum(10,20);//底层默认就是一个数组接收
        System.out.println(r);
    }

    public static int sum(int...agr){
        int s =0;
        //可以使用增强for循环遍历
        for (int i : agr){
            s+=i;
        }
        return s;
    }

}
