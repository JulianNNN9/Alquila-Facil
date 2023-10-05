package co.edu.uniquindio.alquilafacil.javaUtils;

import co.edu.uniquindio.alquilafacil.model.AlquilaFacil;
import co.edu.uniquindio.alquilafacil.model.Cliente;
import co.edu.uniquindio.alquilafacil.model.Vehiculo;
import lombok.extern.java.Log;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;

@Log

public class javaUtil {

    private static final AlquilaFacil alquilaFacil = AlquilaFacil.getInstance();

    public static void escribirEnArchivo(String ruta, String formato){
        try {
            FileWriter fileWriter = new FileWriter(ruta, true);
            Formatter formatter = new Formatter(fileWriter);
            formatter.format(formato+"%n");
            fileWriter.close();
        } catch (IOException e){
            log.severe(e.getMessage());
        }
    }

    public static void leerClientes(String ruta) {
        try (Scanner scanner = new Scanner(new File(ruta))){
            while (scanner.hasNextLine()){
                String linea = scanner.nextLine();
                String [] atributos = linea.split(";");
                alquilaFacil.getClientes().add(Cliente.builder()
                                .cedula(atributos[0])
                                .nombreCompleto(atributos[1])
                                .email(atributos[2])
                                .nroTelefono(atributos[3])
                                .ciudad(atributos[4])
                                .direccionResidencia(atributos[5])
                        .build());
            }
        } catch (IOException e){
            log.severe(e.getMessage());
        }
    }

    public static void leerVehiculos(String ruta) {
        try (Scanner scanner = new Scanner(new File(ruta))){
            while (scanner.hasNextLine()){
                String linea = scanner.nextLine();
                String [] atributos = linea.split(";");
                alquilaFacil.getVehiculos().add(Vehiculo.builder()
                                .placa(atributos[0])
                                .referencia(atributos[1])
                                .marca(atributos[2])
                                .modelo(atributos[3])
                                .kilometraje(atributos[4])
                                .precioAlquilerPorDia(Double.valueOf(atributos[5]))
                                .automatico(atributos[6])
                                .numeroAsientos(atributos[7])
                                .imagenPath(atributos[8])
                        .build());
            }
        } catch (IOException e){
            log.severe(e.getMessage());
        }
    }
}