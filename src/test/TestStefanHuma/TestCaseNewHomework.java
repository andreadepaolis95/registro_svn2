package test.TestStefanHuma;

import controller.AssignmentController;
import org.junit.jupiter.api.Test;
import service.HomeworkService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCaseNewHomework {
    @Test
    void newHomeWork(){
        AssignmentController controller = new AssignmentController();
        String text = "compito di fisica";
        String classe = "1B";
        String matter = "Fisica";
        String data = "2020-05-20";
        int oldSize = 0;
        int newSize = 0;

        try {
            HomeworkService homeworks = new HomeworkService();
            oldSize = homeworks.filterForCourse(classe).size();
            controller.saveNewHomework(text,matter,classe,data);
            newSize = homeworks.filterForCourse(classe).size();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(oldSize+1 , newSize);
    }
}
