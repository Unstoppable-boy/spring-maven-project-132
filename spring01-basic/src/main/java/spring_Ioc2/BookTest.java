package spring_Ioc2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.DateFormat;
import java.util.Date;

public class BookTest {

    private static final String CONFIG = "ApplicationContext-2.xml";

    public static void main(String[] args) {

        //创建Ioc容器
        ApplicationContext context = new ClassPathXmlApplicationContext(CONFIG);

        //按名称
        Date now = (Date) context.getBean("now");
        //按类型
        DateFormat dateFormat = context.getBean(DateFormat.class);
        System.out.println(dateFormat.format(now));


        //按名称向Ioc容器索要对象
        Book book = (Book) context.getBean("book");
        book.output();


    }

}
