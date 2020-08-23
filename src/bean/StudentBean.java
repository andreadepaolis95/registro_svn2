package bean;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class StudentBean {

    private String fullName;
    private String course;
    private List<String> matters;
    private String selectedMatter;
    private Date selectedDay;


    public List<String> getMatters() {
        return matters;
    }

    public void setMatters(List<String> matters) {
        this.matters = matters;
    }

    public String getSelectedMatter() {
        return selectedMatter;
    }

    public void setSelectedMatter(String selectedMatter) {
        this.selectedMatter = selectedMatter;
    }

    public Date getSelectedDay() {
        return selectedDay;
    }

    public void setSelectedDay(Date selectedDay) {
        this.selectedDay = selectedDay;
    }


    public String printDate(){
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        cal.setTime(this.selectedDay);
        cal.add(Calendar.DATE,7);

        return sdf.format(this.selectedDay) + " " + "-" + " " + sdf.format(cal.getTime());

    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
