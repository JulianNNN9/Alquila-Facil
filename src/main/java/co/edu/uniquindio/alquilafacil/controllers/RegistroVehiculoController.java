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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.converter.IntegerStringConverter;
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
    @FXML
    public Label lblPlaca;
    @FXML
    public Label lblReferencia;
    @FXML
    public Label lblMarca;
    @FXML
    public Label lblModelo;
    @FXML
    public Label lblKilometraje;
    @FXML
    public Label lblPrecioAlquilerXDia;
    @FXML
    public Label lblAutomatico;
    @FXML
    public Label lblNumeroAsientos;
    @FXML
    public Label lblRutaImagen;
    @FXML
    public Label lblRegistrarClientes;

    public void initialize(){

        lblRegistrarClientes.setText(alquilaFacil.getResourceBundle().getString("textoLabelRegistrarVehiculos"));
        lblPlaca.setText(alquilaFacil.getResourceBundle().getString("textoLabelPlaca"));
        lblReferencia.setText(alquilaFacil.getResourceBundle().getString("textoLabelReferencia"));
        lblMarca.setText(alquilaFacil.getResourceBundle().getString("textoLabelMarca"));
        lblModelo.setText(alquilaFacil.getResourceBundle().getString("textoLabelModelo"));
        lblKilometraje.setText(alquilaFacil.getResourceBundle().getString("textoLabelKilometraje"));
        lblPrecioAlquilerXDia.setText(alquilaFacil.getResourceBundle().getString("textoLabelPrecioAlquilerPorDia"));
        lblAutomatico.setText(alquilaFacil.getResourceBundle().getString("textoLabelAutomatico"));
        lblNumeroAsientos.setText(alquilaFacil.getResourceBundle().getString("textoLabelNumeroAsientos"));
        lblRutaImagen.setText(alquilaFacil.getResourceBundle().getString("textoLabelRutaImagen"));
        btnRegistrarVehiculo.setText(alquilaFacil.getResourceBundle().getString("textoBotonRegistrarVehiculo"));

        TextFormatter<Integer> textFormatter = new TextFormatter<>(new IntegerStringConverter(), 0, change -> {
            String nuevoTexto = change.getControlNewText();
            if (nuevoTexto.matches("[0-9]*")) {
                return change;
            }
            alquilaFacil.crearAlertaInfo(alquilaFacil.getResourceBundle().getString("textoTituloAlertaInfoIngresoValoresNumericos"), alquilaFacil.getResourceBundle().getString("textoAlertaInfoHeader"),alquilaFacil.getResourceBundle().getString("textoContenidoAlertaInfoIngresoValoresNumericos"));
            return null;
        });

        txtFldPrecioAlquierPorDia.setTextFormatter(textFormatter);

    }

    public void onRegistrarVehiculoClick() throws NumeroNegativoException, InformacionRepetidaException, AtributoVacioException, IOException {

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

        alquilaFacil.crearAlertaInfo(alquilaFacil.getResourceBundle().getString("textoTituloAlertaInfoRegistroVehiculo"), alquilaFacil.getResourceBundle().getString("textoAlertaInfoHeader"),alquilaFacil.getResourceBundle().getString("textoContenidoAlertaInfoRegistroVehiculo") + "'" + txtFldPlaca.getText() + "'");

        Stage stage1 = (Stage) this.btnRegistrarVehiculo.getScene().getWindow();
        stage1.close();
    }

    @FXML
    private void onCerrarVentanaClick() throws IOException {

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
