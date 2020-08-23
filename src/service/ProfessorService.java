package service;

import bean.Page;
import bean.UserBean;
import dao.ProfessorDao;

import excep.ConnectionError;
import excep.NotFoundError;
import model.Matter;
import model.Professor;
import model.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfessorService implements UserService {


    @Override
    public Professor login(String username, String password) throws Exception {
        ProfessorDao dao = new ProfessorDao();
        String id = dao.login(username,password);
        return dao.get(id);

    }

    @Override
    public UserBean createBean(User u) {
        UserBean ub = new UserBean();
        ub.setId(u.getId());
        ub.setFullName(u.getFullName());
        ub.setIsProfessor(true);
        return ub;
    }

    public List<Matter> loadAllCourse(String id) throws ConnectionError, SQLException, NotFoundError {
        ProfessorDao dao = new ProfessorDao();
        return dao.getAllMatter(id);
    }




    public List<Page> getPagesList(){
        List<Page> result = new ArrayList<>();
        result.add(new Page("Home","./ProfessorHomeServlet"));
        result.add(new Page("Register","./ProfessorRegisterServlet"));
        return result;
    }


}
