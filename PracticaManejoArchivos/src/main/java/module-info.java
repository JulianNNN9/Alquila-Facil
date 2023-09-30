module co.edu.uniquindio.alquilafacil {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires lombok;


    opens co.edu.uniquindio.practicamanejoarchivos to javafx.fxml;
    exports co.edu.uniquindio.practicamanejoarchivos.app;
    opens co.edu.uniquindio.practicamanejoarchivos.app to javafx.fxml;
}