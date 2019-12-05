package com.mego.w09_aopAdviceType.utils;

public class Logger {
    public void printLog(){
        System.out.println("===前置通知===");
    }

    public void printLogAfterReturning(){
        System.out.println("===后置通知===");
    }

    public void printLogAfterThrowing(){
        System.out.println("===异常通知===");
    }

    public void printLogAfter(){
        System.out.println("===最终通知===");
    }
}
