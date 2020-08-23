package service;

import utilities.Configuration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Validator {

    public Validator(){};

    public  boolean validateString(String s){
        if(s == null) return false;
        return s.length() > 0;
    }

    public boolean validateDate(String date){
        try{
            Date d =  new SimpleDateFormat("yyyy-MM-dd").parse(date);


            return !d.before(Configuration.startOfAcademicYear()) && !d.after(Configuration.EndOfAcademicYear());

        } catch (Exception e){
            return  false;
        }
    }

    public boolean validateNumber(String numb) {
        if (numb == null) {
            return false;
        }
        try {
           int i = Integer.parseInt(numb);
           return true;

        } catch (NumberFormatException e) {
            return false;
        }
    }


    public boolean isInRange(int n, int min , int max) {
        return n >= min && n <= max;
    }


    public Date convertStringToDate(String d) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd").parse(d);
    }

    public boolean isInRange(Date d, Date start, Date end) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(end);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        end = cal.getTime();

        if(d.after(start) && d.before(end))
             return true;


        Calendar cal2 = Calendar.getInstance();

        cal.setTime(start);
        cal2.setTime(d);

        return cal.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR) && cal.get(Calendar.YEAR) == cal2.get(Calendar.YEAR);


    }


    public boolean isAMail(String email) {
        if(!validateString(email)) return false;

        return email.contains("@") && email.contains(".");
    }
}


