package com.grammar.API04_Array;

import java.util.ArrayList;

/**
 *  如果希望向集合ArrayList当中存储基本类型数据，那就必须使用基本类型对应的“包装类”。
 *  注意:下面是基本类型对应的包装类
 *  基本类型      包装类（引用类型，包装类都位于java.lang包下）
 *  byte          Byte
 *  short         Short
 *  int           Integer [特殊]
 *  long          Long
 *  float         Float
 *  double        Double
 *  char          Character [特殊]
 *  boolean       Boolean
 *
 *  从JDK1.5+开始，支持自动装箱、自动拆箱。
 *      自动装箱：基本类型-->包装类型
 *      自动拆箱：包装类型-->基本类型
 *
 */
public class Demo04ArrayListBasic {
    public static void main(String[] args) {
        //错误的写法! 泛型只能是引用类型，不能是基本类型
        //ArrayList<int> list = new ArrayList<>();
        ArrayList<Integer> listA = new ArrayList<>();
        listA.add(100);
        listA.add(200);
        System.out.println(listA);//[100, 200]
    }
}
