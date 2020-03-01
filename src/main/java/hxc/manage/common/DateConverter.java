package hxc.manage.common;

import org.junit.Test;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sang on 2018/1/13.
 */
public class DateConverter implements Converter<String,Date> {
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    //yyyy-MM-dd转Sun Dec 15 00:00:00 CST 2019
    @Override
    public Date convert(String s) {
        if ("".equals(s) || s == null) {
            return null;
        }
        try {
            return simpleDateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    //时间戳转yyyy-MM-dd
    public String stampToDate(String s){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }

    //Tue Mar 26 00:00:00 CST 2019转时间戳
    public String dateToTimeMillis(String s) {
        Date time =new Date(s);
        return time.getTime()+"";
    }

//2018-08-05T16:00:00.000Z转yyyy-MM-dd
    public String getDateFormat(String s) throws ParseException{
        s = s.replace("Z", " UTC");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");
        Date d = sdf1.parse(s);//Mon Mar 06 00:00:00 CST 2017
        dateToTimeMillis(d.toString());
        return d.getTime()+"";
    }


    //yyyy-MM-dd转时间戳
    public String date1ToTimeMillis(String s) throws ParseException {
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Date d = sdf1.parse(s);
        return d.getTime()+"";
    }
    //判断是不是日期
    public boolean isDate(String date){
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        try {
            sdf1.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }


    }
}


