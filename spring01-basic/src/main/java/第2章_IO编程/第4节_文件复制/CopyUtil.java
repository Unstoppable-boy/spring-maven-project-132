package 第2章_IO编程.第4节_文件复制;

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

    /** 原理分析：
     * 复制的源文件通过FileInputSteam加载输入流，目标文件通过FileOutputSteam写入。由于不确定文件大小，因此为了防止内存溢出，
     * 在进行数据复制时无法对全部数据进行读取，所以采用边读边写的形式进行处理。每次通过输入流读取指定长度的字节数组，而后讲该
     * 数组内容通过输出流写入目标文件。
     */

    private File inFile; //输入文件File对象
    private File outFile; //输出文件File对象

    public CopyUtil(String[] args) throws Exception {
        if (args.length != 2){
            System.out.println("【ERROR】程序复制命令输入的参数不足，无法执行。");

            //System.exit(0);程序正常执行结束退出
            //System.exit(1);非正常退出，程序是否正在执行都退出
            System.exit(1); //程序退出
        }

        this.inFile = new File(args[0]); //源文件
        if (!this.inFile.exists()){ //如果源文件路径不存在
            throw new Exception("源文件不存在！");
        }
        this.outFile = new File(args[1]); //目标文件
        if (!this.outFile.exists()){
            throw new Exception("目标文件不存在！");
        }
    }

    public CopyUtil(String inPath, String outPath) throws Exception {
        this.inFile = new File(inPath);
        if (!this.inFile.exists()){ //如果源文件路径不存在
            throw new Exception("源文件不存在！");
        }
        this.outFile = new File(outPath);
        if (!this.outFile.exists()){
            throw new Exception("目标文件不存在！");
        }
    }


    public long copy() throws IOException {
        long start = System.currentTimeMillis(); //开始时间
        InputStream input = null;
        OutputStream output = null;
        try{
            input = new FileInputStream(this.inFile);
            output = new FileOutputStream(this.outFile);
            byte[] data = new byte[2048]; //每次复制2048个字节
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
