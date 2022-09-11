package 第2章_IO编程.第4节_文件复制;

import java.io.File;

public class TestCopy {
    public static void main(String[] args) throws Exception {

        String orginFilePath = "E:"+ File.separator+"FileDir"+File.separator+"demo - 副本.txt";
        String targetFilePath = "E:"+ File.separator+"FileDir"+File.separator+"demo - 副本 (2).txt";

        String[] paths = {orginFilePath,targetFilePath};

        System.out.println("复制成功！耗时："+new CopyUtil(paths).copy());

    }
}
