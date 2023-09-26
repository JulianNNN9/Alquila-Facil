package co.edu.uniquindio.practicamanejoarchivos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Factura {

    Double precio;
    Alquiler alquiler;
}
