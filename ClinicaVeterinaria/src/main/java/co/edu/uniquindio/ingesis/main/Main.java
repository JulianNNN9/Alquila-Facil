package co.edu.uniquindio.ingesis.main;

import co.edu.uniquindio.ingesis.model.HistorialClinico;
import co.edu.uniquindio.ingesis.model.PatitasPeludas;
import co.edu.uniquindio.ingesis.model.Tipo;

public class Main {
    public static void main(String[] args) {
            PatitasPeludas patitasPeludas = new PatitasPeludas();
            patitasPeludas.registrarCliente("Jorge Nitales", "3159864487", "Jorge@correo.com", "123", "Barrio Cilindro");
            System.out.println(patitasPeludas.clienteList.get(0).getNombre());
            patitasPeludas.registrarMascota
                    ("Carlos", "1 año", "m", Tipo.PERRO, "Caniche", patitasPeludas.clienteList.get(0),
                            new HistorialClinico("Chillidos", "Diarre", "Pata partida"));
            patitasPeludas.getHistorialClinico("123", "Carlos");
        }
}