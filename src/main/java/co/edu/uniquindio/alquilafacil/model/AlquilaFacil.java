package co.edu.uniquindio.alquilafacil.model;

import co.edu.uniquindio.alquilafacil.exceptions.*;
import javafx.scene.control.Alert;
import lombok.Getter;
import lombok.extern.java.Log;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;
import java.util.stream.Collectors;

@Getter
@Log

public class AlquilaFacil {

    List<Cliente> clientes;
    List<Vehiculo> vehiculos;
    List<Alquiler> alquileres;

    @Getter
    private final ResourceBundle resourceBundle;

    private static AlquilaFacil alquilaFacil;

    private AlquilaFacil(){

        this.resourceBundle = ResourceBundle.getBundle("textos");

        try {

            FileHandler fh = new FileHandler("logs.log", true);
            fh.setFormatter( new SimpleFormatter());
            log.addHandler(fh);

        }catch (IOException e){
            log.severe(e.getMessage());
        }

        this.vehiculos = new ArrayList<>();
        vehiculos.add(Vehiculo.builder()
                .placa("HGY-45D")
                .referencia("4")
                .marca("Renault")
                .modelo("2020")
                .kilometraje("1210")
                .precioAlquilerPorDia(100.0)
                .automatico("SI")
                .numeroAsientos("4")
                .imagenPath("https://acnews.blob.core.windows.net/imgnews/small/NAZ_f55645efc0bd45c58f55fd926dc53e79.jpg")
                .build());
        this.clientes = new ArrayList<>();
        clientes.add(Cliente.builder()
                .cedula("1234")
                .nombreCompleto("Ricardo Marin")
                .nroTelefono("123")
                .email("ricard@empresa.com")
                .ciudad("Armenia")
                .direccionResidencia("Salento")
                .build());
        this.alquileres = new ArrayList<>();
    }

    public static AlquilaFacil getInstance(){

        if (alquilaFacil == null){
            alquilaFacil = new AlquilaFacil();
        }

        log.info("Se crea una nueva instancia de AlquilaFacil");

        return alquilaFacil;
    }

    public void registrarCliente(String cedula, String nombreCompleto, String nroTelefono, String email, String ciudad, String direccionResidencia) throws AtributoVacioException, InformacionRepetidaException {

        if (cedula == null || cedula.isBlank() || nombreCompleto == null || nombreCompleto.isBlank() || nroTelefono == null || nroTelefono.isBlank()){
            crearAlertaError(this.getResourceBundle().getString("textoTituloAlertaErrorAtributoVacio"), this.getResourceBundle().getString("textoContenidoAlertaErrorAtributoVacio"));
            log.info("Se ha hecho un intento de registro de cliente con campos vacios.");
            throw new AtributoVacioException(this.getResourceBundle().getString("textoAtributoVacioException"));
        }

        if (clientes.stream().anyMatch(cliente -> cliente.getCedula().equals(cedula))){
            crearAlertaError(this.getResourceBundle().getString("textoTituloAlertaErrorInformacionRepetida"), this.getResourceBundle().getString("textoContenidoAlertaErrorInformacionRepetida"));
            log.info("Se ha hecho un intento de registro de cliente con datos repetidos.");
            throw new InformacionRepetidaException(this.getResourceBundle().getString("textoInformacionRepetidaException"));
        }

        Cliente cliente = Cliente.builder()
                .cedula(cedula)
                .nombreCompleto(nombreCompleto)
                .nroTelefono(nroTelefono)
                .email(email)
                .ciudad(ciudad)
                .direccionResidencia(direccionResidencia)
                .build();

        clientes.add(cliente);

        log.info("Se ha registrado un cliente con la cedula " + cedula);

    }


    public void registrarVehiculo(String placa, String referencia, String marca, String modelo
            , String kilometraje, Double precioAlquilerPorDia, String automatico
            , String numeroSillas, String imagePath) throws InformacionRepetidaException, NumeroNegativoException, AtributoVacioException {

        if (placa == null || placa.isBlank() || referencia == null || referencia.isBlank() || marca == null || marca.isBlank() || modelo == null || modelo.isBlank() || kilometraje == null || kilometraje.isBlank() || automatico == null || automatico.isBlank() || numeroSillas == null || numeroSillas.isBlank()){
            crearAlertaError(this.getResourceBundle().getString("textoTituloAlertaErrorAtributoVacio"), this.getResourceBundle().getString("textoContenidoAlertaErrorAtributoVacio"));
            log.info("Se ha hecho un intento de registro de vehiculo con campos vacios.");
            throw new AtributoVacioException(this.getResourceBundle().getString("textoAtributoVacioException"));
        }

        if (vehiculos.stream().anyMatch(vehiculo -> vehiculo.getPlaca().equals(placa))){
            crearAlertaError(this.getResourceBundle().getString("textoTituloAlertaErrorInformacionRepetida"), this.getResourceBundle().getString("textoContenidoAlertaErrorInformacionRepetida"));
            log.info("Se ha hecho un intento de resgistro de vehiculo con datos repetidos");
            throw new InformacionRepetidaException(this.getResourceBundle().getString("textoInformacionRepetidaException"));
        }

        if (precioAlquilerPorDia < 0){
            crearAlertaError(this.getResourceBundle().getString("textoTituloAlertaErrorNumeroNegativo"), this.getResourceBundle().getString("textoContenidoAlertaErrorNumeroNegativo"));
            log.info("Se han ingresado valores invalidos.");
            throw new NumeroNegativoException(this.getResourceBundle().getString("textoNumeroNegativoException"));
        }

        Vehiculo vehiculo = Vehiculo.builder()
                .placa(placa)
                .referencia(referencia)
                .marca(marca)
                .modelo(modelo)
                .kilometraje(kilometraje)
                .precioAlquilerPorDia(precioAlquilerPorDia)
                .automatico(automatico)
                .numeroAsientos(numeroSillas)
                .imagenPath(imagePath)
                .build();

        vehiculos.add(vehiculo);

        log.info("Se ha registrado un vehiculo con placa " + placa);

    }

    public void registrarAlquiler(String cedulaCliente, String placaVehiculo, LocalDate fechaAlquier, LocalDate fechaRegreso, LocalDate fechaRegistro, double valorTotal) throws ErrorEnIngresoFechasException, AtributoVacioException, AlquilerInvalidoException {

        if (cedulaCliente == null || cedulaCliente.isBlank()|| fechaAlquier == null || fechaRegreso == null){
            crearAlertaError(this.getResourceBundle().getString("textoTituloAlertaErrorAtributoVacio"), this.getResourceBundle().getString("textoContenidoAlertaErrorAtributoVacio"));
            log.info("Se ha hecho un intento de registro de alquiler con campos vacios.");
            throw new AtributoVacioException(this.getResourceBundle().getString("textoAtributoVacioException"));
        }

        if (placaVehiculo == null || placaVehiculo.isBlank()){
            crearAlertaError(this.getResourceBundle().getString("textoTituloAlertaErrorAtributoVacio"), this.getResourceBundle().getString("textoContenidoAlertaErrorAtributoVacio"));
            log.info("Se ha hecho un intento de registro de alquiler sin seleccionar un vehiculo.");
            throw new AtributoVacioException(this.getResourceBundle().getString("textoAtributoVacioException"));
        }

        if (fechaAlquier.isAfter(fechaRegreso)){
            crearAlertaError(this.getResourceBundle().getString("textoTituloAlertaErrorFechas"), this.getResourceBundle().getString("textoContenidoAlertaErrorFechas"));
            log.info("Las fechas fueron incorrectamente colocadas, la fecha de alquiler no puede ser después de la fecha de regreso.");
            throw new ErrorEnIngresoFechasException(this.getResourceBundle().getString("textoErrorEnIngresoFechasException"));
        }

        if (alquileres.stream().anyMatch(alquiler -> fechaRegreso.isAfter(alquiler.getFechaAlquiler()))){
            crearAlertaError(this.getResourceBundle().getString("textoTituloAlertaErrorAlquilerInvalido"), this.getResourceBundle().getString("textoContenidoErrorAlquilerInvalido"));
            log.info("Se ha intentado hacer un alquiler con una fecha inválida");
            throw new AlquilerInvalidoException(this.getResourceBundle().getString("textoAlquilerInvalidoException"));
        }

        List<Alquiler> alquileresSuperpuestos = alquileres.stream()
                .filter(alquiler -> !(!fechaRegreso.isAfter(alquiler.getFechaAlquiler()) ||
                                !fechaAlquier.isBefore(alquiler.getFechaRegreso())))
                .toList();
        if (alquileresSuperpuestos.isEmpty()){
            log.info("Se ha registrado un alquier del vehiculo con la placa " + placaVehiculo.substring(23, placaVehiculo.length() - 1) + " a el cliente con la cedula " + cedulaCliente);
        } else {
            crearAlertaError(this.getResourceBundle().getString("textoTituloAlertaErrorAlquilerInvalido"), this.getResourceBundle().getString("textoContenidoErrorAlquilerInvalido"));
            log.info("Se ha intentado hacer un alquiler con una fecha inválida");
            throw new AlquilerInvalidoException(this.getResourceBundle().getString("textoAlquilerInvalidoException"));
        }

        if (clientes.stream().anyMatch(cliente -> cliente.getCedula().equals(cedulaCliente))){

            long days = fechaAlquier.until(fechaRegreso, ChronoUnit.DAYS);

            Alquiler alquiler = Alquiler.builder()
                    .cedulaCliente(cedulaCliente)
                    .placaVehiculo(placaVehiculo)
                    .fechaAlquiler(fechaAlquier)
                    .fechaRegreso(fechaRegreso)
                    .fechaRegistro(fechaRegistro)
                    .valorTotal(valorTotal)
                    .build();

            alquileres.add(alquiler);

            log.info("Se ha registrado un alquier del vehiculo con la placa " + placaVehiculo.substring(23, placaVehiculo.length() - 1) + " a el cliente con la cedula " + cedulaCliente);

        } else {
            crearAlertaError(this.getResourceBundle().getString("textoTituloAlertaErrorAtributoVacioCedulaNoRegistrada"), this.getResourceBundle().getString("textoContenidoAlertaErrorAtributoVacioCedulaNoRegistrada"));
            log.info("Se ha hecho un intento de registro de alquiler con cédula inválida.");
            throw new AtributoVacioException(this.getResourceBundle().getString("textoAtributoVacioException"));
        }

    }

    public Double calcularTotalGanadoEntreFechas(LocalDate fechaInicio, LocalDate fechaFin) throws ErrorEnIngresoFechasException, AtributoVacioException {

        if (fechaInicio.isAfter(fechaFin)){
            crearAlertaError(this.getResourceBundle().getString("textoTituloAlertaErrorFechas"), this.getResourceBundle().getString("textoContenidoAlertaErrorFechas"));
            log.info("Las fechas fueron incorrectamente colocadas, la fecha de alquiler no puede ser después de la fecha de regreso.");
            throw new ErrorEnIngresoFechasException(this.getResourceBundle().getString("textoErrorEnIngresoFechasException"));
        }

        if (fechaInicio == null || fechaFin == null){
            crearAlertaError(this.getResourceBundle().getString("textoTituloAlertaErrorAtributoVacio"), this.getResourceBundle().getString("textoContenidoAlertaErrorAtributoVacio"));
            log.info("Se ha hecho un intento de registro de alquiler con campos vacios.");
            throw new AtributoVacioException(this.getResourceBundle().getString("textoAtributoVacioException"));
        }

        List<Alquiler> alquilersEntreFechas = alquileres.stream().filter(alquiler -> {
            if (alquiler.getFechaAlquiler().equals(fechaInicio) || alquiler.getFechaAlquiler().isAfter(fechaInicio)){
                if (alquiler.getFechaRegreso().equals(fechaFin) || alquiler.getFechaRegreso().isBefore(fechaFin)){
                    return true;
                }
            }
            return false;
        }).toList();
        return alquilersEntreFechas.stream().mapToDouble(Alquiler::getValorTotal).sum();
    }

    public List<Vehiculo> encontrarVehiculosEnAlquiler(){
        List<String> placaList = alquileres.stream().map(Alquiler::getPlacaVehiculo).toList();
        return vehiculos.stream().filter(vehiculo -> placaList.contains(vehiculo.getPlaca())).collect(Collectors.toList());
    }

    public String conocerMarcaMasVendida(){
        List<Vehiculo> vehiculosEnAlquiler = encontrarVehiculosEnAlquiler();
        Map<String, Long> agruparRepeticionesDeMarcas = vehiculosEnAlquiler.stream().collect(Collectors.groupingBy(Vehiculo::getMarca, Collectors.counting()));
        return agruparRepeticionesDeMarcas.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(null);
    }

    public void crearAlertaError(String tituloError, String contenidoError){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(tituloError);
        alert.setContentText(contenidoError);
        alert.show();
    }

    public void crearAlertaInfo(String tituloError, String encabezadoError, String contenidoError){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(tituloError);
        alert.setHeaderText(encabezadoError);
        alert.setContentText(contenidoError);
        alert.show();
    }
}
