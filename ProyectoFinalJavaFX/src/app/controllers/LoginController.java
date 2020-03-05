package app.controllers;


import app.controllers.MainWindowsController;
import app.ventanas.MainWindows;
import app.ventanas.VentanaLogin;
import app.controllers.Driver_SQL;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginController implements Initializable,EventHandler{
    @FXML
    private TextField usernameLogin;

    @FXML
    private PasswordField passwordLogin;

    @FXML
    private Button buttonLogin;

    @FXML
    private Text tSignL;

    private Driver_SQL driver_sql = new Driver_SQL();
    double x = 0, y =0;
    @FXML
    public void dragged(javafx.scene.input.MouseEvent event) {
        Node node = (Node) event.getSource();

        Stage stage = (Stage) node.getScene().getWindow();

        stage.setX(event.getScreenX() - x);
        stage.setY(event.getScreenY() - y);
    }

    @FXML
    public void pressed(javafx.scene.input.MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();
    }



    @FXML
    public void signup(javafx.scene.input.MouseEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("../views/signup.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        buttonLogin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    boolean login = driver_sql.acceder(usernameLogin.getText(), passwordLogin.getText());
                    if(login){
                        buttonLogin.getScene().getWindow().hide();
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/mainWindows.fxml"));
                        Parent root = loader.load();
                        VentanaLogin ventanaLogin = new VentanaLogin();
                        ventanaLogin.setScene(new Scene(root));
                    }else {
                        Alert alert = new Alert(AlertType.ERROR);
                        alert.setTitle("ERROR");
                        alert.setHeaderText("INICIO DE SESION INCORRECTO");
                        alert.setContentText("Lo sentimos, no se encuentra una cuenta con ese nombre de usuario o contraseña. Por favor, intentalo de nuevo o crea una cuenta.");
                        alert.show();
                    }
                } catch (SQLException | IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }


    @Override
    public void handle(Event event) {
    }
}
