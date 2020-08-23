package utilities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class Month {


    private int index;
    private int days;
    private String name;
    private int year;
    private List<Integer> sundays;


     Month(int index, int days, String name, int year) {
        this.index = index;
        this.days = calculateDays(index,year,days);
        this.name = name;
        this.year = year;
        this.sundays = calculateSunday(index,this.days,this.year);
    }

    private int calculateDays(int index,int year,int days) {
        if(index == 2 && year%4 == 0)
            return 29;
        else
             return days;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getDays() {
        return days;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }


    public List<Integer> getSundays() {
        return sundays;
    }


    private List<Integer> calculateSunday(int index,int day, int year) {

        Calendar cal = Calendar.getInstance();
        List<Integer> result = new ArrayList<>();
        cal.set(year,index-1,1);
        for(int i = 1; i <= day; i++){
            if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
                result.add(i-1);
            cal.set(year,index-1,i);
        }
            return result;
    }

    public Date getStartOfMonth(){
         Calendar cal = Calendar.getInstance();
         cal.set(this.year,this.index-1,1);
         return cal.getTime();
    }
    public Date getEndOfMonth(){
        Calendar cal = Calendar.getInstance();
        cal.set(this.year,this.index-1,this.days);
        return cal.getTime();
    }


}
