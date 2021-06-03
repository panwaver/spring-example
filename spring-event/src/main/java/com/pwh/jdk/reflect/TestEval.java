package com.pwh.jdk.reflect;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author panweihua450
 * @date 2021/6/3 21:16
 */
public class TestEval {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        long start = System.currentTimeMillis();
        eval("int sum = 0; for (int i = 0; i < 1000; i++){sum += i;} System.out.println(sum);");
        long end = System.currentTimeMillis();
        System.out.println("运行耗时：" + (end - start) + "ms");
    }

    public static void eval(String code) throws
            IOException,
            ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            NoSuchMethodException,
            SecurityException,
            IllegalArgumentException,
            InvocationTargetException, InvocationTargetException {
        //创建 eval.java 文件
        File file = new File("D:/Eval.java");
        //创建缓冲输出流
        BufferedWriter buffer = new BufferedWriter(new FileWriter(file));
        //将 code 里面的内容写入 buffer 中
        buffer.write("public class Eval{\n"            //必须是 public class，否则无法访问。
                + "public void test(){\n"
                + code + "\n}"
                + "\n}");
        buffer.close();

        File parentFile = new File(file.getParent());
        //注意这里要补一个分隔符，不然会出错 File.pathSeparator
        //这可能是 src  和  src/ 表示意义的区别
        String parentPath = parentFile.getAbsolutePath() + File.separatorChar;

        //文件分隔符，只能在前面加，因为它是和平台有关的，
        //而这里我需要使用正斜杠，在windows平台下，默认是反斜杠
        parentPath = parentPath.replace('\\', '/');   //反斜杠要使用转义字符

        //Eval.class的位置，我的电脑上是 file:///F:/JavaProject/eval/src/
        //注意最后面的文件分隔符
        //创建一个 URL 数组
        String url = "file:///" + parentPath;
        System.out.println("测试使用，查看输出文件路径：" + url);

        //需要自己编译Java文件，产生 class 文件
        //下面这段代码用于编译文件，这是比较简单的了。
        //这个绝对路径是Java源文件的路径，使用javac编译获取 .class文件
        Process p = Runtime.getRuntime().exec("javac -encoding utf-8 " + file.getAbsolutePath());
        InputStream compileError = p.getErrorStream();
        //下面javac 的编译信息，与在命令行中使用的输出结果一样，只是把错误信息放到了控制台进行输出，如果没有输出，代表编译成功。否则会有错误提示。
        byte[] b = new byte[1000];
        while (compileError.read(b) != -1) {
            System.out.println(new String(b));
        }
        compileError.close();

        URL[] urls = {new URL(url)};
        //以默认的 ClassLoader 作为父 ClassLoader， 创建 URLClassLoader
        URLClassLoader classLoader = new URLClassLoader(urls);
        Class<?> clazz = classLoader.loadClass("Eval");
        Object ob = clazz.newInstance();
        Method mtd = clazz.getMethod("test", new Class<?>[]{});  //使用 null 会有警告
        //执行方法！
        mtd.invoke(ob, new Object[]{});  //使用 null 会有警告
        classLoader.close();   //关闭 URLClassLoader 对象
        System.out.println("执行结束");
    }
}
