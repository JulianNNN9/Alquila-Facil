package co.edu.uniquindio.ingesis.model;

public class Medico extends Persona {
    private String codigo;

    public Medico(String nombre, String telefono, String correo, String codigo) {
        super(nombre, telefono, correo);
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
