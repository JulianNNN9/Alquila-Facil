package co.edu.uniquindio.alquilafacil.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Alquiler implements Serializable {

    private String cedulaCliente;
    private String placaVehiculo;
    private LocalDate fechaAlquiler;
    private LocalDate fechaRegreso;
    private LocalDate fechaRegistro;
    private double valorTotal;

}
