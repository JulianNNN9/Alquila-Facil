package co.edu.uniquindio.ingesis.model;


import java.util.ArrayList;
import java.util.List;
import static co.edu.uniquindio.ingesis.model.Cliente.mascotaList;

public class PatitasPeludas {
    public Medico[] medicosList = {
            new Medico("Ricardo Marin", "3118945687", "RMARIN@clinica.com", "0001"),
            new Medico("Juan Velasco", "3128675117", "JVELASCO@clinica.com", "0002"),
            new Medico("Eriberto Gomez", "3136745687", "EGOMEZ@clinica.com", "0003"),
            new Medico("Gildardo Palacio", "3118967187", "GPALACION@clinica.com", "0004")
    };

    public List<Cliente> clienteList = new ArrayList<>();

    public void registrarCliente(String nombre, String telefono, String correo, String cedula, String direccion){
        clienteList.add(new Cliente(nombre, telefono, correo, cedula, direccion));
    }

    public void registrarMascota(String nombre, String edad, String sexo, Tipo tipo, String raza, Cliente propietario, HistorialClinico historialClinico){
        mascotaList.add(new Mascota(nombre, edad, sexo, tipo, raza, propietario, historialClinico));
    }

    public HistorialClinico OHC(String cedulaDueno, String nombreMascota){
        List<Mascota> coincidencias = mascotaList
                .stream()
                .filter(mascota -> mascota.getNombre().equals(nombreMascota) && mascota.getPropietario().getCedula().equals(cedulaDueno)).toList();
        return coincidencias.get(0).getHistorialClinico();
    }

    public void getHistorialClinico(String cedulaDueno, String nombreMascota){
        System.out.println("Motivo consulta: " + "\n\t" +
                OHC(cedulaDueno, nombreMascota).getMotivoConsulta());
        System.out.println("Enfermedades actuales: " + "\n\t" +
                OHC(cedulaDueno, nombreMascota).getEnfermedadActual());
        System.out.println("Antecedentes: " + "\n\t" +
                OHC(cedulaDueno, nombreMascota).getAntecedentes());
    }
}
