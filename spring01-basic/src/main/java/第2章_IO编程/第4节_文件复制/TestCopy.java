package ��2��_IO���.��4��_�ļ�����;

import java.io.File;

public class TestCopy {
    public static void main(String[] args) throws Exception {

        String orginFilePath = "E:"+ File.separator+"FileDir"+File.separator+"demo - ����.txt";
        String targetFilePath = "E:"+ File.separator+"FileDir"+File.separator+"demo - ���� (2).txt";

        String[] paths = {orginFilePath,targetFilePath};

        System.out.println("���Ƴɹ�����ʱ��"+new CopyUtil(paths).copy());

    }
}
