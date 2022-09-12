package 第4章_反射机制.第3节_反射与对象实例化.第2点_反射与工厂设计模式;


//图书接口
interface IBook {
    public void read(); //抽象方法
}


//图书实现类
class MathBook implements IBook{
    @Override
    public void read() {
        System.out.println("数学很难学");
    }
}

class MusicBook implements IBook{
    @Override
    public void read() {
        System.out.println("音乐是一门艺术课");
    }
}


//工厂
class Factory{

    private Factory(){}

    public static IBook getInstance(String className){
        try {
            Object obj = Class.forName(className).getDeclaredConstructor().newInstance();
            if (obj instanceof IBook){ //防止出现强转异常
                return (IBook) obj;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}


//测试类
public class TestBook{
    public static void main(String[] args) {
        IBook book1 = Factory.getInstance("第4章_反射机制.第3节_反射与对象实例化.第2点_反射与工厂设计模式.MathBook");
        book1.read();

        IBook book2 = Factory.getInstance("第4章_反射机制.第3节_反射与对象实例化.第2点_反射与工厂设计模式.MusicBook");
        book2.read();
    }
}

