package service;

import dao.AbsenceDao;
import dao.Dao;

import excep.ConnectionError;
import model.Absence;
import model.RegisterRecord;
import utilities.Configuration;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AbsenceService implements  RegisterRecordService {



    public Absence saveNew(Absence a) throws Exception {

        Dao<Absence> dao = new AbsenceDao();
        int id = dao.save(a);
        a.setId(String.valueOf(id));
        return a;
    }

    @Override
    public void delete(RegisterRecord rr) throws SQLException, ConnectionError {

        Absence a = (Absence) rr;

        Dao<Absence> dao = new AbsenceDao();
        dao.delete(a);

    }


    public List<RegisterRecord> getAllAbsence(String id) throws SQLException, ConnectionError{

       return getAllBetweenDate(id, Configuration.startOfAcademicYear(),Configuration.EndOfAcademicYear());

    }

    public int justifyAbsence(Absence absence) throws SQLException, ConnectionError {
        AbsenceDao dao = new AbsenceDao();
        String[] param = new String[1];
        dao.update(absence,param);
        return 1;
    }

    public List<RegisterRecord> getAllBetweenDate(String id, Date start, Date end) throws SQLException, ConnectionError {

        Dao<Absence> dao = new AbsenceDao();
        String[] params = new String[2];
        params[0] = id;
        List<Absence> list =  dao.getAll(params);
        Predicate<Absence> byDate = absence -> absence.isInRange(start,end);

        return list.stream().filter(byDate).collect(Collectors.toList());

    }
}
