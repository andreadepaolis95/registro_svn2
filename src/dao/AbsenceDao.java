package dao;

import excep.ConnectionError;
import model.Absence;
import persistence.DataBase;
import persistence.ProfessorQuery;
import persistence.StudentRegisterQuery;
import persistence.StudentQuery;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AbsenceDao implements Dao<Absence> {



    @Override
    public List<Absence> getAll(String[] params) throws SQLException, ConnectionError {


        Statement st = null;
        ResultSet rs = null;

        List<Absence> result = new ArrayList<>();

        try {

            DataBase db = DataBase.getInstance();
            Connection con = db.getConnection();
            st = con.createStatement();
            String id = params[0];
            rs = StudentRegisterQuery.getAllAbsence(st,id);

            while (rs.next())
                result.add(new Absence(rs.getString("id"),rs.getString("value"),rs.getString("studentid"),rs.getDate("day"),rs.getInt("justified")==0?false:true));


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
    public int save(Absence absence) throws SQLException,ConnectionError {



            DataBase db = DataBase.getInstance();
            Connection con = db.getConnection();
            String sql  = "INSERT INTO absences(studentid,value,day,justified) VALUES(?,?,?,?)";
            int result;
            PreparedStatement ps = null;

        try{
            ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,String.valueOf(absence.getStudentId()));
            ps.setString(2, absence.getType());
            ps.setDate(3,new Date(absence.getDate().getTime()));
            ps.setBoolean(4,false);


            int affectedRows = ps.executeUpdate();

            if (affectedRows == 0)
                throw new SQLException("Insert fail");

            ResultSet generatedKeys = ps.getGeneratedKeys();
                if (generatedKeys.next()) {
                   result = ((int) generatedKeys.getLong(1));
                }
                else {
                    throw new SQLException("no ID obtained.");
                }
            } finally {
                 if(ps != null)
                        ps.close();
            }

            return result;
        }


    @Override
    public void update(Absence absence, String[] params) throws SQLException, ConnectionError{


            Statement st = null;

            try {
                DataBase db = DataBase.getInstance();
                Connection con = db.getConnection();
                st = con.createStatement();
                 StudentQuery.justifyAbsence(st, absence.getID());



            }catch (SQLException | ConnectionError se){
                se.printStackTrace();
                throw se;

            }finally {

                if(st != null)
                    st.close();
            }
        }


    @Override
    public void delete(Absence absence) throws ConnectionError, SQLException{


        Statement st = null;

        try {
            DataBase db = DataBase.getInstance();
            Connection con = db.getConnection();
            st = con.createStatement();
            ProfessorQuery.deleteAbsence(st,absence.getID());

        }catch (SQLException | ConnectionError se){
            se.printStackTrace();
            throw se;

        }finally {

            if(st != null)
                st.close();
        }


    }
}
