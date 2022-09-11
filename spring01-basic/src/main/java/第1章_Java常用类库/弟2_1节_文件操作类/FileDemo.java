package 第1章_Java常用类库.弟2_1节_文件操作类;

import java.io.File;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) throws IOException {

        /** File类常用方法
         * 1. public File(String pathname) 通过文件路径定义File对象
         * 2. public File(File parent, String child) 设置文件的父目录和子文件的路径
         * 3. public boolean createFile() 创建新文件
         * 4. public boolean delete() 删除文件
         * 5. public boolean exists() 判断文件是否存在
         *
         *文件目录操作
         * 6. public boolean mkdir() 创建单级目录
         * 7. public boolean mkdirs() 创建多级目录
         * 8. public String getParent() 获取父目录
         * 9. public File getParentFile() 获取父目录文件对象
         *
         *获取文件信息
         * 10. public boolean canExecute() 判断当前路径是否有可执行的权限
         * 11. public boolean canRead() 判断当前路径是否有可读的权限
         * 12. public boolean canWrite() 判断当前路径是否有可写的权限
         * 13. public File getAbsoluteFile() 获取文件绝对路径实例
         * 14. public String getAbsolutePath() 获取文件绝对路径字符串
         * 15. public String getName() 获取名称
         * 16. public boolean isAbsolute() 是否为绝对路径
         * 17. public boolean isDirectory() 是否为目录
         * 18. public boolean isFile() 是否为文件
         * 19. public boolean isHidden() 是否为隐藏文件或目录
         * 20. public long lastModified() 最后修改时间
         * 21. public long length() 获取文件长度 byte
         *
         * 获取目录信息
         * 22. public String[] list() 获取所有子路径名称
         * 23. public File[] listFiles() 获取所有子路径的File对象数组
         * 23. public File[] listFiles(FileFilter filter) 获取所有子路径的File对象时设置一个过滤器
         *
         * 文件更名
         * 24. public boolean renameTo(File dest) 文件重命名/移动文件
         */

        //文件创建/删除
        File file = new File("E:"+File.separator+"FileTest.txt"); //定义File对象，声明操作文件路径
        if (file.exists()){ //判断该文件是否存在
            System.out.println(file.getName()+"[该文件存在] 执行删除操作："+file.delete());
        }else{
            System.out.println(file.getName()+"[不存在该文件] 执行创建操作："+file.createNewFile());
        }


        //创建带有父目录的文件
        File file1 = new File("E:"+File.separator+"FileDir"+
                File.separator+"createFileWithDir.txt"); //定义File对象，声明操作文件路径
        if (!file1.getParentFile().exists()){ //如果父目录不存在
            System.out.println(file1.getName()+"[父目录不存在] 执行创建父目录："+file1.getParentFile().mkdirs()); //创建父目录
        }
        if (file1.exists()){ //如果该文件存在
            System.out.println(file1.getName()+"[文件存在] 执行删除操作："+file1.delete());
        }else{
            System.out.println(file1.getName()+"[不存在该文件] 执行创建操作："+file1.createNewFile());
        }

        //列出目录下指定文件
        File file2 = new File("E:"+File.separator+"FileDir");
        info(file2);


        //文件重命名
        File oldFile = new File("E:"+File.separator+"FileDir"+File.separator+"demo.txt");
        File newFile = new File("E:"+File.separator+"FileDir"+File.separator+"demo2.txt");
        if (oldFile.exists()){
            if (!newFile.exists()){
                System.out.println("[文件重命名：]"+oldFile.renameTo(newFile)+"  "+oldFile.getName());
            }else {
                newFile.delete();
                System.out.println("[文件重命名：]"+oldFile.renameTo(newFile)+"  "+oldFile.getName());
            }
        }else{
            System.out.println("[待重命名文件不存在]");
        }


    }

    //过滤条件 获取文件
    public static void info(File file2){
        if (file2.isDirectory()){
            File[] files = file2.listFiles(
                    (f) -> f.isDirectory()?true:f.getName().contains("副本"));
            if (files != null){
                for (File temp : files){
                    info(temp);
                }
            }
        }else{
            System.out.println(file2);
        }
    }



}
