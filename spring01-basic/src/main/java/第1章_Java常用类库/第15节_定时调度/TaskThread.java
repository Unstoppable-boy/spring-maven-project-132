package ��1��_Java�������.��15��_��ʱ����;

import java.util.Timer;
import java.util.TimerTask;

public class TaskThread extends TimerTask {

    @Override
    public void run() {
        System.out.println("��ʱ����");
    }

    public static void main(String[] args) {

        Timer timer = new Timer(); //��ʱ���������
        timer.schedule(new TaskThread(),1000,2000); //1���ʼ���� 2���ظ�1��

    }
}
