package 第1章_Java常用类库.第13节_Optional;


public class Demo02 {
    public static void main(String[] args) {

        IMessage msgObj = Factory.getInstance().get(); //获取实例对象，并从Optional中获取数据
        msgObj.send("132456");


    }
}
