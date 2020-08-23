package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentQuery {



        public static ResultSet getSchedule(Statement st, String course) throws SQLException {

            String sql = String.format("SELECT * FROM schedule where course = '%s';", course);

            return st.executeQuery(sql);
        }


        public static ResultSet getArgument(Statement st, String course, String matter)throws SQLException {

            String sql = String.format("SELECT * FROM arguments where course = '%s' and matter= '%s';", course,matter);
            return st.executeQuery(sql);
        }

        public static ResultSet getHomework(Statement st, String clazz) throws SQLException {
            String sql = String.format("SELECT * FROM homework where course = '%s';", clazz);
            return st.executeQuery(sql);
        }


    public static ResultSet getAllMatter(Statement st,String course) throws SQLException {
        String sql = String.format("SELECT * FROM matchcourse where course = '%s';", course);
        return st.executeQuery(sql);
    }



    public static int justifyAbsence(Statement st, String id) throws SQLException {
            String sql = String.format("UPDATE absences SET justified='%d' where id='%s';",1, id);
            return st.executeUpdate(sql);
    }

    public static int updatePin(Statement stmt, String pin, String id) throws SQLException {

            String sql = String.format("UPDATE pin SET pin='%s' where studentid='%s';",pin,id);
            return stmt.executeUpdate(sql);

    }

    public static ResultSet getPin(Statement st, String id) throws SQLException {

        String sql = String.format("SELECT * FROM pin WHERE studentid='%s';",id);
        return st.executeQuery(sql);

    }

    public static int saveNewPin(Statement st, String pin, String id) throws SQLException {
        String sql = String.format("INSERT INTO pin(pin,studentid) VALUES('%s','%s');",pin,id);
        return st.executeUpdate(sql);
    }
}
