package model;

public class Matter {


    private String matter;
    private String course;
    private int index;

    public String getMatter() {
        return matter;
    }

    public Matter(String course, String matter, int index) {
        this.matter = matter;
        this.course = course;
        this.index = index;
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

    public int getIndex() {
        return index;
    }

    public String nameExtended(){
        return this.matter + " " + this.course;
    }
}
