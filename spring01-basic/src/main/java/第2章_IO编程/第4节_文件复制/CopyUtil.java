package ��2��_IO���.��4��_�ļ�����;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class CopyUtil {

    /** ԭ�������
     * ���Ƶ�Դ�ļ�ͨ��FileInputSteam������������Ŀ���ļ�ͨ��FileOutputSteamд�롣���ڲ�ȷ���ļ���С�����Ϊ�˷�ֹ�ڴ������
     * �ڽ������ݸ���ʱ�޷���ȫ�����ݽ��ж�ȡ�����Բ��ñ߶���д����ʽ���д���ÿ��ͨ����������ȡָ�����ȵ��ֽ����飬���󽲸�
     * ��������ͨ�������д��Ŀ���ļ���
     */

    private File inFile; //�����ļ�File����
    private File outFile; //����ļ�File����

    public CopyUtil(String[] args) throws Exception {
        if (args.length != 2){
            System.out.println("��ERROR����������������Ĳ������㣬�޷�ִ�С�");

            //System.exit(0);��������ִ�н����˳�
            //System.exit(1);�������˳��������Ƿ�����ִ�ж��˳�
            System.exit(1); //�����˳�
        }

        this.inFile = new File(args[0]); //Դ�ļ�
        if (!this.inFile.exists()){ //���Դ�ļ�·��������
            throw new Exception("Դ�ļ������ڣ�");
        }
        this.outFile = new File(args[1]); //Ŀ���ļ�
        if (!this.outFile.exists()){
            throw new Exception("Ŀ���ļ������ڣ�");
        }
    }

    public CopyUtil(String inPath, String outPath) throws Exception {
        this.inFile = new File(inPath);
        if (!this.inFile.exists()){ //���Դ�ļ�·��������
            throw new Exception("Դ�ļ������ڣ�");
        }
        this.outFile = new File(outPath);
        if (!this.outFile.exists()){
            throw new Exception("Ŀ���ļ������ڣ�");
        }
    }


    public long copy() throws IOException {
        long start = System.currentTimeMillis(); //��ʼʱ��
        InputStream input = null;
        OutputStream output = null;
        try{
            input = new FileInputStream(this.inFile);
            output = new FileOutputStream(this.outFile);
            byte[] data = new byte[2048]; //ÿ�θ���2048���ֽ�
            int len = 0;
            while((len = input.read(data))!=-1){
                output.write(data,0,len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (input != null){
                input.close();
            }
            if (output != null){
                output.close();
            }
        }

        long end = System.currentTimeMillis();
        return end-start;
    }

}
