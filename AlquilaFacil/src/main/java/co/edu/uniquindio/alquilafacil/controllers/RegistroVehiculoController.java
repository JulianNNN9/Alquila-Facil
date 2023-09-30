package co.edu.uniquindio.alquilafacil.controllers;

import co.edu.uniquindio.alquilafacil.exceptions.InformacionRepetidaException;
import co.edu.uniquindio.alquilafacil.exceptions.NumeroNegativoException;
import co.edu.uniquindio.alquilafacil.model.AlquilaFacil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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
    public Button btnRegistrarVehiculo;
    @FXML
    public Button btnCerrarVentana;

    public void onRegistrarVehiculoClick(ActionEvent actionEvent) throws NumeroNegativoException, InformacionRepetidaException {
        alquilaFacil.registrarVehiculo(txtFldPlaca.getText(), txtFldReferencia.getText(), txtFldMarca.getText(), txtFldModelo.getText(), txtFldKilometraje.getText(), Double.valueOf(txtFldPrecioAlquierPorDia.getText()), txtFldAutomatico.getText(), txtFldNumeroAsientos.getText());
    }
}
