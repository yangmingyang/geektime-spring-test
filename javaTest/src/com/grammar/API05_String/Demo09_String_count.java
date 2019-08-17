package com.grammar.API05_String;

import java.util.Scanner;

/**
 *  需求：键盘输入一个字符串，并且统计其中各种字符出现的次数。种类有：大写字母，小写字符，其他。
 */
public class Demo09_String_count {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        char[] chars = str.toCharArray();
        int countUpper =0;
        int countLower =0;
        int countNumber =0;
        int countOther =0;

        //如何判断字符是大小写字母或者是数字？
        for (char ch : chars) {
            if ('A'<=ch && ch<='Z'){
                countUpper++;
            }else if ('a'<=ch && ch<='z'){
                countLower++;
            }else if ('0'<=ch && ch<='9'){
                //注意数字的对比也要是字符，因此要要单引号
                countNumber++;
            }else{
                countOther++;
            }
        }
        System.out.println("大写字符有："+countUpper);
        System.out.println("小写字符有："+countLower);
        System.out.println("数字字符有："+countNumber);
        System.out.println("其他字符有："+countOther);
    }
}
