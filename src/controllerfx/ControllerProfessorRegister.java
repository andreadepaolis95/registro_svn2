package controllerfx;

import bean.ProfessorBean;
import bean.RegisterBean;
import controller.RegisterController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.Matter;
import model.RegisterRecord;
import model.RegisterStudent;
import model.StudentInfoByRegister;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class ControllerProfessorRegister extends ControllerScenes implements Initializable {

    @FXML
    public AnchorPane rootProfRegistro;
    @FXML
    public TableView tableVoti;
    @FXML
    public ComboBox comboClasse;
    @FXML
    public Button prevMese;
    @FXML
    public Button nextMese;
    @FXML
    public Label curMese;
    @FXML
    public Button buttToday;
    @FXML
    public ComboBox votoStudente;
    @FXML
    public ComboBox votoTipologia;
    @FXML
    public DatePicker votoData;
    @FXML
    public Button votoConferma;
    @FXML
    public ComboBox assenzaStudente;
    @FXML
    public ComboBox assenzaTipologia;
    @FXML
    public DatePicker assenzaData;
    @FXML
    public Button assenzaConferma;
    @FXML
    public TextField textVoto;



    private static final String URLREGISTRO = "../viewFX/profRegistro.fxml";

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ProfessorBean pb = this.getProfessorBean();
        RegisterController controller = new RegisterController();

        if(this.lastComReg.equals("primo_avvio") || this.lastComReg.equals("cambio_classe")) {
            try {
                RegisterBean register = controller.initialize(pb.getMatter().getCourse(), pb.getMatter().getMatter());
                this.setRegister(register);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(this.lastComReg.equals("prev_mese") || this.lastComReg.equals("next_mese") || this.lastComReg.equals("curr_mese")){
            try {
                this.getRegister().setStudents(controller.filterForMonth(register.getStudents(), pb.getMatter().getMatter(), register.getMonth()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }



        TableColumn<String, StudentInfoByRegister> column1 = new TableColumn<>("Student Name");
        column1.setCellValueFactory(new PropertyValueFactory<>("fullname"));
        TableColumn<String, StudentInfoByRegister> column2 = new TableColumn<>("Type Report");
        column2.setCellValueFactory(new PropertyValueFactory<>("typeReport"));
        TableColumn<String, StudentInfoByRegister> column3 = new TableColumn<>("Value Report");
        column3.setCellValueFactory(new PropertyValueFactory<>("valueReport"));
        TableColumn<String, StudentInfoByRegister> column4 = new TableColumn<>("Date Report");
        column4.setCellValueFactory(new PropertyValueFactory<>("dateReport"));


        this.tableVoti.getColumns().add(column1);
        this.tableVoti.getColumns().add(column2);
        this.tableVoti.getColumns().add(column3);
        this.tableVoti.getColumns().add(column4);

        for(RegisterStudent student : this.getRegister().getStudents()){
            for(RegisterRecord record : student.getRecord()){
                StudentInfoByRegister studentInfo = new StudentInfoByRegister(student.getFullname(),record.getType(),record.getValue(),record.getDateFormatted());
                this.tableVoti.getItems().add(studentInfo);
            }
        }

        for(Matter materia : pb.getMatterList()){
            this.comboClasse.getItems().add(materia.getMatter() + " " + materia.getCourse());
        }
        this.comboClasse.getSelectionModel().select(pb.getMatter().getMatter() + " " + pb.getMatter().getCourse());

        this.curMese.setText(this.getRegister().getMonth().getName());

        for(RegisterStudent student : this.getRegister().getStudents()){
            this.votoStudente.getItems().add(student);
        }

        this.votoTipologia.getItems().add("written");
        this.votoTipologia.getItems().add("oral");
        this.votoTipologia.getItems().add("lab");

        for(RegisterStudent student : this.getRegister().getStudents()){
            this.assenzaStudente.getItems().add(student);
        }

        this.assenzaTipologia.getItems().add("ritardo");
        this.assenzaTipologia.getItems().add("absence");

    }

    public void cambiaClasse() throws IOException {
        int indexMateria = this.comboClasse.getSelectionModel().getSelectedIndex();
        this.getProfessorBean().setMatter(this.getProfessorBean().getMatterList().get(indexMateria));
        this.lastComReg = "cambio_classe";
        FXMLLoader loader = new FXMLLoader(getClass().getResource(URLREGISTRO));
        AnchorPane pane = loader.load();
        rootProfRegistro.getChildren().setAll(pane);
    }

    public void goToPrevMese() throws IOException {
        RegisterController controller = new RegisterController();
        this.getRegister().setMonth(controller.changeMonth(this.getRegister().getMonth(), -1));
        this.lastComReg = "prev_mese";
        FXMLLoader loader = new FXMLLoader(getClass().getResource(URLREGISTRO));
        AnchorPane pane = loader.load();
        rootProfRegistro.getChildren().setAll(pane);
    }

    public void goToNextMese() throws IOException {
        RegisterController controller = new RegisterController();
        register.setMonth(controller.changeMonth(register.getMonth(), +1));
        this.lastComReg = "next_mese";
        FXMLLoader loader = new FXMLLoader(getClass().getResource(URLREGISTRO));
        AnchorPane pane = loader.load();
        rootProfRegistro.getChildren().setAll(pane);
    }

    public void goToToday() throws IOException {
        RegisterController controller = new RegisterController();
        register.setMonth(controller.getCurrentMont());
        this.lastComReg = "curr_mese";
        FXMLLoader loader = new FXMLLoader(getClass().getResource(URLREGISTRO));
        AnchorPane pane = loader.load();
        rootProfRegistro.getChildren().setAll(pane);
    }

    public void addVoto() throws Exception {
        RegisterController rg = new RegisterController();
        RegisterRecord rr;

        String id = ((RegisterStudent) votoStudente.getSelectionModel().getSelectedItem()).getId();
        String numb = textVoto.getText();
        String d = votoData.getValue().toString();
        String type = votoTipologia.getSelectionModel().getSelectedItem().toString();
        rr = rg.newMark(id, numb, d, type, this.getProfessorBean().getMatter().getMatter());

        for (RegisterStudent std : this.getRegister().getStudents()) {
            if (std.getId().equals(id)) {
                std.getRecord().add(rr);
                std.setMedia(rg.calculateMedia(std.getId(), this.getProfessorBean().getMatter().getMatter()));
            }
        }
        FXMLLoader loader = new FXMLLoader(getClass().getResource(URLREGISTRO));
        AnchorPane pane = loader.load();
        rootProfRegistro.getChildren().setAll(pane);
    }

    public void addAbsence() throws Exception {
        RegisterController rg = new RegisterController();
        RegisterRecord rr;

        String id = ((RegisterStudent) assenzaStudente.getSelectionModel().getSelectedItem()).getId();
        String d = assenzaData.getValue().toString();
        String type = assenzaTipologia.getSelectionModel().getSelectedItem().toString();
        rr = rg.newAbsence(id, type, d);

        for (RegisterStudent std : this.getRegister().getStudents()) {
            if (std.getId().equals(id)) {
                std.getRecord().add(rr);
                std.setMedia(rg.calculateMedia(std.getId(), this.getProfessorBean().getMatter().getMatter()));
            }
        }
        FXMLLoader loader = new FXMLLoader(getClass().getResource(URLREGISTRO));
        AnchorPane pane = loader.load();
        rootProfRegistro.getChildren().setAll(pane);
    }

    public void goToLogout() throws IOException {
        this.setRegister(null);
        this.setProfessorBean(null);
        this.setHomeBean(null);
        this.setUtils(null);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../viewFX/login.fxml"));
        AnchorPane pane = loader.load();
        rootProfRegistro.getChildren().setAll(pane);
    }

    public void goToHomePage() throws IOException {
        this.setRegister(null);
        this.lastComReg = "primo_avvio";
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../viewFX/professorHome.fxml"));
        AnchorPane pane = loader.load();
        rootProfRegistro.getChildren().setAll(pane);
    }
}

