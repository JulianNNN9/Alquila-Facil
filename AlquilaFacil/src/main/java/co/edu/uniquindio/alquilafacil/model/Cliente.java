package co.edu.uniquindio.alquilafacil.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder

public class Cliente {

    @EqualsAndHashCode.Include
    private String cedula;
    private String nombreCompleto;
    private String nroTelefono;
    private String email;
    private String ciudad;
    private String direccionResidencia;

}
