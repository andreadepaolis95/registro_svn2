package service;

import model.ReportRecord;

import java.util.ArrayList;
import java.util.List;

public class StudentReportService {


    public List<ReportRecord> loadFullReport(String id, List<String> matters) throws Exception {

        List<ReportRecord> result = new ArrayList<>();
        RegisterService rg = new RegisterService();
        for (String m: matters) {
                result.add(new ReportRecord(m,rg.calculateMedia(id,m)));
        }
        return result;
    }
}
