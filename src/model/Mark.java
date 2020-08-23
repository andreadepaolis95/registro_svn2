package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Mark implements RegisterRecord{

    private String id;
    private int value;
    private Date date;
    private String category;
    private String matter;
    private String studentId;


    public Mark(String id, int value, Date d, String category, String matter, String studentId) {
        this.id = id;
        this.value = value;
        this.date = d;
        this.category = category;
        this.matter = matter;
        this.studentId = studentId;
    }


    @Override
    public String getID() {
        return this.id;
    }

    @Override
    public Date getDate() {
        return date;
    }


    @Override
    public  void setId(String id){
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public String getMatter() {
        return matter;
    }

    @Override
    public String getValue() {
        return String.valueOf(this.value);
    }

    @Override
    public String getDateFormatted() {
        return new SimpleDateFormat("dd-MM-yyyy").format(this.date);
    }

    @Override
    public int getDayAsIndex() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(this.date);
        int res = cal.get(Calendar.DAY_OF_MONTH);
        return res;
    }

    @Override
    public String getType() {

        return this.category;
    }

    @Override
    public Boolean isInRange(Date start, Date end) {
        return this.date.after(start) && this.date.before(end);
    }


    public int getValueAsInt(){
        return this.value;
    }

    public String getStudentId() {
        return studentId;
    }
}
