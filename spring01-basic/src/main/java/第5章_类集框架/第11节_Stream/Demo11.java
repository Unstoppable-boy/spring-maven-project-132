package ��5��_�༯���.��11��_Stream;

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
 * ͨ������ʽ��̵Ľṹʵ�ּ������ݵķ���
 *
 * Collection�ṩ����������������
 * 1. stream() ��ȡһ��Stream�ӿڶ���ʵ��
 * 2. parallelStream() ��ȡ���̵߳�Stream�ӿ�ʵ�������д�������
 *
 * Stream�ӿڳ��÷���
 * 1. count() ��ȡ�������е�Ԫ�ظ���
 * 2. distinct() �������������ظ���Ԫ��
 * 3. sorted() ����������
 * 4. limit(long maxSize) ��������ȡ���Ƴ���
 * 5. skip(long n) ��ԾԪ�ظ���
 * 6. forEach() ����������
 * 7. reduce() ����ͳ��
 * 8. collect() �����ռ�
 * 9. anyMatch() ����������ƥ��
 * 10. allMatch() ������ȫ��ƥ��
 * 12. findFirst() ��ȡ��һ��Ԫ��
 * 13. filter() ����������
 * 14. map() ���ݴ���
 * */

public class Demo11 {
    public static void main(String[] args) {

        /*+++++++++++++++++++++++++++++++++++++++++++ Stream�������� +++++++++++++++++++++++++++++++++++++*/
        List<String> data = new ArrayList<>();
        Collections.addAll(data,"java","c","js","php","java");

        Stream<String> stream = data.stream(); //ͨ�����ϻ�ȡStream����

        //filter() �����ݽ��й��� �����ǹ�������
        //collect() �����������������ռ���һ���µ�List����
        List<String> list = stream
                .filter((ele)->ele.toLowerCase().contains("j"))
                .distinct() //ȥ�� ֻ�ռ�һ��java
                .collect(Collectors.toList()); //Stream���ݴ���

        System.out.println(list);


        /*+++++++++++++++++++++++++++++++++++++++++++ �������ݴ��� +++++++++++++++++++++++++++++++++++++*/

        List<String> data1 = new ArrayList<>();
        Collections.addAll(data1,"java","c","js","php","c#","c++","python","go","mysql");

        Stream<String> stream1 = data1.stream(); //ͨ�����ϻ�ȡstream����

        //skip(2) ����2������������ ������js�
        //limit(4) �������ݵĸ���Ϊ4����������2�����ȣ����������Ϊ2~5������
        List<String> list1 = stream1.skip(2).limit(4).filter((ele)->
                ele.toLowerCase().matches("(.*j.*)|(.*c.*)")).collect(Collectors.toList());

        System.out.println(list1);


        /*+++++++++++++++++++++++++++++++++++++++++++ MapReduce���ݴ��� +++++++++++++++++++++++++++++++++++++*/
        
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("��java��",19.9,3));
        orders.add(new Order("��c��",18.9,9));
        orders.add(new Order("��php��",20.9,20));
        orders.add(new Order("��python��",22.9,30));
        
        Stream<Order> stream2 = orders.stream(); //ͨ�����ϻ�ȡstream����


        DoubleSummaryStatistics result = stream2
                .filter((ele)->ele.getName().toLowerCase().contains("p"))
                .mapToDouble((orderObject)->orderObject.getPrice()*orderObject.getAmount())
                .summaryStatistics();

        System.out.println("����������"+result.getCount());
        System.out.println("�����ܷ��ã�"+result.getSum());
        System.out.println("��Ʒƽ���۸�"+result.getAverage());
        System.out.println("��Ʒ��߼ۣ�"+result.getMax());
        System.out.println("��Ʒ��ͼۣ�"+result.getMin());
        


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
