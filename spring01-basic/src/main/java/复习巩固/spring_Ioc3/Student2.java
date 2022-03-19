package 复习巩固.spring_Ioc3;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student2 {

    private static final DateFormat dateFormat =
            new SimpleDateFormat("yyyy-MM-dd");

    private String name;
    private Integer age;
    private Date birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    //功能方法
    public void putInfo(){
        System.out.println(
                "姓名："+this.name+"  "
                +"年龄："+this.age+"  "
                +"出生日期："+dateFormat.format(this.birthday)+"  "
        );
    }
}
