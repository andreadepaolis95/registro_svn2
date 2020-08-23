package model;


import java.util.Date;

public class Argument implements Assignment,Comparable<Argument>{

    private String matter;
    private String text;
    private String course;
    private String title;
    private Date date;
    private String id;

    public Argument(String id, String matter, String text, String course, String title, Date date) {
        this.id = id;
        this.matter = matter;
        this.text = text;
        this.course = course;
        this.title = title;
        this.date = date;
    }

    @Override
    public String getMatter() {
        return matter;
    }

    public void setMatter(String matter) {
        this.matter = matter;
    }

    @Override
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int compareTo(Argument o) {
        return Integer.parseInt(this.id) - Integer.parseInt(o.getId());
    }

}


