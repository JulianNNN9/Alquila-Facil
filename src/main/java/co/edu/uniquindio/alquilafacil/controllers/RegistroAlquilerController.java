package co.edu.uniquindio.alquilafacil.controllers;

import co.edu.uniquindio.alquilafacil.exceptions.AlquilerInvalidoException;
import co.edu.uniquindio.alquilafacil.exceptions.AtributoVacioException;
import co.edu.uniquindio.alquilafacil.exceptions.ErrorEnIngresoFechasException;
import co.edu.uniquindio.alquilafacil.model.AlquilaFacil;
import co.edu.uniquindio.alquilafacil.model.Vehiculo;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.converter.IntegerStringConverter;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

public class RegistroAlquilerController {

    /*

    ---------------FUNCIONES POR IMPLEMENTAR-----------------

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
    public Label lblCedulaCliente;
    @FXML
    public Label lblFechaAlquiler;
    @FXML
    public Label lblFechaRegreso;
    @FXML
    public Label lblValorTotal;
    @FXML
    public Label lblRegistrarAlquileres;
    @FXML
    public Label lblSeleccionVehiculo;

    @FXML
    private ImageView imageView;

    public void initialize(){

        lblRegistrarAlquileres.setText(alquilaFacil.getResourceBundle().getString("textoLabelRegistrarAlquileres"));
        lblCedulaCliente.setText(alquilaFacil.getResourceBundle().getString("textoLabelCedulaCliente"));
        lblFechaAlquiler.setText(alquilaFacil.getResourceBundle().getString("textoLabelFechaAlquiler"));
        lblFechaRegreso.setText(alquilaFacil.getResourceBundle().getString("textoLabelFechaRegreso"));
        lblValorTotal.setText(alquilaFacil.getResourceBundle().getString("textoLabelValorTotal"));
        lblSeleccionVehiculo.setText(alquilaFacil.getResourceBundle().getString("textoLabelSeleccioneVehiculoAlquilar"));
        btnRegistrarAlquier.setText(alquilaFacil.getResourceBundle().getString("textoBotonRegistrarAlquilar"));

        colPlaca.setText(alquilaFacil.getResourceBundle().getString("textoLabelPlaca"));
        colReferencia.setText(alquilaFacil.getResourceBundle().getString("textoLabelReferencia"));
        colMarca.setText(alquilaFacil.getResourceBundle().getString("textoLabelMarca"));
        colModelo.setText(alquilaFacil.getResourceBundle().getString("textoLabelModelo"));
        colKilometraje.setText(alquilaFacil.getResourceBundle().getString("textoLabelKilometraje"));
        colAlquilerXDia.setText(alquilaFacil.getResourceBundle().getString("textoLabelPrecioAlquilerPorDia"));
        colAutomatico.setText(alquilaFacil.getResourceBundle().getString("textoLabelAutomatico"));
        colNumeroAsientos.setText(alquilaFacil.getResourceBundle().getString("textoLabelNumeroAsientos"));

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
            alquilaFacil.crearAlertaInfo(alquilaFacil.getResourceBundle().getString("textoTituloAlertaInfoIngresoValoresNumericos"), alquilaFacil.getResourceBundle().getString("textoContenidoAlertaInfoIngresoValoresNumericos"));
            return null;
        });

        txtFldValorTotal.setTextFormatter(textFormatter);

    }

    public void onRegistrarAlquilerClick() throws ErrorEnIngresoFechasException, AtributoVacioException, IOException, AlquilerInvalidoException {

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
        alert.setTitle(alquilaFacil.getResourceBundle().getString("textoFacturaTitulo"));
        alert.setHeaderText(alquilaFacil.getResourceBundle().getString("textoFacturaEncabezado"));
        alert.setContentText(alquilaFacil.getResourceBundle().getString("textoFacturaCedulaCliente") + " " + txtFldCedulaCliente.getText() + "\n" +
                alquilaFacil.getResourceBundle().getString("textoFacturaFechaAlquiler") + " " + colPlaca.getCellObservableValue(tablaVehiculos.getSelectionModel().getFocusedIndex()).toString().substring(23, colPlaca.getCellObservableValue(tablaVehiculos.getSelectionModel().getFocusedIndex()).toString().length() - 1) +"\n" +
                alquilaFacil.getResourceBundle().getString("textoFacturaFechaRegreso") + " " + txtFldFechaAlquier.getValue() + "\n" +
                alquilaFacil.getResourceBundle().getString("textoFacturaFechaRegistro") + " " + txtFldFechaRegreso.getValue() + "\n" + alquilaFacil.getResourceBundle().getString("textoFacturaCedulaCliente") + LocalDate.now() + "\n" +
                "\n" +
                alquilaFacil.getResourceBundle().getString("textoFacturaValorTotal") + " " + txtFldValorTotal.getText());
        alert.show();

        Stage stage1 = (Stage) this.btnRegistrarAlquier.getScene().getWindow();
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
