package com.redis.jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *  首先要引进两个jar包 commons-pool2-2.3.jar  jedis-2.7.0.jar
 *
 */
public class Demo01_jedis {
    /**
     * 快速入门
     */
    @Test
    public void demo01(){
        //1.获取连接
        Jedis jedis = new Jedis("localhost",6379);
        //2.操作
        jedis.set("username","ymy");
        //3.关闭连接
        jedis.close();
    }


    /**
     * 1）字符串类型 string
     */
    @Test
    public void demo02(){
        //空参数默认就是"localhost"和6379端口
        Jedis jedis = new Jedis();
        jedis.set("username","xiaoTang");
        String username = jedis.get("username");
        System.out.println(username);

        /**
         *  可以使用setex()方法存储可以指定过期时间的 key value
         *  将activeCode：code键值对存入redis,并且20秒后自动删除该键值对
         */
        jedis.setex("activeCode",20,"code");
    }

    /**
     * 2）哈希类型 hash : map格式
     */
    @Test
    public void demo03(){
        //空参数默认就是"localhost"和6379端口
        Jedis jedis = new Jedis();

        jedis.hset("user","name","zhangSan");
        jedis.hset("user","age","18");
        jedis.hset("user","gender","male");

        //获取某个属性的值
        String name = jedis.hget("user", "name");
        System.out.println(name);

        //获取全部
        Map<String, String> user = jedis.hgetAll("user");
        for (String key : user.keySet()){
            System.out.println(key + ":" + user.get(key));
        }
    }


    /**
     * 3）列表类型 lish : linkedlist格式。支持重复元素
     */
    @Test
    public void demo04(){
        //空参数默认就是"localhost"和6379端口
        Jedis jedis = new Jedis();
        jedis.lpush("myList","a","b","c");
        jedis.rpush("myList","a","b","c");

        List<String> myList = jedis.lrange("myList", 0, -1);
        System.out.println(myList);

        String e1 = jedis.lpop("myList");
        System.out.println(e1);

        String m2 = jedis.rpop("myList");
        System.out.println(m2);

        List<String> myList2 = jedis.lrange("myList", 0, -1);
        System.out.println(myList2);
    }

    /**
     * 4）集合类型 set : 不允许重复元素
     */
    @Test
    public void demo05(){
        //空参数默认就是"localhost"和6379端口
        Jedis jedis = new Jedis();
        jedis.sadd("mySet","a","b","c");
        Set<String> mySet = jedis.smembers("mySet");
        System.out.println(mySet);//[a, b, c]

        Long s1 = jedis.srem("mySet", "a");
        System.out.println(s1);

        Set<String> mySet2 = jedis.smembers("mySet");
        System.out.println(mySet2);
    }

    /**
     * 5）有序集合类型 sortedset : 不允许重复元素，且元素有顺序
     */
    @Test
    public void demo06(){
        //空参数默认就是"localhost"和6379端口
        Jedis jedis = new Jedis();
        jedis.zadd("mySortedSet",3,"盖伦");
        jedis.zadd("mySortedSet",30,"后裔");
        jedis.zadd("mySortedSet",25,"孙悟空");

        Set<String> mySortedSet = jedis.zrange("mySortedSet", 0, -1);
        System.out.println(mySortedSet);

        Long zrem = jedis.zrem("mySortedSet", "盖伦");
        System.out.println(zrem);
    }
}
