package controllerfx;

import bean.*;
import controller.AssignmentController;
import controller.ProfessorHomeController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.*;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class ControllerProfessorHome extends ControllerScenes implements Initializable {

    @FXML
    public ComboBox comboCambiaClasse;

    @FXML
    public TableView tableSchedule;

    @FXML
    private TextArea textAreaArgomenti;

    @FXML
    private AnchorPane root;

    @FXML
    private TextArea areaCompiti;

    @FXML
    private DatePicker dateHomework;

    @FXML
    private TextArea homeworkDescription;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        UserBean ub = this.getUserBean();
        ProfessorBean pb = this.getProfessorBean();
        ProfessorHomeController phc = new ProfessorHomeController();
        HomeBean hpb = null;
        if (pb == null) {
            try {
                pb = phc.loadMatter(ub.getId());
                hpb = phc.loadPage(ub.getId(), pb.getMatter().getCourse(), pb.getMatter().getMatter());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {

            try {
                hpb = phc.loadPage(ub.getId(), pb.getMatter().getCourse(), pb.getMatter().getMatter());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.setProfessorBean(pb);
        this.setHomeBean(hpb);
        this.setUtils(new Util());

        this.areaCompiti.setText("");
        for (Homework homework : this.getHomeBean().getHomework()) {
            this.areaCompiti.appendText(homework.getDate().toString() + "\n" + homework.getText() + "\n\n");
        }

        this.textAreaArgomenti.setText("");
        for (Argument argument : this.getHomeBean().getArgument()) {
            this.textAreaArgomenti.appendText(argument.getTitle() + "\n" + argument.getText() + "\n\n");
        }

        this.textAreaArgomenti.setText("");
        for (Argument argument : this.getHomeBean().getArgument()) {
            this.textAreaArgomenti.appendText(argument.getTitle() + "\n" + argument.getText() + "\n\n");
        }

        for (Matter materia : this.getProfessorBean().getMatterList()) {
            this.comboCambiaClasse.getItems().add(materia.getMatter() + " " + materia.getCourse());
        }
        this.comboCambiaClasse.getSelectionModel().select(this.getProfessorBean().getMatter().getMatter() + " " + this.getProfessorBean().getMatter().getCourse());


        TableColumn<String, ScheduleForTableViewProf> column1 = new TableColumn<>("Materia");
        column1.setCellValueFactory(new PropertyValueFactory<>("matter"));
        TableColumn<String, ScheduleForTableViewProf> column2 = new TableColumn<>("Giorno");
        column2.setCellValueFactory(new PropertyValueFactory<>("day"));
        TableColumn<String, ScheduleForTableViewProf> column3 = new TableColumn<>("Ora");
        column3.setCellValueFactory(new PropertyValueFactory<>("hour"));


        this.tableSchedule.getColumns().add(column1);
        this.tableSchedule.getColumns().add(column2);
        this.tableSchedule.getColumns().add(column3);

        for(Schedule schedule : this.getHomeBean().getSchedule()){
            ScheduleForTableViewProf scheduleInfo = new ScheduleForTableViewProf(schedule.getMatter(),schedule.getCourse(),schedule.getDay(),schedule.getHour());
            this.tableSchedule.getItems().add(scheduleInfo);
        }

    }

    public void addHomework() throws Exception {
        String dataCompito = this.dateHomework.getValue().toString();
        String descrizioneCompito = this.homeworkDescription.getText();
        String materiaCompito = this.getProfessorBean().getMatter().getMatter();
        String classeCompito = this.getProfessorBean().getMatter().getCourse();
        AssignmentController controller = new AssignmentController();
        Homework hmw = controller.saveNewHomework(descrizioneCompito, materiaCompito, classeCompito, dataCompito);
        this.getHomeBean().getHomework().add(hmw);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../viewFX/professorHome.fxml"));
        AnchorPane pane = loader.load();
        root.getChildren().setAll(pane);
    }

    public void goToRegistro() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../viewFX/profRegistro.fxml"));
        AnchorPane pane = loader.load();
        root.getChildren().setAll(pane);
    }

    public void logout() throws IOException {
        this.setProfessorBean(null);
        this.setHomeBean(null);
        this.setUtils(null);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../viewFX/login.fxml"));
        AnchorPane pane = loader.load();
        root.getChildren().setAll(pane);
    }

    public void cambiaClasse() throws IOException {
        int indexMateria = this.comboCambiaClasse.getSelectionModel().getSelectedIndex();
        this.getProfessorBean().setMatter(this.getProfessorBean().getMatterList().get(indexMateria));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../viewFX/professorHome.fxml"));
        AnchorPane pane = loader.load();
        root.getChildren().setAll(pane);
    }
}
