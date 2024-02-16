package com.tipicocantabria.sigpymeadv;

import com.tipicocantabria.sigpymeadv.conexion.Conexion;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.IOException;
import java.sql.Connection;

public class PrincipalController {

    @FXML
    private TextField idUsuario;

    @FXML
    private PasswordField idPassword;

    @FXML

    private void identificarse(ActionEvent event) throws IOException {

        Conexion.setUserName(idUsuario.getText());
        Conexion.setPassword(idPassword.getText());
        Connection  con;
        con = Conexion.conexionFilemaer();
        if(Conexion.estado=="si") {
            leerVentana("pantallaPrincipal.fxml", event);
        }

    }
    private void leerVentana(String url, Event event) throws IOException {

        ((Node)(event.getSource())).getScene().getWindow().hide();

        Parent root = FXMLLoader.load(getClass().getResource(url));
        Scene scene = new Scene((root), 1100,800);

        Stage nuevoStage = new Stage();
        nuevoStage.setScene(scene);
        nuevoStage.setTitle("Pantalla Principal");
        nuevoStage.show();
    }

}