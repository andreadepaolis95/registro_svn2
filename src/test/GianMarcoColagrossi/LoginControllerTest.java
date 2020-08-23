package test.GianMarcoColagrossi;

import bean.UserBean;
import controller.LoginController;
import excep.InputException;
import org.junit.jupiter.api.Test;


import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class LoginControllerTest {



    @Test
    void handleLoginStudent() {
        LoginController controller = new LoginController();
        String username = "alberto";
        String password = "123";
        boolean flag = false;

        try {


            UserBean u = controller.handleLogin(username, password, flag);
            if( u == null) fail();

            assertFalse(u.isProfessor());
            assertTrue(u.getFullName().length() > 0);
            assertTrue(u.getPageList().size() > 0);
            assertFalse(u.getCourse().isEmpty());


        } catch (Exception se){
            se.printStackTrace();
            fail();
        }

    }
    @Test
    void handleLoginProfessor() {
        LoginController controller = new LoginController();
        String username = "fab";
        String password = "123";
        boolean flag = true;

        try {

            UserBean u = controller.handleLogin(username, password, flag);
            if( u == null) fail();

            else {
                assertTrue(u.isProfessor());
                assertTrue(u.getFullName().length() > 0);
                assertTrue(u.getPageList().size() > 0);

            }

        } catch (Exception se){
            se.printStackTrace();
            fail();
        }

    }


    @Test
    void LoginFail() {
        LoginController controller = new LoginController();
        String username = "";
        String password = "";
        boolean flag = false;

        try {

            UserBean u = controller.handleLogin(username, password, flag);
            fail();

        }catch (Exception e){
            assertTrue(e instanceof InputException);

        }

    }

    @Test
    void LoginFailCredential() {
        LoginController controller = new LoginController();
        String username = "alberto";
        String password = "1456";
        boolean flag = false;

        try {

            UserBean u = controller.handleLogin(username, password, flag);

        }catch (Exception e){
            assertTrue(e instanceof SQLException);
        }

    }
}