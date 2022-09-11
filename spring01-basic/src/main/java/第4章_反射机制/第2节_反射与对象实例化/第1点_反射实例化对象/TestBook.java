package 第4章_反射机制.第2节_反射与对象实例化.第1点_反射实例化对象;


public class TestBook {
    public static void main(String[] args) throws Exception {

        /** Class类对象的实例化3种方式
         * 1. 对象.getClass()
         * 2. 类名.class
         * 3. Class.forName(类的全限名称)
         */

        Class<?> bookClazz = Book.class; //反射获取Class对象
        //无参构造获取实例 通过反射实例化的对象返回类型统一为Object
        Object obj = bookClazz.getDeclaredConstructor().newInstance();

        Book book = (Book) obj; //向下转型

        book.read();

    }
}


class Book{
    public Book(){
        System.out.println("无参构造实例化对象");
    }
    public void read(){
        System.out.println("这本书很好看");
    }
}