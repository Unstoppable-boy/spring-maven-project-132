package ��4��_�������.��2��_���������ʵ����.��1��_����ʵ��������;


public class TestBook {
    public static void main(String[] args) throws Exception {

        /** Class������ʵ����3�ַ�ʽ
         * 1. ����.getClass()
         * 2. ����.class
         * 3. Class.forName(���ȫ������)
         */

        Class<?> bookClazz = Book.class; //�����ȡClass����
        //�޲ι����ȡʵ�� ͨ������ʵ�����Ķ��󷵻�����ͳһΪObject
        Object obj = bookClazz.getDeclaredConstructor().newInstance();

        Book book = (Book) obj; //����ת��

        book.read();

    }
}


class Book{
    public Book(){
        System.out.println("�޲ι���ʵ��������");
    }
    public void read(){
        System.out.println("�Ȿ��ܺÿ�");
    }
}