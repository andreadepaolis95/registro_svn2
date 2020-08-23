package controllerfx;


import bean.AbsenceList;
import bean.UserBean;
import controller.StudentAbsenceController;
import excep.InputException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import model.Absence;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ControllerAbsencesStudentFX extends ControllerScenes implements Initializable {
    @FXML
    public TextArea textAreaDaGiustificare;
    @FXML
    public TextArea textAreaGiustificate;
    @FXML
    public ComboBox comboAssenza;
    @FXML
    public TextField textPin;
    @FXML
    public Button buttonGiustifica;
    @FXML
    private AnchorPane rootAbsences;

    public void goToLogout() throws IOException {
        this.setAbsenceList(null);
        this.setAbsenceList(null);
        this.pinDigited = "none";
        this.setReport(null);
        this.matterPicked = "none";
        this.setStudent(null);
        this.setHomeBean(null);
        this.setUtils(null);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../viewFX/login.fxml"));
        AnchorPane pane = loader.load();
        rootAbsences.getChildren().setAll(pane);
    }

    public void goToGrades() throws IOException {
        this.setAbsenceList(null);
        this.setAbsenceList(null);
        this.pinDigited = "none";
        this.setReport(null);
        this.matterPicked = "none";
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../viewFX/gradesStudent.fxml"));
        AnchorPane pane = loader.load();
        rootAbsences.getChildren().setAll(pane);
    }

    public void goToHome() throws IOException {
        this.setAbsenceList(null);
        this.setAbsenceList(null);
        this.pinDigited = "none";
        this.setReport(null);
        this.matterPicked = "none";
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../viewFX/homeStudent.fxml"));
        AnchorPane pane = loader.load();
        rootAbsences.getChildren().setAll(pane);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        if(this.getAbsenceList() == null) {
            UserBean user = this.getUserBean();
            StudentAbsenceController controller = new StudentAbsenceController();


            AbsenceList list = null;
            try {
                list = controller.loadAllAbsence(user.getId());
            } catch (Exception exception) {
                exception.printStackTrace();
            }

            this.setAbsenceList(list);
        }
        else{
            StudentAbsenceController controller = new StudentAbsenceController();

            AbsenceList list = this.getAbsenceList();


            String index = this.getAbsenceToJustify().getID();
            String pin = this.pinDigited;


            Predicate<Absence> byIndex = record -> record.getID().equals(index);
            Absence a = list.getAbsences().stream().filter(byIndex).collect(Collectors.toList()).get(0);
            try {
                if (!controller.justifyAbsence(a, a.getStudentId(), pin)) throw new InputException("pin");
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            list.getAbsences().remove(a);
            list.addJustified(a);
            this.setAbsenceList(list);

        }
        this.textAreaDaGiustificare.setText("");
        for (Absence absence : this.getAbsenceList().getAbsences()) {
            this.textAreaDaGiustificare.appendText("Data: " + absence.getDateFormatted() + " Tipo: " + absence.getType());
        }

        for (Absence absence : this.getAbsenceList().getAbsences()) {
            this.comboAssenza.getItems().add(absence);
        }

        this.textAreaGiustificate.setText("");
        for(Absence absence : this.getAbsenceList().getJustifiedAbsences()){
            this.textAreaGiustificate.appendText("Data: " + absence.getDateFormatted() + " Tipo: " + absence.getType());
        }

    }

    public void giustificAssenza() throws IOException {
        this.setAbsenceToJustify((Absence) this.comboAssenza.getSelectionModel().getSelectedItem());
        this.pinDigited = this.textPin.getText();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../viewFX/absencesStudent.fxml"));
        AnchorPane pane = loader.load();
        rootAbsences.getChildren().setAll(pane);
    }
}
