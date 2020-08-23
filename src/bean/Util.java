package bean;

import java.util.ArrayList;
import java.util.List;

public class Util {

    private List<Integer> intDays;
    private List<String> days;
    private List<Integer> hours;

    public Util(){
        this.days = this.getFixedDays();
        this.hours = this.getFixedHours();
        this.intDays = this.getFixedIntDays();
    }

    private List<Integer> getFixedIntDays() {
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < 5; i++)
             result.add(i);
        return result;

    }

    public List<Integer> getIntDays() {
        return intDays;
    }

    private List<Integer> getFixedHours() {
        List<Integer> result = new ArrayList<>();
        result.add(9);
        result.add(10);
        result.add(11);
        result.add(12);
        result.add(13);
        return result;
    }


    private List<String> getFixedDays(){
        List<String> result = new ArrayList<>();
        result.add("Lun");
        result.add("Mar");
        result.add("Mer");
        result.add("Gio");
        result.add("Ven");
        return result;
    }

    public List<String> getDays() {
        return days;
    }

    public List<Integer> getHours() {
        return hours;
    }



}
