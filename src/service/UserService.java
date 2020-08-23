package service;

import bean.Page;
import bean.UserBean;
import model.User;

import java.util.List;

public interface UserService {


    public User login(String username,String password) throws Exception;

    List<Page> getPagesList();

    UserBean createBean(User u);
}
