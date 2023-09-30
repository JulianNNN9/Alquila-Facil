package co.edu.uniquindio.alquilafacil.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.extern.java.Log;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

@Log

public class AlquilaFacilApp extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        File url = new File("src/main/resources/co/edu/uniquindio/alquilafacil/ventanaPrincipal.fxml");
        FXMLLoader loader = new FXMLLoader(url.toURL());
        Parent parent = loader.load();

        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}