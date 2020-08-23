package controller;

import bean.RegisterBean;
import excep.InputException;
import model.*;
import service.*;
import utilities.Month;
import utilities.MonthFactory;

import java.util.Calendar;

import java.util.List;

public class RegisterController {

    public RegisterController() {}

    public RegisterBean initialize(String course, String matter) throws Exception {

        RegisterBean register = new RegisterBean();
        Calendar cal = Calendar.getInstance();
        MonthFactory mf = new MonthFactory();
        Month m = mf.createMonth(cal.get(Calendar.MONTH)+1,cal.get(Calendar.YEAR));
        register.setMonth(m);


        List<RegisterStudent> list = loadStudentOfClass(course);

        register.setStudents(filterForMonth(list,matter,m));

        return register;
    }

    public List<RegisterStudent> loadStudentOfClass(String course) throws Exception {
        RegisterService rs = new RegisterService();
        return rs.loadStudentOfClass(course);
    }

    public Month changeMonth(Month m, int amount){

        MonthFactory mf = new MonthFactory();
        return mf.createMonth(m.getIndex()+amount,m.getYear());
    }

    public Month getCurrentMont() {
        Calendar cal = Calendar.getInstance();
        MonthFactory mf = new MonthFactory();
        return  mf.createMonth(cal.get(Calendar.MONTH)+1,cal.get(Calendar.YEAR));
    }

    public List<RegisterStudent> filterForMonth(List<RegisterStudent> students, String matter, Month m) throws Exception {
        MarkService markService = new MarkService();
        AbsenceService absenceService = new AbsenceService();
        RegisterService service = new RegisterService();

        for(RegisterStudent student: students) {
            student.setMedia(service.calculateMedia(student.getId(),matter));
            student.setRecord(markService.getAllBetweenDate(student.getId(), matter,m.getStartOfMonth(),m.getEndOfMonth()));
            student.addListRecord(absenceService.getAllBetweenDate(student.getId(),m.getStartOfMonth(),m.getEndOfMonth()));
        }
        return students;
    }

    public Mark newMark(String std, String numb, String d, String type, String matter) throws Exception {

          MarkService service = new MarkService();
          Validator v = new Validator();
        if(!v.validateNumber(std)) throw new InputException("student");
          if(!v.validateNumber(numb)) throw new InputException("value");
          if(!v.validateDate(d)) throw new InputException("date");

          Mark m = new Mark("temp", Integer.parseInt(numb),v.convertStringToDate(d),type,matter,std);

          return service.saveNew(m);

    }


    public Absence newAbsence(String std,String type,String d) throws Exception {

        AbsenceService service = new AbsenceService();
        Validator v = new Validator();
        if(!v.validateNumber(std)) throw new InputException("student");
        if(!v.validateString(type)) throw new InputException("type");
        if(!v.validateDate(d)) throw new InputException("date");
        Absence a = new Absence("temp",type,std,v.convertStringToDate(d),false);

        return service.saveNew(a);

    }

    public double calculateMedia(String id, String matter) throws Exception {
        RegisterService service = new RegisterService();
        return service.calculateMedia(id,matter);

    }

    public void delete(RegisterRecord rr) throws Exception {


        RegisterRecordService service;

        if(rr instanceof  Absence)

            service = new AbsenceService();

        else
            service = new MarkService();

        service.delete(rr);


    }


}
