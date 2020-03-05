package app.ventanas;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class VentanaLogin extends Stage {
    public VentanaLogin() {

        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("../views/login.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root,800,800);
        this.setScene(scene);
        this.show();
    }
}
