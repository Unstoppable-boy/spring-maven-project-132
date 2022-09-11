package 第1章_Java常用类库.第1_1节;

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

        /*********************************** StringBuffer类 *************************************/
        /*********************************** StringBuilder类 *************************************/

        /*常用方法
        * public StringBuffer append(数据类型 a)    向StringBuffer中保存数据
        * public StringBuffer delete(int start,int end) 指定位置删除字符串内容
        * public StringBuffer insert(int offset,数据类型 b) 在指定位置增加数据
        * public StringBuffer reverse() 字符串反转
        * public StringBuffer replace(int start,int end,String str) 替换指定范围的字符串
        * */

        StringBuffer buf = new StringBuffer();

        System.out.println(buf.append("123456789"));

        System.out.println(buf.delete(1,3));

        System.out.println(buf.insert(2,"哈哈"));

        System.out.println(buf.reverse());

        System.out.println(buf.replace(4,5,"替换"));

        /*
        123456789
        1456789
        14哈哈56789
        98765哈哈41
        9876替换哈哈41
        */



        /*********************************** 大数字处理类 *************************************/
        /*常用方法
         1. java.math.BigInteger
         public BigInteger(String val)  将字符串数字转为大数字
         public BigInteger add(BigInteger val)  加法运算
         public BigInteger subtract(BigInteger val) 减法计算
         public BigInteger multiply(BigInteger val) 乘法计算
         public BigInteger divide(BigInteger 除数)   除法计算
         public BigInteger[] divideAndRemainder(BigInteger 除数) 除法计算，获得商和余数
         public BigInteger max(BigInteger val)  两个对象比较获取最大值
         public BigInteger min(BigInteger val)  两个对象比较获取最小值
         public BigInteger mod(BigInteger val)  获取模

         1. java.math.BigDecimal
         类似以上方法
         * */
        BigInteger bigNum1 = new BigInteger("23");
        BigInteger bigNum2 = new BigInteger("4");
        System.out.println("商="+bigNum1.divideAndRemainder(bigNum2)[0]+
                        "  余数="+bigNum1.divideAndRemainder(bigNum2)[1]);

        System.out.println("最大值="+bigNum1.max(bigNum2));
        System.out.println("最小值="+bigNum1.min(bigNum2));
        System.out.println("模="+bigNum1.mod(bigNum2));

        /*商=5  余数=3
        最大值=23
        最小值=4
        模=3*/


        /*********************************** 日期时间处理 *************************************/

        /*Date常用方法
        * public Date()
        * public Date(long date)    将时间戳数字转为Date对象
        * public long getTime()
        * public boolean after(Date when)   是否在指定日期之后
        * public boolean before(Date when)   是否在指定日期之前
        *
        * */

        long datetime = System.currentTimeMillis()-90000;

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date1 = new Date(datetime);
        System.out.println(dateFormat.format(date1));

        Date date2 = new Date();
        System.out.println(dateFormat.format(date2));
        System.out.println("date1日期更晚？"+date1.after(date2));
        System.out.println("date1日期更早？"+date1.before(date2));

        /*2022-08-16 08:18:08
        2022-08-16 08:19:38
        date1日期更晚？false
        date1日期更早？true*/


        /*Calendar常用方法
        *Calendar.getInstance(); //获取对象实例
        *calendar.get(Calendar.YEAR) 获取年
        *calendar.get(Calendar.MONTH)+1 获取月
        *calendar.get(Calendar.DAY_OF_MONTH) 获取日
        *calendar.get(Calendar.HOUR_OF_DAY) 获取时
        *calendar.get(Calendar.MINUTE) 获取分
        *calendar.get(Calendar.SECOND) 获取秒
        *c.add(Calendar.YEAR,2); //2年后
         c.add(Calendar.MONTH,5); //5个月后
         cal.set(cal.get(Calendar.YEAR),8,1); //指定日期 当前年-9-1
         */

        /*获取当前时间*/
        Calendar calendar = Calendar.getInstance(); //获取对象实例
        System.out.println(String.format("当前的日期时间：%s-%s-%s %s:%s:%s",calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH)+1,calendar.get(Calendar.DAY_OF_MONTH),calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE),calendar.get(Calendar.SECOND)));
        //当前的日期时间：2022-8-16 20:27:50

        /*日期的精准计算*/
        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR,2); //2年后
        c.add(Calendar.MONTH,5); //5个月后
        System.out.println(String.format("当前的日期时间：%s-%s-%s %s:%s:%s",c.get(Calendar.YEAR),
                c.get(Calendar.MONTH)+1,c.get(Calendar.DAY_OF_MONTH),c.get(Calendar.HOUR_OF_DAY),
                c.get(Calendar.MINUTE),c.get(Calendar.SECOND)));


        /*找到8月的最后一天: 9月1日减去1天*/
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR),8,1); //指定日期 当前年-9-1
        cal.add(Calendar.DATE,-1); //日期-1天
        System.out.println(String.format("当前的日期时间：%s-%s-%s %s:%s:%s",cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH)+1,cal.get(Calendar.DAY_OF_MONTH),cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE),cal.get(Calendar.SECOND)));
        //当前的日期时间：2022-8-31 20:43:58


        /*LocalDate LocalTime LocalDateTime常用方法*/

        LocalDate localdate = LocalDate.now(); //获取当前日期
        LocalTime localTime = LocalTime.now(); //获取当前时间
        LocalDateTime localDateTime = LocalDateTime.now(); //获取当前日期时间
        System.out.println(localdate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        /*2022-08-16
        20:59:41.988
        2022-08-16T20:59:41.988*/

        LocalDate today = LocalDate.now();
        System.out.println(String.format("当前日期：%s-%s-%s",today.getYear(),today.getMonthValue(),today.getDayOfMonth()));

        System.out.println("今天星期几？"+today.getDayOfWeek().getValue());
        System.out.println("今天是当月的第几周？"+today.get(ChronoField.ALIGNED_WEEK_OF_MONTH));
        System.out.println("今天是今年的第几周？"+today.get(ChronoField.ALIGNED_WEEK_OF_YEAR));
        System.out.println("今天是今年的第几天？"+today.getDayOfYear());

        LocalDate loc = LocalDate.parse("2022-08-16"); //操作指定日期
        System.out.println("今年是闰年么？"+loc.isLeapYear());

        /* LocalDate日期推算 */
        LocalDate localDate = LocalDate.parse("2022-08-17"); //操作指定日期
        System.out.println("当月第一天："+localDate.with(TemporalAdjusters.firstDayOfMonth()));
        System.out.println("当月第二天："+localDate.withDayOfMonth(2));
        System.out.println("当月最后一天："+localDate.with(TemporalAdjusters.lastDayOfMonth()));
        System.out.println("30年后的日期："+localDate.plusYears(30));
        System.out.println("6个月后的日期："+localDate.plusMonths(6));
        System.out.println("当前月的第一个周一："+localDate.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY)));
        System.out.println("日期所处年的第一个周一："+localDate.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY)));


        /* 多线程下的SimpleDateFormat */
        /*DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                try {
                    System.out.println("【"+Thread.currentThread().getName()+"】"+df.parse("2022-08-17 08:55:33"));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            },"df线程切换"+i).start();
        }*/
        //java.lang.NumberFormatException: multiple points
        //SimpleDateFormat并不适用于高并发多线程的操作，使用localDate或LocalDateTime来实现。

        /* 使用LocalDateTime来实现并发转换 */
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        ZoneId zoneId = ZoneId.systemDefault(); //获取当前的时区id
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                LocalDateTime localDateTime1 = LocalDateTime.parse("2022-08-17 09:08:17",formatter);
                Instant instant = localDateTime1.atZone(zoneId).toInstant();
                Date date = Date.from(instant); //字符串转为日期时间
                System.out.println("【"+Thread.currentThread().getName()+"】"+date);

                LocalDateTime localDateTime2 = LocalDateTime.now(); //获取当前时间
                String format = formatter.format(localDateTime2); //将日期时间转为字符串
                System.out.println(format);
            },"LDT线程切换"+i).start();
        }



        /*********************************** 正则表达式 *************************************/
        /*String类对正则的支持
        * public boolean matches(String regex) 使用字符串与正则式进行匹配，符合正则式，返回true，反之false
        * public String[] split(String regex) 使用正则式作为拆分符号
        * public String[] split(String regex,int limit) 使用正则式作为拆分符号
        * public String replaceFirst(String regex,String replaceStr) 替换首个匹配字符串
        * public String replaceAll(String regex,String replaceStr) 替换全部匹配字符串
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



        /*********************************** ResourceBundle 对象读取资源文件 *************************************/
        ResourceBundle bundle = ResourceBundle.getBundle("Message"); //绑定指定的资源文件
        System.out.println(bundle.getString("name"));
        System.out.println(bundle.getString("age"));
        System.out.println(bundle.getString("sex"));


        Locale locale = Locale.CHINA; //中文环境
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Message",locale);
        String value = resourceBundle.getString("login.info");
        System.out.println(MessageFormat.format(value,"小明","www.baidu.com"));



        /*********************************** 数字格式化 *************************************/
        /*NumberFormat常用方法
        * NumberFormat.getInstance() 获取普通实例对象
        * NumberFormat.getInstance(Locale inLocale) 绑定locale对象实例
        * getPercentInstance() 获取百分比
        * getPercentInstance(Locale inLocale) 绑定locale对象获取百分比
        * getCurrencyInstance() 获取默认Locale的货币实例
        * getCurrencyInstance(Locale inLocale) 绑定locale对象获取货币实例
        * */

        NumberFormat numberFormat = NumberFormat.getInstance(); //获取一个普通实例
        numberFormat.setMinimumFractionDigits(4); //保留4位小数
        System.out.println(numberFormat.format(2546854.5611515)); //2,546,854.5612 (默认四舍五入了)

        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance();
        decimalFormat.setRoundingMode(RoundingMode.DOWN); //不进位
        decimalFormat.setPositivePrefix("收入流水："); //格式化前缀
        decimalFormat.setPositiveSuffix("人民币"); //格式化后缀
        decimalFormat.setMinimumFractionDigits(5); //保留5位小数
        System.out.println(decimalFormat.format(15161561451.15615615)); //收入流水：15,161,561,451.15615人民币

        NumberFormat percent = NumberFormat.getPercentInstance(); //获取普通的百分比实例
        System.out.println(percent.format(0.6596)); //66%
        //如果对百分比格式化有自定义要求，必须向下转型
        DecimalFormat myPercent = (DecimalFormat) percent;
        myPercent.setMinimumFractionDigits(2); //自定义百分比保留2位小数
        System.out.println(myPercent.format(0.35165541)); //35.17%

        /* 货币格式化：结合Locale类实现货币格式化处理 */
        System.out.println(NumberFormat.getCurrencyInstance(Locale.CHINA).format(531.5156)); //￥531.52
        System.out.println(NumberFormat.getCurrencyInstance(Locale.US).format(531.5156)); //$531.52


        /*********************************** Base64加密解密 *************************************/
        String msg = "156sdaAASD_小明和小红是好朋友!";
        Base64.Encoder encoder = Base64.getEncoder();
        byte[] encodeData = encoder.encode(msg.getBytes());
        System.out.println("加密后的数据："+new String(encodeData));

        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decodeDate = decoder.decode(encodeData);
        System.out.println("解密后的数据："+new String(decodeDate));


        /*********************************** UUID 通用唯一识别码 *************************************/
        String uuid = UUID.randomUUID().toString(); //生成UUID
        System.out.println(uuid); //276f6f16-16c0-49fd-83e8-bf70cb046e1c


    }
}
