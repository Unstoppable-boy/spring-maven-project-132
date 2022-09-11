package 第1章_Java常用类库.第13节_Optional;

import java.util.Optional;

public class Factory {

    private Factory(){}

    /**
     * public static<T> Optional<T> of(T val)   保存数据，if val==null ,return 异常
     * public static<T> Optional<T> ofNullable(T val)   可以保存空数据
     * public T get()   从Optional中获取对应的数据
     * public boolean isEmpty() 是否为空的Optional
     * public boolean isPresent() 是否存在内容，如存在，则返回true
     * @return
     */
    public static Optional<IMessage> getInstance(){
        return Optional.of((msg)->{
            System.out.println("消息发送："+msg);
        });
    }

}
