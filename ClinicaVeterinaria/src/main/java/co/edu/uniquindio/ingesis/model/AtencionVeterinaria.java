package co.edu.uniquindio.ingesis.model;

import java.time.LocalDate;

public class AtencionVeterinaria {

    private Enum<Estado> estadoEnum;
    private LocalDate localDate;
    private Mascota mascota;
    private Medico medico;

    public AtencionVeterinaria(Enum<Estado> estadoEnum, LocalDate localDate, Mascota mascota, Medico medico) {
        this.estadoEnum = estadoEnum;
        this.localDate = localDate;
        this.mascota = mascota;
        this.medico = medico;
    }

    public Enum<Estado> getEstadoEnum() {
        return estadoEnum;
    }

    public void setEstadoEnum(Enum<Estado> estadoEnum) {
        this.estadoEnum = estadoEnum;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
}
