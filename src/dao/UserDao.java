package dao;

import model.Schedule;
import model.User;

import java.util.List;

public interface UserDao {


    public String login(String username,String password) throws Exception;

    public User get(String id) throws Exception;

    public List<Schedule> getSchedule(String param) throws Exception;

}
