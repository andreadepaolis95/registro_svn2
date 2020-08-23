package dao;

import excep.ConnectionError;

import java.sql.SQLException;
import java.util.List;

public interface Dao<T> {


    List<T> getAll(String[] params) throws SQLException, ConnectionError;

    int save(T t) throws SQLException, ConnectionError;;

    void update(T t, String[] params)  throws SQLException, ConnectionError;

    void delete(T t) throws SQLException, ConnectionError;


}