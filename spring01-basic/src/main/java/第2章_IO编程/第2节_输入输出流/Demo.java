package 第2章_IO编程.第2节_输入输出流;

import java.io.*;

public class Demo {

    public static void main(String[] args) throws IOException {

        //向文件中写入数据
        File file = new File("E:"+File.separator+"FileDir"+File.separator+"demo2.txt");
        if (!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        if (!file.exists()){
            file.createNewFile();
        }
        OutputStream out = new FileOutputStream(file); //实例化输出流对象
        String msg = "Hello World!"; //写入的数据
        byte[] bytes = msg.getBytes(); //将字符串转为字节数组
        out.write(bytes);//字节数组写入文件
        System.out.println("数据已经写入文件");
        out.close();//关闭输出流


        //读取demo2.txt文件全部数据
        if (file.exists()){
            //采用AutoCloseable自动关闭处理，程序结束自动调用close方法
            try (InputStream in = new FileInputStream(file)){
                byte[] data = new byte[1024]; //开辟字节数组，存放读取的数据
                int len = in.read(data);
                System.out.println("读取完毕！"+new String(data,0,len));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        //循环读取数据
        StringBuffer buffer = new StringBuffer();
        if (file.exists()){
            try(InputStream inputStream = new FileInputStream(file)){
                byte[] data = new byte[8]; //开辟8个字节长度的数组，每次读取8字节长度的内容
                int len = 0;
                while((len = inputStream.read(data))!=-1){
                    buffer.append(new String(data,0,len));
                }
                System.out.println("读取到的数据内容："+buffer);
            }catch (Exception e){}
        }



        //使用Writer输出数据
        File file2 = new File("E:"+File.separator+"FileDir"+File.separator+"新建文本文档.txt");
        if (!file2.getParentFile().exists()){
            file2.getParentFile().mkdirs();
        }
        if (!file2.exists()){
            file2.createNewFile();
        }
        try(Writer w = new FileWriter(file2)){
            w.write("123456");
            w.append("789"); //追加内容
            System.out.println("使用Writer输出数据完成");
        }catch (Exception e){}


        //Reader字符输入
        if (file2.exists()){
            try(Reader in = new FileReader(file2)){
                char[] data = new char[1024];
                int len = in.read(data);
                System.out.println(new String(data,0,len));
            }
        }
        //Reader字符循环输入
        if (file2.exists()){
            StringBuffer buffer1 = new StringBuffer();
            try(Reader in = new FileReader(file2)){
                char[] data = new char[8];
                int len = 0;
                while((len=in.read(data))!=-1){
                    buffer1.append(new String(data,0,len));
                }
                System.out.println("读取到的数据内容："+buffer1);
            }
        }














    }
}
