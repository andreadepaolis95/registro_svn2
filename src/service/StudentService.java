package service;
import bean.Page;
import bean.UserBean;
import dao.Dao;
import dao.StudentDao;
import dao.UserDao;
import model.Schedule;
import model.Student;
import model.User;

import java.util.ArrayList;

import java.util.List;

public class StudentService implements UserService {

    @Override
    public User login(String username, String password) throws Exception {

        UserDao dao =  new StudentDao();
        String id = dao.login(username,password);
        return dao.get(id);
    }


    @Override
    public UserBean createBean(User u) {
        UserBean ub = new UserBean();
        ub.setId(u.getId());
        ub.setFullName(u.getFullName());
        ub.setCourse(u.getCourse());
        ub.setIsProfessor(false);
        return ub;
    }


    @Override
    public List<Page> getPagesList(){
        List<Page> result = new ArrayList<>();
        result.add(new Page("Home","./StudentHomeServlet"));
        result.add(new Page("Report","./StudentReportServlet"));
        result.add(new Page("Absence","./StudentAbsenceServlet"));
        return result;
    }

    public List<Schedule> loadScheduleForCourse(String course) throws Exception {

        UserDao dao = new StudentDao();
        return dao.getSchedule(course);
    }


    public List<String> getAllMatter(String course) throws Exception {
        StudentDao dao = new StudentDao();
        return dao.getAllMatter(course);
    }

    public List<Student> getAllStudent(String course) throws Exception {

        Dao<Student> dao = new StudentDao();
        String[] params = new String[1];
        params[0] = course;

        return  dao.getAll(params);
    }
}
