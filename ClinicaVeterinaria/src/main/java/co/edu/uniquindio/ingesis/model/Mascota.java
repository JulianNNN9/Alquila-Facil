package co.edu.uniquindio.ingesis.model;

public class Mascota {
    private String nombre;
    private String edad;
    private String sexo;
    private Enum<Tipo> tipoEnum;
    private String raza;
    private Cliente propietario;
    private HistorialClinico historialClinico;

    public Mascota(String nombre, String edad, String sexo, Enum<Tipo> tipoEnum, String raza, Cliente propietario, HistorialClinico historialClinico) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.tipoEnum = tipoEnum;
        this.raza = raza;
        this.propietario = propietario;
        this.historialClinico = historialClinico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Enum<Tipo> getTipoEnum() {
        return tipoEnum;
    }

    public void setTipoEnum(Enum<Tipo> tipoEnum) {
        this.tipoEnum = tipoEnum;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public Cliente getPropietario() {
        return propietario;
    }

    public void setPropietario(Cliente propietario) {
        this.propietario = propietario;
    }

    public HistorialClinico getHistorialClinico() {
        return historialClinico;
    }

    public void setHistorialClinico(HistorialClinico historialClinico) {
        this.historialClinico = historialClinico;
    }
}
