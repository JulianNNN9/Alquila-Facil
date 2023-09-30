package co.edu.uniquindio.alquilafacil.model;

import co.edu.uniquindio.alquilafacil.exceptions.AtributoVacioException;
import co.edu.uniquindio.alquilafacil.exceptions.ErrorEnIngresoFechasException;
import co.edu.uniquindio.alquilafacil.exceptions.InformacionRepetidaException;
import co.edu.uniquindio.alquilafacil.exceptions.NumeroNegativoException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;
@Getter
@Log

public class AlquilaFacil {

    List<Cliente> clientes;
    List<Vehiculo> vehiculos;
    List<Alquiler> alquileres;

    private static AlquilaFacil alquilaFacil;

    private AlquilaFacil(){

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
                        .referencia("159842")
                        .marca("Renault")
                        .modelo("2020")
                        .kilometraje("1210")
                        .precioAlquilerPorDia(1500.0)
                        .automatico("SI")
                        .numeroAsientos("4")
                        .build());
        this.clientes = new ArrayList<>();
        clientes.add(Cliente.builder()
                        .cedula("1594")
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

        if (cedula == null || cedula.isBlank()){
            log.info("Se ha hecho un intento de registro de cliente con campos vacios.");
            throw new AtributoVacioException("El campo cédula es obligatorio.");
        }

        if (clientes.stream().anyMatch(cliente -> cliente.getCedula().equals(cedula))){
            log.info("Se ha hecho un intento de registro de cliente con datos repetidos.");
            throw new InformacionRepetidaException("La cédula ya se encuentra registrada.");
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
            , String numeroSillas) throws InformacionRepetidaException, NumeroNegativoException {

        if (vehiculos.stream().anyMatch(vehiculo -> vehiculo.getPlaca().equals(placa))){
            log.info("Se ha hecho un intento de resgistro de vehiculo con datos repetidos");
            throw new InformacionRepetidaException("El vehiculo ya se encuentra registrado.");
        }

        if (precioAlquilerPorDia < 0){
            log.info("Se han ingresado valores invalidos.");
            throw new NumeroNegativoException("El valor no puede ser negativo.");
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
                .build();

        vehiculos.add(vehiculo);

        log.info("Se ha registrado un vehiculo con placa " + placa);

    }

    public void registrarAlquiler(String cedulaCliente, String placaVehiculo, LocalDate fechaAlquier, LocalDate fechaRegreso, LocalDateTime fechaRegistro, double valorTotal) throws ErrorEnIngresoFechasException {

        if (fechaAlquier.isAfter(fechaRegreso)){
            log.info("Las fechas fueron incorrectamente colocadas.");
            throw new ErrorEnIngresoFechasException("La fecha de alquiler no puede ser después de la fecha de devolución.");
        }

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

    }

    public Cliente obtenerCliente(String cedula){
        return (Cliente) clientes.stream().filter(cliente -> cliente.getCedula().equals(cedula));
    }


}
