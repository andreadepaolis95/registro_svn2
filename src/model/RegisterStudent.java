package model;

import java.util.ArrayList;
import java.util.List;

public class RegisterStudent implements Comparable<RegisterStudent> {

    private String fullname;
    private String id;
    private List<RegisterRecord> record;

    private double media;

    public RegisterStudent(String fullname, String id) {
        this.fullname = fullname;
        this.id = id;
        this.record = new ArrayList<>();
    }


    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<RegisterRecord> getRecord() {
        return record;
    }

    public void setRecord(List<RegisterRecord> record) {
             this.record = record;
    }

    public void addListRecord(List<RegisterRecord> record){
        this.record.addAll(record);
    }

    @Override
    public int compareTo(RegisterStudent r) {
        return this.fullname.compareTo(r.getFullname());
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public String toString(){
        return this.fullname;
    }

}
