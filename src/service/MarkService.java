package service;

import dao.Dao;
import dao.MarkDao;

import model.Mark;
import model.RegisterRecord;

import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MarkService  implements RegisterRecordService{


    public List<RegisterRecord> getAllBetweenDate(String id, String matter, Date start, Date end) throws Exception {

        Dao<Mark> dao = new MarkDao();
        String[] params = new String[2];
        Validator v = new Validator();
        params[0] = id;
        params[1] = matter;
        List<Mark> list =  dao.getAll(params);
        Predicate<Mark> byDate = mark -> v.isInRange(mark.getDate(),start,end);
        return list.stream().filter(byDate).collect(Collectors.toList());

    }

    public Mark saveNew(Mark m) throws Exception {


        Dao<Mark> dao = new MarkDao();
        int id = dao.save(m);
        m.setId(String.valueOf(id));
        return m;

    }


    @Override
    public void delete(RegisterRecord rr) throws Exception {

        Mark a = (Mark) rr;
        Dao<Mark> dao = new MarkDao();
        dao.delete(a);
    }
}
