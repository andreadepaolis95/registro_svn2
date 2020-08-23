package dao;

import excep.ConnectionError;
import model.Homework;
import persistence.AssignementQuery;
import persistence.DataBase;
import persistence.ProfessorQuery;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HomeworkDao  implements Dao<Homework>{



    /**
     *
     * @param params course, matter
     * @return homework filtered for class and matter
     * @throws Exception
     */

    @Override
    public List<Homework> getAll(String[] params) throws SQLException, ConnectionError {

        Statement st = null;
        ResultSet rs = null;

        List<Homework> result = new ArrayList<>();
        try {

            DataBase db = DataBase.getInstance();
            Connection con = db.getConnection();
            st = con.createStatement();
            rs = ProfessorQuery.getHomework(st, params[0]);
            while (rs.next())
                result.add(new Homework(rs.getString(1), rs.getString("matter"), rs.getString("description"), rs.getString("course"), rs.getDate("expire")));

        }catch (SQLException | ConnectionError se){
            se.printStackTrace();
            throw se;

        } finally {


            if(rs != null)rs.close();
            if(st != null) st.close();
        }
        return result;



    }

    @Override
    public int save(Homework homework)  throws SQLException, ConnectionError {

        DataBase db = DataBase.getInstance();
        Connection con = db.getConnection();
        String sql = "INSERT INTO homework(matter,course,description,expire) VALUES(?,?,?,?)";
        int result;
        PreparedStatement ps = null;
        try{
        ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1,homework.getMatter());
        ps.setString(2,homework.getCourse());
        ps.setString(3,homework.getText());
        ps.setDate(4, new Date(homework.getDate().getTime()));

        int affectedRows = ps.executeUpdate();

        if (affectedRows == 0) {
            throw new SQLException("Insert fail, no rows affected.");
        }
        //need to take index for delete or update after created without re-load all data;
       ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                result = ( (int) generatedKeys.getLong(1));
            }
            else {
                throw new SQLException("Creating user failed, no ID obtained.");
            }
        } finally {
            if(ps!= null)
                 ps.close();
        }
        return result;
    }


    @Override
    public void update(Homework homework, String[] params) throws SQLException,ConnectionError {
        //da levare


    }

    @Override
    public void delete(Homework homework) throws SQLException,ConnectionError {

        Statement st = null;

        try {

            DataBase db = DataBase.getInstance();
            Connection con = db.getConnection();
            st = con.createStatement();

            AssignementQuery.removeHmw(st,Integer.parseInt(homework.getId()));
        }catch (SQLException | ConnectionError se){
            se.printStackTrace();
            throw se;


        } finally {
            if(st != null)
                st.close();
        }

    }

}
