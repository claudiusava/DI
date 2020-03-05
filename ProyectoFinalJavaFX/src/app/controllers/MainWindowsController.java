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
        import javafx.scene.control.Button;
        import javafx.scene.control.TableColumn;
        import javafx.scene.control.TableView;
        import javafx.scene.control.cell.PropertyValueFactory;
        import javafx.stage.Stage;
        import java.io.IOException;
        import java.net.URL;
        import java.sql.Connection;
        import java.sql.PreparedStatement;
        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.util.ResourceBundle;
        import java.util.logging.Level;
        import java.util.logging.Logger;

public class MainWindowsController implements Initializable {


    @FXML
    TableColumn<User, String> tableusername, tablename, tablesurname, tableemail, tablegenre;
    ObservableList <User> datosUsuario;

    @FXML
    TableView table;

    @FXML
    Button buttonDelete;

    User u;


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


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        rellenarDatos();
        cargarUsuarios();
        acciones();
    }

    private void acciones(){
        buttonDelete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                try{
                    u = (User) table.getSelectionModel().getSelectedItem();
                    Driver_SQL.borrar(u.getUser());
                    datosUsuario.remove(u);
                    table.refresh();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    @FXML
    public void signup(javafx.scene.input.MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/app/views/signup.fxml"));

        Node node = (Node) event.getSource();

        Stage stage = (Stage) node.getScene().getWindow();

        stage.setScene(new Scene(root));
    }



    private void rellenarDatos(){

        datosUsuario = FXCollections.observableArrayList();

        tableusername.setCellValueFactory(new PropertyValueFactory<>("user"));
        tablename.setCellValueFactory(new PropertyValueFactory<>("name"));
        tablesurname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        tableemail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tablegenre.setCellValueFactory(new PropertyValueFactory<>("favgenre"));

        table.setItems(datosUsuario);
    }



    private void cargarUsuarios() {

        Connection conexion = null;
        try {
            conexion = Driver_SQL.conectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = conexion.prepareStatement("SELECT user, name, surname, email, favgenre FROM user");
            rs = ps.executeQuery();

            while(rs.next()){
                //System.out.println(rs.getString("favgenre"));
                User usuari = new User(rs.getString("user"),rs.getString("name"),rs.getString("surname"), rs.getString("email"), rs.getString("favgenre"));
                datosUsuario.add(usuari);
                System.out.println(usuari.getFavgenre());
            }

        }catch (SQLException ex) {
            Logger.getLogger(Driver_SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
