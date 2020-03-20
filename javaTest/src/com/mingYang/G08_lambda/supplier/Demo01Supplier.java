package com.mingYang.G08_lambda.supplier;

import java.util.function.Supplier;

public class Demo01Supplier {
        private static String getString(Supplier<String> function) {
            return function.get();
        }
        public static void main(String[] args) {
            String msgA = "Hello";
            String msgB = "World";
            System.out.println(getString(() -> msgA + msgB));
        }
}
