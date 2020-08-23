package utilities;

import java.util.Calendar;
import java.util.Date;

public abstract class Configuration {


    public static Date startOfAcademicYear(){

        Calendar cal = Calendar.getInstance();
        cal.set(2019,Calendar.SEPTEMBER,1);
        return cal.getTime();
    }

    public static Date EndOfAcademicYear(){

        Calendar cal = Calendar.getInstance();
        cal.set(2020,Calendar.SEPTEMBER,31);
        return cal.getTime();
    }


}
