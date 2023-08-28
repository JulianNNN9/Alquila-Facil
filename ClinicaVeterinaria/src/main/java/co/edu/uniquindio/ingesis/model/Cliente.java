package co.edu.uniquindio.ingesis.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona {
    private String cedula;
    private String direccion;
    public static List<Mascota> mascotaList = new ArrayList<Mascota>();

    public Cliente(String nombre, String telefono, String correo, String cedula, String direccion) {
        super(nombre, telefono, correo);
        this.cedula = cedula;
        this.direccion = direccion;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Mascota> getMascotaList() {
        return mascotaList;
    }
}
