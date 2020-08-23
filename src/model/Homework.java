package model;

import java.util.Date;

public class Homework implements Assignment ,Comparable<Homework>{



    private String matter;
    private String text;
    private String course;
    private Date date;
    private String id;

    public Homework(String id, String matter, String text, String course, Date date) {
        this.matter = matter;
        this.text = text;
        this.course = course;
        this.date = date;
        this.id = id;
    }

    public String getMatter() {
        return matter;
    }

    public void setMatter(String matter) {
        this.matter = matter;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public int compareTo(Homework o) {
        return Integer.parseInt(this.getId()) - Integer.parseInt(o.getId());
    }
}
