package com.grammar.API03_Random;

import java.util.Random;
import java.util.Scanner;

/**
 * 案例：用代码模拟猜数字的小游戏
 */
public class Demo02RandomGame {
    public static void main(String[] args) {
        Random random = new Random();
        int gameNum = random.nextInt(100);
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("请输入数字：");
            int num = scanner.nextInt();
            if (num>gameNum){
                System.out.println("你猜的太大了");
            }else if (num<gameNum){
                System.out.println("你猜的太小了");
            }else {
                System.out.println("你猜中了");
                break;//结束循环
            }
        }
        System.out.println("游戏结束");
    }
}
