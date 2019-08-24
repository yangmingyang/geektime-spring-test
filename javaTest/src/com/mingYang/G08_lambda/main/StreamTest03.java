package com.mingYang.G08_lambda.main;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 对stream的操作分为为两类，中间操作(intermediate operations)和结束操作(terminal operations)
 * 中间操作总是会惰式执行，调用中间操作只会生成一个标记了该操作的新stream，仅此而已。
 * 结束操作会触发实际计算，计算发生时会把所有中间操作积攒的操作以pipeline的方式执行，这样可以减少迭代次数。计算完成之后stream就会失效。
 *
 * 中间操作的方法：concat() distinct() filter() flatMap() limit() map() peek() skip() sorted() parallel() sequential() unordered()
 * 结束操作的方法：	allMatch() anyMatch() collect() count() findAny() findFirst() forEach() forEachOrdered() max() min() noneMatch() reduce() toArray()
 *
 */
public class StreamTest03 {
    public static void main(String[] args) {

        /**
         * filter()
         * 保留长度等于3的字符串
         */
        /*Stream<String> stream= Stream.of("I", "love", "you", "too");
        stream.filter(str -> str.length()==3).forEach(str -> System.out.println(str));*/


        /**
         * distinct()
         *  函数原型为Stream<T> distinct()，作用是返回一个去除重复元素之后的Stream
         */
        /*Stream<String> stream= Stream.of("I", "love", "you", "too", "too");
        stream.distinct().forEach(str -> System.out.println(str));*/

        /**
         *  sorted()
         *  排序函数有两个，一个是用自然顺序排序，一个是使用自定义比较器排序，函数原型分别为Stream<T>　sorted()和Stream<T>　sorted(Comparator<? super T> comparator)
         */
        /*Stream<String> stream= Stream.of("I", "love", "you", "too");
        stream.sorted((str1, str2) -> str1.length()-str2.length())
                .forEach(str -> System.out.println(str));*/


        /**
         * map()
         * 函数原型为<R> Stream<R> map(Function<? super T,? extends R> mapper)，作用是返回一个对当前所有元素执行执行mapper之后的结果组成的Stream。
         * 直观的说，就是对每个元素按照某种操作进行转换，转换前后Stream中元素的个数不会改变，但元素的类型取决于转换之后的类型。
         */
        /*Stream<String> stream = Stream.of("I", "love", "you", "too");
        stream.map(str -> str.toUpperCase())
                .forEach(str -> System.out.println(str));*/

        /**
         * flatMap()
         * 函数原型为<R> Stream<R> flatMap(Function<? super T,? extends Stream<? extends R>> mapper)，作用是对每个元素执行mapper指定的操作，
         * 并用所有mapper返回的Stream中的元素组成一个新的Stream作为最终返回结果。说起来太拗口，
         * 通俗的讲flatMap()的作用就相当于把原stream中的所有元素都”摊平”之后组成的Stream，转换前后元素的个数和类型都可能会改变。
         *
         *  下面代码中，原来的stream中有两个元素，分别是两个List<Integer>，执行flatMap()之后，将每个List都“摊平”成了一个个的数字，所以会新产生一个由5个数字组成的Stream。所以最终将输出1~5这5个数字。
         */
        Stream<List<Integer>> stream = Stream.of(Arrays.asList(1,2), Arrays.asList(3, 4, 5));
        stream.flatMap(list -> list.stream())
                .forEach(i -> System.out.println(i));

    }
}
