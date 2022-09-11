package ��2��_IO���.��2��_���������;

import java.io.*;

public class Demo {

    public static void main(String[] args) throws IOException {

        //���ļ���д������
        File file = new File("E:"+File.separator+"FileDir"+File.separator+"demo2.txt");
        if (!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        if (!file.exists()){
            file.createNewFile();
        }
        OutputStream out = new FileOutputStream(file); //ʵ�������������
        String msg = "Hello World!"; //д�������
        byte[] bytes = msg.getBytes(); //���ַ���תΪ�ֽ�����
        out.write(bytes);//�ֽ�����д���ļ�
        System.out.println("�����Ѿ�д���ļ�");
        out.close();//�ر������


        //��ȡdemo2.txt�ļ�ȫ������
        if (file.exists()){
            //����AutoCloseable�Զ��رմ�����������Զ�����close����
            try (InputStream in = new FileInputStream(file)){
                byte[] data = new byte[1024]; //�����ֽ����飬��Ŷ�ȡ������
                int len = in.read(data);
                System.out.println("��ȡ��ϣ�"+new String(data,0,len));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        //ѭ����ȡ����
        StringBuffer buffer = new StringBuffer();
        if (file.exists()){
            try(InputStream inputStream = new FileInputStream(file)){
                byte[] data = new byte[8]; //����8���ֽڳ��ȵ����飬ÿ�ζ�ȡ8�ֽڳ��ȵ�����
                int len = 0;
                while((len = inputStream.read(data))!=-1){
                    buffer.append(new String(data,0,len));
                }
                System.out.println("��ȡ�����������ݣ�"+buffer);
            }catch (Exception e){}
        }



        //ʹ��Writer�������
        File file2 = new File("E:"+File.separator+"FileDir"+File.separator+"�½��ı��ĵ�.txt");
        if (!file2.getParentFile().exists()){
            file2.getParentFile().mkdirs();
        }
        if (!file2.exists()){
            file2.createNewFile();
        }
        try(Writer w = new FileWriter(file2)){
            w.write("123456");
            w.append("789"); //׷������
            System.out.println("ʹ��Writer����������");
        }catch (Exception e){}


        //Reader�ַ�����
        if (file2.exists()){
            try(Reader in = new FileReader(file2)){
                char[] data = new char[1024];
                int len = in.read(data);
                System.out.println(new String(data,0,len));
            }
        }
        //Reader�ַ�ѭ������
        if (file2.exists()){
            StringBuffer buffer1 = new StringBuffer();
            try(Reader in = new FileReader(file2)){
                char[] data = new char[8];
                int len = 0;
                while((len=in.read(data))!=-1){
                    buffer1.append(new String(data,0,len));
                }
                System.out.println("��ȡ�����������ݣ�"+buffer1);
            }
        }














    }
}
