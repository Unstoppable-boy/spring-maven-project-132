package 复习巩固.spring_Ioc3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring_Ioc.Student;
import sun.security.krb5.Config;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Test {

    private static final String CONFIG = "复习巩固/applicationContext.xml";

    public static void main(String[] args) {
        //创建Ioc
        ApplicationContext context = new ClassPathXmlApplicationContext(CONFIG);
        Student2 student = (Student2) context.getBean("student");
        student.putInfo();

    }
}
