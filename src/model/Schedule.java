package model;

public class Schedule {

    private int day;
    private int hour;
    private String matter;
    private String course;

    public Schedule(int day, int hour, String matter, String course) {
        this.day = day;
        this.hour = hour;
        this.matter = matter;
        this.course = course;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public String getMatter() {
        return matter;
    }

    public void setMatter(String matter) {
        this.matter = matter;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}


