package model;

public class ScheduleForTableViewProf {
    private String matter;
    private String day;
    private String hour;
    private String classe;

    public ScheduleForTableViewProf(String matter , String classe , int day , int hour){
        this.matter = matter + " " + classe;
        if(day == 0) this.day = "LUNEDI";
        else if(day == 1) this.day = "MARTEDI";
        else if(day == 2) this.day = "MERCOLEDI";
        else if(day == 3) this.day = "GIOVEDI";
        else if(day == 4) this.day = "VENERDI";
        else if(day == 5) this.day = "SABATO";
        else if(day == 6) this.day = "DOMENICA";
        this.hour = hour+":00";
    }

    public String getDay() {
        return day;
    }

    public String getHour() {
        return hour;
    }

    public String getMatter() {
        return matter;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public void setMatter(String matter) {
        this.matter = matter;
    }
}
