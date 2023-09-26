package co.edu.uniquindio.practicamanejoarchivos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Alquiler {

    Cliente cliente;
    Vehiculo vehiculo;
    LocalDate fechaAlquiler;
    LocalDate fechaRegreso;

}
