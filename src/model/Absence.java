package model;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Absence implements RegisterRecord{

    private String value;
    private String id;
    private String studentId;
    private Date date;
    private boolean justified;


    public Absence(String id,String value,String studentId ,Date d, boolean justified) {
        this.value = value;
        this.id = id;
        this.date = d;
        this.justified = justified;
        this.studentId = studentId;
    }


    public void setValue(String value) {
        this.value = value;
    }

    public String getId() {
        return id;
    }



    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isJustified() {
        return justified;
    }

    public void setJustified(boolean justified) {
        this.justified = justified;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
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
    public  void setId( String id){
        this.id = id;
    }


    @Override
    public String getValue() {
        if(this.value.equals("absence"))
            return "A";
        else
            return "R";
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

        return this.value;
    }

    @Override
    public Boolean isInRange(Date start, Date end) {
        return this.date.after(start) && this.date.before(end);
    }

    @Override
    public String toString() {
        return this.getType() + " in data: " + this.getDate();
    }
}
