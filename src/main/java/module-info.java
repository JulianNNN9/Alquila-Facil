module co.edu.uniquindio.alquilafacil {

    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires javafx.graphics;
    requires static lombok;


    opens co.edu.uniquindio.alquilafacil to javafx.fxml;
    opens co.edu.uniquindio.alquilafacil.app to javafx.fxml;
    opens co.edu.uniquindio.alquilafacil.controllers to javafx.fxml;


    exports co.edu.uniquindio.alquilafacil.app;
    exports co.edu.uniquindio.alquilafacil.controllers;
    exports co.edu.uniquindio.alquilafacil.exceptions;
    exports co.edu.uniquindio.alquilafacil.model;
    exports co.edu.uniquindio.alquilafacil.javaUtils;
}