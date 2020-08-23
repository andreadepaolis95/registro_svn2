package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentRegisterQuery {


    public static ResultSet getAllStudents(Statement stmt ,String course) throws SQLException {
        String sql = String.format("SELECT * FROM students where course = '%s';", course);
        return stmt.executeQuery(sql);

    }

    public static ResultSet getStudent(Statement st, String id) throws SQLException {
        String sql = String.format("SELECT * FROM students where id = '%s';", id);
        return st.executeQuery(sql);
    }

    public static ResultSet login(Statement st, String username, String password) throws SQLException {
        String sql = String.format("SELECT * FROM users where username = '%s' and password= '%s';", username,password);
        return st.executeQuery(sql);
    }

    public static ResultSet getAllGrades(Statement st,String id, String matter) throws SQLException {

        String sql = String.format("SELECT * FROM grades where studentid = '%s' and matter= '%s';", id,matter);
        return st.executeQuery(sql);
    }

    public static ResultSet getAllAbsence(Statement st, String id) throws SQLException {
        String sql = String.format("SELECT * FROM absences where studentid = '%s'", id);
        return st.executeQuery(sql);
    }
}
