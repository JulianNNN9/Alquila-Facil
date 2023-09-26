package co.edu.uniquindio.ingesis;


import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {

        //-----EJEMPLOS-----

        System.out.println("Factorial: " + factorialRecursivo(5, 1));

        System.out.println("Fibonacci: " + calcularFibonacci(10));

        //-----EJERCICIOS-----

        System.out.println();
        System.out.println("EJERCICIOS: ");
        System.out.println();


        System.out.println("1) " + productoSucesivo(5, 4));

        System.out.println("2) " + divisionSucesiva(20, 5));

        System.out.println("3) " + sumarImparesHastaN(10));

        System.out.println("4) " + calcularPotencia(4, 3));

        System.out.println("5) " + imprimirArray(0, new String[]{"a", "b", "c"}));

        System.out.println("6) " + sumarArray(0, new int[]{1, 2, 3, 4}));

        int [] ints = new int[]{4, 2, 1, 5, 8};
        System.out.println("7) " + retornarMenorElemento(1, ints, ints[0]));

        System.out.println("8) " + contarRepeticionesElemento(1, 0, new int[]{1, 1, 1, 2, 2, 3, 1, 1}, 0));

        Integer [][] matriz = {
                {1,1,1},
                {1,1,1},
                {1,1,1}
        };
        System.out.println("9) ");
        imprimirMatriz(0, 0, matriz);

        System.out.println("10) " + sumarMatrizCuadrada(0, 0, matriz));

        System.out.println("11) " + determinarPalindrome(0, "amoma"));

        System.out.println("12) " + contarNroVocales(0, "aeiouAEIOU", "aaaaa"));

        //-----TALLER 1-----

        System.out.println();
        System.out.println("TALLER 1: ");
        System.out.println();

        System.out.println("1) " + multiplicacionRusa(5, 5));

        System.out.println("2) " + invertirNumero(123, 0, 0));

        System.out.println("3) " + encontrarModulo(8, 5, 0));

        String [] cadenas = {"A", "B", "C", "D", "E", "F"};
        ArrayList<String> combinaciones = new ArrayList<>();
        combinarElementos(0, 1, cadenas, combinaciones);
        System.out.println("4) " + combinaciones);

        //-----TALLER 2-----

        System.out.println();
        System.out.println("TALLER 2: ");
        System.out.println();

        System.out.println("1) " + esPotencia(16, 2));

        int [] ints1 = new int[]{4, 2, 1, 5, 3};
        ordenarFormaDescendente(ints1, 0, 1, 0);
        System.out.println("2) " + Arrays.toString(Arrays.stream(ints1).toArray()));

        System.out.println("3) " + esPerfecto(28, 0, 28));

        int [] ints2 = new int[]{4, 2, 1, 5, 3};
        System.out.println("4) " + encontrarNormaVector(ints2, 0, 0));

        System.out.println("5) Repetida");

        int [] ints3 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("6) " + contarNumerosPrimos(ints3, 0, 2, ints3.length - 1));

        int [] ints4 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("7) " + mostrarNumerosEnIndicePar(ints4, 0));

        String [] strings = new String[]{"miedo", "bucear", "abeto", "diodos", "abeja", };
        System.out.println("8) " + buscarLetra_E_EnMedio(strings, 0));

        double [] doubles = new double[]{1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0, 4.5, 5.0};
        double promedio = obtenerPromedio(doubles);
        System.out.println("9) ");
        contarNumerosEncima_y_DebajoDelPromedio(doubles, 0, 0, 0, promedio);

        Double [][] matriz1 = {
                {1.0, 2.0, 3.0},
                {4.0, 5.0, 6.0},
                {7.0, 8.0, 9.0}
        };
        System.out.println("10) " + promedioDiagonal(matriz1, 0, 0, 0));

        int [][] matriz2 = {
                {2,3,4},
                {9,1,5},
                {8,7,6}
        };
        System.out.println("11) " + retornarMenorElementoMatriz(matriz2, 0, 0, matriz2[0][0]));

        Double [][] matriz3 = {
                {1.0, 2.0, 3.0},
                {4.0, 5.0, 6.0},
                {7.0, 8.0, 9.0}
        };
        System.out.println("12) " + sumarDiagonalSecundaria(matriz3, matriz3.length - 1, 0));

        System.out.println("14) ");
    }

        private static double sumarDiagonalSecundaria(Double[][] matriz, int i, double suma) {
            if (i >= 0){
                suma = suma + matriz[i][i];
                return sumarDiagonalSecundaria(matriz, --i, suma);
            }
            return suma;
        }

    private static int retornarMenorElementoMatriz(int[][] matriz, int i, int j, int menor) {
        if (i < matriz.length - 1){
            if (j < matriz.length - 1){
                if (matriz[i][j] < menor){
                    menor = matriz[i][j];
                }
                return retornarMenorElementoMatriz(matriz, i, ++j, menor);
            }
            return retornarMenorElementoMatriz(matriz, ++i, 0, menor);
        }
        return menor;
    }

    private static double promedioDiagonal(Double[][] matriz, int i, double promedio, double suma) {
        if (i == matriz.length){
            return promedio;
        }
        suma = suma + matriz[i][i];
        promedio = suma/matriz.length;
        return promedioDiagonal(matriz, ++i, promedio, suma);
    }


    private static void contarNumerosEncima_y_DebajoDelPromedio(double[] doubles, int i, int porEncima, int porDebajo, double promedio) {
        if (i == doubles.length - 1){
            System.out.println("Por debajo: " + porDebajo);
            System.out.println("Por encima: " + porEncima);
            return;
        }
        if (doubles[i] <= promedio && doubles[i] != promedio){
            contarNumerosEncima_y_DebajoDelPromedio(doubles, ++i, porEncima, ++porDebajo, promedio);
        } else if (doubles[i] >= promedio){
            contarNumerosEncima_y_DebajoDelPromedio(doubles, ++i, ++porEncima, porDebajo, promedio);
        }
    }
    private static double obtenerPromedio(double[] doubles) {
        double suma = 0;
        for (double numero: doubles) {
            suma += numero;
        }
        return suma/doubles.length;
    }

    private static String buscarLetra_E_EnMedio(String[] strings, int i) {
        if (i == strings.length){
            return "";
        }
        if (strings[i].charAt(strings.length / 2) == 'e'){
            return strings[i] + ", " + buscarLetra_E_EnMedio(strings, ++i);
        }
        return buscarLetra_E_EnMedio(strings, ++i);
    }

    private static String mostrarNumerosEnIndicePar(int[] ints, int i) {
        if (i == ints.length){
            return "";
        }
        if (i == 0){
            return ints[i] + " " + mostrarNumerosEnIndicePar(ints, i += 2);
        }
        if (i % 2 == 0){
            return ints[i] + " " + mostrarNumerosEnIndicePar(ints, i += 2);
        }
        return "";
    }

    private static int contarNumerosPrimos(int[] ints, int i, int j, int primos) {
        if (i == ints.length){
            return primos;
        }
        if (ints[i] > 1){
            if (j < ints [i] && ints[i] % j == 0){
                return contarNumerosPrimos(ints, i, ++j, --primos);
            }
        }
        return contarNumerosPrimos(ints, ++i, 2, primos);
    }

    private static int encontrarNormaVector(int[] ints, int i, int sumatoria) {
        if (i == ints.length){
            return (int) Math.sqrt(sumatoria);
        }
        sumatoria = sumatoria + (int) Math.pow(ints[i], 2);
        return encontrarNormaVector(ints, ++i,sumatoria);
    }

    private static boolean esPerfecto(int n, int suma, int aux) {
        if (suma == n){
            return true;
        }
        if (aux <= 0){
            return false;
        }
        return esPerfecto(n, suma + (n / 2), aux / 2);
    }

    private static void ordenarFormaDescendente(int[] ints, int i, int j, int aux) {
        if (i < ints.length - 1){
            if (j < ints.length - 1){
                if (ints[j] < ints[j + 1]){
                    aux = ints[j + 1];
                    ints[j + 1] = ints[j];
                    ints[j] = aux;
                }
                ordenarFormaDescendente(ints, i, ++j, 0);
            }
            ordenarFormaDescendente(ints, ++i, 0, 0);
        }
    }


    private static boolean esPotencia(int b, int n) {
        if (b == 1) {
            return true;
        }
        if (b < n || b % n != 0) {
            return false;
        }
        return esPotencia(b / n, n);
    }

    private static void combinarElementos(int i, int j, String[] cadenas, ArrayList<String> combinaciones) {
        if (i == cadenas.length){
            return;
        }
        if (i < cadenas.length && i + j < cadenas.length){
            combinaciones.add(cadenas[i] + cadenas[i + j]);
            combinarElementos(i, j + 1, cadenas, combinaciones);
        } else {
            combinarElementos(i + 1, 1, cadenas, combinaciones);
        }
    }

    private static int encontrarModulo(int a, int b, int residuo) throws Exception {
        if (b == 0){
            throw new Exception("División inválida");
        }
        if (a < b){
            return residuo;
        }
        return encontrarModulo(a - b, b, a- b);
    }

    public static int invertirNumero(int numero, int resto, int numeroInvertido){
        if (numero == 0){
            return numeroInvertido;
        }
        resto = numero % 10;
        numeroInvertido = (numeroInvertido * 10) + resto;
        return invertirNumero(numero / 10, 0, numeroInvertido);
    }

    private static int multiplicacionRusa(int m, int n) {
        if (m <= 0){
            return 0;
        }
        if (m % 2 != 0){
            return n + multiplicacionRusa(m / 2, n * 2);
        }
        return multiplicacionRusa(m / 2, n * 2);
    }

    private static int contarNroVocales(int i, String vocales, String cadena) {
        if (i > cadena.length() - 1){
            return 0;
        }
        if (vocales.contains(String.valueOf(cadena.charAt(i)))){
            return 1 + contarNroVocales(i + 1, vocales, cadena);
        } else {
            return contarNroVocales(i + 1, vocales,cadena);
        }
    }

    private static boolean determinarPalindrome(int i, String cadena) {
        if (i > cadena.length() / 2){
            return false;
        }
        if (cadena.charAt(i) == cadena.charAt(cadena.length() - 1 - i)){
            determinarPalindrome(i + 1, cadena);
            return true;
        } else {
            return false;
        }
    }

    private static int sumarMatrizCuadrada(int i, int j, Integer[][] matriz) {
        if (i == matriz.length){
            return 0;
        }
        if (j < matriz.length){
            return matriz[i][j] + sumarMatrizCuadrada(i, j + 1, matriz);
        } else {
            return sumarMatrizCuadrada(i + 1, 0, matriz);
        }
    }

    private static void imprimirMatriz(int i, int j, Integer [][] matriz) {
        if (i == matriz.length){
            return;
        }
        System.out.print(matriz[i][j] + " ");
        if (j < matriz.length - 1){
            imprimirMatriz(i, j + 1, matriz);
        } else {
            System.out.println();
            imprimirMatriz(i + 1, 0, matriz);
        }
    }

    private static int contarRepeticionesElemento(int elemento, int i, int[] ints, int repeticiones) {
        if (i > ints.length - 1){
            return repeticiones;
        }
        if (elemento == ints[i]){
            return contarRepeticionesElemento(elemento, i + 1, ints, repeticiones + 1);
        } else {
            return contarRepeticionesElemento(elemento, i + 1, ints, repeticiones);
        }
    }

    private static int contarRepeticionesElemento1(int elemento, int i, int[] ints) {
        if (i > ints.length - 1){
            return 0;
        }
        if (elemento == ints[i]){
            return 1 + contarRepeticionesElemento1(elemento, i + 1, ints);
        } else {
            return contarRepeticionesElemento1(elemento, i + 1, ints);
        }
    }

    private static int retornarMenorElemento(int i, int[] ints, int menor) {
        if (ints[i] < menor) { // {4, 2, 1, 5, 8}
            menor = ints[i];
        }
        if (i + 1 < ints.length){
            return retornarMenorElemento(i + 1, ints, menor);
        } else {
            return menor;
        }
    }

    private static int sumarArray(int i, int[] ints) {
        if (i > ints.length - 1){
            return 0;
        }
        return ints[i] + sumarArray(i + 1, ints);
    }

    private static String imprimirArray(int i, String[] strings) {
        if (i > strings.length - 1){
            return "";
        }
        return strings[i] + " " + imprimirArray(i + 1, strings);
    }

    private static int calcularPotencia(int base, int exponente) {
        if (exponente == 0){
            return 1;
        }
        return base * calcularPotencia(base, exponente - 1);
    }

    private static int sumarImparesHastaN(int n) {
        if (n < 0) {
            return 0;
        }
        if (n % 2 != 0) {
            return n + sumarImparesHastaN(n - 2);
        } else {
            return sumarImparesHastaN(n - 1);
        }
    }

    private static double divisionSucesiva(double a, double b) throws Exception {
        if (b == 0){
            throw new Exception("No es posible dividir entre cero.");
        }
        if (b > a){
            return 0;
        }
        return 1 + divisionSucesiva(a - b, b);
    }

    private static double productoSucesivo(double a, double b) {
        if (b == 0){
            return  0;
        }
        return a + productoSucesivo(a, b - 1);
    }

    private static int calcularFibonacci(int n) {
        if (n == 1 || n == 0){
            return n;
        }
        return calcularFibonacci(n - 2) + calcularFibonacci(n - 1);
    }

    private static int factorialRecursivo(int numero, int resultado) {
        if (numero == 0 || numero == 1){
            return resultado;
        }
        resultado = resultado * numero;
        return factorialRecursivo(numero - 1, resultado);
    }
}