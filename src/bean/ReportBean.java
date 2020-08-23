package bean;

import model.RegisterRecord;
import model.ReportRecord;

import java.util.List;

public class ReportBean {

    private List<ReportRecord> reportList;
    private List<RegisterRecord> allGrades;




    public ReportBean() { }

    public List<RegisterRecord> getAllGrades() {
        return allGrades;
    }

    public void setAllGrades(List<RegisterRecord> allGrades) {
        this.allGrades = allGrades;
    }

    public List<ReportRecord> getReportList() {
        return reportList;
    }

    public void setReportList(List<ReportRecord> reportList) {
        this.reportList = reportList;
    }
}
