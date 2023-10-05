package co.edu.uniquindio.alquilafacil.utils;

import co.edu.uniquindio.alquilafacil.model.Alquiler;
import co.edu.uniquindio.alquilafacil.model.Cliente;
import co.edu.uniquindio.alquilafacil.model.Vehiculo;
import lombok.extern.java.Log;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.time.LocalDate;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

@Log

public class archivoUtils {

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

    public static void leerClientes(String ruta, List<Cliente> clientes) {
        try (Scanner scanner = new Scanner(new File(ruta))){
            while (scanner.hasNextLine()){
                String linea = scanner.nextLine();
                String [] atributos = linea.split(";");
                clientes.add(Cliente.builder()
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

    public static void leerVehiculos(String ruta, List<Vehiculo> vehiculos) {
        try (Scanner scanner = new Scanner(new File(ruta))){
            while (scanner.hasNextLine()){
                String linea = scanner.nextLine();
                String [] atributos = linea.split(";");
                vehiculos.add(Vehiculo.builder()
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

    public static void leerAlquileres(String ruta, List<Alquiler> alquileres){
        try (Scanner scanner = new Scanner(new File(ruta))){
            while (scanner.hasNextLine()){
                String linea = scanner.nextLine();
                String [] atributos = linea.split(";");
                alquileres.add(Alquiler.builder()
                        .cedulaCliente(atributos[0])
                        .placaVehiculo(atributos[1])
                        .fechaAlquiler(LocalDate.parse(atributos[2]))
                        .fechaRegreso(LocalDate.parse(atributos[3]))
                        .fechaRegistro(LocalDate.parse(atributos[4]))
                        .valorTotal(Double.parseDouble(atributos[5]))
                        .build());
            }
        } catch (IOException e){
            log.severe(e.getMessage());
        }
    }

    public static void serializarObjeto(String ruta, Object objeto) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(ruta);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {

            objectOutputStream.writeObject(objeto);

        } catch (IOException e) {
            log.severe(e.getMessage());
        }
    }

    public static List<Alquiler> deserializarObjeto(String ruta) {
        try (FileInputStream fileInputStream = new FileInputStream(ruta);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){

            return (List<Alquiler>) objectInputStream.readObject();

        } catch (IOException | ClassNotFoundException e) {
            log.severe(e.getMessage());
        }

        return null;
    }

    /**
     * Serializa un objeto en un archivo en formato XML
     * @param ruta Ruta del archivo donde se va a serializar el objeto
     * @param objeto Objeto a serializar
     * @throws FileNotFoundException
     */
    public static void serializarObjetoXML(String ruta, Object objeto) throws FileNotFoundException {
        XMLEncoder encoder = new XMLEncoder(new FileOutputStream(ruta));
        encoder.writeObject(objeto);
        encoder.close();
    }

    /**
     * Deserializa un objeto desde un archivo XML
     * @param ruta Ruta del archivo a deserializar
     * @return Objeto deserializado
     * @throws IOException
     */
    public static Object deserializarObjetoXML(String ruta) throws IOException{
        XMLDecoder decoder = new XMLDecoder(new FileInputStream(ruta));
        Object objeto = decoder.readObject();
        decoder.close();

        return objeto;
    }

}
