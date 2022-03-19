package spring_Ioc;

import java.util.Date;

public class Student {

    private String name;
    private int age;
    private Date registTime;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getRegistTime() {
        return registTime;
    }

    public void setRegistTime(Date registTime) {
        this.registTime = registTime;
    }

    //功能方法
    public void showInfo(){
        System.out.println("姓名："+name+"  年龄："+age+"  注册时间："+registTime);
    }
}
