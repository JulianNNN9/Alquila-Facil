package co.edu.uniquindio.alquilafacil.controllers;

import co.edu.uniquindio.alquilafacil.exceptions.AtributoVacioException;
import co.edu.uniquindio.alquilafacil.exceptions.InformacionRepetidaException;
import co.edu.uniquindio.alquilafacil.model.AlquilaFacil;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.File;
import java.io.IOException;

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
    @FXML
    public Label lblCedula;
    @FXML
    public Label lblNombreCompleto;
    @FXML
    public Label lblNumeroTelefono;
    @FXML
    public Label lblMail;
    @FXML
    public Label lblCiudad;
    @FXML
    public Label lblResidencia;
    @FXML
    public Label lblRegistrarClientes;

    public void initialize(){

        lblRegistrarClientes.setText(alquilaFacil.getResourceBundle().getString("textoLabelRegistrarClientes"));
        lblCedula.setText(alquilaFacil.getResourceBundle().getString("textoLabelCedula"));
        lblNombreCompleto.setText(alquilaFacil.getResourceBundle().getString("textoLabelNombreCompleto"));
        lblNumeroTelefono.setText(alquilaFacil.getResourceBundle().getString("textoLabelNumeroTelefono"));
        lblMail.setText(alquilaFacil.getResourceBundle().getString("textoLabelMail"));
        lblCiudad.setText(alquilaFacil.getResourceBundle().getString("textoLabelCiudad"));
        lblResidencia.setText(alquilaFacil.getResourceBundle().getString("textoLabelDireccionResidencia"));
        btnRegistrarCliente.setText(alquilaFacil.getResourceBundle().getString("textoBotonRegistrarCliente"));

        txtFldCedula.setTextFormatter(alquilaFacil.stringFormatterParaNumeros());
        txtFldNumeroTelefono.setTextFormatter(alquilaFacil.stringFormatterParaNumeros());

    }

    public void onRegistrarClienteClick() throws AtributoVacioException, InformacionRepetidaException, IOException {

        alquilaFacil.registrarCliente(txtFldCedula.getText(), txtFldNombreCompleto.getText(), txtFldNumeroTelefono.getText(), txtFldMail.getText(), txtFldCiudad.getText(), txtFldDireccionResidencia.getText());

        File url = new File("src/main/resources/co/edu/uniquindio/alquilafacil/ventanaPrincipal.fxml");
        FXMLLoader loader = new FXMLLoader(url.toURL());
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        scene.setFill(Color.TRANSPARENT);
        stage.show();

        alquilaFacil.crearAlertaInfo(alquilaFacil.getResourceBundle().getString("textoTituloAlertaInfoRegistroCliente"), alquilaFacil.getResourceBundle().getString("textoAlertaInfoHeader"),alquilaFacil.getResourceBundle().getString("textoContenidoAlertaInfoRegistroCliente") + "'" + txtFldCedula.getText() + "'");

        Stage stage1 = (Stage) this.btnRegistrarCliente.getScene().getWindow();
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
