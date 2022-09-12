package ��4��_�������.��3��_���������ʵ����.��2��_�����빤�����ģʽ;


//ͼ��ӿ�
interface IBook {
    public void read(); //���󷽷�
}


//ͼ��ʵ����
class MathBook implements IBook{
    @Override
    public void read() {
        System.out.println("��ѧ����ѧ");
    }
}

class MusicBook implements IBook{
    @Override
    public void read() {
        System.out.println("������һ��������");
    }
}


//����
class Factory{

    private Factory(){}

    public static IBook getInstance(String className){
        try {
            Object obj = Class.forName(className).getDeclaredConstructor().newInstance();
            if (obj instanceof IBook){ //��ֹ����ǿת�쳣
                return (IBook) obj;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}


//������
public class TestBook{
    public static void main(String[] args) {
        IBook book1 = Factory.getInstance("��4��_�������.��3��_���������ʵ����.��2��_�����빤�����ģʽ.MathBook");
        book1.read();

        IBook book2 = Factory.getInstance("��4��_�������.��3��_���������ʵ����.��2��_�����빤�����ģʽ.MusicBook");
        book2.read();
    }
}

