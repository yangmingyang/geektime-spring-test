package com.grammar.API01_Scanner;

import java.util.Scanner;

/**
 * 案例：比较输入的三个数字的大小
 */
public class Demo02ScannerMax {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int max;
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        if(a>b){
            max=a;
        }else{
            max=b;
        }

        int c = scanner.nextInt();
        if (max>c){
            System.out.println("最大值为："+max);
        }else{
            System.out.println("最大值为："+c);
        }

    }
}
