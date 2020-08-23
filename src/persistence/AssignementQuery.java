package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public  abstract  class AssignementQuery {


    public static int save(Statement st, String title, String text, String matter, String course, Date date) throws SQLException {

        String sql = String.format("INSERT INTO arguments(matter,course,title,description,created) VALUES('%s','%s','%s','%s','%tF')",matter,course,title,text,date);
        st.executeUpdate(sql);
        return 0;
    }

    public static int removeArg(Statement st, int index) throws SQLException {

        String sql = String.format("DELETE FROM arguments WHERE id='%d'",index);
        return st.executeUpdate(sql);
    }


    public static int removeHmw(Statement st, int index) throws SQLException {

        String sql = String.format("DELETE FROM homework WHERE id='%d'",index);
        return st.executeUpdate(sql);
    }
}
