package controllerfx;

import bean.HomeBean;
import bean.StudentBean;
import bean.UserBean;
import bean.Util;
import controller.StudentHomeController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.*;

import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;


public class ControllerHomeStudentFX extends ControllerScenes implements Initializable {
    @FXML
    private Label labelWelcomeStudent;
    @FXML
    private TextArea tabelHomework;
    @FXML
    private TableView tableSchedule;
    @FXML
    private Label labelDataHomework;
    @FXML
    private AnchorPane rootHomeStudent;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        UserBean ub = this.getUserBean();

        if(this.lastComStudent.equals("primo_avvio")) {
            StudentHomeController shc = new StudentHomeController();
            StudentBean sb = null;
            HomeBean hb = null;
            try {
                sb = shc.loadStudentInfo(ub.getCourse());
                sb.setSelectedMatter(sb.getMatters().get(0));
                hb = shc.loadHomeInfo(ub.getCourse(), sb.getSelectedMatter());
            } catch (Exception e) {
                e.printStackTrace();
            }

            this.setStudent(sb);
            this.setHomeBean(hb);
            this.setUtils(new Util());
        }
        else{
            StudentHomeController controller = new StudentHomeController();


            HomeBean hb = this.getHomeBean();
            StudentBean sb= this.getCurrentStudent();

            String cmd = this.lastComStudent;
            if(cmd.equals("sub") || cmd.equals("add")) {
                int amount = cmd.equals("add") ? +7 : -7;

                Calendar cal = Calendar.getInstance();
                cal.setTime(sb.getSelectedDay());
                cal.add(Calendar.DATE, amount);
                Date d = cal.getTime();
                try {
                    hb.setHomework(controller.scrollHomework(ub.getCourse(), sb.getSelectedDay(), d));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                sb.setSelectedDay(d);
                this.setHomeBean(hb);
                this.setStudent(sb);
            }
        }


        this.tabelHomework.setText("");
        for(Homework homework : this.getHomeBean().getHomework()){
            this.tabelHomework.appendText(homework.getMatter() + " " + homework.getDate() + ":\n" +"   " +homework.getText() +"\n\n");
        }

        this.labelDataHomework.setText(this.getCurrentStudent().printDate());
        this.labelWelcomeStudent.setText(this.getCurrentStudent().getFullName());


        TableColumn<String, SchedulerForTableView> column1 = new TableColumn<>("Materia");
        column1.setCellValueFactory(new PropertyValueFactory<>("matter"));
        TableColumn<String, SchedulerForTableView> column2 = new TableColumn<>("Giorno");
        column2.setCellValueFactory(new PropertyValueFactory<>("day"));
        TableColumn<String, SchedulerForTableView> column3 = new TableColumn<>("Ora");
        column3.setCellValueFactory(new PropertyValueFactory<>("hour"));


        this.tableSchedule.getColumns().add(column1);
        this.tableSchedule.getColumns().add(column2);
        this.tableSchedule.getColumns().add(column3);

        for(Schedule schedule : this.getHomeBean().getSchedule()){
            SchedulerForTableView scheduleInfo = new SchedulerForTableView(schedule.getMatter(),schedule.getDay(),schedule.getHour());
            this.tableSchedule.getItems().add(scheduleInfo);
        }
    }

    public void logout() throws IOException {
        this.setStudent(null);
        this.setHomeBean(null);
        this.setUtils(null);
        this.lastComStudent = "primo_avvio";
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../viewFX/login.fxml"));
        AnchorPane pane = loader.load();
        rootHomeStudent.getChildren().setAll(pane);
    }

    public void goToAbsences() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../viewFX/absencesStudent.fxml"));
        AnchorPane pane = loader.load();
        rootHomeStudent.getChildren().setAll(pane);
    }

    public void goToGrades() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../viewFX/gradesStudent.fxml"));
        AnchorPane pane = loader.load();
        rootHomeStudent.getChildren().setAll(pane);
    }

    public void goDayBefore() throws IOException {
        this.lastComStudent = "sub";
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../viewFX/homeStudent.fxml"));
        AnchorPane pane = loader.load();
        rootHomeStudent.getChildren().setAll(pane);
    }

    public void goToDayAfter() throws IOException {
        this.lastComStudent = "add";
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../viewFX/homeStudent.fxml"));
        AnchorPane pane = loader.load();
        rootHomeStudent.getChildren().setAll(pane);
    }

}
