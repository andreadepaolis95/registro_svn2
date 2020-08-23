package bean;

import model.RegisterStudent;
import utilities.Month;

import java.util.List;

public class RegisterBean {


    private Month month;

    private List<RegisterStudent> students;




    public Month getMonth() {
        return month;
    }

    public void setMonth(Month m) {
        this.month = m;
    }


    public List<RegisterStudent> getStudents() {
        return students;
    }

    public void setStudents(List<RegisterStudent> students) {
        this.students = students;
    }
}
