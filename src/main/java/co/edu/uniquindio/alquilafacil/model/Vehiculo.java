package co.edu.uniquindio.alquilafacil.model;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder

public class Vehiculo {

    @EqualsAndHashCode.Include
    private String placa;
    private String referencia;
    private String marca;
    private String modelo;
    private String kilometraje;
    private Double precioAlquilerPorDia;
    private String automatico;
    private String numeroAsientos;
    private String imagenPath;

}
