package ��1��_Java�������.��13��_Optional;


public class Demo02 {
    public static void main(String[] args) {

        IMessage msgObj = Factory.getInstance().get(); //��ȡʵ�����󣬲���Optional�л�ȡ����
        msgObj.send("132456");


    }
}
