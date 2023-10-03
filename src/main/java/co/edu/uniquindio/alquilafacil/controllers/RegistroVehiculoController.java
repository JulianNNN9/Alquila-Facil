package co.edu.uniquindio.alquilafacil.controllers;

import co.edu.uniquindio.alquilafacil.exceptions.AtributoVacioException;
import co.edu.uniquindio.alquilafacil.exceptions.InformacionRepetidaException;
import co.edu.uniquindio.alquilafacil.exceptions.NumeroNegativoException;
import co.edu.uniquindio.alquilafacil.model.AlquilaFacil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;

public class RegistroVehiculoController {

    private final AlquilaFacil alquilaFacil = AlquilaFacil.getInstance();

    @FXML
    public TextField txtFldPlaca;
    @FXML
    public TextField txtFldReferencia;
    @FXML
    public TextField txtFldMarca;
    @FXML
    public TextField txtFldModelo;
    @FXML
    public TextField txtFldKilometraje;
    @FXML
    public TextField txtFldPrecioAlquierPorDia;
    @FXML
    public TextField txtFldAutomatico;
    @FXML
    public TextField txtFldNumeroAsientos;
    @FXML
    public TextField txtFldImagePath;
    @FXML
    public Button btnRegistrarVehiculo;
    @FXML
    public Button btnCerrarVentana;

    public void onRegistrarVehiculoClick(ActionEvent actionEvent) throws NumeroNegativoException, InformacionRepetidaException, AtributoVacioException, IOException {

        alquilaFacil.registrarVehiculo(txtFldPlaca.getText(), txtFldReferencia.getText(), txtFldMarca.getText(), txtFldModelo.getText(), txtFldKilometraje.getText(), Double.valueOf(txtFldPrecioAlquierPorDia.getText()), txtFldAutomatico.getText(), txtFldNumeroAsientos.getText(), txtFldImagePath.getText());

        File url = new File("src/main/resources/co/edu/uniquindio/alquilafacil/ventanaPrincipal.fxml");
        FXMLLoader loader = new FXMLLoader(url.toURL());
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        scene.setFill(Color.TRANSPARENT);
        stage.show();

        alquilaFacil.crearAlertaInfo("Registro de vehiculo", "Se ha registrado un vehiculo con la placa '" + txtFldPlaca.getText() + "'");

        Stage stage1 = (Stage) this.btnRegistrarVehiculo.getScene().getWindow();
        stage1.close();
    }

    @FXML
    private void onCerrarVentanaClick(ActionEvent event) throws IOException {

        File url = new File("src/main/resources/co/edu/uniquindio/alquilafacil/ventanaPrincipal.fxml");
        FXMLLoader loader = new FXMLLoader(url.toURL());
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        scene.setFill(Color.TRANSPARENT);
        stage.show();

        Stage stage1 = (Stage) this.btnCerrarVentana.getScene().getWindow();
        stage1.close();
    }
}
