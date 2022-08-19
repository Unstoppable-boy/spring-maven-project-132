package ��1��_Java�������.��13��_Optional;

import java.util.Optional;

public class Factory {

    private Factory(){}

    /**
     * public static<T> Optional<T> of(T val)   �������ݣ�if val==null ,return �쳣
     * public static<T> Optional<T> ofNullable(T val)   ���Ա��������
     * public T get()   ��Optional�л�ȡ��Ӧ������
     * public boolean isEmpty() �Ƿ�Ϊ�յ�Optional
     * public boolean isPresent() �Ƿ�������ݣ�����ڣ��򷵻�true
     * @return
     */
    public static Optional<IMessage> getInstance(){
        return Optional.of((msg)->{
            System.out.println("��Ϣ���ͣ�"+msg);
        });
    }

}
