package com.grammar.API05_String;

/**
 *  需求：定义一个方法，把数组{1,2,3}按照指定格式拼接成一个字符串。格式参照如下：[word1#word2#word3]
 */
public class Demo08_String_practise {
    public static void main(String[] args) {
        int[] arrays = {1,2,3};
        String newString = getNewString(arrays);
        System.out.println(newString);
    }

    public static String getNewString(int[] array){
        String str ="[";
        for (int i = 0; i < array.length; i++) {
            if (i<array.length-1){
                str +=array[i]+"#";
            }else{
                str +=array[i]+"]";
            }
        }
        return str;
    }
}
