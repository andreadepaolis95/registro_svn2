package service;

import dao.Dao;
import model.Argument;
import dao.ArgumentDao;

import java.util.List;

public class ArgumentService {



    public ArgumentService(){};

    public List<Argument> filterForMatterAndCourse(String course, String matter) throws Exception {

        Dao<Argument> dao = new ArgumentDao();
        String[] params = new String[2];
        params[0] = course;
        params[1] = matter;
        return dao.getAll(params);
    }

    public int saveNew(Argument a) throws Exception {

        Dao<Argument> dao = new ArgumentDao();
         return dao.save(a);

    }
    public void delete(Argument a ) throws Exception {

        Dao<Argument> dao = new ArgumentDao();
        dao.delete(a);
    }
}
