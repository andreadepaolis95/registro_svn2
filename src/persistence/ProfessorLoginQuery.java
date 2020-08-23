package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProfessorLoginQuery {


    public static ResultSet login(Statement st, String username, String password) throws SQLException {

        String sql = String.format("SELECT * FROM users where username = '%s' and password= '%s';", username,password);
        return st.executeQuery(sql);

    }

    public static ResultSet getProfessor(Statement st, String id) throws SQLException {

        String sql = String.format("SELECT * FROM professors where id = '%s';", id);
        return st.executeQuery(sql);
    }
}
