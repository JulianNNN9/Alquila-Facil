package co.edu.uniquindio.alquilafacil.controllers;

import co.edu.uniquindio.alquilafacil.model.AlquilaFacil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import lombok.extern.java.Log;

import java.io.File;
import java.io.IOException;

public class VentanaPrincipalController {
    private final AlquilaFacil alquilaFacil = AlquilaFacil.getInstance();
    @FXML
    public Button btnRegistrarCliente;
    @FXML
    public Button btnRegistrarVehiculo;
    @FXML
    public Button btnHacerAlquiler;


    public void onRegistrarClienteClick(ActionEvent actionEvent) throws IOException {

        File url = new File("src/main/resources/co/edu/uniquindio/alquilafacil/registroCliente.fxml");
        FXMLLoader loader = new FXMLLoader(url.toURL());
        Parent parent = loader.load();

        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

    }

    public void onRegistrarVehiculoClick(ActionEvent actionEvent) throws IOException {

        File url = new File("src/main/resources/co/edu/uniquindio/alquilafacil/registroVehiculo.fxml");
        FXMLLoader loader = new FXMLLoader(url.toURL());
        Parent parent = loader.load();

        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

    }

    public void onHacerAlquilerClick(ActionEvent actionEvent) throws IOException {

        File url = new File("src/main/resources/co/edu/uniquindio/alquilafacil/registroAlquiler.fxml");
        FXMLLoader loader = new FXMLLoader(url.toURL());
        Parent parent = loader.load();

        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();


    }
}