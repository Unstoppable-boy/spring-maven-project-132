package ��1��_Java�������.��1_1��;

import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

public class Demo01 {
    public static void main(String[] args) {

        /*********************************** StringBuffer�� *************************************/
        /*********************************** StringBuilder�� *************************************/

        /*���÷���
        * public StringBuffer append(�������� a)    ��StringBuffer�б�������
        * public StringBuffer delete(int start,int end) ָ��λ��ɾ���ַ�������
        * public StringBuffer insert(int offset,�������� b) ��ָ��λ����������
        * public StringBuffer reverse() �ַ�����ת
        * public StringBuffer replace(int start,int end,String str) �滻ָ����Χ���ַ���
        * */

        StringBuffer buf = new StringBuffer();

        System.out.println(buf.append("123456789"));

        System.out.println(buf.delete(1,3));

        System.out.println(buf.insert(2,"����"));

        System.out.println(buf.reverse());

        System.out.println(buf.replace(4,5,"�滻"));

        /*
        123456789
        1456789
        14����56789
        98765����41
        9876�滻����41
        */



        /*********************************** �����ִ����� *************************************/
        /*���÷���
         1. java.math.BigInteger
         public BigInteger(String val)  ���ַ�������תΪ������
         public BigInteger add(BigInteger val)  �ӷ�����
         public BigInteger subtract(BigInteger val) ��������
         public BigInteger multiply(BigInteger val) �˷�����
         public BigInteger divide(BigInteger ����)   ��������
         public BigInteger[] divideAndRemainder(BigInteger ����) �������㣬����̺�����
         public BigInteger max(BigInteger val)  ��������Ƚϻ�ȡ���ֵ
         public BigInteger min(BigInteger val)  ��������Ƚϻ�ȡ��Сֵ
         public BigInteger mod(BigInteger val)  ��ȡģ

         1. java.math.BigDecimal
         �������Ϸ���
         * */
        BigInteger bigNum1 = new BigInteger("23");
        BigInteger bigNum2 = new BigInteger("4");
        System.out.println("��="+bigNum1.divideAndRemainder(bigNum2)[0]+
                        "  ����="+bigNum1.divideAndRemainder(bigNum2)[1]);

        System.out.println("���ֵ="+bigNum1.max(bigNum2));
        System.out.println("��Сֵ="+bigNum1.min(bigNum2));
        System.out.println("ģ="+bigNum1.mod(bigNum2));

        /*��=5  ����=3
        ���ֵ=23
        ��Сֵ=4
        ģ=3*/


        /*********************************** ����ʱ�䴦�� *************************************/

        /*Date���÷���
        * public Date()
        * public Date(long date)    ��ʱ�������תΪDate����
        * public long getTime()
        * public boolean after(Date when)   �Ƿ���ָ������֮��
        * public boolean before(Date when)   �Ƿ���ָ������֮ǰ
        *
        * */

        long datetime = System.currentTimeMillis()-90000;

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date1 = new Date(datetime);
        System.out.println(dateFormat.format(date1));

        Date date2 = new Date();
        System.out.println(dateFormat.format(date2));
        System.out.println("date1���ڸ���"+date1.after(date2));
        System.out.println("date1���ڸ��磿"+date1.before(date2));

        /*2022-08-16 08:18:08
        2022-08-16 08:19:38
        date1���ڸ���false
        date1���ڸ��磿true*/


        /*Calendar���÷���
        *Calendar.getInstance(); //��ȡ����ʵ��
        *calendar.get(Calendar.YEAR) ��ȡ��
        *calendar.get(Calendar.MONTH)+1 ��ȡ��
        *calendar.get(Calendar.DAY_OF_MONTH) ��ȡ��
        *calendar.get(Calendar.HOUR_OF_DAY) ��ȡʱ
        *calendar.get(Calendar.MINUTE) ��ȡ��
        *calendar.get(Calendar.SECOND) ��ȡ��
        *c.add(Calendar.YEAR,2); //2���
         c.add(Calendar.MONTH,5); //5���º�
         cal.set(cal.get(Calendar.YEAR),8,1); //ָ������ ��ǰ��-9-1
         */

        /*��ȡ��ǰʱ��*/
        Calendar calendar = Calendar.getInstance(); //��ȡ����ʵ��
        System.out.println(String.format("��ǰ������ʱ�䣺%s-%s-%s %s:%s:%s",calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH)+1,calendar.get(Calendar.DAY_OF_MONTH),calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE),calendar.get(Calendar.SECOND)));
        //��ǰ������ʱ�䣺2022-8-16 20:27:50

        /*���ڵľ�׼����*/
        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR,2); //2���
        c.add(Calendar.MONTH,5); //5���º�
        System.out.println(String.format("��ǰ������ʱ�䣺%s-%s-%s %s:%s:%s",c.get(Calendar.YEAR),
                c.get(Calendar.MONTH)+1,c.get(Calendar.DAY_OF_MONTH),c.get(Calendar.HOUR_OF_DAY),
                c.get(Calendar.MINUTE),c.get(Calendar.SECOND)));


        /*�ҵ�8�µ����һ��: 9��1�ռ�ȥ1��*/
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR),8,1); //ָ������ ��ǰ��-9-1
        cal.add(Calendar.DATE,-1); //����-1��
        System.out.println(String.format("��ǰ������ʱ�䣺%s-%s-%s %s:%s:%s",cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH)+1,cal.get(Calendar.DAY_OF_MONTH),cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE),cal.get(Calendar.SECOND)));
        //��ǰ������ʱ�䣺2022-8-31 20:43:58


        /*LocalDate LocalTime LocalDateTime���÷���*/

        LocalDate localdate = LocalDate.now(); //��ȡ��ǰ����
        LocalTime localTime = LocalTime.now(); //��ȡ��ǰʱ��
        LocalDateTime localDateTime = LocalDateTime.now(); //��ȡ��ǰ����ʱ��
        System.out.println(localdate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        /*2022-08-16
        20:59:41.988
        2022-08-16T20:59:41.988*/

        LocalDate today = LocalDate.now();
        System.out.println(String.format("��ǰ���ڣ�%s-%s-%s",today.getYear(),today.getMonthValue(),today.getDayOfMonth()));

        System.out.println("�������ڼ���"+today.getDayOfWeek().getValue());
        System.out.println("�����ǵ��µĵڼ��ܣ�"+today.get(ChronoField.ALIGNED_WEEK_OF_MONTH));
        System.out.println("�����ǽ���ĵڼ��ܣ�"+today.get(ChronoField.ALIGNED_WEEK_OF_YEAR));
        System.out.println("�����ǽ���ĵڼ��죿"+today.getDayOfYear());

        LocalDate loc = LocalDate.parse("2022-08-16"); //����ָ������
        System.out.println("����������ô��"+loc.isLeapYear());

        /* LocalDate�������� */
        LocalDate localDate = LocalDate.parse("2022-08-17"); //����ָ������
        System.out.println("���µ�һ�죺"+localDate.with(TemporalAdjusters.firstDayOfMonth()));
        System.out.println("���µڶ��죺"+localDate.withDayOfMonth(2));
        System.out.println("�������һ�죺"+localDate.with(TemporalAdjusters.lastDayOfMonth()));
        System.out.println("30�������ڣ�"+localDate.plusYears(30));
        System.out.println("6���º�����ڣ�"+localDate.plusMonths(6));
        System.out.println("��ǰ�µĵ�һ����һ��"+localDate.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY)));
        System.out.println("����������ĵ�һ����һ��"+localDate.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY)));


        /* ���߳��µ�SimpleDateFormat */
        /*DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                try {
                    System.out.println("��"+Thread.currentThread().getName()+"��"+df.parse("2022-08-17 08:55:33"));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            },"df�߳��л�"+i).start();
        }*/
        //java.lang.NumberFormatException: multiple points
        //SimpleDateFormat���������ڸ߲������̵߳Ĳ�����ʹ��localDate��LocalDateTime��ʵ�֡�

        /* ʹ��LocalDateTime��ʵ�ֲ���ת�� */
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        ZoneId zoneId = ZoneId.systemDefault(); //��ȡ��ǰ��ʱ��id
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                LocalDateTime localDateTime1 = LocalDateTime.parse("2022-08-17 09:08:17",formatter);
                Instant instant = localDateTime1.atZone(zoneId).toInstant();
                Date date = Date.from(instant); //�ַ���תΪ����ʱ��
                System.out.println("��"+Thread.currentThread().getName()+"��"+date);

                LocalDateTime localDateTime2 = LocalDateTime.now(); //��ȡ��ǰʱ��
                String format = formatter.format(localDateTime2); //������ʱ��תΪ�ַ���
                System.out.println(format);
            },"LDT�߳��л�"+i).start();
        }



        /*********************************** ������ʽ *************************************/
        /*String��������֧��
        * public boolean matches(String regex) ʹ���ַ���������ʽ����ƥ�䣬��������ʽ������true����֮false
        * public String[] split(String regex) ʹ������ʽ��Ϊ��ַ���
        * public String[] split(String regex,int limit) ʹ������ʽ��Ϊ��ַ���
        * public String replaceFirst(String regex,String replaceStr) �滻�׸�ƥ���ַ���
        * public String replaceAll(String regex,String replaceStr) �滻ȫ��ƥ���ַ���
        * */

        String str1 = "AAA_BBB_CCC_DDD";
        String regex = "_";
        String[] split = str1.split(regex, -1); //[AAA, BBB, CCC, DDD]
        String[] split2 = str1.split(regex, 0); //[AAA, BBB, CCC, DDD]
        String[] split3 = str1.split(regex, 2); //[AAA, BBB_CCC_DDD]
        String[] split4 = str1.split(regex, 5); //[AAA, BBB, CCC, DDD]
        System.out.println(Arrays.toString(split));
        System.out.println(Arrays.toString(split2));
        System.out.println(Arrays.toString(split3));
        System.out.println(Arrays.toString(split4));



        /*********************************** ResourceBundle �����ȡ��Դ�ļ� *************************************/
        ResourceBundle bundle = ResourceBundle.getBundle("Message"); //��ָ������Դ�ļ�
        System.out.println(bundle.getString("name"));
        System.out.println(bundle.getString("age"));
        System.out.println(bundle.getString("sex"));


        Locale locale = Locale.CHINA; //���Ļ���
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Message",locale);
        String value = resourceBundle.getString("login.info");
        System.out.println(MessageFormat.format(value,"С��","www.baidu.com"));



        /*********************************** ���ָ�ʽ�� *************************************/
        /*NumberFormat���÷���
        * NumberFormat.getInstance() ��ȡ��ͨʵ������
        * NumberFormat.getInstance(Locale inLocale) ��locale����ʵ��
        * getPercentInstance() ��ȡ�ٷֱ�
        * getPercentInstance(Locale inLocale) ��locale�����ȡ�ٷֱ�
        * getCurrencyInstance() ��ȡĬ��Locale�Ļ���ʵ��
        * getCurrencyInstance(Locale inLocale) ��locale�����ȡ����ʵ��
        * */

        NumberFormat numberFormat = NumberFormat.getInstance(); //��ȡһ����ͨʵ��
        numberFormat.setMinimumFractionDigits(4); //����4λС��
        System.out.println(numberFormat.format(2546854.5611515)); //2,546,854.5612 (Ĭ������������)

        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance();
        decimalFormat.setRoundingMode(RoundingMode.DOWN); //����λ
        decimalFormat.setPositivePrefix("������ˮ��"); //��ʽ��ǰ׺
        decimalFormat.setPositiveSuffix("�����"); //��ʽ����׺
        decimalFormat.setMinimumFractionDigits(5); //����5λС��
        System.out.println(decimalFormat.format(15161561451.15615615)); //������ˮ��15,161,561,451.15615�����

        NumberFormat percent = NumberFormat.getPercentInstance(); //��ȡ��ͨ�İٷֱ�ʵ��
        System.out.println(percent.format(0.6596)); //66%
        //����԰ٷֱȸ�ʽ�����Զ���Ҫ�󣬱�������ת��
        DecimalFormat myPercent = (DecimalFormat) percent;
        myPercent.setMinimumFractionDigits(2); //�Զ���ٷֱȱ���2λС��
        System.out.println(myPercent.format(0.35165541)); //35.17%

        /* ���Ҹ�ʽ�������Locale��ʵ�ֻ��Ҹ�ʽ������ */
        System.out.println(NumberFormat.getCurrencyInstance(Locale.CHINA).format(531.5156)); //��531.52
        System.out.println(NumberFormat.getCurrencyInstance(Locale.US).format(531.5156)); //$531.52


        /*********************************** Base64���ܽ��� *************************************/
        String msg = "156sdaAASD_С����С���Ǻ�����!";
        Base64.Encoder encoder = Base64.getEncoder();
        byte[] encodeData = encoder.encode(msg.getBytes());
        System.out.println("���ܺ�����ݣ�"+new String(encodeData));

        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decodeDate = decoder.decode(encodeData);
        System.out.println("���ܺ�����ݣ�"+new String(decodeDate));


        /*********************************** UUID ͨ��Ψһʶ���� *************************************/
        String uuid = UUID.randomUUID().toString(); //����UUID
        System.out.println(uuid); //276f6f16-16c0-49fd-83e8-bf70cb046e1c


    }
}
