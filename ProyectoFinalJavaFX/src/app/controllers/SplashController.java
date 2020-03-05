package app.controllers;

import app.controllers.LoginController;
import app.ventanas.VentanaLogin;
import javafx.animation.FadeTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class SplashController implements Initializable {

    @FXML
    ImageView imagenSplash;


    @Override
    public void initialize(URL location, ResourceBundle resources) {


        FadeTransition transition = new FadeTransition(Duration.seconds(4),imagenSplash);
        transition.setToValue(1.0);
        transition.setFromValue(0.0);
        transition.play();

        transition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                VentanaLogin ventanaLogin = new VentanaLogin();
                Stage stage = (Stage) imagenSplash.getScene().getWindow();
                stage.hide();
            }
        });
    }
}
