package service;

import dao.Dao;
import dao.HomeworkDao;
import model.Homework;

import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class HomeworkService {



   public List<Homework> filterHomework(String course, Date start , Date end) throws Exception {

       Dao<Homework> dao = new HomeworkDao();
       String[] params = new String[1];
       params[0] = course;
       List<Homework> result = dao.getAll(params);
       Predicate<Homework> byDate = homework -> homework.getDate().before(end) && homework.getDate().after(start) || homework.getDate().equals(start);
       return  result.stream().filter(byDate).collect(Collectors.toList());
   }


   public List<Homework> filterForCourse(String course) throws Exception {

       Dao<Homework> dao = new HomeworkDao();
       String[] params = new String[1];
       params[0] = course;
       List<Homework> result = dao.getAll(params);
       result.sort(Homework::compareTo);
       return result;
   }


    public List<Homework> filterForCourseAndMatter(String course,String matter) throws Exception {

        Dao<Homework> dao = new HomeworkDao();
        String[] params = new String[1];
        params[0] = course;
        List<Homework> result = dao.getAll(params);

        Predicate<Homework> byMatter = homework -> homework.getMatter().equals(matter);

        return  result.stream().filter(byMatter).collect(Collectors.toList());
    }


    public int saveNew(Homework a) throws Exception {

        Dao<Homework> dao = new HomeworkDao();
        return dao.save(a);
    }

    public void delete(Homework h) throws Exception {
        Dao<Homework> dao = new HomeworkDao();
        dao.delete(h);
    }
}
