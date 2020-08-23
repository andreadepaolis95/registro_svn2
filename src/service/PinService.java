package service;



import dao.PinDao;
import excep.ConnectionError;

import java.security.SecureRandom;
import java.sql.SQLException;

public class PinService {


    public String generateNewPin(){

        SecureRandom random = new SecureRandom();
        int num = random.nextInt(100000);
        return String.format("%05d", num);
    }

    public void savePin(String pin, String id) throws SQLException, ConnectionError {
        PinDao dao = new PinDao();
        dao.savePin(pin,id);
    }

    public int checkPin(String id) throws ConnectionError{
        PinDao dao = new PinDao();
        try{
              dao.getPin(id);
              return 1;

        } catch (SQLException se){
            se.printStackTrace();
            return 0;
        }
    }
    public void updatePin(String pin, String id) throws SQLException, ConnectionError {
        PinDao dao = new PinDao();
         dao.updatePin(pin,id);
    }


/*
    public String loadEmail(String id) throws Exception {

        PinDao dao = new PinDao();
        return dao.retrivesEmail(id);
    }
*/

    public boolean verifyPin(String pin ,String id) throws SQLException, ConnectionError {
        PinDao dao = new PinDao();
        String oldPin = dao.getPin(id);
        return oldPin.equals(pin);
    }



}
