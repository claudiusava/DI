package app.controllers;

import app.utils.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
//import org.graalvm.compiler.lir.LIRInstruction;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {


    @FXML
    private TextField usernameSignUp, nameSignUp, surnameSignUp, emailSignUp, passwordSignUp;

    @FXML
    private ComboBox comboGenre;
    ObservableList<String> generos = FXCollections.observableArrayList("Documental", "Biográfico", "Histórico", "Musical", "Comedia", "Infantil", "Western",
            "Aventura y acción", "Bélico", "Ciencia ficción", "Drama", "Suspense", "Terror", "Erótico");

    @FXML
    private Button buttonSignUp;

    @FXML
    private Text textLogin;




    double x = 0, y =0;
    @FXML
    public void pressed(javafx.scene.input.MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();
    }


    @FXML
    public void dragged(javafx.scene.input.MouseEvent event) {
        Node node = (Node) event.getSource();

        Stage stage = (Stage) node.getScene().getWindow();

        stage.setX(event.getScreenX() - x);
        stage.setY(event.getScreenY() - y);
    }


    @FXML
    public void login(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/app/views/login.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(root));
    }


    /*
    @Override
    public void handle(Event event) {
        if(event.getSource() == buttonSignUp){
            Controller c = new Controller();
            User u = new User(usernameSignUp.getText(),emailSignUp.getText(),passwordSignUp.getText());
            try {
                c.agregar(u);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
*/


    private void resetTFs(){
        usernameSignUp.setText("");
        emailSignUp.setText("");
        passwordSignUp.setText("");
        nameSignUp.setText("");
        surnameSignUp.setText("");
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {


        comboGenre.setItems(generos);

            buttonSignUp.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {

                    Driver_SQL c = new Driver_SQL();
                    User u = new User(usernameSignUp.getText(), emailSignUp.getText(), passwordSignUp.getText(), nameSignUp.getText(), surnameSignUp.getText(), (String) comboGenre.getValue());
                    try {
                        if (usernameSignUp.getText().isEmpty() || emailSignUp.getText().isEmpty() || passwordSignUp.getText().isEmpty() || nameSignUp.getText().isEmpty() || surnameSignUp.getText().isEmpty()) {

                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("ERROR");
                            alert.setHeaderText("REGISTRO INCORRECTO!");
                            alert.setContentText("Por favor, rellena todos los campos.");
                            alert.show();
                        } else {
                            c.agregar(u);
                            resetTFs();
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("REGISTRO");
                            alert.setHeaderText("REGISTRO CORRECTO");
                            alert.setContentText("El ususario ha sido introducido.");
                            alert.show();
                        }
                    } catch (SQLException e) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERROR");
                        alert.setHeaderText("REGISTRO NO REALIZADO!");
                        alert.setContentText("Intentelo de nuevo y asegurate de completar todos los campos.");
                        alert.show();
                    }
                }
            });
        }
}
