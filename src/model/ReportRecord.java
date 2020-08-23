package model;

public class ReportRecord {


    public String matter;
    public double media;


    public ReportRecord(String matter,double media) {
        this.matter = matter;
        this.media = media;
    }

    public String getMatter() {
        return matter;
    }

    public double getMedia() {
        return media;
    }
}
