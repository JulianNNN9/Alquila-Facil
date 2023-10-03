package co.edu.uniquindio.alquilafacil.controllers;

import co.edu.uniquindio.alquilafacil.exceptions.AtributoVacioException;
import co.edu.uniquindio.alquilafacil.exceptions.ErrorEnIngresoFechasException;
import co.edu.uniquindio.alquilafacil.model.AlquilaFacil;
import co.edu.uniquindio.alquilafacil.model.Vehiculo;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.converter.IntegerStringConverter;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import static java.util.concurrent.TimeUnit.DAYS;

public class RegistroAlquilerController {

    /*

    ---------------FUNCIONES POR IMPLEMENTAR-----------------

    - Debe validar que el vehículo elegido esté disponible en la fecha que se requiere.

    - Escriba un método que retorne el total ganado por alquileres de vehículos durante un rango de fechas.

    - Escriba un método que retorne la marca de vehículo que más se alquila.

     */

    private final AlquilaFacil alquilaFacil = AlquilaFacil.getInstance();

    @FXML
    public TextField txtFldCedulaCliente;
    @FXML
    public DatePicker txtFldFechaAlquier;
    @FXML
    public DatePicker txtFldFechaRegreso;
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
    @FXML
    public Button btnCalcularValorTotal;

    @FXML
    private ImageView imageView;

    public void initialize(){
        ObservableList<Vehiculo> observableList = tablaVehiculos.getItems();
        observableList.addAll(alquilaFacil.getVehiculos());

        this.colPlaca.setCellValueFactory(new PropertyValueFactory<>("placa"));
        this.colReferencia.setCellValueFactory(new PropertyValueFactory<>("referencia"));
        this.colMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        this.colModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        this.colKilometraje.setCellValueFactory(new PropertyValueFactory<>("kilometraje"));
        this.colAlquilerXDia.setCellValueFactory(new PropertyValueFactory<>("precioAlquilerPorDia"));
        this.colAutomatico.setCellValueFactory(new PropertyValueFactory<>("automatico"));
        this.colNumeroAsientos.setCellValueFactory(new PropertyValueFactory<>("numeroAsientos"));

        tablaVehiculos.addEventHandler(MouseEvent.MOUSE_CLICKED, (mouseEvent -> {
            String selectedItem = tablaVehiculos.getSelectionModel().getSelectedItem().getImagenPath();
            Image image = new Image(selectedItem);
            imageView.setImage(image);
        }));

        TextFormatter<Integer> textFormatter = new TextFormatter<>(new IntegerStringConverter(), 0, change -> {
            String nuevoTexto = change.getControlNewText();
            if (nuevoTexto.matches("[0-9]*")) {
                return change;
            }
            alquilaFacil.crearAlertaInfo("Error en el ingreso de datos", "Solo se pueden ingresar valores numericos.");
            return null;
        });

        txtFldValorTotal.setTextFormatter(textFormatter);

    }

    public void onRegistrarAlquilerClick(ActionEvent actionEvent) throws ErrorEnIngresoFechasException, AtributoVacioException, IOException {

        alquilaFacil.registrarAlquiler(txtFldCedulaCliente.getText(), colPlaca.getCellObservableValue(tablaVehiculos.getSelectionModel().getFocusedIndex()).toString(), txtFldFechaAlquier.getValue(), txtFldFechaRegreso.getValue(), LocalDate.now(), Double.parseDouble(txtFldValorTotal.getText()));

        File url = new File("src/main/resources/co/edu/uniquindio/alquilafacil/ventanaPrincipal.fxml");
        FXMLLoader loader = new FXMLLoader(url.toURL());
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        scene.setFill(Color.TRANSPARENT);
        stage.show();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("FACTURA");
        alert.setHeaderText("Se ha hecho el alquiler con éxito");
        alert.setContentText("Cédula cliente: " + txtFldCedulaCliente.getText() + "\n" +
                "Placa del vehiculo: " + colPlaca.getCellObservableValue(tablaVehiculos.getSelectionModel().getFocusedIndex()).toString().substring(23, colPlaca.getCellObservableValue(tablaVehiculos.getSelectionModel().getFocusedIndex()).toString().length() - 1) +"\n" +
                "Fecha alquiler: " + txtFldFechaAlquier.getValue() + "\n" +
                "Fecha regreso: " + txtFldFechaRegreso.getValue() + "\n" +
                "Fecha de registro: " + LocalDate.now() + "\n" +
                "\n" +
                "VALOR TOTAL: " + txtFldValorTotal.getText());
        alert.show();

        Stage stage1 = (Stage) this.btnRegistrarAlquier.getScene().getWindow();
        stage1.close();
    }

    public void onCalcularValotTotal(ActionEvent actionEvent) throws AtributoVacioException {

        if (txtFldFechaAlquier.toString().isBlank() || txtFldFechaRegreso.toString().isBlank()){

            alquilaFacil.crearAlertaError("Campo obligatorio*", "Se debe ingresar algunos datos obligatoriamente. (*)");

            throw new AtributoVacioException("Hay atributos que son obligatorios. (*)");

        } else {

            long diasDeDiferencia = DAYS.toChronoUnit().between(txtFldFechaAlquier.getValue(), txtFldFechaRegreso.getValue());
            txtFldValorTotal.setText(String.valueOf(Double.parseDouble(colAlquilerXDia.getCellObservableValue(tablaVehiculos.getSelectionModel().getFocusedIndex()).toString().substring(23, colAlquilerXDia.getCellObservableValue(tablaVehiculos.getSelectionModel().getFocusedIndex()).toString().length() - 1)) * diasDeDiferencia));

        }
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
