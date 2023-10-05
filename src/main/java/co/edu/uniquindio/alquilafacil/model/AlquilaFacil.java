package co.edu.uniquindio.alquilafacil.model;

import co.edu.uniquindio.alquilafacil.exceptions.*;
import javafx.scene.control.Alert;
import javafx.scene.control.TextFormatter;
import javafx.util.converter.IntegerStringConverter;
import lombok.Getter;
import lombok.extern.java.Log;
import java.io.File;
import java.io.FileWriter;
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
        //leerVehiculos("src/main/resources/persistencia/vehiculos.txt");
        this.clientes = new ArrayList<>();
        //leerClientes("src/main/resources/persistencia/clientes.txt");
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

        String ruta = "src/main/resources/persistencia/clientes.txt";
        String formato = cedula+";"+nombreCompleto+";"+nroTelefono+";"+email+";"+ciudad+";"+direccionResidencia;
        //escribirEnArchivo(ruta, formato);

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

        String ruta = "src/main/resources/persistencia/vehiculos.txt";
        String formato = placa+";"+referencia+";"+marca+";"+modelo+";"+kilometraje+";"+precioAlquilerPorDia+";"+automatico+";"+numeroSillas+";"+imagePath+";";
        //escribirEnArchivo(ruta, formato);

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

    public void registrarAlquiler(String cedulaCliente, String placaVehiculo, LocalDate fechaAlquier, LocalDate fechaRegreso, LocalDate fechaRegistro, double valorTotal) throws ErrorEnIngresoFechasException, AtributoVacioException {

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

        if (validarFechasAlquiler(fechaAlquier, fechaRegreso, placaVehiculo)) {
            crearAlertaError(this.getResourceBundle().getString("textoTituloAlertaErrorAlquilerInvalido"), this.getResourceBundle().getString("textoContenidoErrorAlquilerInvalido"));
            log.info("Las fechas fueron incorrectamente colocadas, la fecha de alquiler no puede ser después de la fecha de regreso.");
            throw new ErrorEnIngresoFechasException(this.getResourceBundle().getString("textoErrorEnIngresoFechasException"));
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

            log.info("Se ha registrado un alquier del vehiculo con la placa " + placaVehiculo + " a el cliente con la cedula " + cedulaCliente);

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
        System.out.println(alquileres);
        List<Vehiculo> vehiculosEnAlquiler = encontrarVehiculosEnAlquiler();
        System.out.println(vehiculosEnAlquiler);
        Map<String, Long> agruparPorMarca = vehiculosEnAlquiler.stream()
                .collect(Collectors.groupingBy(Vehiculo::getMarca, Collectors.counting()));
        Optional<Map.Entry<String, Long>> marcaMasVendida = agruparPorMarca.entrySet().stream()
                .max(Map.Entry.comparingByValue());
        return marcaMasVendida.map(Map.Entry::getKey).orElse(this.getResourceBundle().getString("textoValidacionEnFechasError"));
    }

    public boolean validarFechasAlquiler(LocalDate fechaAlquiler, LocalDate fechaRegreso, String placaVehiculo) {
        return alquileres.stream()
                .filter(alquiler -> alquiler.getPlacaVehiculo().equals(placaVehiculo))
                .anyMatch(alquiler ->
                        !(!fechaRegreso.isBefore(alquiler.getFechaAlquiler()) ||
                                !fechaAlquiler.isAfter(alquiler.getFechaRegreso())));
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

    public TextFormatter<Integer> stringFormatterParaNumeros(){
        TextFormatter<Integer> textFormatter = new TextFormatter<>(new IntegerStringConverter(), 0, change -> {
            String nuevoTexto = change.getControlNewText();
            if (nuevoTexto.matches("[0-9]*")) {
                return change;
            }
            alquilaFacil.crearAlertaInfo(alquilaFacil.getResourceBundle().getString("textoTituloAlertaInfoIngresoValoresNumericos"), alquilaFacil.getResourceBundle().getString("textoAlertaInfoHeader"),alquilaFacil.getResourceBundle().getString("textoContenidoAlertaInfoIngresoValoresNumericos"));
            return null;
        });
        return textFormatter;
    }

/*
    public void escribirEnArchivo(String ruta, String formato){
        try {
            FileWriter fileWriter = new FileWriter(ruta, true);
            Formatter formatter = new Formatter(fileWriter);
            formatter.format(formato+"%n");
            fileWriter.close();
        } catch (IOException e){
            log.severe(e.getMessage());
        }
    }

    public void leerClientes(String ruta) {
        try (Scanner scanner = new Scanner(new File(ruta))){
            while (scanner.hasNextLine()){
                String linea = scanner.nextLine();
                String [] atributos = linea.split(";");
                if (!alquilaFacil.getClientes().isEmpty()){
                    alquilaFacil.getClientes().add(Cliente.builder()
                            .cedula(atributos[0])
                            .nombreCompleto(atributos[1])
                            .email(atributos[2])
                            .nroTelefono(atributos[3])
                            .ciudad(atributos[4])
                            .direccionResidencia(atributos[5])
                            .build());
                }
            }
        } catch (IOException e){
            log.severe(e.getMessage());
        }
    }

    public void leerVehiculos(String ruta) {
        try (Scanner scanner = new Scanner(new File(ruta))){
            while (scanner.hasNextLine()){
                String linea = scanner.nextLine();
                String [] atributos = linea.split(";");
                if (!alquilaFacil.getVehiculos().isEmpty()) {
                    alquilaFacil.getVehiculos().add(Vehiculo.builder()
                            .placa(atributos[0])
                            .referencia(atributos[1])
                            .marca(atributos[2])
                            .modelo(atributos[3])
                            .kilometraje(atributos[4])
                            .precioAlquilerPorDia(Double.valueOf(atributos[5]))
                            .automatico(atributos[6])
                            .numeroAsientos(atributos[7])
                            .imagenPath(atributos[8])
                            .build());
                }
            }
        } catch (IOException e){
            log.severe(e.getMessage());
        }
    }
    */
}
