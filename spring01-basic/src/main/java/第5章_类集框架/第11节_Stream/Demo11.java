package 第5章_类集框架.第11节_Stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * java.util.stream
 * 通过函数式编程的结构实现几何数据的分析
 *
 * Collection提供的数据流操作方法
 * 1. stream() 获取一个Stream接口对象实例
 * 2. parallelStream() 获取多线程的Stream接口实例，并行处理数据
 *
 * Stream接口常用方法
 * 1. count() 获取数据流中的元素个数
 * 2. distinct() 消除数据流中重复的元素
 * 3. sorted() 数据流排序
 * 4. limit(long maxSize) 数据流读取限制长度
 * 5. skip(long n) 跳跃元素个数
 * 6. forEach() 迭代数据流
 * 7. reduce() 数据统计
 * 8. collect() 数据收集
 * 9. anyMatch() 数据流部分匹配
 * 10. allMatch() 数据流全部匹配
 * 12. findFirst() 获取第一个元素
 * 13. filter() 数据流过滤
 * 14. map() 数据处理
 * */

public class Demo11 {
    public static void main(String[] args) {

        /*+++++++++++++++++++++++++++++++++++++++++++ Stream基本操作 +++++++++++++++++++++++++++++++++++++*/
        List<String> data = new ArrayList<>();
        Collections.addAll(data,"java","c","js","php","java");

        Stream<String> stream = data.stream(); //通过集合获取Stream对象

        //filter() 对数据进行过滤 参数是过滤条件
        //collect() 将满足条件的数据收集到一个新的List集合
        List<String> list = stream
                .filter((ele)->ele.toLowerCase().contains("j"))
                .distinct() //去重 只收集一个java
                .collect(Collectors.toList()); //Stream数据处理

        System.out.println(list);


        /*+++++++++++++++++++++++++++++++++++++++++++ 部分数据处理 +++++++++++++++++++++++++++++++++++++*/

        List<String> data1 = new ArrayList<>();
        Collections.addAll(data1,"java","c","js","php","c#","c++","python","go","mysql");

        Stream<String> stream1 = data1.stream(); //通过集合获取stream对象

        //skip(2) 跳过2个长度数据项 （跳到js项）
        //limit(4) 操作数据的个数为4个，先跳了2个长度，则操作索引为2~5的数据
        List<String> list1 = stream1.skip(2).limit(4).filter((ele)->
                ele.toLowerCase().matches("(.*j.*)|(.*c.*)")).collect(Collectors.toList());

        System.out.println(list1);


        /*+++++++++++++++++++++++++++++++++++++++++++ MapReduce数据处理 +++++++++++++++++++++++++++++++++++++*/
        
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("《java》",19.9,3));
        orders.add(new Order("《c》",18.9,9));
        orders.add(new Order("《php》",20.9,20));
        orders.add(new Order("《python》",22.9,30));
        
        Stream<Order> stream2 = orders.stream(); //通过集合获取stream对象


        DoubleSummaryStatistics result = stream2
                .filter((ele)->ele.getName().toLowerCase().contains("p"))
                .mapToDouble((orderObject)->orderObject.getPrice()*orderObject.getAmount())
                .summaryStatistics();

        System.out.println("订单总量："+result.getCount());
        System.out.println("订单总费用："+result.getSum());
        System.out.println("商品平均价格："+result.getAverage());
        System.out.println("商品最高价："+result.getMax());
        System.out.println("商品最低价："+result.getMin());
        


    }
}


@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
class Order{
    private String name;
    private double price;
    private int amount;
}
