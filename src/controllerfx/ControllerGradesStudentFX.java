package controllerfx;

import bean.ReportBean;
import bean.StudentBean;
import bean.UserBean;
import controller.StudentReportController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import model.RegisterRecord;
import model.ReportRecord;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerGradesStudentFX extends ControllerScenes implements Initializable {
    @FXML
    public ComboBox comboMateria;
    @FXML
    private TextArea textAreaVoti;
    @FXML
    private TextArea textAreaReport;
    @FXML
    private AnchorPane rootGradesStudent;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(this.matterPicked.equals("none")) {

            StudentReportController controller = new StudentReportController();
            UserBean u = this.getUserBean();
            StudentBean std = this.getCurrentStudent();

            ReportBean report = null;
            try {
                report = controller.loadFullReport(u.getId(),std.getMatters());
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.setReport(report);
        }
        else{
            StudentReportController controller = new StudentReportController();


            UserBean u = this.getUserBean();
            StudentBean std = this.getCurrentStudent();
            ReportBean report = this.getReport();


            String matter = this.matterPicked;
            std.setSelectedMatter(matter);

            try {
                report.setAllGrades(controller.allGradesForMatter(u.getId(),matter));
            } catch (Exception e) {
                e.printStackTrace();
            }

            this.setReport(report);
            this.setStudent(std);

            this.textAreaVoti.setText("Voti di " + this.getCurrentStudent().getSelectedMatter() + "\n\n");
            for(RegisterRecord record : this.getReport().getAllGrades()){
                this.textAreaVoti.appendText(record.getType() + " " + record.getValue() + " " + record.getDateFormatted() + "\n");
            }
        }

        for (String matter : this.getCurrentStudent().getMatters()) {
            this.comboMateria.getItems().add(matter);
        }

        this.textAreaReport.setText("");
        for(ReportRecord record : this.getReport().getReportList()){
            this.textAreaReport.appendText(record.getMatter() + ": " + record.getMedia() + "\n");
        }
    }

    public void goToLogout() throws IOException {
        this.setReport(null);
        this.matterPicked = "none";
        this.setStudent(null);
        this.setHomeBean(null);
        this.setUtils(null);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../viewFX/login.fxml"));
        AnchorPane pane = loader.load();
        rootGradesStudent.getChildren().setAll(pane);
    }

    public void goToHome() throws IOException {
        this.setReport(null);
        this.setStudent(null);
        this.matterPicked = "none";
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../viewFX/homeStudent.fxml"));
        AnchorPane pane = loader.load();
        rootGradesStudent.getChildren().setAll(pane);
    }

    public void goToAbsences() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../viewFX/absencesStudent.fxml"));
        AnchorPane pane = loader.load();
        rootGradesStudent.getChildren().setAll(pane);
    }

    public void changeMatter() throws IOException {
        this.matterPicked = (String) this.comboMateria.getSelectionModel().getSelectedItem();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../viewFX/gradesStudent.fxml"));
        AnchorPane pane = loader.load();
        rootGradesStudent.getChildren().setAll(pane);
    }
}
