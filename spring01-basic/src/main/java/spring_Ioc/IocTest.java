package spring_Ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.DateFormat;
import java.util.Date;

public class IocTest {

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println(11111);
        System.out.println(22222);

        //向Ioc容器索要对象，有2中方式
        //方式1：按名称索要
        Date now = (Date) context.getBean("now");
        System.out.println("now = "+now);



        //方式2：按类型索要
        Date now2 = context.getBean(Date.class);
        System.out.println("now2 = "+now2);
        //按类型索要日期格式对象
        DateFormat dateFormat = context.getBean(DateFormat.class);
        System.out.println(dateFormat.format(now));

        //
        Student student = (Student) context.getBean("student");
        student.showInfo();

    }

}
