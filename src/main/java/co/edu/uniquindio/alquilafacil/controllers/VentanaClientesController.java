package co.edu.uniquindio.alquilafacil.controllers;

import co.edu.uniquindio.alquilafacil.model.AlquilaFacil;
import co.edu.uniquindio.alquilafacil.model.Cliente;
import co.edu.uniquindio.alquilafacil.model.Vehiculo;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;

public class VentanaClientesController {

    private final AlquilaFacil alquilaFacil = AlquilaFacil.getInstance();

    @FXML
    public Label lblTituloClientesVentana;
    @FXML
    public TableColumn<Cliente, Cliente> colCedula;
    @FXML
    public TableColumn<Cliente, Cliente> colNombre;
    @FXML
    public TableColumn<Cliente, Cliente> colTelefono;
    @FXML
    public TableColumn<Cliente, Cliente> colEmail;
    @FXML
    public TableColumn<Cliente, Cliente> colCiudad;
    @FXML
    public TableColumn<Cliente, Cliente> colDireccion;
    @FXML
    public TableView<Cliente> tablaClientes;

    @FXML
    public Button btnCerrarVentana;

    public void initialize(){

        lblTituloClientesVentana.setText(alquilaFacil.getResourceBundle().getString("textoTablaClientesTitulo"));
        colCedula.setText(alquilaFacil.getResourceBundle().getString("textoLabelColCedula"));
        colNombre.setText(alquilaFacil.getResourceBundle().getString("textoLabelColNombre"));
        colTelefono.setText(alquilaFacil.getResourceBundle().getString("textoLabelColTelefono"));
        colEmail.setText(alquilaFacil.getResourceBundle().getString("textoLabelColEmail"));
        colCiudad.setText(alquilaFacil.getResourceBundle().getString("textoLabelColCiudad"));
        colDireccion.setText(alquilaFacil.getResourceBundle().getString("textoLabelColDireccion"));

        ObservableList<Cliente> observableList = tablaClientes.getItems();
        observableList.addAll(alquilaFacil.getClientes());

        this.colCedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        this.colNombre.setCellValueFactory(new PropertyValueFactory<>("nombreCompleto"));
        this.colTelefono.setCellValueFactory(new PropertyValueFactory<>("nroTelefono"));
        this.colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        this.colCiudad.setCellValueFactory(new PropertyValueFactory<>("ciudad"));
        this.colDireccion.setCellValueFactory(new PropertyValueFactory<>("direccionResidencia"));

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
