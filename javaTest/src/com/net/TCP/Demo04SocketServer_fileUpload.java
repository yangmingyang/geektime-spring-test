package com.net.TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *  文件上传案例服务器端：读取客户端上传的文件，保存到服务器的硬盘，给客户端回写“上传成功”。
 *  明确：
 *      数据源：客户端上传的文件
 *      目的地：服务器的硬盘D:\personalDoc\2019\baby\1.jpg
 *
 *  实现步骤：
 *      1.创建一个服务器ServerSocket对象，和系统要指定的端口号。
 *      2.使用ServerSocket对象中accept方法，获取到请求客户端Socket对象。
 *      3.使用Socket对象中的getInputStream方法，获取到网络字节输入流InputStream对象。
 *      4.判断D:\personalDoc\2019\baby文件夹是否存在，不存在则创建。
 *      5.创建一个本地的字节输出流FileOutputStream对象，构造方法中绑定要输出的目的地。
 *      6.使用网络字节输入流InputStream对象中的read方法，读取客户端上传的文件。
 *      7.使用本地字节输出流FileOutputStream中的write方法，把读取到的文件保存到服务器的硬盘上。
 *      8.使用Socket对象中的getOutputStream，获取到网络字节输出流OutputStream对象。
 *      9.使用网络字节输出流OutputStream对象中的write方法，给客户端回写“上传成功”。
 *      10.释放资源（FileOutputStream,Socket,ServerSocket）
 *
 */
public class Demo04SocketServer_fileUpload {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8888);
        Socket socket = server.accept();
        InputStream is = socket.getInputStream();
        File file = new File("D:\\personalDoc\\2019\\baby");
        boolean exists = file.exists();
        if (!exists){
            //不存在则创建
            file.mkdirs();
        }
        FileOutputStream os = new FileOutputStream(file+"\\b.txt");
        byte[] bytes = new byte[1024];
        int len;
        while ((len=is.read(bytes))!=-1){
            os.write(bytes,0,len);
        }
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("上传成功".getBytes());
        os.close();
        socket.close();
        server.close();
    }
}
