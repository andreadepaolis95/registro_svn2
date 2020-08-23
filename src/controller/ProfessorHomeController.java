package controller;

import bean.HomeBean;
import bean.ProfessorBean;
import dao.ProfessorDao;
import model.Argument;
import service.AbsenceService;
import service.ArgumentService;
import service.HomeworkService;
import service.ProfessorService;

public class ProfessorHomeController {

    public HomeBean loadPage(String id, String clazz, String matter) throws Exception {

        HomeBean hb = new HomeBean();
        HomeworkService service = new HomeworkService();
        ArgumentService as = new ArgumentService();
        ProfessorDao pd = new ProfessorDao();
        hb.setArgument(as.filterForMatterAndCourse(clazz,matter));
        hb.setSchedule(pd.getSchedule(id));
        hb.setHomework(service.filterForCourseAndMatter(clazz,matter));

        return hb;


    }

    public ProfessorBean loadMatter(String id) throws Exception {

        ProfessorService service = new ProfessorService();
        ProfessorBean pb = new ProfessorBean();
        pb.setMatterList(service.loadAllCourse(id));
        pb.setMatter(pb.getMatterList().get(0));
        return pb;
    }


}
