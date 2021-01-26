package com.xian.requireproject.common;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * 日期工具类
 * Created by yexinmeng on 2017/12/21.
 */
public class DateUtil {

    // 半小时常量 30 * 60 * 1000
    public static final int HALF_HOUR = 1800000;
    // 一天时间常量 24 * 60 * 60 * 1000
    public static final int ONE_DAY = 86400000;

    /**
     * 获取一天后时间
     * @param date
     * @return
     */
    public static Date getDateAddOneDay(Date date) {
        Date dateResult = new Date();
        dateResult.setTime(date.getTime() + ONE_DAY);
        return dateResult;
    }

    /**
     * 获取半小时后时间
     * @param date
     * @return
     */
    public static Date getDateAddHalfHour(Date date) {
        Date dateResult = new Date();
        dateResult.setTime(date.getTime() + HALF_HOUR);
        return dateResult;
    }

    /**
     * 获取半小时前时间
     * @param date
     * @return
     */
    public static Date getDateSubHalfHour(Date date) {
        Date dateResult = new Date();
        dateResult.setTime(date.getTime() - HALF_HOUR);
        return dateResult;
    }

    /**
     * 获取30天后时间
     * @Title: getNextMonthDay
     * @param: @param date
     * @param: @return
     * @return: Date
     */
    public static Date getNextMonthDay(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 1);
        return calendar.getTime();
    }

    /**
     * 获取7天后时间
     * @Title: getNextWeekDay
     * @param: @param date
     * @param: @return      
     * @return: Date
     */
    public static Date getNextWeekDay(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.WEEK_OF_YEAR, 1);
        return calendar.getTime();
    }

    /**
     * 获取上一年时间
     * @Title: getLastYearDay
     * @param: @param date
     * @param: @return      
     * @return: Date
     */
    public static Date getLastYearDay(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, -1);
        return calendar.getTime();
    }

    /**
     * 获取上月时间
     * @Title: getLastMonthDay
     * @param: @param date
     * @param: @return      
     * @return: Date
     */
    public static Date getLastMonthDay(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, -1);
        return calendar.getTime();
    }

    /**
     * 获取上周时间
     * @Title: getLastWeekDay
     * @param: @param date
     * @param: @return      
     * @return: Date
     */
    public static Date getLastWeekDay(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.WEEK_OF_YEAR, -1);
        return calendar.getTime();
    }

    /**
     * 获取年份
     * @Title: getYear
     * @param: @param date
     * @param: @return      
     * @return: Integer
     */
    public static Integer getYear(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.YEAR);
    }

    /**
     * 当月第几天
     * @Title: getDayOfMonth
     * @param: @param date
     * @param: @return      
     * @return: Integer
     */
    public static Integer getDayOfMonth(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取当年第几周
     * @Title: getWeekOfYear
     * @param: @param date
     * @param: @return      
     * @return: Integer
     */
    public static Integer getWeekOfYear(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * 获取月数
     * @Title: getMonth
     * @param: @param date
     * @param: @return      
     * @return: Integer
     */
    public static Integer getMonth(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.MONTH) + 1;
    }

    /**
     * 获取当周最后一天（周六）
     * @Title: getLastDayOfWeek
     * @param: @param date
     * @param: @return      
     * @return: Date
     */
    public static Date getLastDayOfWeek(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_WEEK, cal.getMaximum(Calendar.DAY_OF_WEEK));
        return cal.getTime();
    }

    /**
     * 获取当周第一天（周日）
     * @Title: getFirstDayOfWeek
     * @param: @param date
     * @param: @return      
     * @return: Date
     */
    public static Date getFirstDayOfWeek(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_WEEK, cal.getMinimum(Calendar.DAY_OF_WEEK));
        return cal.getTime();
    }

    /**
     * 得到某月的最后一天 
     * @Title: getLastDayOfMonth
     * @param: @param date
     * @param: @return      
     * @return: Date
     */
    public static Date getLastDayOfMonth(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, cal.getMaximum(Calendar.DAY_OF_MONTH));
        return cal.getTime();
    }

    /**
     * 获取当月第一天
     * @Title: getFirstDayOfMonth
     * @param: @param date
     * @param: @return      
     * @return: Date
     */
    public static Date getFirstDayOfMonth(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, cal.getMinimum(Calendar.DAY_OF_MONTH));
        return cal.getTime();
    }

    /**
     * 获取当年第一天
     * @Title: getFirstDayOfYear
     * @param: @param date
     * @param: @return      
     * @return: Date
     */
    public static Date getFirstDayOfYear(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_YEAR, 1);
        return cal.getTime();
    }

    /**
     * 获取一年中所有周一到周五
     * @param year
     * @return list
     */
    public static List<String> getYearMonToFri(int year){
        List<String> dateList=new ArrayList<String>();
        SimpleDateFormat simdf = new SimpleDateFormat("MM-dd");
        Calendar calendar = new GregorianCalendar(year, 0, 1);
        int i = 1;
        while (calendar.get(Calendar.YEAR) < year + 1) {
            calendar.set(Calendar.WEEK_OF_YEAR, i++);
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
            if (calendar.get(Calendar.YEAR) == year) {
                dateList.add(simdf.format(calendar.getTime()));
            }
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
            if (calendar.get(Calendar.YEAR) == year) {
                dateList.add(simdf.format(calendar.getTime()));
            }
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
            if (calendar.get(Calendar.YEAR) == year) {
                dateList.add(simdf.format(calendar.getTime()));
            }
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
            if (calendar.get(Calendar.YEAR) == year) {
                dateList.add(simdf.format(calendar.getTime()));
            }
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
            if (calendar.get(Calendar.YEAR) == year) {
                dateList.add(simdf.format(calendar.getTime()));
            }
        }
        return dateList;
    }

    public static String getDateyyyyMMdd(Date date) {
        if (date == null){
            return "";
        }
        return DateFormatUtils.format(date, "yyyy-MM-dd");
    }

    public static String getDateTimeHHmmss(Date date) {
        if (date == null){
            return "";
        }
        return DateFormatUtils.format(date, "HH:mm:ss");
    }

    public static String getDateyyyyMMddHHmmss(Date date) {
        if (date == null){
            return "";
        }
        return DateFormatUtils.format(date, "yyyy-MM-dd HH:mm:ss");
    }

    public static String getDateOnlyyyyyMMddHHmmss(Date date) {
        if (date == null){
            return "";
        }
        return DateFormatUtils.format(date, "yyyyMMddHHmmss");
    }
    public static String getDateOnlyyyyyMMdd(Date date) {
        if (date == null){
            return "";
        }
        return DateFormatUtils.format(date, "yyyyMMdd");
    }

    /**
     * 根据日期差计算
     * @param dateDifference
     * @return
     */
    public static Date getDateByDateDifference(Integer dateDifference){
        if (dateDifference == null || dateDifference == 0){
            return new Date();
        }

        Calendar calendar=Calendar.getInstance();
        calendar.setTime(new Date());
        //今天的日期
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        //让日期减去日期差
        calendar.set(Calendar.DAY_OF_MONTH,calendar.get(Calendar.DAY_OF_MONTH)- dateDifference);
        return calendar.getTime();
    }

    /**
     * 根据日期差计算
     * @param date
     * @param dateDifference
     * @return
     */
    public static Date getDateByDateDifference(Date date,Integer dateDifference){
        if (dateDifference == null || dateDifference <= 0){
            return date;
        }

        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        //今天的日期
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        //让日期减去日期差
        calendar.set(Calendar.DAY_OF_MONTH,calendar.get(Calendar.DAY_OF_MONTH)- dateDifference);
        return calendar.getTime();
    }

    /**
     * 给与指定字符串格式日期，返回指定格式日期字符串
     * @param dateStr yyyy-MM-dd
     * @return yyyyMMdd
     */
    public static String formatStringByStringDate(String dateStr){
        if (StringUtils.isBlank(dateStr)) {
            return null;
        }
        String resultDate = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(dateStr);
            resultDate = DateFormatUtils.format(date, "yyyyMMdd");
        } catch (ParseException e) {
            return null;
        }
        return resultDate;
    }

    /**
     * 返回yyyy-MM的时间字符串
     * @param date
     * @return
     */
    public static String formatDate(Date date) {
        if (date == null) {
            return null;
        }
        return DateFormatUtils.format(date, "yyyy-MM");
    }

    /**
     * @Description 传入字符串类型日期，返回格式化后的Date日期
     * @author zw
     * @date 2020/1/6 13:23
     */
    public static Date formatStringDateToDate(String dateStr) {
        if (StringUtils.isBlank(dateStr)) {
            return null;
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            return null;
        }

    }

    /**
     * @Description 传入字符串类型日期，返回格式化后的Date日期
     * @author zw
     * @date 2020/1/6 13:23
     */
    public static Date formatStringToDate(String dateStr) {
        if (StringUtils.isBlank(dateStr)) {
            return null;
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            return null;
        }

    }

    /**
     * @Description 传入字符串类型日期，返回当前日期的月的第一天
     * @author zw
     * @date 2020/1/6 12:00
     * @param dateStr yyyy-MM-dd HH:mm:ss
     */
    public static Date formatStrDateToMonthOneDay(String dateStr) {
        if (StringUtils.isBlank(dateStr)) {
            return null;
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(sdf.parse(dateStr));
            //获取某月最大天数
            int firstDay = calendar.getActualMinimum(Calendar.DAY_OF_MONTH);
            calendar.set(Calendar.DAY_OF_MONTH, firstDay);
            calendar.set(Calendar.HOUR_OF_DAY, 00);
            calendar.set(Calendar.MINUTE, 00);
            calendar.set(Calendar.SECOND, 00);
            return calendar.getTime();
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * @Description 传入字符串类型日期，返回当前日期的上一个月的第一天字符串Date
     * @author zw
     * @date 2020/1/6 12:00
     * @param dateStr yyyy-MM-dd
     */
    public static String formatStrDateToLastMonthOneDay(String dateStr) {
        if (StringUtils.isBlank(dateStr)) {
            return null;
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(sdf.parse(dateStr));
            calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);
            //获取某月最小天数
            int firstDay = calendar.getActualMinimum(Calendar.DAY_OF_MONTH);
            calendar.set(Calendar.DAY_OF_MONTH, firstDay);
            calendar.set(Calendar.HOUR_OF_DAY, 00);
            calendar.set(Calendar.MINUTE, 00);
            calendar.set(Calendar.SECOND, 00);
            return sdf.format(calendar.getTime());
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * @Description 传入字符串类型日期，返回当前日期的上一个月的第一天Date
     * @author zw
     * @date 2020/1/6 12:00
     * @param dateStr yyyy-MM-dd
     */
    public static Date formatStrDateToLastMonthStartDay(String dateStr) {
        if (StringUtils.isBlank(dateStr)) {
            return null;
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(sdf.parse(dateStr));
            calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);
            //获取某月最小天数
            int firstDay = calendar.getActualMinimum(Calendar.DAY_OF_MONTH);
            calendar.set(Calendar.DAY_OF_MONTH, firstDay);
            calendar.set(Calendar.HOUR_OF_DAY, 00);
            calendar.set(Calendar.MINUTE, 00);
            calendar.set(Calendar.SECOND, 00);
            return calendar.getTime();
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * @Description 传入字符串类型日期，返回当前日期的上一个月的最后一天Date
     * @author zw
     * @date 2020/1/6 12:00
     * @param dateStr yyyy-MM-dd
     */
    public static Date formatStrDateToLastMonthEndDay(String dateStr) {
        if (StringUtils.isBlank(dateStr)) {
            return null;
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(sdf.parse(dateStr));
            calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);
            //获取某月最小天数
            int firstDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
            calendar.set(Calendar.DAY_OF_MONTH, firstDay);
            calendar.set(Calendar.HOUR_OF_DAY, 23);
            calendar.set(Calendar.MINUTE, 59);
            calendar.set(Calendar.SECOND, 59);
            return calendar.getTime();
        } catch (ParseException e) {
            return null;
        }
    }
    /**
     * @Description 传入字符串类型日期，返回当前日期年的第一天
     * @author zw
     * @date 2020/1/6 12:00
     * @param dateStr yyyy-MM-dd
     */
    public static Date formatStrDateToYearFirstDay(String dateStr) {
        if (StringUtils.isBlank(dateStr)) {
            return null;
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(sdf.parse(dateStr));
            int last = calendar.getActualMinimum(Calendar.DAY_OF_YEAR);
            calendar.set(Calendar.DAY_OF_YEAR, last);
            calendar.set(Calendar.HOUR_OF_DAY, 00);
            calendar.set(Calendar.MINUTE, 00);
            calendar.set(Calendar.SECOND, 00);
            return calendar.getTime();
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * @Description 传入字符串类型日期转换日期类型
     * 使用规则：先查看传入的字符串日期月份是否为1月，
     *          如果是1月则年份减一，返回传入日期的上一年的第一天。
     *          如果月份不为1月，则返回传入日期年份的第一天。
     * 使用示例：例1： 传入2020-01-01  返回 2019-01-01
     *          例2： 传入2020-04-21  返回 2020-01-01
     * @author zw
     * @date 2020/1/6 12:00
     * @param dateStr yyyy-MM-dd
     */
    public static Date formatStrDateToYearFirstDayByMonth(String dateStr) {
        if (StringUtils.isBlank(dateStr)) {
            return null;
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(sdf.parse(dateStr));
            // 获取月份
            int month = calendar.get(Calendar.MONTH) + 1;
            if (month <= 1) {
                calendar.add(Calendar.YEAR, -1);
            }
            int last = calendar.getActualMinimum(Calendar.DAY_OF_YEAR);
            calendar.set(Calendar.DAY_OF_YEAR, last);
            calendar.set(Calendar.HOUR_OF_DAY, 00);
            calendar.set(Calendar.MINUTE, 00);
            calendar.set(Calendar.SECOND, 00);
            return calendar.getTime();
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * @Description 传入字符串类型日期，返回当前日期上一年的第一天
     * @author zw
     * @date 2020/1/6 12:00
     * @param dateStr yyyy-MM-dd
     */
    public static Date formatStrDateToLastYearFirstDay(String dateStr) {
        if (StringUtils.isBlank(dateStr)) {
            return null;
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(sdf.parse(dateStr));
            int last = calendar.getActualMinimum(Calendar.DAY_OF_YEAR);
            calendar.add(Calendar.YEAR, -1);
            calendar.set(Calendar.DAY_OF_YEAR, last);
            calendar.set(Calendar.HOUR_OF_DAY, 00);
            calendar.set(Calendar.MINUTE, 00);
            calendar.set(Calendar.SECOND, 00);
            return calendar.getTime();
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * @Description 传入字符串类型日期，返回当前日期的月的最后一天
     * @author zw
     * @date 2020/1/6 12:00
     * @param dateStr yyyy-MM-dd HH:mm:ss
     * @return java.lang.String
     */
    public static Date formatStrDateToMonthLastDay(String dateStr){
        if (StringUtils.isBlank(dateStr)) {
            return null;
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar  = Calendar.getInstance();
            calendar.setTime(sdf.parse(dateStr));
            //获取某月最大天数
            int firstDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
            calendar.set(Calendar.DAY_OF_MONTH, firstDay);
            calendar.set(Calendar.HOUR_OF_DAY, 23);
            calendar.set(Calendar.MINUTE, 59);
            calendar.set(Calendar.SECOND, 59);
            return calendar.getTime();
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * @Description 传入字符串类型日期，返回传入日期的上个月Date
     * @author zw
     * @date 2020/1/6 12:00
     * @param dateStr yyyy-MM-dd HH:mm:ss
     */
    public static Date formatStrBeforeMonthDate(String dateStr) {
        if (StringUtils.isBlank(dateStr)) {
            return null;
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(sdf.parse(dateStr));
            calendar.add(Calendar.MONTH, -1);
            return calendar.getTime();
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * @Description 传入字符串类型日期，返回传入日期的Date
     * @author zw
     * @date 2020/1/6 12:00
     * @param dateStr yyyy-MM-dd
     */
    public static Date strDateFormatDate(String dateStr) {
        if (StringUtils.isBlank(dateStr)) {
            return null;
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(sdf.parse(dateStr));
            return calendar.getTime();
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * @Description 传入字符串类型日期，返回传入日期的上个月的上个月Date
     * @author zw
     * @date 2020/1/6 12:00
     * @param dateStr yyyy-MM-dd HH:mm:ss
     */
    public static Date formatStrMonthBeforeLastDate(String dateStr) {
        if (StringUtils.isBlank(dateStr)) {
            return null;
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(sdf.parse(dateStr));
            calendar.add(Calendar.MONTH, -2);
            return calendar.getTime();
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * @Description 传入字符串类型日期，返回传入日期的上一年上个月Date
     * @author zw
     * @date 2020/1/6 12:00
     * @param dateStr yyyy-MM-dd HH:mm:ss
     */
    public static Date formatStrBeforeYearMonthDate(String dateStr) {
        if (StringUtils.isBlank(dateStr)) {
            return null;
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(sdf.parse(dateStr));
            calendar.add(Calendar.MONTH, -13);
            return calendar.getTime();
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * @Description 传入Date，返回格式化后的String类型日期
     * @Param dateFormatType 选择格式化类型
     *      1：yyyy/MM/dd
     *      2：yyyy/MM/dd HH:mm
     *      3：HH:mm
     * @author zw
     * @date 2020/1/6 13:23
     */
    public static String formatDateByDateType(Date date, Integer dateType) {
        if (null == date) {
            return null;
        }
        SimpleDateFormat sdf = null;
        if (1 == dateType) {
            sdf = new SimpleDateFormat("yyyy/MM/dd");
        } else if (2 == dateType) {
            sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        } else if (3 == dateType) {
            sdf = new SimpleDateFormat("HH:mm");
        }
        return sdf.format(date);
    }

    /**
     * @Description 获取当前时间N天前的时间
     * @param n
     * @return N天前的时间
     */
    public static Date getNDaysAgo(Integer n) {
    	Calendar calendar = Calendar.getInstance();
    	calendar.add(Calendar.DATE, -n);
    	Date time = calendar.getTime();
    	return time;
    }

    /**
     * @Description 将字符串类型日期进行格式化
     * @Param yyyyMMdd
     * @return yyyy-MM-dd
     */
    public static String yyyyMMddDateFormat(String dateStr) {
        if (StringUtils.isBlank(dateStr) || dateStr.length() != 8) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(dateStr.substring(0,4)).append("-").append(dateStr.substring(4,6)).append("-").append(dateStr.substring(6,8));
        return sb.toString();
    }

    /**
     * @Description 将季度进行格式化
     * @Param quarterStr 季度分值
     */
    public static String quarterDateFormat(String quarterStr) {
        if (StringUtils.isBlank(quarterStr)) {
            return "";
        }
        Integer num = Integer.valueOf(quarterStr);
        if (1 == num) {
            return "第一季度";
        } else if (2 == num) {
            return "第二季度";
        } else if (3 == num) {
            return "第三季度";
        } else if (4 == num) {
            return "第四季度";
        }
        return "";
    }

    /**
     * 获取昨日的日期
     * @return 昨日日期
     */
    public static String getYesterdayDate() {
       DateFormat dateFormat=new SimpleDateFormat("yyyyMMdd");
       Calendar calendar=Calendar.getInstance();
       calendar.set(Calendar.HOUR_OF_DAY,-24);
       String yesterdayDate=dateFormat.format(calendar.getTime());
       return yesterdayDate;
    }

    /**
     * 获取T-30日~T-1日日期集合
     * @return T-30日~T-1日日期集合
     */
    public static List<String> getYesterdayTo30dayDate() {
        int endDate = 30;
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Calendar calendar = Calendar.getInstance();
        List<String> dateList = new ArrayList<>();
        for (int i = 0; i < endDate; i++) {
            calendar.set(Calendar.HOUR_OF_DAY,-24);
            String yesterdayDate = dateFormat.format(calendar.getTime());
            dateList.add(yesterdayDate);
        }
        //进行逆序
        Collections.reverse(dateList);
        return dateList;
    }

    /**
     * 获取T-30日~T-1日日期集合
     * 格式化
     * @return T-30日~T-1日日期集合
     */
    public static List<String> getYesterdayTo30dayDateFormat() {
        int endDate = 30;
        DateFormat dateFormat = new SimpleDateFormat("MMdd");
        Calendar calendar = Calendar.getInstance();
        List<String> dateList = new ArrayList<>();
        for (int i = 0; i < endDate; i++) {
            calendar.set(Calendar.HOUR_OF_DAY,-24);
            String yesterdayDate = dateFormat.format(calendar.getTime());
            dateList.add(yesterdayDate);
        }
        //进行逆序
        Collections.reverse(dateList);
        return dateList;
    }

    /**
     * @Description 传入字符串类型日期，返回传入日期的上个月的上个月Date
     * @author zw
     * @date 2020/1/6 12:00
     */
    public static String formatStrBeforeMonthDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        return dateFormat.format(calendar.getTime());
    }

    /**
     * @Description 传入字符串类型日期，返回传入日期的上个月的上个月Date
     * @author niuxd
     * @date 2020/1/6 12:00
     */
    public static String formatStrMonthBeforeLastDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -2);
        return dateFormat.format(calendar.getTime());
    }

    /**
     * @Description 上月最后一天日期
     * @return 上月最后一天日期
     */
    public static Date lastMonthEndDate() {
        Calendar calendar = Calendar.getInstance();
        //指定日期月份减去一
        calendar.add(Calendar.MONTH, -1);
        //指定日期月份减去一后的 最大天数
        calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        //获取最终的时间
        Date time = calendar.getTime();
        return time;
    }

    /**
     * @Description 上月第一天日期
     * @return 上月第一天日期
     */
    public static Date lastMonthStartDate() {
        Calendar calendar = Calendar.getInstance();
        //指定日期月份减去一
        calendar.add(Calendar.MONTH, -1);
        //指定日期月份减去一后的 最大天数
        calendar.set(Calendar.DATE, calendar.getActualMinimum(Calendar.DATE));
        calendar.set(Calendar.HOUR_OF_DAY, 00);
        calendar.set(Calendar.MINUTE, 00);
        calendar.set(Calendar.SECOND, 00);
        //获取最终的时间
        Date time = calendar.getTime();
        return time;
    }

    /**
     * 获得指定日期下一天
     * @param specifiedDay
     * @return
     */
    public static String getSpecifiedDayAfter(String specifiedDay) {
        Calendar c = Calendar.getInstance();
        Date date = null;
        String dayAfter = null;
        try {
            date = new SimpleDateFormat("yyyyMMdd").parse(specifiedDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day + 1);

        dayAfter = new SimpleDateFormat("yyyyMMdd").format(c.getTime());
        return dayAfter;
    }
}
