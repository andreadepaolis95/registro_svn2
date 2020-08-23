package dao;

import excep.ConnectionError;
import persistence.DataBase;
import persistence.StudentQuery;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PinDao {


    public int savePin(String pin, String id) throws SQLException, ConnectionError {


        Statement st = null;

        try {
            DataBase db = DataBase.getInstance();
            Connection con = db.getConnection();

            st = con.createStatement();
            return StudentQuery.saveNewPin(st, pin, id);

        } finally {
            if (st != null)
                st.close();
        }
    }

    public String getPin(String id) throws SQLException, ConnectionError {


        Statement st = null;
        ResultSet rs = null;

        try {
            DataBase db = DataBase.getInstance();
            Connection con = db.getConnection();

            st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            rs = StudentQuery.getPin(st, id);
            if (!rs.first()) throw new SQLException("Pin not already created, Try to generate new one");

            return rs.getString("pin");

        } finally {
            if (rs != null)
                st.close();

            if (st != null)
                st.close();
        }

    }


    public void updatePin(String pin, String id) throws SQLException, ConnectionError {


        Statement st = null;

        try {
            DataBase db = DataBase.getInstance();
            Connection con = db.getConnection();

            st = con.createStatement();
            StudentQuery.updatePin(st, pin, id);

        } finally {
            if (st != null)
                st.close();
        }

    }
}
