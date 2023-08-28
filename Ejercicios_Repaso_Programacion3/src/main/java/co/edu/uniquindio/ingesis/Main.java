package co.edu.uniquindio.ingesis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

15)
    int a = 9, b = 5, c = 8;

    int num = -(a++) - (c - ++b) * c + --c;       //      - 9 - (8-6) * 8 + 7 = - 9 - 2 * 8 + 7 = - 9 - 16 + 7 = -18

    System.out.println("Num: "+num);    //    -18
    System.out.println("a: "+a);    //     10
    System.out.println("b: "+b);    //     5
    System.out.println("c: "+c);    //     8

16)

    ¿Qué sentencias condicionales conoce? Dé un ejemplo de su uso.

    if - if else - else if - switch

    if (nota > 2.9) {
        aprobado =  true;
    } else {
        aprobado = false;
    }

17)

    ¿Qué sentencias repetitivas conoce? Dé un ejemplo de su uso.

    for - while - do while

    while (contador < 11) {
        System.out.println(contador);
        contador++;
    }

18)

    ¿Qué es JUnit, cómo se realizan las pruebas unitarias en Java?

    Es una biblioteca para hacer pruebas unitarias en Java.

    1) En el paquete test crea la clase MetodoTest

    2) La etiqueta @Test marca un método como método de prueba.

    3) Los métodos de prueba siempre deben ser public void.


 */
public class Main {

    public static void main(String[] args) {

        //19)

        int [][] matriz = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int sumaBordes = sumarBorderMatriz(matriz);

        System.out.println(sumaBordes);

        //20)

        List<String> stringList = new ArrayList<>();
        stringList.add("hola");
        stringList.add("string");
        stringList.add("matriz");

        String palabraMasConsonantes = encontrarPalabraMasConsonantes(stringList);

        System.out.println(palabraMasConsonantes);

        //21)

        float [] floatList = {4f, 2.5f, 1f, 8f, 6f};

        float [] listaInvertida = invertirPalabra(floatList);

        System.out.println(Arrays.toString(listaInvertida));
    }

    private static float [] invertirPalabra(float [] floatList) {
        float [] floatListInvertida = new float[floatList.length];
        float aux = 0;
        for (int i = 0; i <= floatList.length/2; i++) {
            aux = floatList[i];
            floatListInvertida[i] = floatList[floatList.length - 1 - i];
            floatListInvertida[floatListInvertida.length - 1 - i] = aux;
        }
        return floatListInvertida;
    }

    private static String encontrarPalabraMasConsonantes(List<String> stringList) {
        String palabraMasConsonantes = "";
        char [] vocales = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        int mayorNumeroConsonantes = 0;
        for (String palabra: stringList) {
            int consonantes = palabra.length();
            for (int i = 0; i < palabra.length(); i++) {
                char letraPalabra = palabra.charAt(i);
                for (char vocal : vocales) {
                    if (letraPalabra == vocal) {
                        consonantes--;
                    }
                }
            }
            //System.out.println(consonantes);
            if (consonantes > mayorNumeroConsonantes){
                mayorNumeroConsonantes = consonantes;
                palabraMasConsonantes = palabra;
            }
        }
        return palabraMasConsonantes;
    }

    private static int sumarBorderMatriz(int[][] matriz) {
        int sumaBordes = 0;
        for (int i = 0; i < matriz.length; i++) {
            sumaBordes += matriz[0][i];
            sumaBordes += matriz[matriz.length - 1][i];
            if (i > 0 && i < matriz.length - 1) {
                sumaBordes += matriz[i][0];
                sumaBordes += matriz[i][matriz.length - 1];
            }
        }
        return sumaBordes;
    }

}