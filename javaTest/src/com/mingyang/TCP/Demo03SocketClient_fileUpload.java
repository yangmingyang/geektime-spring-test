package com.mingyang.TCP;

import org.junit.Test;

import java.io.*;
import java.net.Socket;

/**
 *  文件上传案例的客户端：读取本地文件，上传到服务器，读取服务器回写的数据。
 *
 *  明确两件事情：
 *      数据源：D:\\1.jpa
 *      目的地：服务器
 *  实现步骤：
 *      1.创建一个本地字节输入流FileInputStream对象，构造方法中绑定要读取的数据源。
 *      2.创建一个客户端Socket对象，构造方法中绑定服务器的IP地址和端口号。
 *      3.使用Socket中的方法getOutputStream，获取网络字节输出流OutputStream对象。
 *      4.使用本地字节输入流FileInputStream对象中的read方法，读取本地文件。
 *      5.使用网络字节输出流OutputStream对象中的write方法，把读取到的文件上传到服务器。
 *      6.使用Socket中的getInputStream，获取网络字节输入流InputStream对象。
 *      7.使用网络字节输入流InputStream对象中的方法read读取服务器回写的数据。
 *      8.释放资源（FileInputStream,Socket）.
 *
 *
 */
public class Demo03SocketClient_fileUpload {
    public static void main(String[] args) throws IOException {

        /*FileInputStream fis = new FileInputStream("D:\\personalDoc\\2019\\baby\\a.txt");
        Socket socket = new Socket("127.0.0.1",8888);
        OutputStream os = socket.getOutputStream();
        int len;
        byte[] bytes = new byte[1024];
        while ((len=fis.read(bytes))!=-1){
            os.write(bytes,0,len);
        }
        InputStream inputStream = socket.getInputStream();
        byte[] bytes2 = new byte[1024];
        int len2;
        while ((len2=inputStream.read(bytes2))!=-1){
            System.out.println(new String(bytes2,0,len2));
        }
        fis.close();
        socket.close();*/
    }

    /**
     *  对于上面的main方法里的上传文件的代码，会有一个问题，那就是len=fis.read(bytes)读取不到-1,导致了while循环一直在继续。
     *  解决方法：shutdownOutput（）调用该方法
     */
    @Test
    public void demo01() throws IOException {
        //1.创建一个本地字节输入流FileInputStream对象，构造方法中绑定要读取的数据源。
        FileInputStream fis = new FileInputStream("D:\\personalDoc\\2019\\baby\\a.txt");
        //2.创建一个客户端Socket对象，构造方法中绑定服务器的IP地址和端口号。
        Socket socket = new Socket("127.0.0.1",8888);
        //3.使用Socket中的方法getOutputStream，获取网络字节输出流OutputStream对象。
        OutputStream os = socket.getOutputStream();
        int len;
        byte[] bytes = new byte[1024];
        //4.使用本地字节输入流FileInputStream对象中的read方法，读取本地文件。
        while ((len=fis.read(bytes))!=-1){
            //5.使用网络字节输出流OutputStream对象中的write方法，把读取到的文件上传到服务器。
            os.write(bytes,0,len);
        }

        /**
         *  通过该方法进行优化
         *  禁用此套接字的输出流。对于 TCP 套接字，任何以前写入的数据都将被发送，并且后跟 TCP 的正常连接终止序列。
         */
        socket.shutdownOutput();
        //6.使用Socket中的getInputStream，获取网络字节输入流InputStream对象。
        InputStream inputStream = socket.getInputStream();
        byte[] bytes2 = new byte[1024];
        int len2;
        //7.使用网络字节输入流InputStream对象中的方法read读取服务器回写的数据。
        while ((len2=inputStream.read(bytes2))!=-1){
            System.out.println(new String(bytes2,0,len2));
        }
        //8.释放资源（FileInputStream,Socket）.
        fis.close();
        socket.close();
    }
}
