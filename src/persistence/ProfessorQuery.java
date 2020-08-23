package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class ProfessorQuery {
    public static ResultSet getCourseList(Statement st, String id) throws SQLException {

        String sql = String.format("SELECT * FROM matchcourse where userid = '%s';", id);
        return st.executeQuery(sql);
    }

    public static ResultSet getSchedule(Statement st, String id) throws SQLException {

        String sql = String.format("SELECT * FROM schedule where pid = '%s';", id);
        return st.executeQuery(sql);
    }


    public static ResultSet getArgument(Statement st, String clazz, String matter) throws SQLException {

        String sql = String.format("SELECT * FROM arguments where course = '%s' and matter= '%s';", clazz,matter);
        return st.executeQuery(sql);
    }

    public static ResultSet getHomework(Statement st, String clazz) throws SQLException {
        String sql = String.format("SELECT * FROM homework where course = '%s';", clazz);
        return st.executeQuery(sql);
    }

    public static int deleteAbsence(Statement st, String id) throws SQLException {

        String sql = String.format("DELETE FROM absences where id = '%s';", id);
        return st.executeUpdate(sql);
    }
    public static int deleteGrades(Statement st, int id) throws SQLException {

        String sql = String.format("DELETE FROM grades where id = '%d';", id);
        return st.executeUpdate(sql);
    }
}
