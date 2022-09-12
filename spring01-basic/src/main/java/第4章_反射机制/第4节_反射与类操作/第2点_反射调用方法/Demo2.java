package 第4章_反射机制.第4节_反射与类操作.第2点_反射调用方法;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.lang.reflect.Method;

/**
 * 反射获取方法
 * 1. getMethod(String name, Class<?>... paramterType) 获取public权限定义的指定方法
 * 2. getMethods() 获取全部public方法
 * 3. getDeclaredMothod(String name, Class<?>... paramterType) 不分权限获取指定方法
 * 4. getDeclaredMothods() 获取所有方法 不分权限
 *
 * Method类常用方法
 * 1. getReturnType() 获取方法返回值类型
 * 2. getGenericParamterTypes() 获取方法参数类型
 * 3. getGenericExceptionTypes() 获取方法抛出异常的类型
 * 4. invoke() 方法调用
 * 5. getModifiers() 获取方法访问修饰符。返回的是int数据。
     *  public	1
     *  private	2
     *  protected	4
     * static	8
     * final	16
     * synchronized	32
     * volatile	64
     * transient	128
     * native	256
     * interface	512
     * abstract	1024
     * strict	2048
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
class Book{
    private String title;
}

public class Demo2 {
    public static void main(String[] args) throws Exception {

        String fieldName = "title"; //指定对象的属性
        String fieldValue = "java开发实战"; //给属性的预设值

        Class<?> clazz = Book.class;

        Object obj = clazz.getDeclaredConstructor().newInstance(); //反射对象实例化

        //找到指定的setTitle()方法，参数类型为String
        Method setMethod = clazz.getMethod("set"+initcap(fieldName),String.class);

        //invoke(对象，实参)
        setMethod.invoke(obj,fieldValue); //相当于obj.setTitle(fieldValue)

        //找到指定的getTitle()方法，无参数
        Method getMethod = clazz.getMethod("get"+initcap(fieldName));

        //通过反射获取get方法返回值
        Object value = getMethod.invoke(obj);

        System.out.println(value);


    }

    private static String initcap(String str){
        if (str==null || "".equals(str)){
            return str;
        }
        if (str.length()==1){
            return str.toUpperCase();
        }else {
            return str.substring(0,1).toUpperCase()+str.substring(1);
        }

    }
}
