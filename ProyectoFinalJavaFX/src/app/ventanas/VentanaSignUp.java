package app.ventanas;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;

public class VentanaSignUp extends Stage {
    private String titulo;

    public VentanaSignUp(String titulo){

        this.titulo = titulo;
        initGUI();
    }

    private void initGUI() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../views/signup.fxml"));
            Scene scene = new Scene(root,800,500);
            this.setScene(scene);
            this.setTitle(titulo);
            this.initStyle(StageStyle.DECORATED);
            this.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
