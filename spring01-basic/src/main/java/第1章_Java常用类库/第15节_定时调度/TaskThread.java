package 第1章_Java常用类库.第15节_定时调度;

import java.util.Timer;
import java.util.TimerTask;

public class TaskThread extends TimerTask {

    @Override
    public void run() {
        System.out.println("定时任务");
    }

    public static void main(String[] args) {

        Timer timer = new Timer(); //定时任务调度类
        timer.schedule(new TaskThread(),1000,2000); //1秒后开始调度 2秒重复1次

    }
}
