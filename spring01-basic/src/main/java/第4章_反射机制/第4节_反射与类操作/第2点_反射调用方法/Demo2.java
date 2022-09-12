package ��4��_�������.��4��_�����������.��2��_������÷���;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.lang.reflect.Method;

/**
 * �����ȡ����
 * 1. getMethod(String name, Class<?>... paramterType) ��ȡpublicȨ�޶����ָ������
 * 2. getMethods() ��ȡȫ��public����
 * 3. getDeclaredMothod(String name, Class<?>... paramterType) ����Ȩ�޻�ȡָ������
 * 4. getDeclaredMothods() ��ȡ���з��� ����Ȩ��
 *
 * Method�ೣ�÷���
 * 1. getReturnType() ��ȡ��������ֵ����
 * 2. getGenericParamterTypes() ��ȡ������������
 * 3. getGenericExceptionTypes() ��ȡ�����׳��쳣������
 * 4. invoke() ��������
 * 5. getModifiers() ��ȡ�����������η������ص���int���ݡ�
     *  public	1
     *  private	2
     *  protected	4
     * static	8
     * final	16
     * synchronized	32
     * volatile	64
     * transient	128
     * native	256
     * interface	512
     * abstract	1024
     * strict	2048
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
class Book{
    private String title;
}

public class Demo2 {
    public static void main(String[] args) throws Exception {

        String fieldName = "title"; //ָ�����������
        String fieldValue = "java����ʵս"; //�����Ե�Ԥ��ֵ

        Class<?> clazz = Book.class;

        Object obj = clazz.getDeclaredConstructor().newInstance(); //�������ʵ����

        //�ҵ�ָ����setTitle()��������������ΪString
        Method setMethod = clazz.getMethod("set"+initcap(fieldName),String.class);

        //invoke(����ʵ��)
        setMethod.invoke(obj,fieldValue); //�൱��obj.setTitle(fieldValue)

        //�ҵ�ָ����getTitle()�������޲���
        Method getMethod = clazz.getMethod("get"+initcap(fieldName));

        //ͨ�������ȡget��������ֵ
        Object value = getMethod.invoke(obj);

        System.out.println(value);


    }

    private static String initcap(String str){
        if (str==null || "".equals(str)){
            return str;
        }
        if (str.length()==1){
            return str.toUpperCase();
        }else {
            return str.substring(0,1).toUpperCase()+str.substring(1);
        }

    }
}
