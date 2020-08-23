package persistence;

import excep.ConnectionError;

import java.sql.Connection;
import java.sql.DriverManager;


public class DataBase {

    private final String  USER = "root";
    private final String PASS = "password";
    private final String DB_URL = "jdbc:mysql://localhost:3306/registro4";
    private final String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
    private Connection conn;
    private final String OPTION = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Rome";

    private static DataBase instance = null;


    private DataBase() throws ConnectionError{
        try {
            Class.forName(DRIVER_CLASS_NAME);

        } catch (Exception e) {
            e.printStackTrace();
            throw new ConnectionError();
        }

    }

    public static  DataBase getInstance() throws ConnectionError{
        if(instance == null) instance = new DataBase();
        return instance;
    }



    public Connection getConnection() throws ConnectionError {

        try {
            if (this.conn == null || this.conn.isClosed())
                conn = DriverManager.getConnection(DB_URL + OPTION, USER, PASS);

            return this.conn;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ConnectionError();
        }


    }
}
