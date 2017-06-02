package com.czwm.util;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 */
public class DateUtils {

    private static final Logger logger = LoggerFactory.getLogger(DateUtils.class);

    private static final SimpleDateFormat YYYY_MM_DD_HHMMSS = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm:ss");

    private static final SimpleDateFormat YYYY_MM_DD = new SimpleDateFormat("yyyy-MM-dd");

    private static final SimpleDateFormat HHMM = new SimpleDateFormat("HH:mm");

    private static final SimpleDateFormat MMDD = new SimpleDateFormat("MM月dd日");

    private static final SimpleDateFormat YYYYMMDD = new SimpleDateFormat("yyyyMMdd");

    private static final SimpleDateFormat YYYY = new SimpleDateFormat("yyyy");

    private static final SimpleDateFormat MM = new SimpleDateFormat("MM");

    private static final SimpleDateFormat DD = new SimpleDateFormat("dd");

    private static final SimpleDateFormat YYYYMMDDHHMMSS = new SimpleDateFormat("yyyyMMddHHmmss");

    private static final SimpleDateFormat YYYYMMDDHHMMSS_SSS = new SimpleDateFormat(
            "yyyyMMddHHmmssSSS");

    private static final SimpleDateFormat YYYY_MM_DD_HH_MM_SS_SSS = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm:ss.SSS");

    private static final SimpleDateFormat YYYY_MM_DD_T_HH_MM = new SimpleDateFormat(
            "yyyy-MM-dd'T'HH:mm");
    /**
     * 1秒钟的毫秒数
     */
    public static final long MILLIS_PER_SECOND = 1000;

    /**
     * 1分钟的毫秒数
     */
    public static final long MILLIS_PER_MINUTE = 60 * MILLIS_PER_SECOND;

    /**
     * 1小时的毫秒数
     */
    public static final long MILLIS_PER_HOUR = 60 * MILLIS_PER_MINUTE;

    /**
     * 1天的毫秒数
     */
    public static final long MILLIS_PER_DAY = 24 * MILLIS_PER_HOUR;

    /**
     * 获取当前月的起始时间，如：2012-09-01 00:00:00.000
     *
     * @return 当前月的起始时间
     */
    public static Date getStartOfMonth() {
        return getStartOfMonth(0);
    }

    /**
     * 获取当前月距amount个月的起始时间，如：2012-09月前一个月（amount = -1）的起始日期：2012-08-01 00:00:00.000
     *
     * @param amount 间隔月份
     * @return 当前月之前amount个月的起始时间
     */
    public static Date getStartOfMonth(int amount) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, amount);
        cal.set(Calendar.HOUR_OF_DAY, cal.getMinimum(Calendar.HOUR_OF_DAY));
        cal.set(Calendar.MINUTE, cal.getMinimum(Calendar.MINUTE));
        cal.set(Calendar.SECOND, cal.getMinimum(Calendar.SECOND));
        cal.set(Calendar.MILLISECOND, cal.getMinimum(Calendar.MILLISECOND));
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

    /**
     * 获取当前月的结束时间，如：2012-09-30 23:59:59.999
     *
     * @return 当前月的结束时间
     */
    public static Date getEndOfMonth() {
        return getEndOfMonth(0);
    }

    /**
     * 获取距当前月amount个月的结束时间，如：2012-09月前一个月（amount = 1）的起始日期：2012-08-31 23:59:59.999
     *
     * @param amount 间隔月份
     * @return 距当前月amount个月的结束时间
     */
    public static Date getEndOfMonth(int amount) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, amount + 1);
        cal.set(Calendar.HOUR_OF_DAY, cal.getMaximum(Calendar.HOUR_OF_DAY));
        cal.set(Calendar.MINUTE, cal.getMaximum(Calendar.MINUTE));
        cal.set(Calendar.SECOND, cal.getMaximum(Calendar.SECOND));
        cal.set(Calendar.MILLISECOND, cal.getMaximum(Calendar.MILLISECOND));
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.add(Calendar.DAY_OF_MONTH, -1);
        return cal.getTime();
    }

    /**
     * 时间字符串转化为日期类型，格式为yyyy-MM-dd HH:mm:ss
     *
     * @param dateTime 时间字符串，格式为yyyy-MM-dd HH:mm:ss
     * @return Date
     */
    public static Date parseDateTime(String dateTime) {
        try {
            return YYYY_MM_DD_HHMMSS.parse(dateTime);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 时间字符串转化为日期类型，格式为yyyy-MM-dd
     *
     * @param date 时间字符串，格式为yyyy-MM-dd
     * @return Date
     */
    public static Date parseDate(String date) {
        try {
            return YYYY_MM_DD.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 时间字符串转化为日期类型，格式为HH:mm
     *
     * @param date 时间字符串，格式为HH:mm
     * @return Date
     */
    public static Date parseTime(String date) {
        try {
            return HHMM.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 格式化日期类型为字符串，格式为yyyy-MM-dd HH:mm:ss
     *
     * @param dateTime 日期类型
     * @return 时间字符串，格式为yyyy-MM-dd HH:mm:ss
     */
    public static String formatDateTime(Date dateTime) {
        if (dateTime == null) {
            return null;
        }
        return YYYY_MM_DD_HHMMSS.format(dateTime);
    }

    /**
     * 格式化日期类型为字符串，格式为yyyy-MM-dd
     *
     * @param date 日期类型
     * @return 时间字符串，格式为yyyy-MM-dd
     */
    public static String formatDate(Date date) {
        if (date == null) {
            return null;
        }
        return YYYY_MM_DD.format(date);
    }

    public static String formatDateYear(Date date) {
        if (date == null) {
            return null;
        }
        return YYYY.format(date);
    }

    public static String formatDateMonth(Date date) {
        if (date == null) {
            return null;
        }
        return MM.format(date);
    }

    public static String formatDateDay(Date date) {
        if (date == null) {
            return null;
        }
        return DD.format(date);
    }

    /**
     * Description: 格式化日期类型为字符串，格式为MM月dd日<br>
     *
     * @param date
     * @return <br>
     * @author fanxiang<br>
     * @taskId <br>
     */
    public static String formatDateChinese(Date date) {
        if (date == null) {
            return null;
        }
        return MMDD.format(date);
    }

    /**
     * 格式化日期类型为字符串，格式为yyyyMMdd
     *
     * @param date 日期类型
     * @return 时间字符串，格式为yyyyMMdd
     */
    public static String formatDate2YYYYMMDD(Date date) {
        if (date == null) {
            return null;
        }
        return YYYYMMDD.format(date);
    }

    /**
     * 格式化日期类型为字符串，格式为YYYYMMDDHHMMSS
     *
     * @param date 日期类型
     * @return 时间字符串，格式为YYYYMMDDHHMMSS
     */
    public static String formatDate2YYYYMMDDHHMMSS(Date date) {
        if (date == null) {
            return null;
        }
        return YYYYMMDDHHMMSS.format(date);
    }

    /**
     * 格式化日期类型为字符串，格式为yyyyMMddHHmmssSSS
     *
     * @param date 日期类型
     * @return 时间字符串，格式为yyyyMMddHHmmssSSS
     */
    public static String formatDate2YYYYMMDDHHMMSS_SSS(Date date) {
        if (date == null) {
            return null;
        }
        return YYYYMMDDHHMMSS_SSS.format(date);
    }

    /**
     * 格式化日期类型为字符串，格式为yyyy-MM-dd HH:mm:ss.SSS
     *
     * @param date 日期类型
     * @return 时间字符串，格式为yyyy-MM-dd HH:mm:ss.SSS
     */
    public static String formatDate2YYYY_MM_DD_HH_MM_SS_SSS(Date date) {
        if (date == null) {
            return null;
        }
        return YYYY_MM_DD_HH_MM_SS_SSS.format(date);
    }

    /**
     * 格式化日期类型为字符串，格式为yyyy-MM-dd HH:mm:ss.SSS
     *
     * @param date 日期类型
     * @return 时间字符串，格式为yyyy-MM-dd HH:mm:ss.SSS
     */
    public static String formatDate2YYYY_MM_DD_T_HH_MM(Date date) {
        if (date == null) {
            return null;
        }
        return YYYY_MM_DD_T_HH_MM.format(date);
    }

    /**
     * @return 当前时间
     */
    public static Date getCurrentTime() {
        return Calendar.getInstance().getTime();
    }

    /**
     * @return 当前时间的毫秒数
     */
    public static Long getCurrentTimeMis() {
        return Calendar.getInstance().getTimeInMillis();
    }

    /**
     * @param dayAmount
     * @return
     */
    public static Date afterNowOfDay(int dayAmount) {
        return addDays(Calendar.getInstance().getTime(), dayAmount);
    }

    /**
     * 获取两个日期之间的天数
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static Long getBetweenDays(Date startDate, Date endDate) {
        if (startDate == null || endDate == null) {
            return null;
        }
        Long day = (endDate.getTime() - startDate.getTime()) / (24 * 60 * 60 * 1000);
        return day;
    }

    // -----------------------------------------------------------------------

    /**
     * <p>
     * Checks if two date objects are on the same day ignoring time.
     * </p>
     * <p>
     * 28 Mar 2002 13:45 and 28 Mar 2002 06:01 would return true. 28 Mar 2002 13:45 and 12 Mar 2002 13:45 would return false.
     * </p>
     *
     * @param date1 the first date, not altered, not null
     * @param date2 the second date, not altered, not null
     * @return true if they represent the same day
     * @throws IllegalArgumentException if either date is <code>null</code>
     * @since 2.1
     */
    public static boolean isSameDay(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        return isSameDay(cal1, cal2);
    }

    /**
     * <p>
     * Checks if two calendar objects are on the same day ignoring time.
     * </p>
     * <p>
     * 28 Mar 2002 13:45 and 28 Mar 2002 06:01 would return true. 28 Mar 2002 13:45 and 12 Mar 2002 13:45 would return false.
     * </p>
     *
     * @param cal1 the first calendar, not altered, not null
     * @param cal2 the second calendar, not altered, not null
     * @return true if they represent the same day
     * @throws IllegalArgumentException if either calendar is <code>null</code>
     * @since 2.1
     */
    public static boolean isSameDay(Calendar cal1, Calendar cal2) {
        if (cal1 == null || cal2 == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        return (cal1.get(Calendar.ERA) == cal2.get(Calendar.ERA) && cal1.get(Calendar.YEAR) == cal2
                .get(Calendar.YEAR) && cal1
                .get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR));
    }

    /**
     * Adds a number of months to a date returning a new object. The original date object is unchanged.
     *
     * @param date   the date, not null
     * @param amount the amount to add, may be negative
     * @return the new date object with the amount added
     * @throws IllegalArgumentException if the date is null
     */
    public static Date addMonths(Date date, int amount) {
        return add(date, Calendar.MONTH, amount);
    }

    /**
     * Adds a number of days to a date returning a new object. The original date object is unchanged.
     *
     * @param date   the date, not null
     * @param amount the amount to add, may be negative
     * @return the new date object with the amount added
     * @throws IllegalArgumentException if the date is null
     */
    public static Date addDays(Date date, int amount) {
        return add(date, Calendar.DAY_OF_MONTH, amount);
    }

    /**
     * Adds to a date returning a new object. The original date object is unchanged.
     *
     * @param date          the date, not null
     * @param calendarField the calendar field to add to
     * @param amount        the amount to add, may be negative
     * @return the new date object with the amount added
     * @throws IllegalArgumentException if the date is null
     */
    public static Date add(Date date, int calendarField, int amount) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(calendarField, amount);
        return c.getTime();
    }

    public static String now() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.format(Calendar.getInstance().getTime());
    }

    // ---------------------------------------------------------------------------------------------------

    /**
     * 加减指定的日期的年份。
     *
     * @param date   --指定的日期
     * @param amount --数量可以为负数
     * @return 计算后的结果
     */
    public static Date addYears(Date date, int amount) {
        return add(date, Calendar.YEAR, amount);
    }

    // ---------------------------------------------------------------------------------------------------

    /**
     * 加减指定的日期的小时数
     *
     * @param date   --指定的日期
     * @param amount --加减数量
     * @return 计算后的结果
     */
    public static Date addHours(Date date, int amount) {
        return add(date, Calendar.HOUR_OF_DAY, amount);
    }

    // ---------------------------------------------------------------------------------------------------

    /**
     * 加减指定的日期的分钟数
     *
     * @param date   --指定的日期
     * @param amount --加减数量
     * @return 计算后的结果
     */
    public static Date addMinutes(Date date, int amount) {
        return add(date, Calendar.MINUTE, amount);
    }

    // ---------------------------------------------------------------------------------------------------

    /**
     * 加减指定的日期的秒数
     *
     * @param date   --指定的日期
     * @param amount --加减数量
     * @return 计算后的结果
     */
    public static Date addSeconds(Date date, int amount) {
        return add(date, Calendar.SECOND, amount);
    }

    // ---------------------------------------------------------------------------------------------------

    /**
     * 加减指定的日期的毫秒数
     *
     * @param date   --指定的日期
     * @param amount --加减数量
     * @return 计算后的结果
     */
    public static Date addMilliseconds(Date date, int amount) {
        return add(date, Calendar.MILLISECOND, amount);
    }

    // ---------------------------------------------------------------------------------------------------

    /**
     * 设置指定日期重新的年份
     *
     * @param date   --指定的日期
     * @param amount --年份
     * @return 设置后的日期
     */
    public static Date setYears(Date date, int amount) {
        return set(date, Calendar.YEAR, amount);
    }

    // ---------------------------------------------------------------------------------------------------

    /**
     * 设置指定日期的月份
     *
     * @param date   --指定的日期
     * @param amount --月份
     * @return 设置后的日期
     */
    public static Date setMonths(Date date, int amount) {
        return set(date, Calendar.MONTH, amount);
    }

    // ---------------------------------------------------------------------------------------------------

    /**
     * 设置指定日期的天数
     *
     * @param date   --指定的日期
     * @param amount --天数
     * @return 设置后的日期
     */
    public static Date setDays(Date date, int amount) {
        return set(date, Calendar.DAY_OF_MONTH, amount);
    }

    // ---------------------------------------------------------------------------------------------------

    /**
     * 设置指定日期的小时
     *
     * @param date   --指定日期
     * @param amount --小时数
     * @return 设置后的日期
     */
    public static Date setHours(Date date, int amount) {
        return set(date, Calendar.HOUR_OF_DAY, amount);
    }

    // ---------------------------------------------------------------------------------------------------

    /**
     * 设置指定日期的分钟数
     *
     * @param date   --指定日期
     * @param amount --分钟数
     * @return 设置后的日期
     */
    public static Date setMinutes(Date date, int amount) {
        return set(date, Calendar.MINUTE, amount);
    }

    // ---------------------------------------------------------------------------------------------------

    /**
     * 设置指定日期的秒
     *
     * @param date   --指定日期
     * @param amount --秒
     * @return 设置后的日期
     */
    public static Date setSeconds(Date date, int amount) {
        return set(date, Calendar.SECOND, amount);
    }

    // ---------------------------------------------------------------------------------------------------

    /**
     * 设置指定日期的毫秒
     *
     * @param date   --指定日期
     * @param amount --毫秒
     * @return 设置后的日期
     */
    public static Date setMilliSeconds(Date date, int amount) {
        return set(date, Calendar.MILLISECOND, amount);
    }

    // ---------------------------------------------------------------------------------------------------

    /**
     * 设置指定日期的各域
     *
     * @param date          --指定日期
     * @param calendarFiled --域包括年、月、日、时、分、秒、毫秒
     * @param amount        --数量
     * @return 设置后日期
     */
    public static Date set(Date date, int calendarFiled, int amount) {
        if (null == date) {
            throw new IllegalArgumentException("The date must not be null");
        } else {

        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(calendarFiled, amount);
        return c.getTime();
    }

    // ---------------------------------------------------------------------------------------------------

    /**
     * 把日期转换成日历
     *
     * @param date --日期格式
     * @return 日历格式
     */
    public static Calendar toCalendar(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c;
    }

    // ----------------------------------------------------------------------------------------------------

    /**
     * 两个日期相加
     *
     * @param d1 --日期1
     * @param d2 --日期2
     * @return 相加后的日期
     */
    public static Date addTwo(Date d1, Date d2) {
        if (null == d1 || null == d2) {
            return null;
        } else {

        }
        return new Date(d1.getTime() + d2.getTime());
    }

    // -----------------------------------------------------------------------------------------------------

    /**
     * 计算两个日期之间相差的年，不足一年的被舍去，d1和d2都不能为null
     *
     * @param d1 --日期1
     * @param d2 --日期2
     * @return d1和d2相差的年份
     */
    public static int minusToYear(Date d1, Date d2) {
        if (null == d1 || null == d2) {
            throw new IllegalArgumentException("d1和d2都不能为null");
        } else {

        }
        Calendar cl1 = Calendar.getInstance();
        Calendar cl2 = Calendar.getInstance();
        cl1.setTime(d1);
        cl2.setTime(d2);
        return cl1.get(Calendar.YEAR) - cl2.get(Calendar.YEAR);
    }

    // ----------------------------------------------------------------------------------------------------

    /**
     * 计算两个日期之间的月份，不足一月的被舍去，d1和d2都不能为null
     *
     * @param d1 --日期1
     * @param d2 --日期2
     * @return d1和d2之间相差月份
     */
    public static int minusToMonth(Date d1, Date d2) {

        if (null == d1 || null == d2) {
            throw new IllegalArgumentException("d1和d2都不能为null");
        } else {

        }
        Calendar cl1 = Calendar.getInstance();
        Calendar cl2 = Calendar.getInstance();
        cl1.setTime(d1);
        cl2.setTime(d2);
        return (cl1.get(Calendar.YEAR) - cl2.get(Calendar.YEAR)) * 12 + cl1.get(Calendar.MONTH)
                - cl2.get(Calendar.MONTH);
    }

    // ----------------------------------------------------------------------------------------------------

    /**
     * 计算两个日期之间的天数，不足一天的被舍去，d1和d2都不能为null
     *
     * @param d1 --日期1
     * @param d2 --日期2
     * @return d1和d2之间相差的天数
     */
    public static int minusToDay(Date d1, Date d2) {

        return (int) (minusToMilliSecond(d1, d2) / MILLIS_PER_DAY);
    }

    // ----------------------------------------------------------------------------------------------------

    /**
     * 计算两个日期之间的小时数，不足一小时的被舍去，d1和d2都不能为null
     *
     * @param d1 --日期1
     * @param d2 --日期2
     * @return d1和d2之间相差的小时数
     */
    public static int minusToHours(Date d1, Date d2) {

        return (int) (minusToMilliSecond(d1, d2) / MILLIS_PER_HOUR);
    }

    // ----------------------------------------------------------------------------------------------------

    /**
     * 计算两个日期之间的分钟数不足一分钟的被舍去，d1和d2都不能为null
     *
     * @param d1 --日期1
     * @param d2 --日期2
     * @return d1和d2之间相差的分钟数
     */
    public static long minusToMinutes(Date d1, Date d2) {

        return minusToMilliSecond(d1, d2) / MILLIS_PER_MINUTE;
    }

    // ----------------------------------------------------------------------------------------------------

    /**
     * 计算两个日期之间的秒数不足以秒的被舍去，d1和d2都不能为null
     *
     * @param d1 --日期1
     * @param d2 --日期2
     * @return d1和d2之间相差的秒数
     */
    public static long minusToSeconds(Date d1, Date d2) {

        return minusToMilliSecond(d1, d2) / MILLIS_PER_SECOND;
    }

    // -----------------------------------------------------------------------------------------------------

    /**
     * 计算两个日期之间的毫秒数，d1和d2都不能为null
     *
     * @param d1 --日期1
     * @param d2 --日期2
     * @return d1和d2之间相差的毫秒数
     */
    public static long minusToMilliSecond(Date d1, Date d2) {
        if (null == d1 || null == d2) {
            throw new IllegalArgumentException("d1和d2都不能为null");
        } else {

        }
        return d1.getTime() - d2.getTime();
    }

    /**
     * 将string转换为date 入参格式like：“Wed Mar 19 13:20:02 CST 2014”
     *
     * @param date
     * @return
     */
    public static Date formatDate(String date) {
        if (null == date) {
            return null;
        } else {
            Long longDate = Date.parse(date);
            Date newDate = new Date(longDate - (14 * MILLIS_PER_HOUR));
            return newDate;
        }
    }

    /**
     * 获取下天日期
     *
     * @param specifiedDay
     * @return
     * @throws ParseException
     */
    public static Date getNextDay(Date specifiedDay) throws ParseException {
        Calendar c = Calendar.getInstance();
        c.setTime(specifiedDay);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day + 1);
        String dayAfter = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
        Date nextDay = new SimpleDateFormat("yyyy-MM-dd").parse(dayAfter);
        return nextDay;
    }

    /**
     * 获取上天日期
     *
     * @param specifiedDay
     * @return
     * @throws ParseException
     */
    public static Date getAfterDay(Date specifiedDay) throws ParseException {
        Calendar c = Calendar.getInstance();
        c.setTime(specifiedDay);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day - 1);
        String dayAfter = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
        Date nextDay = new SimpleDateFormat("yyyy-MM-dd").parse(dayAfter);
        return nextDay;
    }

    /**
     * 获取当前时间的n年之后的日期
     *
     * @param nowTime
     * @param n
     * @return
     * @throws ParseException
     */
    public static Date getNextNyear(Date nowTime, int n) throws ParseException {
        Calendar c = Calendar.getInstance();
        c.setTime(nowTime);
        int year = c.get(Calendar.YEAR);
        c.set(Calendar.YEAR, year + n);
        String yearAfter = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
        Date nextNyear = new SimpleDateFormat("yyyy-MM-dd").parse(yearAfter);
        return nextNyear;
    }

    /**
     * 获取下天日期
     *
     * @param specifiedDay
     * @return
     * @throws ParseException
     */
    public static Date getNextNDay(Date specifiedDay, int n) throws ParseException {
        Calendar c = Calendar.getInstance();
        c.setTime(specifiedDay);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day + n);
        String dayAfter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(c.getTime());
        Date nextDay = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dayAfter);
        return nextDay;
    }

    /**
     * 获取指定当天的23:59:59
     *
     * @param date
     * @return
     * @throws ParseException
     */
    public static Date getEndTimeOfDay(Date date) throws ParseException {
        String tmpDate = YYYY_MM_DD.format(date);
        tmpDate = tmpDate + " 23:59:59";
        Date endDate = YYYY_MM_DD_HHMMSS.parse(tmpDate);
        return endDate;
    }

    /**
     * 获取指定当天的00:00:00
     *
     * @param date
     * @return
     * @throws ParseException
     */
    public static Date getStartTimeOfDay(Date date) throws ParseException {
        String tmpDate = YYYY_MM_DD.format(date);
        tmpDate = tmpDate + " 00:00:00";
        Date endDate = YYYY_MM_DD_HHMMSS.parse(tmpDate);
        return endDate;
    }

    /**
     * 判断是否是周末
     *
     * @param date
     * @return
     */
    public static boolean isWeekend(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
                || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断是否是工作时间，早8点至晚6点视为工作时间
     *
     * @param date
     * @return
     */
    public static boolean isWorkTime(Date date) throws ParseException {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        String tmpDate = YYYY_MM_DD.format(date);
        Calendar calBegin = Calendar.getInstance();
        Calendar calEnd = Calendar.getInstance();
        calBegin.setTime(YYYY_MM_DD_HHMMSS.parse(tmpDate + " 08:00:00"));
        calEnd.setTime(YYYY_MM_DD_HHMMSS.parse(tmpDate + " 18:00:00"));
        if (cal.before(calEnd) && cal.after(calBegin)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取昨天日期
     *
     * @param specifiedDay
     * @return
     * @throws ParseException
     */
    public static Date getPrevDay(Date specifiedDay) throws ParseException {
        Calendar c = Calendar.getInstance();
        c.setTime(specifiedDay);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day - 1);
        String dayAfter = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
        Date prevDay = new SimpleDateFormat("yyyy-MM-dd").parse(dayAfter);
        return prevDay;
    }

    /**
     * 将string 格式类型的时间转换时间格式
     *
     * @param paramdate
     * @return
     * @throws Exception
     */
    public static Date getDateFromString(String paramdate) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (StringUtils.isNotEmpty(paramdate)) {
            Date retDate = sdf.parse(paramdate);
            return retDate;
        } else {
            return null;
        }
    }

    /**
     * 传递日期和时间
     *
     * @param paramDate
     * @param paramTime
     * @return
     * @throws Exception
     */
    public static Date getDateFromString(String paramDate, String paramTime) throws Exception {
        StringBuffer tempTime = new StringBuffer();
        if (paramTime.length() < 8) {
            tempTime = new StringBuffer(paramTime).append(":00");
        } else {
            tempTime = new StringBuffer(paramTime);
        }
        String dateTime = new StringBuffer(paramDate).append(" ").append(tempTime).toString();
        Date retDate = parseDateTime(dateTime);
        return retDate;
    }

    /**
     * @param interval second
     * @return
     * @description 将Long型的间隔转换成可以看得懂的时间格式
     * @time 2016年4月9日 下午2:54:49
     * @user tangjun3
     */
    public static String transferInterval(Long interval) {
        if (interval != null) {
            long day = interval / (24 * 60 * 60);
            interval = interval % (24 * 60 * 60);
            long hour = interval / (60 * 60);
            interval = interval % (60 * 60);
            long minute = interval / (60);
            interval = interval % (60);
            long second = interval;
            String formatInterval = "";
            if (day > 0) {
                formatInterval += day + "天";
            }
            if (hour > 0) {
                formatInterval += hour + "小时";
            }
            if (minute > 0) {
                formatInterval += minute + "分钟";
            }
            if (second > 0) {
                formatInterval += second + "秒";
            }
            if (StringUtils.isNotBlank(formatInterval)) {
                return formatInterval;
            } else {
                return "即刻";
            }
        }
        return null;
    }

    /**
     * @param ms 毫秒
     * @return
     * @description 将毫秒转换成天时分秒
     * @author zhoufangjun
     */
    public static String msec2date(Long ms) {
        if (ms != null) {
            int ss = 1000;
            int mi = ss * 60;
            int hh = mi * 60;
            int dd = hh * 24;

            long day = ms / dd;
            long hour = (ms - day * dd) / hh;
            long minute = (ms - day * dd - hour * hh) / mi;
            long second = (ms - day * dd - hour * hh - minute * mi) / ss;

            return day + "天" + hour + "小时" + minute + "分钟" + second + "秒";
        }
        return null;
    }

    public static long convert2long(String date, String format) {
        try {
            if (StringUtils.isNotBlank(date)) {
                if (StringUtils.isBlank(format))
                    format = "yyyy-MM-dd HH:mm:ss";

                SimpleDateFormat sf = new SimpleDateFormat(format);
                return sf.parse(date).getTime();
            }
        } catch (ParseException e) {
            logger.error("ExceptionInfo:{}", JsonUtils.toString(e));
        }
        return 0;
    }

    /**
     * 判断传入的时间是否在当天18点之前
     *
     * @param param
     * @return
     */
    public static Boolean isToDayPmSix(Date param) {

        try {

            Calendar paramCalendar = Calendar.getInstance();
            paramCalendar.setTime(param);

            Calendar current = Calendar.getInstance();

            Calendar yesterday = Calendar.getInstance();    //今天凌晨

            yesterday.set(Calendar.YEAR, current.get(Calendar.YEAR));
            yesterday.set(Calendar.MONTH, current.get(Calendar.MONTH));
            yesterday.set(Calendar.DAY_OF_MONTH, current.get(Calendar.DAY_OF_MONTH));
            yesterday.set(Calendar.HOUR_OF_DAY, 0);
            yesterday.set(Calendar.MINUTE, 0);
            yesterday.set(Calendar.SECOND, 0);

            Calendar toDayPmSix = Calendar.getInstance();    //今天18

            toDayPmSix.set(Calendar.YEAR, current.get(Calendar.YEAR));
            toDayPmSix.set(Calendar.MONTH, current.get(Calendar.MONTH));
            toDayPmSix.set(Calendar.DAY_OF_MONTH, current.get(Calendar.DAY_OF_MONTH));
            //  Calendar.HOUR——12小时制的小时数 Calendar.HOUR_OF_DAY——24小时制的小时数
            toDayPmSix.set(Calendar.HOUR_OF_DAY, 18);
            toDayPmSix.set(Calendar.MINUTE, 0);
            toDayPmSix.set(Calendar.SECOND, 0);

            if (paramCalendar.after(yesterday) && paramCalendar.before(toDayPmSix)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            logger.error("DateUtils isToDayPmSix ex:" + (StringUtils.isEmpty(ex.getMessage()) ?
                    "true" :
                    ex.getMessage()));
            return null;
        }
    }

    /**
     * 判断传入的时间是在昨天18点后，昨天24点前
     *
     * @param param
     * @return
     */
    public static Boolean isYesterdayDayPmSix(Date param) {

        try {

            Calendar paramCalendar = Calendar.getInstance();
            paramCalendar.setTime(param);

            Calendar current = Calendar.getInstance();

            Calendar startTime = Calendar.getInstance();

            startTime.set(Calendar.YEAR, current.get(Calendar.YEAR));
            startTime.set(Calendar.MONTH, current.get(Calendar.MONTH));
            startTime.set(Calendar.DAY_OF_MONTH, current.get(Calendar.DAY_OF_MONTH) - 1);
            startTime.set(Calendar.HOUR_OF_DAY, 18);
            startTime.set(Calendar.MINUTE, 0);
            startTime.set(Calendar.SECOND, 0);

            Calendar endTime = Calendar.getInstance();

            endTime.set(Calendar.YEAR, current.get(Calendar.YEAR));
            endTime.set(Calendar.MONTH, current.get(Calendar.MONTH));
            endTime.set(Calendar.DAY_OF_MONTH, current.get(Calendar.DAY_OF_MONTH));
            //  Calendar.HOUR——12小时制的小时数 Calendar.HOUR_OF_DAY——24小时制的小时数
            endTime.set(Calendar.HOUR_OF_DAY, 24);
            endTime.set(Calendar.MINUTE, 0);
            endTime.set(Calendar.SECOND, 0);

            if (paramCalendar.after(startTime) && paramCalendar.before(endTime)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            logger.error("DateUtils isToDayPmSix ex:" + (StringUtils.isEmpty(ex.getMessage()) ?
                    "true" :
                    ex.getMessage()));
            return null;
        }
    }

    public static int calculateAge(Date birthday) {
        Calendar cal = Calendar.getInstance();

        if (cal.before(birthday)) {
            throw new IllegalArgumentException(
                    "The birthDay is before Now.It's unbelievable!");
        }

        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH) + 1;
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);

        cal.setTime(birthday);
        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH) + 1;
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

        int age = yearNow - yearBirth;

        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                // monthNow==monthBirth
                if (dayOfMonthNow < dayOfMonthBirth) {
                    age--;
                }
            } else {
                // monthNow>monthBirth
                age--;
            }
        }
        return age;
    }

    /**
     * 计算两个日期之间相差的天数
     *
     * @param smdate 较小的时间
     * @param bdate  较大的时间
     * @return 相差天数
     * @throws ParseException
     */
    public static int daysBetween(Date smdate, Date bdate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        smdate = sdf.parse(sdf.format(smdate));
        bdate = sdf.parse(sdf.format(bdate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);

        return Integer.parseInt(String.valueOf(between_days));
    }

    /**
     * 获取当前日期是星期几<br>
     *
     * @param dt
     * @return 当前日期是星期几
     */
    public static String getWeekOfDate(Date dt) {
        String[] weekDays = { "7", "1", "2", "3", "4", "5", "6" };
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }

    /**
     * 将YYYY_MM_DD_T_HH_MM类型的时间转化称Date
     *
     * @param dateStr YYYY_MM_DD_T_HH_MM类型的时间字符串
     * @return 时间
     */
    public static Date formatDateFromYYYY_MM_DD_T_HH_MM(String dateStr) {
        try {
            return YYYY_MM_DD_T_HH_MM.parse(dateStr);
        } catch (Exception e) {
            return null;
        }

    }

}
