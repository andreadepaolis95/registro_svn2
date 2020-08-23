package controller;

import bean.HomeBean;
import bean.StudentBean;

import model.Argument;
import model.Homework;
import service.ArgumentService;
import service.HomeworkService;
import service.StudentService;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class StudentHomeController {

    public HomeBean loadHomeInfo(String course,String matter) throws Exception {

        StudentService service = new StudentService();
        ArgumentService as = new ArgumentService();
        HomeBean hb = new HomeBean();
        Calendar cal = Calendar.getInstance();
        Date start = cal.getTime();
        cal.add(Calendar.DATE,7);
        Date end = cal.getTime();
        hb.setSchedule(service.loadScheduleForCourse(course));
        hb.setHomework(this.scrollHomework(course,start,end));
        hb.setArgument(as.filterForMatterAndCourse(course,matter));
        return hb;
    }


    public List<Homework> scrollHomework(String course, Date start , Date end) throws Exception {

        HomeworkService service = new HomeworkService();
        System.out.println(start);
        System.out.println(end);
        System.out.println("_______");
        if( start.before(end) )
                 return service.filterHomework(course,start,end);
        else
             return service.filterHomework(course,end,start);
    }



    public List<Argument> scrollArg(String course, String matter) throws Exception {

        ArgumentService service = new ArgumentService();
        return service.filterForMatterAndCourse(course,matter);


    }

    public StudentBean loadStudentInfo(String course) throws Exception {

        StudentService service = new StudentService();
        StudentBean sb = new StudentBean();
        sb.setMatters(service.getAllMatter(course));
        if(sb.getMatters().size() == 0) throw new Exception("err");
        sb.setSelectedMatter(sb.getMatters().get(0));
        sb.setSelectedDay(new Date());
        return sb;
    }
}
