package test.TestStefanHuma;

import controller.AssignmentController;
import model.Argument;
import org.junit.jupiter.api.Test;
import service.ArgumentService;
import service.HomeworkService;



import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCaseDeleteArgument {
    @Test
    void deleteArgument(){
        AssignmentController controller = new AssignmentController();
        String classe = "1B";
        String matter = "Storia";
        int oldSize = 0;
        int newSize = 0;

        try {
            ArgumentService argumentController = new ArgumentService();
            oldSize = argumentController.filterForMatterAndCourse(classe,matter).size();
            Argument argument = argumentController.filterForMatterAndCourse(classe,matter).get(0);
            controller.deleteArgument(argument);
            newSize = argumentController.filterForMatterAndCourse(classe,matter).size();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(oldSize-1 , newSize);
    }
}
