package app.controllers;

import app.utils.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Driver_SQL {
    private static Connection conexion = null;
    private String rutaJSON;

    public Driver_SQL() {
        try {
            conectar();
        } catch (SQLException ex) {
            Logger.getLogger(Driver_SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



    static Connection conectar() throws SQLException {
        conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "");
        return conexion;
    }



    public boolean acceder(String user, String password) throws SQLException {
            String sql = "SELECT * FROM user WHERE user='" + user + "' && password = '" + password + "'";
            ResultSet rs = conexion.prepareStatement(sql).executeQuery();

        if (rs.next()) {
            rutaJSON = rs.getString("User");
            return true;
        }

            return false;
    }


    public void agregar(User u) throws SQLException {
        String sql = "INSERT INTO user (user, email, password, name, surname, favgenre) values (?,?,?,?,?,?)";
        PreparedStatement ps = (PreparedStatement) conexion.prepareStatement(sql);
        ps.setString(1, u.getUser());
        ps.setString(2, u.getEmail());
        ps.setString(3, u.getPassword());
        ps.setString(4, u.getName());
        ps.setString(5, u.getSurname());
        ps.setString(6, u.getFavgenre());

        ps.executeUpdate();
    }


    public static void borrar(String user) throws SQLException {
        String sql = "DELETE FROM user WHERE user = '" + user + "';";

        PreparedStatement ps = (PreparedStatement) conexion.prepareStatement(sql);
        ps.executeUpdate();
    }


    private void desconectar() throws SQLException {
        conexion.close();
    }

    public String getRutaJSON() {
        return rutaJSON;
    }

}
