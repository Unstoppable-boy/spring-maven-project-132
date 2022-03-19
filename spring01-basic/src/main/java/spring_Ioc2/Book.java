package spring_Ioc2;

import java.util.Calendar;
import java.util.Date;

public class Book {

    private String name;
    private Double price;
    private Date date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    //功能方法
    public void output(){
        System.out.println("书名："+name+"\n价格："+price+"\n出版日期："+date);
    }
}
