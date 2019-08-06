package com.mingyang.IO.PrintStream;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 *  java.io.PrintStream:打印流
 *      PrintStream 为其他输出流添加了功能，使他们能够方便地打印各种数据值表示形式。
 *
 *  PrintStream特点：
 *      1.只负责数据的输出，不负责数据的读取。
 *      2.与其他输出流不同，PrintStream 永远不会抛出IOException
 *      3.有特有的方法，print,println
 *          void print(任意类型的值)
 *          void println(任意类型的值并换行)
 *
 *  构造方法：
 *      PrintStream(File file)：输出的目的地是一个文件。
 *      PrintStream(OutputStream out)：输出的目的地是一个字节输出流。
 *      PrintStream(String fileName) ：输出的目的是一个文件路径。
 *
 *  继承自父类的成员方法:
 *      void close() 关闭此输出流并释放与此流有关的所有系统资源。
 *      void flush() 刷新此输出流并强制写出所有缓冲的输出字节。
 *      void write(byte[] b) 将 b.length 个字节从指定的 byte 数组写入此输出流。
 *      void write(byte[] b, int off, int len) 将指定 byte 数组中从偏移量 off 开始的 len 个字节写入此输出流。
 *      abstract  void write(int b) 将指定的字节写入此输出流。
 *
 *  注意：
 *      如果使用继承自父类的write方法写数据，那么查看数据的时候会查询编码表 97->a
 *      如果使用自己特有的方法print/println方法写数据，写的数据原样输出 97->97
 *
 *
 */
public class Demo01PrintStream {
    @Test
    public void demo01() throws FileNotFoundException {
        //public final static PrintStream out = null;这是out对象的源码，它是一个静态的对象
        System.out.println(97);//97

        PrintStream printStream = new PrintStream("D:\\personalDoc\\2019\\August\\print.txt");
        printStream.write(97);
        printStream.close();
    }

    /**
     * 可以改变输出语句的目的地（打印流的流向）
     *  输出语句，默认是在控制台中打印
     *  使用System.setOut方法改变输出语句的目的地，可以改为参数中传递的打印流的目的地。
     *      static void setOut(PrintStream out)
     *      重新分配“标准”输出流。
     */
    @Test
    public void demo02() throws FileNotFoundException {
        System.out.println("在控制台输出");
        PrintStream printStream = new PrintStream("D:\\personalDoc\\2019\\August\\print.txt");
        System.setOut(printStream);
        System.out.println("我在改变输出流的地方输出了");
    }
}
