package com.HttpClient;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 *  http://hc.apache.org/downloads.cgi
 *  HttpClient入门案例：
 *      1.先要导入三个jar包： httpclient-4.3.4.jar、httpcore-4.3.2.jar、commons-logging-1.1.1.jar
 *      注意：这三个包是必须的。缺一不可。
 */
public class Demo01HttpClient {
    public static void main(String[] args){
        InputStream ins = null;
        CloseableHttpResponse response = null;
        CloseableHttpClient httpclient = null;
        try{
            httpclient = HttpClients.createDefault();
            HttpGet httpget = new HttpGet("http://www.baidu.com");
            response = httpclient.execute(httpget);
            HttpEntity entity = response.getEntity();
            ins = entity.getContent();
            byte[] bytes = new byte[1024];
            int len;
            while ((len=ins.read(bytes))!=-1){
                System.out.println(new String(bytes,0,len));
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (ins!=null){
                try {
                    ins.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (response!=null){
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (httpclient!=null){
                try {
                    httpclient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     *  测试EntityUtils.toString(responseEntity)方法
     *  该方法就是通过转换InputStream字节输入转为字符串
     */
    @Test
    public void demo(){
        CloseableHttpResponse response = null;
        CloseableHttpClient httpclient = null;
        try{
            httpclient = HttpClients.createDefault();
            //HttpGet httpget = new HttpGet("http://www.baidu.com");
            HttpGet httpget = new HttpGet("https://blog.csdn.net/u011442726");
            response = httpclient.execute(httpget);
            HttpEntity entity = response.getEntity();
            //可以通过charset来指定字符集，避免乱码
            String result = EntityUtils.toString(entity,"utf-8");
            System.out.println(result);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (response!=null){
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (httpclient!=null){
                try {
                    httpclient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
