package controller;

import bean.ReportBean;
import model.RegisterRecord;
import service.MarkService;
import service.StudentReportService;
import utilities.Configuration;

import java.util.List;

public class StudentReportController {


    public StudentReportController(){};

    public ReportBean loadFullReport(String id, List<String> matters) throws Exception {

        ReportBean rb = new ReportBean();
        StudentReportService service = new StudentReportService();
        rb.setReportList(service.loadFullReport(id,matters));
        rb.setAllGrades(this.allGradesForMatter(id,matters.get(0)));
        return rb;
    }


    public List<RegisterRecord> allGradesForMatter(String id,String matter) throws Exception {

        MarkService markService = new MarkService();
        return markService.getAllBetweenDate(id,matter, Configuration.startOfAcademicYear(),Configuration.EndOfAcademicYear());
    }



}
