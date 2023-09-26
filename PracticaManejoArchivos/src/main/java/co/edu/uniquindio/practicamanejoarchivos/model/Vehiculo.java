package co.edu.uniquindio.practicamanejoarchivos.model;
import javafx.scene.image.Image;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Vehiculo {

    @EqualsAndHashCode.Include
    private String placa;
    private String nombre;
    private String marca;
    private String modelo;
    private Image foto;
    private String kilometraje;
    private Double precioAlquilerPorDia;
    private boolean automatico;
    private String numeroAsientos;

}
