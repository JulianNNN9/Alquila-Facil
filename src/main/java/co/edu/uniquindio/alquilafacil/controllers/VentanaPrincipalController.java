package co.edu.uniquindio.alquilafacil.controllers;

import co.edu.uniquindio.alquilafacil.model.AlquilaFacil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
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
    @FXML
    public Button btnCerrarVentana;


    public void onRegistrarClienteClick(ActionEvent actionEvent) throws IOException {

        File url = new File("src/main/resources/co/edu/uniquindio/alquilafacil/registroCliente.fxml");
        FXMLLoader loader = new FXMLLoader(url.toURL());
        Parent parent = loader.load();

        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        scene.setFill(Color.TRANSPARENT);
        stage.setResizable(false);
        stage.show();

        Stage stage1 = (Stage) this.btnRegistrarCliente.getScene().getWindow();
        stage1.close();

    }

    public void onRegistrarVehiculoClick(ActionEvent actionEvent) throws IOException {

        File url = new File("src/main/resources/co/edu/uniquindio/alquilafacil/registroVehiculo.fxml");
        FXMLLoader loader = new FXMLLoader(url.toURL());
        Parent parent = loader.load();

        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        scene.setFill(Color.TRANSPARENT);
        stage.setResizable(false);
        stage.show();

        Stage stage1 = (Stage) this.btnRegistrarVehiculo.getScene().getWindow();
        stage1.close();
    }

    public void onHacerAlquilerClick(ActionEvent actionEvent) throws IOException {

        File url = new File("src/main/resources/co/edu/uniquindio/alquilafacil/registroAlquiler.fxml");
        FXMLLoader loader = new FXMLLoader(url.toURL());
        Parent parent = loader.load();

        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        scene.setFill(Color.TRANSPARENT);
        stage.setResizable(false);
        stage.show();

        Stage stage1 = (Stage) this.btnHacerAlquiler.getScene().getWindow();
        stage1.close();
    }

    @FXML
    private void onCerrarVentanaClick(ActionEvent event) {
        Stage stage = (Stage) this.btnCerrarVentana.getScene().getWindow();
        stage.close();
    }
}