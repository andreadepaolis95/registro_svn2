package test.GianMarcoColagrossi;

import bean.ProfessorBean;
import controller.ProfessorHomeController;
import excep.ConnectionError;
import excep.NotFoundError;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class ProfessorHomeControllerTest {

    @Test
    void loadMatter() {
        ProfessorHomeController controller = new ProfessorHomeController();
        String validId = "20";
        try {
            ProfessorBean pb = controller.loadMatter(validId);

            assertTrue(pb.getMatterList().size() > 0);
            assertTrue(pb.getMatterList().contains(pb.getMatter()));

        } catch (Exception e) {
            fail();
        }
    }

    @Test
    void loadMatterInvalidID() {
        ProfessorHomeController controller = new ProfessorHomeController();
        String validId = "909929292ciao";
        try {
            ProfessorBean pb = controller.loadMatter(validId);


        } catch (SQLException | ConnectionError se) {
            fail(se.getMessage());

        } catch (Exception e) {
            assertTrue(e instanceof NotFoundError);
        }
    }
}