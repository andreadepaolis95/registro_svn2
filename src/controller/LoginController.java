package controller;

import bean.UserBean;
import excep.InputException;
import model.User;
import service.ProfessorService;
import service.StudentService;
import service.UserService;
import service.Validator;


public class LoginController {


    public LoginController(){};


    public UserBean handleLogin(String username,String password,boolean isProfessor) throws Exception {

          UserService service;
          Validator v = new Validator();

          if(!v.validateString(username)) throw new InputException("username");
          if(!v.validateString(password)) throw new InputException("password");

          if(!isProfessor)
              service = new StudentService();
          else
              service = new ProfessorService();

          User u = service.login(username,password);

          UserBean ub =  service.createBean(u);
          ub.setPageList(service.getPagesList());
          return  ub;

    }





}
