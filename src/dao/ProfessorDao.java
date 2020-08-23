package dao;

import excep.ConnectionError;
import excep.InputException;
import excep.NotFoundError;
import model.Matter;
import model.Professor;
import model.Schedule;
import persistence.DataBase;
import persistence.ProfessorLoginQuery;
import persistence.ProfessorQuery;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDao implements UserDao{

    public Professor get(String id) throws ConnectionError,SQLException {

        Statement st = null;
        ResultSet rs = null;
        Professor p = null;

        try {
            DataBase db = DataBase.getInstance();
            Connection con = db.getConnection();
            st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = ProfessorLoginQuery.getProfessor(st, id);
            if (!rs.first())
                throw new SQLException("No professor found");

            p = new Professor(rs.getString("name"), rs.getString("last"), rs.getString("id"));


        } finally {
            if(rs != null)
                rs.close();

            if(st != null)
                st.close();
        }

        return p;
    }

    public String login(String username, String password) throws Exception {


        Statement st = null;
        ResultSet rs = null;
        String id = null;
        try {

            DataBase db = DataBase.getInstance();
            Connection con = db.getConnection();
            st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = ProfessorLoginQuery.login(st, username, password);

            if (!rs.first()) throw new InputException("invalid login");

            rs.first();
            id = rs.getString("id");

        }finally {
            if(rs != null)
                rs.close();

            if(st != null)
                st.close();
        }

        return id;
    }



    @Override
    public List<Schedule> getSchedule(String id) throws SQLException,ConnectionError {


        Statement st = null;
        ResultSet rs = null;
        List<Schedule> result = new ArrayList<>();
        try {
            DataBase db = DataBase.getInstance();
            Connection con = db.getConnection();
            st = con.createStatement();
            rs = ProfessorQuery.getSchedule(st, id);

            while (rs.next())
                result.add(new Schedule(rs.getInt("day"), rs.getInt("hour"), rs.getString("matter"), rs.getString("course")));

            if (!(result.size() > 0)) throw new SQLException("Database inconsistente");


        } finally {

            if (rs != null) rs.close();
            if (st != null) st.close();
        }

        return result;

    }

    public List<Matter> getAllMatter(String params) throws NotFoundError, SQLException , ConnectionError {


        Statement st = null;
        ResultSet rs = null;
        List<Matter> result = new ArrayList<>();
        try {

            DataBase db = DataBase.getInstance();
            Connection con = db.getConnection();
            st = con.createStatement();
            rs = ProfessorQuery.getCourseList(st, params);
            if (!rs.isBeforeFirst()) throw new NotFoundError("matter");

            while (rs.next())
                result.add(new Matter(rs.getString("course"), rs.getString("matter"), result.size()));


        } finally {


            if(rs != null)rs.close();
            if(st != null) st.close();
        }
        return result;

    }

    }
