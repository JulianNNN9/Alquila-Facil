package co.edu.uniquindio.alquilafacil.controllers;

import co.edu.uniquindio.alquilafacil.model.AlquilaFacil;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.File;
import java.io.IOException;

public class VentanaPrincipalController {

    private final AlquilaFacil alquilaFacil = AlquilaFacil.getInstance();

    @FXML
    public Button btnRegistrarCliente;
    @FXML
    public Button btnRegistrarVehiculo;
    @FXML
    public Button btnHacerAlquiler;
    @FXML
    public Button btnListaClientes;

    @FXML
    public Button btnCerrarVentana;
    @FXML
    public Button btnCalcularTotalGanado;
    @FXML
    public Label lblTituloVentanaPrincipal;
    @FXML
    public Button btnMarcaMasVendida;

    public VentanaPrincipalController() {
    }

    public void initialize(){

        lblTituloVentanaPrincipal.setText(alquilaFacil.getResourceBundle().getString("textoTitulo"));
        btnListaClientes.setText(alquilaFacil.getResourceBundle().getString("textoBotonVentanaLitaClientes"));
        btnRegistrarCliente.setText(alquilaFacil.getResourceBundle().getString("textoBotonRegistrarClienteVentanaPrincipal"));
        btnRegistrarVehiculo.setText(alquilaFacil.getResourceBundle().getString("textoBotonRegistrarVehiculoVentanaPrincipal"));
        btnHacerAlquiler.setText(alquilaFacil.getResourceBundle().getString("textoHacerAlquilerVentanaPrincipal"));
        btnCalcularTotalGanado.setText(alquilaFacil.getResourceBundle().getString("textoBotonCalcularTotalGanado"));
        btnMarcaMasVendida.setText(alquilaFacil.getResourceBundle().getString("textoBotonMarcaMasVendida"));

    }

    public void onRegistrarClienteClick() throws IOException {

        File url = new File("src/main/resources/co/edu/uniquindio/alquilafacil/registroCliente.fxml");
        FXMLLoader loader = new FXMLLoader(url.toURL());
        Parent parent = loader.load();

        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        scene.setFill(Color.TRANSPARENT);
        stage.setResizable(false);
        stage.show();

        Stage stage1 = (Stage) this.btnRegistrarCliente.getScene().getWindow();
        stage1.close();

    }

    public void onRegistrarVehiculoClick() throws IOException {

        File url = new File("src/main/resources/co/edu/uniquindio/alquilafacil/registroVehiculo.fxml");
        FXMLLoader loader = new FXMLLoader(url.toURL());
        Parent parent = loader.load();

        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        scene.setFill(Color.TRANSPARENT);
        stage.setResizable(false);
        stage.show();

        Stage stage1 = (Stage) this.btnRegistrarVehiculo.getScene().getWindow();
        stage1.close();
    }

    public void onHacerAlquilerClick() throws IOException {

        File url = new File("src/main/resources/co/edu/uniquindio/alquilafacil/registroAlquiler.fxml");
        FXMLLoader loader = new FXMLLoader(url.toURL());
        Parent parent = loader.load();

        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        scene.setFill(Color.TRANSPARENT);
        stage.setResizable(false);
        stage.show();

        Stage stage1 = (Stage) this.btnHacerAlquiler.getScene().getWindow();
        stage1.close();
    }

    public void onCalcularTotalGanadoClick() throws IOException {

        File url = new File("src/main/resources/co/edu/uniquindio/alquilafacil/totalGanado.fxml");
        FXMLLoader loader = new FXMLLoader(url.toURL());
        Parent parent = loader.load();

        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        scene.setFill(Color.TRANSPARENT);
        stage.setResizable(false);
        stage.show();

        Stage stage1 = (Stage) this.btnHacerAlquiler.getScene().getWindow();
        stage1.close();
    }

    public void onListaClientesClick() throws IOException {

        File url = new File("src/main/resources/co/edu/uniquindio/alquilafacil/ventanaClientes.fxml");
        FXMLLoader loader = new FXMLLoader(url.toURL());
        Parent parent = loader.load();

        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        scene.setFill(Color.TRANSPARENT);
        stage.setResizable(false);
        stage.show();

        Stage stage1 = (Stage) this.btnHacerAlquiler.getScene().getWindow();
        stage1.close();
    }

    public void onMarcaMasVendidaClick() {
        alquilaFacil.crearAlertaInfo(alquilaFacil.getResourceBundle().getString("textoTituloAlertaInfoMarcaMasVendida"), alquilaFacil.getResourceBundle().getString("textoAlertaInfoHeader"),alquilaFacil.getResourceBundle().getString("textoContextoAlertaInfoMarcaMasVendida") + " " +alquilaFacil.conocerMarcaMasVendida() + ".");
    }

    @FXML
    private void onCerrarVentanaClick() {
        Stage stage = (Stage) this.btnCerrarVentana.getScene().getWindow();
        stage.close();
    }

}