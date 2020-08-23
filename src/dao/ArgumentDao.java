package dao;

import excep.ConnectionError;
import model.Argument;
import persistence.AssignementQuery;
import persistence.DataBase;
import persistence.StudentQuery;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArgumentDao implements Dao<Argument> {



    /**
     *
     * @param params course, matter
     * @return list of arguments filtered for course and matter
     * @throws Exception
     */
    @Override
    public List<Argument> getAll(String[] params) throws SQLException,ConnectionError {


        Statement st = null;
        ResultSet rs = null;

        List<Argument> result = new ArrayList<>();
        try {

            DataBase db = DataBase.getInstance();
            Connection con = db.getConnection();
            st = con.createStatement();
            rs = StudentQuery.getArgument(st, params[0], params[1]);
            while (rs.next())
                result.add(new Argument(rs.getString("id"), rs.getString("matter"), rs.getString("description"),rs.getString("course"),rs.getString("title"),rs.getDate("created")));


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
    public int save(Argument argument) throws SQLException, ConnectionError {


        DataBase db = DataBase.getInstance();
        Connection con = db.getConnection();
        int result;
        PreparedStatement ps = null;
        String sql = "INSERT INTO arguments(matter,course,description,created,title) VALUES(?,?,?,?,?)";
        try{

        ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ps.setString(1,argument.getMatter());
        ps.setString(2,argument.getCourse());
        ps.setString(3,argument.getText());
        ps.setDate(4, new Date(argument.getDate().getTime()));
        ps.setString(5,argument.getTitle());

        int affectedRows = ps.executeUpdate();

        if (affectedRows == 0) {
            throw new SQLException("Saving argument fails");
        }
        ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                result = ( (int) generatedKeys.getLong(1));
            }
            else
                throw new SQLException("Creating");

        } finally {
            if(ps != null)
            ps.close();
        }
        return result;
    }

    @Override
    public void update(Argument argument, String[] params) throws SQLException,ConnectionError {
        //future version;
    }

    @Override
    public void delete(Argument argument) throws SQLException,ConnectionError {

        Statement st = null;

        try {

            DataBase db = DataBase.getInstance();
            Connection con = db.getConnection();
            st = con.createStatement();

            AssignementQuery.removeArg(st, Integer.parseInt(argument.getId()) );


        }catch (SQLException | ConnectionError se){
            se.printStackTrace();
            throw se;


        } finally {
            if(st != null)
                st.close();
        }

    }
}
