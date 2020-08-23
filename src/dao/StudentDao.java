package dao;

import excep.ConnectionError;
import excep.InputException;
import model.Schedule;
import model.Student;
import model.User;
import persistence.DataBase;
import persistence.StudentRegisterQuery;
import persistence.StudentQuery;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDao implements Dao<Student>,UserDao {


    @Override
    public User get(String id) throws InputException, ConnectionError, SQLException{

            Statement st = null;
            ResultSet rs = null;
            Student s = null;

            try {
                DataBase db = DataBase.getInstance();
                Connection con = db.getConnection();
                st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                rs = StudentRegisterQuery.getStudent(st,id);
                if (!rs.first())
                    throw new InputException("Login");

                s = new Student(rs.getString("name"), rs.getString("last"), rs.getString("id"),rs.getString("course"));

            }catch (InputException ie) {
                ie.printStackTrace();
                throw ie;
            }catch (Exception e) {
                e.printStackTrace();
                throw new ConnectionError();


            } finally {
                if(rs != null)
                    rs.close();

                if(st != null)
                    st.close();
            }

            return s;
        }


    @Override
    public String login(String username, String password) throws Exception {
        Statement st = null;
        ResultSet rs = null;
        String id = "";

        try {
            DataBase db = DataBase.getInstance();
            Connection con = db.getConnection();
            st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
             rs = StudentRegisterQuery.login(st, username,password);
            if (!rs.first())
                throw new InputException("Login");

            id = rs.getString("id");


        }catch (InputException ie) {
            ie.printStackTrace();
            throw ie;
        }catch (Exception e) {
            e.printStackTrace();
            throw new ConnectionError();


        } finally {
            if(rs != null)
                rs.close();

            if(st != null)
                st.close();
        }

        return id;

    }

    @Override
    public List<Student> getAll(String[] params) throws ConnectionError,SQLException {

        Statement st = null;
        List<Student> result = new ArrayList<>();


        try{
        DataBase db = DataBase.getInstance();
        Connection con = db.getConnection();
        st = con.createStatement();
        ResultSet rs = StudentRegisterQuery.getAllStudents(st,params[0]);

        while (rs.next()) {

            Student s = new Student(rs.getString("name"), rs.getString("last"), rs.getString("id"), rs.getString("course"));
            result.add(s);

           }
        }catch (SQLException | ConnectionError se){
            se.printStackTrace();
            throw se;


        } finally {
            if(st != null)
                    st.close();
        }
        return result;

    }

    @Override
    public int save(Student student) throws SQLException,ConnectionError {
        //da fare per un eventuale terzo attore(segreteria)
      return 0;
    }

    @Override
    public void update(Student student, String[] params) throws SQLException,ConnectionError {
        //da fare per un eventuale terzo attore(segreteria)

    }

    @Override
    public void delete(Student student) throws SQLException,ConnectionError {
        //da fare per un eventuale terzo attore(segreteria)

    }


    /**
     *
     * @param  course
     *
     *
     * @return
     * @throws Exception
     */

    @Override
    public List<Schedule> getSchedule(String course) throws SQLException,ConnectionError {


        Statement st = null;
        ResultSet rs = null;
        List<Schedule> result = new ArrayList<>();
        try {
            DataBase db = DataBase.getInstance();
            Connection con = db.getConnection();
            st = con.createStatement();
            rs = StudentQuery.getSchedule(st, course);

            while (rs.next())
                result.add(new Schedule(rs.getInt("day"), rs.getInt("hour"), rs.getString("matter"), rs.getString("course")));

            if (!(result.size() > 0)) throw new SQLException("Database inconsistente");

        }catch (SQLException | ConnectionError se){
            se.printStackTrace();
            throw se;

        } finally {

            if (rs != null) rs.close();
            if (st != null) st.close();
        }

        return result;

    }


    public List<String> getAllMatter(String id) throws ConnectionError,SQLException {


        Statement st = null;
        ResultSet rs = null;
        List<String> result = new ArrayList<>();
        try {

            DataBase db = DataBase.getInstance();
            Connection con = db.getConnection();
            st = con.createStatement();
             rs = StudentQuery.getAllMatter(st, id);

            while(rs.next())
                result.add(rs.getString("matter"));

        }catch (SQLException | ConnectionError se){
            se.printStackTrace();
            throw se;

        } finally {


            if(rs != null)rs.close();
            if(st != null) st.close();
        }
        return result;

    }

}
