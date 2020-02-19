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
}