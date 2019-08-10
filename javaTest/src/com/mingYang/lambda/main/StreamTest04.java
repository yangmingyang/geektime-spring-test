package com.mingYang.lambda.main;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest04 {

    /**
     * 规约操作（reduction operation）又被称作折叠操作（fold），是通过某个连接动作将所有元素汇总成一个汇总结果的过程。
     * 元素求和、求最大值或最小值、求出元素总个数、将所有元素转换成一个列表或集合，都属于规约操作。
     * Stream类库有两个通用的规约操作reduce()和collect()，也有一些为简化书写而设计的专用规约操作，
     * 比如sum()、max()、min()、count()等。
     * @param args
     */
    public static void main(String[] args) {
        /**
         * 多面手reduce()
         * reduce操作可以实现从一组元素中生成一个值，sum()、max()、min()、count()等都是reduce操作，将他们单独设为函数只是因为常用。reduce()的方法定义有三种重写形式：
         *
         * Optional<T> reduce(BinaryOperator<T> accumulator)
         * T reduce(T identity, BinaryOperator<T> accumulator)
         * <U> U reduce(U identity, BiFunction<U,? super T,U> accumulator, BinaryOperator<U> combiner)
         * 虽然函数定义越来越长，但语义不曾改变，多的参数只是为了指明初始值（参数identity），或者是指定并行执行时多个部分结果的合并方式（参数combiner）。
         * reduce()最常用的场景就是从一堆值中生成一个值。
         * 用这么复杂的函数去求一个最大或最小值，你是不是觉得设计者有病。
         * 其实不然，因为“大”和“小”或者“求和”有时会有不同的语义。
         */


        /**
         *  找出最长的单词
         */
        /*Stream<String> stream = Stream.of("I", "love", "you", "too");
        Optional<String> longest = stream.reduce((s1, s2) -> s1.length()>=s2.length() ? s1 : s2);
        //Optional<String> longest = stream.max((s1, s2) -> s1.length()-s2.length());
        System.out.println(longest.get());*/


    }

    @Test
    public void reduce(){
        /**
         *  需求：求出一组单词的长度之和。这是个“求和”操作，操作对象输入类型是String，而结果类型是Integer。
         */
        // 求单词长度之和
        Stream<String> stream = Stream.of("I", "love", "you", "too");
        Integer lengthSum = stream.reduce(0,
        (sum, str) -> sum+str.length(),
                (a, b) -> a+b);
        // int lengthSum = stream.mapToInt(str -> str.length()).sum();
        System.out.println(lengthSum);
    }

    @Test
    public void streamToMap(){
        /**
         * 终极武器collect()
         */
        // 将Stream转换成容器或Map
        Stream<String> stream1 = Stream.of("I", "love", "you", "too");
        List<String> list = stream1.collect(Collectors.toList()); // (1)
        // Set<String> set = stream.collect(Collectors.toSet()); // (2)
        //Map<String, Integer> map = stream1.collect(Collectors.toMap(Function.identity(), String::length)); // (3)
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }


    @Test
    public void collectToList(){
        //　将Stream规约成List
        Stream<String> stream = Stream.of("I", "love", "you", "too");
        List<String> list = stream.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);// 方式１
        //List<String> list = stream.collect(Collectors.toList());// 方式2
        System.out.println(list);
    }

    @Test
    public void StreamToListOrSet(){
        // 将Stream转换成List或Set
        Stream<String> stream = Stream.of("I", "love", "you", "too");
        List<String> list = stream.collect(Collectors.toList()); // (1)
        System.out.println(list.toString());
        //Set<String> set = stream.collect(Collectors.toSet()); // (2)
    }
}
