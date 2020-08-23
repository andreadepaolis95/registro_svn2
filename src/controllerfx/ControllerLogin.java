package controllerfx;

import bean.UserBean;
import controller.LoginController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;


public class ControllerLogin extends ControllerScenes implements Initializable {

    @FXML
    public TextField usernameStudente;

    @FXML
    public TextField usernameProf;

    @FXML
    private PasswordField passwordStudente;

    @FXML
    private AnchorPane root;

    @FXML
    private Label isRightProf;

    @FXML
    private PasswordField passwordProf;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.usernameProf.setText("fab");
        this.passwordProf.setText("123");
        this.usernameStudente.setText("alberto");
        this.passwordStudente.setText("123");

    }
    @FXML
    public void loginStudent() throws Exception {
        LoginController lg = new LoginController();
        UserBean u = lg.handleLogin(usernameStudente.getText(), passwordStudente.getText(), false);
        if(u != null){
            this.setUserBean(u);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../viewFX/homeStudent.fxml"));
            AnchorPane pane = loader.load();
            root.getChildren().setAll(pane);
        }else{
            isRightProf.setText("Non Trovato");
        }
    }

    @FXML
    public void loginProf() throws Exception {
        LoginController lg = new LoginController();
        UserBean u = lg.handleLogin(usernameProf.getText(), passwordProf.getText(), true);
        if(u != null){
            this.setUserBean(u);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../viewFX/professorHome.fxml"));
            AnchorPane pane = loader.load();
            root.getChildren().setAll(pane);
        }else{
            isRightProf.setText("Non Trovato");
        }
    }
}
