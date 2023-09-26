package co.edu.uniquindio.practicamanejoarchivos.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cliente {

    @EqualsAndHashCode.Include
    private String cedula;
    private String nombreCompleto;
    private String nroTelefono;
    private String email;
    private String ciudad;
    private String direccionResidencia;

}
