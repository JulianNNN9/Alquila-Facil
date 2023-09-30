package co.edu.uniquindio.alquilafacil.controllers;

import co.edu.uniquindio.alquilafacil.model.AlquilaFacil;
import co.edu.uniquindio.alquilafacil.model.Vehiculo;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class RegistroAlquilerController {

    private final AlquilaFacil alquilaFacil = AlquilaFacil.getInstance();

    @FXML
    public TextField txtFldCedulaCliente;
    @FXML
    public DatePicker txtFldFechaAlquier;
    @FXML
    public DatePicker txtFldFechaRegreso;
    @FXML
    public DatePicker txtFldFechaRegistro;
    @FXML
    public TextField txtFldValorTotal;
    @FXML
    public Button btnCerrarVentana;
    @FXML
    public Button btnRegistrarAlquier;
    @FXML
    public TableColumn<Vehiculo, Vehiculo> colPlaca;
    @FXML
    public TableColumn<Vehiculo, Vehiculo> colReferencia;
    @FXML
    public TableColumn<Vehiculo, Vehiculo> colMarca;
    @FXML
    public TableColumn<Vehiculo, Vehiculo> colModelo;
    @FXML
    public TableColumn<Vehiculo, Vehiculo> colKilometraje;
    @FXML
    public TableColumn<Vehiculo, Vehiculo> colAlquilerXDia;
    @FXML
    public TableColumn<Vehiculo, Vehiculo> colAutomatico;
    @FXML
    public TableColumn<Vehiculo, Vehiculo> colNumeroAsientos;
    @FXML
    public TableView<Vehiculo> tablaVehiculos;

    /*
    public void initialize(){
        this.tablaVehiculos.setItems((ObservableList<Vehiculo>) alquilaFacil.getVehiculos());
    }
    */

}
