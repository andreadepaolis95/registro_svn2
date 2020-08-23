package dao;

import excep.ConnectionError;
import model.Mark;
import persistence.DataBase;
import persistence.ProfessorQuery;
import persistence.StudentRegisterQuery;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MarkDao implements Dao<Mark> {


    /**
     *
     * @param params studentid, matter
     * @return list of student's marks
     * @throws Exception
     */


    @Override
    public List<Mark> getAll(String[] params) throws SQLException,ConnectionError {


        Statement st = null;
        ResultSet rs = null;

        List<Mark> result = new ArrayList<>();

        try {

            DataBase db = DataBase.getInstance();
            Connection con = db.getConnection();
            st = con.createStatement();
            rs = StudentRegisterQuery.getAllGrades(st,params[0],params[1]);

            while (rs.next())
                result.add(new Mark(rs.getString("id"),rs.getInt("value"),rs.getDate("day"),rs.getString("type"),rs.getString("matter"),rs.getString("studentid")));
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
    public int save(Mark mark) throws ConnectionError,SQLException {

        DataBase db = DataBase.getInstance();
        Connection conn = db.getConnection();
        String sql = "INSERT INTO grades(studentid,value,day,matter,type) VALUES(?,?,?,?,?)";
        int result;
        PreparedStatement stmt = null;
        try{

        stmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        stmt.setString(1,String.valueOf(mark.getStudentId()));
        stmt.setInt(2,mark.getValueAsInt());
        stmt.setDate(3,new Date(mark.getDate().getTime()));
        stmt.setString(4,mark.getMatter());
        stmt.setString(5,mark.getCategory());



        int affectedRows = stmt.executeUpdate();

        if (affectedRows == 0)
            throw new SQLException("Insert fail");

        ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                result = ((int) generatedKeys.getLong(1));
            }
            else {
                throw new SQLException("Cannot take id");
            }
        } finally {
            if(stmt != null)
            stmt.close();
        }
        return result;



}

    @Override
    public void update(Mark mark, String[] params) throws ConnectionError,SQLException {

        //maybe in future version

    }

    @Override
    public void delete(Mark mark) throws SQLException, ConnectionError {

        Statement st = null;

        try {
            DataBase db = DataBase.getInstance();
            Connection con = db.getConnection();
            st = con.createStatement();
             ProfessorQuery.deleteGrades(st,Integer.parseInt(mark.getID()));


        }finally {

            if(st != null)
                st.close();
        }

    }
}
