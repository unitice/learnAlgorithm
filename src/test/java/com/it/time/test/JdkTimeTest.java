package com.it.time.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@SpringBootTest
public class JdkTimeTest {

    /**
     * 获取当天日期
     */
    @Test
    @DisplayName("newDate")
    public void newDateTest(){
        LocalDate today = LocalDate.now();
        System.out.println("今天的日期:"+today);
    }

    /**
     * 获取当前年月日
     */
    @Test
    @DisplayName("year_month_day")
    public void yearMonthDayTest(){
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        int month = today.getMonthValue();
        int day = today.getDayOfMonth();

        System.out.println("year:"+year);
        System.out.println("month:"+month);
        System.out.println("day:"+day);
    }

    /**
     * 生产指定日期
     */
    @Test
    @DisplayName("specifyDate")
    public void specifyDate(){
        LocalDate date = LocalDate.of(2018,2,6);
        System.out.println("自定义日期:"+date);
    }

    /**
     * 日期比较
     */
    @Test
    @DisplayName("dateCompare")
    public void dateCompare(){
        LocalDate date1 = LocalDate.now();
        LocalDate date2 = LocalDate.of(2018,2,5);
        if(date1.equals(date2)){
            System.out.println("时间相等");
        }else{
            System.out.println("时间不等");
        }

    }

    /**
     * 周期性日期比较
     */
    @Test
    @DisplayName("recurringDateCompare")
    public void recurringDateCompare(){
        LocalDate date1 = LocalDate.now();

        LocalDate date2 = LocalDate.of(2018,2,6);
        MonthDay birthday = MonthDay.of(date2.getMonth(),date2.getDayOfMonth());
        MonthDay currentMonthDay = MonthDay.from(date1);

        if(currentMonthDay.equals(birthday)){
            System.out.println("是你的生日");
        }else{
            System.out.println("你的生日还没有到");
        }
    }

    /**
     * 获取当前时间
     */
    @Test
    @DisplayName("newTime")
    public void newTime(){
        LocalTime time = LocalTime.now();
        System.out.println("获取当前的时间,不含有日期:"+time);
    }

    /**
     * 时间计算
     */
    @Test
    @DisplayName("calculationTime")
    public void calculationTime(){
        LocalTime time = LocalTime.now();
        LocalTime newTime = time.plusHours(3);
        System.out.println("三个小时后的时间为:"+newTime);
        LocalDate today = LocalDate.now();
        System.out.println("今天的日期为:"+today);
        LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
        System.out.println("一周后的日期为:"+nextWeek);
        LocalDate previousYear = today.minus(1, ChronoUnit.YEARS);
        System.out.println("一年前的日期 : " + previousYear);
        LocalDate nextYear = today.plus(1, ChronoUnit.YEARS);
        System.out.println("一年后的日期:"+nextYear);
    }

    /**
     * clock时钟表
     */
    @Test
    @DisplayName("clock")
    public void clockTest(){
        // Returns the current time based on your system clock and set to UTC.
        Clock clock = Clock.systemUTC();
        System.out.println("Clock : " + clock.millis());

        // Returns time based on system clock zone
        Clock defaultClock = Clock.systemDefaultZone();
        System.out.println("Clock : " + defaultClock.millis());
    }

    /**
     * 时间比较早晚
     */
    @Test
    @DisplayName(" dateSoonerOrLater")
    public void dateSoonerOrLaterTest(){
        LocalDate today = LocalDate.now();

        LocalDate tomorrow = LocalDate.of(2018,2,6);
        if(tomorrow.isAfter(today)){
            System.out.println("之后的日期:"+tomorrow);
        }

        LocalDate yesterday = today.minus(1, ChronoUnit.DAYS);
        if(yesterday.isBefore(today)){
            System.out.println("之前的日期:"+yesterday);
        }
    }

    /**
     * 时区处理
     */
    @Test
    @DisplayName("timeZoneProcessing")
    public void timeZoneProcessingTest(){
        // Date and time with timezone in Java 8
        ZoneId america = ZoneId.of("America/New_York");
        LocalDateTime localtDateAndTime = LocalDateTime.now();
        ZonedDateTime dateAndTimeInNewYork  = ZonedDateTime.of(localtDateAndTime, america );
        System.out.println("Current date and time in a particular timezone : " + dateAndTimeInNewYork);
    }

    /**
     * 固定日期
     */
    @Test
    @DisplayName("fixedDate")
    public void fixedDateTest(){
        YearMonth currentYearMonth = YearMonth.now();
        System.out.printf("Days in month year %s: %d%n", currentYearMonth, currentYearMonth.lengthOfMonth());
        YearMonth creditCardExpiry = YearMonth.of(2019, Month.FEBRUARY);
        System.out.printf("Your credit card expires on %s %n", creditCardExpiry);
    }

    /**
     * 判断是否为闰年 闰年检测
     */
    @Test
    @DisplayName("leapYearDetection")
    public void leapYearDetection(){
        LocalDate today = LocalDate.now();
        if(today.isLeapYear()){
            System.out.println("This year is Leap year");
        }else {
            System.out.println("2018 is not a Leap year");
        }
    }

    /**
     * 计算日期之前差值 间隔计算
     */
    @Test
    @DisplayName("dateIntervalCalculation")
    public void dateIntervalCalculation(){
        LocalDate today = LocalDate.now();
        LocalDate java8Release = LocalDate.of(2021, 12, 14);
        Period periodToNextJavaRelease = Period.between(today, java8Release);
        System.out.println("Months left between today and Java 8 release : "
                + periodToNextJavaRelease.getMonths() );
    }

    /**
     * 获取时间戳
     */
    @Test
    @DisplayName("getTimestamp")
    public void getTimestamp(){
        Instant timestamp = Instant.now();
        System.out.println("What is value of this instant " + timestamp.toEpochMilli());
    }

    /**
     * 日期格式化
     */
    @Test
    @DisplayName("dateFormatting")
    public void dateFormatting(){
        String dayAfterTommorrow = "20180205";
        LocalDate formatted = LocalDate.parse(dayAfterTommorrow,
                DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(dayAfterTommorrow+"  格式化后的日期为:  "+formatted);
    }

    /**
     * 字符串日期转换
     */
    @Test
    @DisplayName("stringDateConversion")
    public void stringDateConversion(){
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        //日期转字符串
        String str = date.format(format1);
        System.out.println("日期转换为字符串:"+str);
        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        //字符串转日期
        LocalDate date2 = LocalDate.parse(str,format2);
        System.out.println("日期类型:"+date2);

    }


}
