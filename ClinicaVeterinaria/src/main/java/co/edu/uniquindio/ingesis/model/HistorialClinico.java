package co.edu.uniquindio.ingesis.model;

public class HistorialClinico {
    private String motivoConsulta;
    private String enfermedadActual;
    private String antecedentes;

    public HistorialClinico(String motivoConsulta, String enfermedadActual, String antecedentes) {
        this.motivoConsulta = motivoConsulta;
        this.enfermedadActual = enfermedadActual;
        this.antecedentes = antecedentes;
    }

    public String getMotivoConsulta() {
        return motivoConsulta;
    }

    public void setMotivoConsulta(String motivoConsulta) {
        this.motivoConsulta = motivoConsulta;
    }

    public String getEnfermedadActual() {
        return enfermedadActual;
    }

    public void setEnfermedadActual(String enfermedadActual) {
        this.enfermedadActual = enfermedadActual;
    }

    public String getAntecedentes() {
        return antecedentes;
    }

    public void setAntecedentes(String antecedentes) {
        this.antecedentes = antecedentes;
    }
}
