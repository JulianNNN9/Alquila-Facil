package co.edu.uniquindio.ingesis.model;

import java.time.LocalDate;

public class Factura {
    private float costo;
    private LocalDate localDate;
    private Cliente cliente;
    private String observacion;
    private String atencion;

    public Factura(float costo, LocalDate localDate, Cliente cliente, String observacion, String atencion) {
        this.costo = costo;
        this.localDate = localDate;
        this.cliente = cliente;
        this.observacion = observacion;
        this.atencion = atencion;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getAtencion() {
        return atencion;
    }

    public void setAtencion(String atencion) {
        this.atencion = atencion;
    }
}
