package ��1��_Java�������.��2_1��_�ļ�������;

import java.io.File;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) throws IOException {

        /** File�ೣ�÷���
         * 1. public File(String pathname) ͨ���ļ�·������File����
         * 2. public File(File parent, String child) �����ļ��ĸ�Ŀ¼�����ļ���·��
         * 3. public boolean createFile() �������ļ�
         * 4. public boolean delete() ɾ���ļ�
         * 5. public boolean exists() �ж��ļ��Ƿ����
         *
         *�ļ�Ŀ¼����
         * 6. public boolean mkdir() ��������Ŀ¼
         * 7. public boolean mkdirs() �����༶Ŀ¼
         * 8. public String getParent() ��ȡ��Ŀ¼
         * 9. public File getParentFile() ��ȡ��Ŀ¼�ļ�����
         *
         *��ȡ�ļ���Ϣ
         * 10. public boolean canExecute() �жϵ�ǰ·���Ƿ��п�ִ�е�Ȩ��
         * 11. public boolean canRead() �жϵ�ǰ·���Ƿ��пɶ���Ȩ��
         * 12. public boolean canWrite() �жϵ�ǰ·���Ƿ��п�д��Ȩ��
         * 13. public File getAbsoluteFile() ��ȡ�ļ�����·��ʵ��
         * 14. public String getAbsolutePath() ��ȡ�ļ�����·���ַ���
         * 15. public String getName() ��ȡ����
         * 16. public boolean isAbsolute() �Ƿ�Ϊ����·��
         * 17. public boolean isDirectory() �Ƿ�ΪĿ¼
         * 18. public boolean isFile() �Ƿ�Ϊ�ļ�
         * 19. public boolean isHidden() �Ƿ�Ϊ�����ļ���Ŀ¼
         * 20. public long lastModified() ����޸�ʱ��
         * 21. public long length() ��ȡ�ļ����� byte
         *
         * ��ȡĿ¼��Ϣ
         * 22. public String[] list() ��ȡ������·������
         * 23. public File[] listFiles() ��ȡ������·����File��������
         * 23. public File[] listFiles(FileFilter filter) ��ȡ������·����File����ʱ����һ��������
         *
         * �ļ�����
         * 24. public boolean renameTo(File dest) �ļ�������/�ƶ��ļ�
         */

        //�ļ�����/ɾ��
        File file = new File("E:"+File.separator+"FileTest.txt"); //����File�������������ļ�·��
        if (file.exists()){ //�жϸ��ļ��Ƿ����
            System.out.println(file.getName()+"[���ļ�����] ִ��ɾ��������"+file.delete());
        }else{
            System.out.println(file.getName()+"[�����ڸ��ļ�] ִ�д���������"+file.createNewFile());
        }


        //�������и�Ŀ¼���ļ�
        File file1 = new File("E:"+File.separator+"FileDir"+
                File.separator+"createFileWithDir.txt"); //����File�������������ļ�·��
        if (!file1.getParentFile().exists()){ //�����Ŀ¼������
            System.out.println(file1.getName()+"[��Ŀ¼������] ִ�д�����Ŀ¼��"+file1.getParentFile().mkdirs()); //������Ŀ¼
        }
        if (file1.exists()){ //������ļ�����
            System.out.println(file1.getName()+"[�ļ�����] ִ��ɾ��������"+file1.delete());
        }else{
            System.out.println(file1.getName()+"[�����ڸ��ļ�] ִ�д���������"+file1.createNewFile());
        }

        //�г�Ŀ¼��ָ���ļ�
        File file2 = new File("E:"+File.separator+"FileDir");
        info(file2);


        //�ļ�������
        File oldFile = new File("E:"+File.separator+"FileDir"+File.separator+"demo.txt");
        File newFile = new File("E:"+File.separator+"FileDir"+File.separator+"demo2.txt");
        if (oldFile.exists()){
            if (!newFile.exists()){
                System.out.println("[�ļ���������]"+oldFile.renameTo(newFile)+"  "+oldFile.getName());
            }else {
                newFile.delete();
                System.out.println("[�ļ���������]"+oldFile.renameTo(newFile)+"  "+oldFile.getName());
            }
        }else{
            System.out.println("[���������ļ�������]");
        }


    }

    //�������� ��ȡ�ļ�
    public static void info(File file2){
        if (file2.isDirectory()){
            File[] files = file2.listFiles(
                    (f) -> f.isDirectory()?true:f.getName().contains("����"));
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
