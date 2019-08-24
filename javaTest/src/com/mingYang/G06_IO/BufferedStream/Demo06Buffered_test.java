package com.mingYang.G06_IO.BufferedStream;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *  练习：
 *      对文本的内容进行排序
 *      按照（1,2,3...）顺序排序
 *      7.我是第七位
 *      5.我是第5位
 *      6.我是第6位
 *      3.我是第3位
 *      4.我是第4位
 *      2.我是第2位
 *      1.我是第1位
 *
 */
public class Demo06Buffered_test {
    public static void main(String[] args) throws IOException {
        //先读取文本里面的数据
        BufferedReader br = new BufferedReader(new FileReader("D:\\personalDoc\\2019\\August\\test.txt"));
        //写入一个新的文本
        BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\personalDoc\\2019\\August\\write.txt"));
        String s;
        HashMap<String , String> map = new HashMap<>();
        while ((s=br.readLine())!=null){
            //System.out.println(s);
            String[] split = s.split("\\.");
            //存放到hashMap集合中
            map.put(split[0],split[1]);
        }
        //问题是：哪个集合是可以自动排序的？
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries){
            bw.write(entry.getKey()+"."+entry.getValue());
            bw.newLine();
        }
        br.close();
        bw.close();
        /**
         * 最后的结果：
         * 1.我是第1位
         * 2.我是第2位
         * 3.我是第3位
         * 4.我是第4位
         * 5.我是第5位
         * 6.我是第6位
         * 7.我是第七位
         */
    }
}
