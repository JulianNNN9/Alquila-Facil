package co.edu.uniquindio.alquilafacil.controllers;

import co.edu.uniquindio.alquilafacil.exceptions.AtributoVacioException;
import co.edu.uniquindio.alquilafacil.exceptions.InformacionRepetidaException;
import co.edu.uniquindio.alquilafacil.model.AlquilaFacil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class RegistroClienteController {

    private final AlquilaFacil alquilaFacil = AlquilaFacil.getInstance();

    @FXML
    public Button btnRegistrarCliente;
    @FXML
    public Button btnCerrarVentana;
    @FXML
    public TextField txtFldCedula;
    @FXML
    public TextField txtFldNombreCompleto;
    @FXML
    public TextField txtFldNumeroTelefono;
    @FXML
    public TextField txtFldMail;
    @FXML
    public TextField txtFldCiudad;
    @FXML
    public TextField txtFldDireccionResidencia;

    public void onRegistrarClienteClick(ActionEvent actionEvent) throws AtributoVacioException, InformacionRepetidaException {
        alquilaFacil.registrarCliente(txtFldCedula.getText(), txtFldNombreCompleto.getText(), txtFldNumeroTelefono.getText(), txtFldMail.getText(), txtFldCiudad.getText(), txtFldDireccionResidencia.getText());
    }
}
