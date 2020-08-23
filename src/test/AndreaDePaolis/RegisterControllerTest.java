package test.AndreaDePaolis;

import controller.RegisterController;
import excep.InputException;
import model.Absence;
import model.RegisterRecord;
import model.RegisterStudent;
import service.AbsenceService;
import service.Validator;

import java.util.List;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class RegisterControllerTest {


    @org.junit.jupiter.api.Test
    void validateStudents() {
        RegisterController  reg = new RegisterController();
        String validCourse = "3B";
        try{
            List<RegisterStudent>  list = reg.loadStudentOfClass(validCourse);
            assertTrue(list.size() > 0);

        } catch (Exception e){
            fail();
        }

    }



    @org.junit.jupiter.api.Test
    void newAbsence(){
        RegisterController  reg = new RegisterController();
        String id = "1";
       AbsenceService service = new AbsenceService();
        try{
            int size =  service.getAllAbsence(id).size();

            Absence a = reg.newAbsence(id,"ritardo","2020-8-10");
            assertNotNull(a);
           
            List<RegisterRecord> list = service.getAllAbsence(id);
            assertEquals(size +1 ,list.size());

            Predicate<RegisterRecord> byIndex = absence -> absence.getID().equals(a.getID());
            assertTrue(list.stream().anyMatch(byIndex));

        } catch (Exception e){
            fail();
        }

    }




    @org.junit.jupiter.api.Test
    void newAbsenceWithInvalidDate(){
        RegisterController  reg = new RegisterController();
        String id = "1";
        AbsenceService service = new AbsenceService();
        Validator v = new Validator();
        try{
            int size =  service.getAllAbsence(id).size();

            Absence a = reg.newAbsence(id,"ritardo","2020-14-33");
            assertFalse(v.validateDate(a.getDateFormatted()));
            assertEquals(size+1,service.getAllAbsence(id).size());

        } catch (Exception e){
            e.printStackTrace();
            assertTrue(e instanceof InputException);
        }

    }

    @org.junit.jupiter.api.Test
    void calculateMedia(){
        RegisterController  reg = new RegisterController();
        String validID = "1";
        String matter = "Matematica";
        try {
            double result = reg.calculateMedia(validID,matter);
            assertTrue(result <= 10 && result >= 0);

        } catch (Exception e) {
                fail("Test fails");
        }
    }

}