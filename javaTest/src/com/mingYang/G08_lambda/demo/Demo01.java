package com.mingYang.G08_lambda.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *  需求：将一个订单明细的商品进行合并，金额合并，件数合同，返回一个新的集合
 */
public class Demo01 {
    public static void main(String[] args) {
        System.out.println(0.05+0.11);//结果：0.060000000000000005
        List<POSOrderItem> orderItems = getOrderItem();
        List<POSOrderItem> newOrderItem = getNewOrderItem(orderItems);
        System.out.println(newOrderItem);
        for (POSOrderItem it : newOrderItem){
            System.out.println(it);
        }
    }

    //定义一个orderItem订单明细
    public static List<POSOrderItem> getOrderItem(){
        List<POSOrderItem> orderItems = new ArrayList<>();
        orderItems.add(new POSOrderItem(1.0,0.05,"苹果"));
        orderItems.add(new POSOrderItem(1.0,0.01,"苹果"));
        orderItems.add(new POSOrderItem(1.0,12.10,"香蕉"));
        orderItems.add(new POSOrderItem(1.0,10.10,"香蕉"));
        orderItems.add(new POSOrderItem(1.0,12.11,"啤酒"));
        return orderItems;
    }

    /**
     * double sum = list.stream().mapToDouble(User::getHeight).sum();
     * System.out.println("身高 总和：" + df.format(sum));
     *
     * double max = list.stream().mapToDouble(User::getHeight).max().getAsDouble();
     * System.out.println("身高 最大：" + df.format(max));
     *
     * double min = list.stream().mapToDouble(User::getHeight).min().getAsDouble();
     * System.out.println("身高 最小：" + df.format(min));
     *
     * double average = list.stream().mapToDouble(User::getHeight).average().getAsDouble();
     * System.out.println("身高 平均：" + df.format(average));
     */
    public static List<POSOrderItem> getNewOrderItem(List<POSOrderItem>orderItems){
        Map<String, List<POSOrderItem>> collect = orderItems.stream().collect(Collectors.groupingBy(POSOrderItem::getGoodsName));
        List<POSOrderItem> list = new ArrayList<>();
        for (String key : collect.keySet()){
            POSOrderItem orderItem = new POSOrderItem();
            //System.out.println(key);
            orderItem.setGoodsName(key);
            List<POSOrderItem> its = collect.get(key);
            /*Double quantity = 0.0;
            Double price =0.0;
            for (POSOrderItem it : its){
                // System.out.println(it);
                quantity += it.getQuantity();
                price += it.getPrice();
            }*/
            Double price = its.stream().mapToDouble(POSOrderItem::getPrice).sum();
            Double quantity = its.stream().mapToDouble(POSOrderItem::getQuantity).sum();
            orderItem.setQuantity(quantity);
            orderItem.setPrice(price);
            list.add(orderItem);
        }
        return list;
    }


}
