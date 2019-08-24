package com.mingYang.G08_lambda.main;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest05 {

    @Test
    public void costOrder(){
        // 不使用lambda表达式为每个订单加上12%的税
        /*List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        for (Integer cost : costBeforeTax) {
            double price = cost + .12*cost;
            System.out.println(price);
        }*/

        // 使用lambda表达式
        List<Double> costBeforeTax = Arrays.asList(100.00, 200.00, 300.00, 400.00, 500.00);
        /**
         * 思考：这里的map方法起到什么作用？
         * 作用是返回一个对当前所有元素执行执行mapper之后的结果组成的Stream。直观的说，就是对每个元素按照某种操作进行转换，
         * 转换前后Stream中元素的个数不会改变，但元素的类型取决于转换之后的类型。
         */
        costBeforeTax.stream().map((cost)->cost + cost*0.12).forEach((s)-> System.out.println(s));
        //costBeforeTax.stream().map((cost) -> cost + 0.12 * cost).forEach(System.out::println);
    }

    @Test
    public void costOrder02(){
        //在上个例子中，可以看到map将集合类（例如列表）元素进行转换的。还有一个 reduce() 函数可以将所有值合并成一个
        /**
         * Map和Reduce操作是函数式编程的核心操作，因为其功能，reduce 又被称为折叠操作。
         */

        // 为每个订单加上12%的税
        // 老方法：
//        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
//        double total = 0;
//        for (Integer cost : costBeforeTax) {
//            double price = cost + .12*cost;
//            total = total + price;
//        }
//        System.out.println("Total : " + total);//1680

        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        //先使用map函数重新操作完流，相当于重组了一个流对象，然后再用reduce方法进行一次合并
        /**
         * 思考一个问题：都说reduce操作可以实现从一组元素中生成一个值，是不是就是只能计算出一个数值的结果
         * 如果我想搞一个重组后的数值之类的是否可以实现呢？
         */
        double sumResult = costBeforeTax.stream().map((cost)->cost+ 0.12*cost).reduce((sum,a)->sum+a).get();//1680
        //double sumResult = costBeforeTax.stream().reduce((sum,cost)->sum+cost).get();//1500
        System.out.println(sumResult);
        //costBeforeTax.stream().filter((a)->a>100).forEach((s)-> System.out.println(s));
    }

    @Test
    public void filterString(){
        List<String> strList = Arrays.asList("I", "like", "java","abc");
        // 创建一个字符串列表，每个字符串长度大于2
//        List<String> filtered = strList.stream().filter(x -> x.length()> 2).collect(Collectors.toList());
//        System.out.printf("原始数据 : %s, 过滤后的数据 : %s %n", strList, filtered);
        /**
         * 如果我需要多个过滤条件该怎么写,可以使用&& 、|| 这些合并操作符
         */
        List<String> list = strList.stream().filter((x)->x.length()>2 && x.length()<=3).collect(Collectors.toList());
        System.out.println(list);
    }
}
