package co.edu.uniquindio.alquilafacil.controllers;

import co.edu.uniquindio.alquilafacil.exceptions.AtributoVacioException;
import co.edu.uniquindio.alquilafacil.exceptions.ErrorEnIngresoFechasException;
import co.edu.uniquindio.alquilafacil.model.AlquilaFacil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;

public class TotalGanadoController {

    private final AlquilaFacil alquilaFacil = AlquilaFacil.getInstance();

    @FXML
    public Button btnCerrarVentana;
    @FXML
    public DatePicker datePckerFechaInicio;
    @FXML
    public DatePicker datePckerFechaFin;
    @FXML
    public Label lblFechaInicio;
    @FXML
    public Label lblFechaFin;
    @FXML
    public Label lblTotalGanado;
    @FXML
    public Label lblResultado;
    @FXML
    public Button btnCalcular;
    @FXML
    public Label lblCalcularTotalGanado;

    public TotalGanadoController() {
    }

    public void initialize(){

        lblCalcularTotalGanado.setText(alquilaFacil.getResourceBundle().getString("textoLabelTitulo"));
        lblFechaInicio.setText(alquilaFacil.getResourceBundle().getString("textoLabelFechaInicio"));
        lblFechaFin.setText(alquilaFacil.getResourceBundle().getString("textoLabelFechaFin"));
        lblTotalGanado.setText(alquilaFacil.getResourceBundle().getString("textoLabelTotalGanado"));
        btnCalcular.setText(alquilaFacil.getResourceBundle().getString("textoBtnCalcular"));

    }

    public void onCalcularClick() throws AtributoVacioException, ErrorEnIngresoFechasException {
        lblResultado.setText(String.valueOf(alquilaFacil.calcularTotalGanadoEntreFechas(datePckerFechaInicio.getValue(), datePckerFechaFin.getValue())));
    }

    public void onCerrarVentanaClick() throws IOException {

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
