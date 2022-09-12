package ��4��_�������.��4��_�����������.��1��_������ù��췽��;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.lang.reflect.Constructor;

/**
 * �����ȡ��ṹ�ķ���
 * 1. public Package getPackage() ��ȡָ�������ڰ�
 * 2. public String getPackageName() ��ȡ����
 * 3. public Class<? super T> getSuperclass() ��ȡ����
 * 4. public Class<?>[] getInterfaces() ��ȡ�ӿ�
 *
 * �����ȡ���췽��
 * 1. getConstructor(paramterType) ��ȡָ���������͡�public�Ĺ��췽��
 *      ����clazz.getConstructor(String.class,double.class)
 * 2. getConstructor() ���ȫ��public���췽��
 * 3. getDeclaredConstructor(paramterType) ��ȡָ�����͵Ĺ��췽����������Ȩ��
 * 4. getDeclaredConstructor() ��ȡȫ�����췽����������Ȩ��
 *
 * Constructor�ೣ�÷���
 * 1. getName() ��ȡ���췽��������
 * 2. getParamterCount() ��ȡ���췽���в�������
 * 3. getTypeParamters() ��ȡ���в���������
 * 4. newInstance(Onject... initargs) ���ù��췽������ʵ����
 *
 *
 *
 */


@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
class Book{
    private String name;
    private double price;
    private int pageSize;
}

public class Demo {
    public static void main(String[] args) throws Exception {
        ////// ͨ�� Constructor ʵ��������
        Class<?> clazz = Book.class;
        //��ȡָ�����͹��췽��
        Constructor<?> constructor = clazz.getConstructor(String.class, double.class, int.class);
        Object obj = constructor.newInstance("��java���š�",22.9,325);
        System.out.println(obj);
    }
}
