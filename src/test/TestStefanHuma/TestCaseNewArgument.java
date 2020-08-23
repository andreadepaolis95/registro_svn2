package test.TestStefanHuma;

import controller.AssignmentController;
import org.junit.jupiter.api.Test;
import service.ArgumentService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCaseNewArgument {

    @Test
    void newArgument(){
        AssignmentController controller = new AssignmentController();
        String title = "La rivoluzione Francese";
        String text = "introduzione capitoli 12.1 e 12.2";
        String classe = "1B";
        String matter = "Storia";
        String data = "2020-06-20";
        int oldSize = 0;
        int newSize = 0;

        try {
            ArgumentService argument = new ArgumentService();
            oldSize = argument.filterForMatterAndCourse(classe,matter).size();
            controller.saveNewArgument(title,text,matter,classe,data);
            newSize = argument.filterForMatterAndCourse(classe,matter).size();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(oldSize+1 , newSize);
    }
}
