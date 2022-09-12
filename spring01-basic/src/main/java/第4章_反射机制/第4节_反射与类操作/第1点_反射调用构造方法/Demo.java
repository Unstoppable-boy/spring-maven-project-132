package 第4章_反射机制.第4节_反射与类操作.第1点_反射调用构造方法;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.lang.reflect.Constructor;

/**
 * 反射获取类结构的方法
 * 1. public Package getPackage() 获取指定类所在包
 * 2. public String getPackageName() 获取包名
 * 3. public Class<? super T> getSuperclass() 获取父类
 * 4. public Class<?>[] getInterfaces() 获取接口
 *
 * 反射获取构造方法
 * 1. getConstructor(paramterType) 获取指定参数类型、public的构造方法
 *      例：clazz.getConstructor(String.class,double.class)
 * 2. getConstructor() 获得全部public构造方法
 * 3. getDeclaredConstructor(paramterType) 获取指定类型的构造方法，不区分权限
 * 4. getDeclaredConstructor() 获取全部构造方法，不区分权限
 *
 * Constructor类常用方法
 * 1. getName() 获取构造方法的名称
 * 2. getParamterCount() 获取构造方法中参数个数
 * 3. getTypeParamters() 获取所有参数的类型
 * 4. newInstance(Onject... initargs) 调用构造方法反射实例化
 *
 *
 *
 */


@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
class Book{
    private String name;
    private double price;
    private int pageSize;
}

public class Demo {
    public static void main(String[] args) throws Exception {
        ////// 通过 Constructor 实例化对象
        Class<?> clazz = Book.class;
        //获取指定类型构造方法
        Constructor<?> constructor = clazz.getConstructor(String.class, double.class, int.class);
        Object obj = constructor.newInstance("《java入门》",22.9,325);
        System.out.println(obj);
    }
}
