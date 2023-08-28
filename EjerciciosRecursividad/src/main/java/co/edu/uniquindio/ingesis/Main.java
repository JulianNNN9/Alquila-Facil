package co.edu.uniquindio.ingesis;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {

         System.out.println("Factorial: " + factorialRecursivo(5));

         System.out.println("Fibonacci: " + calcularFibonacci(10));
         //1)
         System.out.println("1) " + productoSucesivo(5, 4));
         //2)
         System.out.println("2) " + divisionSucesiva(20, 5));
         //3)
         System.out.println("3) " + sumarImparesHastaN(10));
         //4)
         System.out.println("4) " + calcularPotencia(4, 3));
         //5)
         System.out.println("5) " + imprimirArray(0, new String[]{"a", "b", "c"}));
         //6)
         System.out.println("6) " + sumarArray(0, new int[]{1, 2, 3, 4}));
         //7)
         int [] ints = new int[]{4, 2, 1, 5, 8};
         System.out.println("7) " + retornarMenorElemento(1, ints, ints[0]));
         //8)
         System.out.println("8) " + contarRepeticionesElemento(1, 0, new int[]{1, 1, 1, 2, 2, 3, 1, 1}, 0));
         //9)
         Integer [][] matriz = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
         };
         System.out.println("9) ");
         imprimirMatriz(0, 0, matriz);
         //10)
         System.out.println("10) " + sumarMatrizCuadrada(0, 0, matriz) + " - No funciona");
         //11)
         System.out.println("11) " + determinarPalindrome(0, "amoma"));
         //12)
         System.out.println("12) " + contarNroVocales(0, "aeiouAEIOU", "aaaaa"));
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
        if (i > matriz.length - 1 || j > matriz.length - 1){
            return 0;
        }
        if (j < matriz.length - 1){
            return matriz[i][j] + sumarMatrizCuadrada(i, j + 1, matriz);
        } else {
            return sumarMatrizCuadrada(i + 1, 0, matriz);
        }
    }

    private static void imprimirMatriz(int i, int j, Integer [][] matriz) {
        if (i > matriz.length - 1 || j > matriz.length - 1){
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

    private static int retornarMenorElemento(int i, int[] ints, int menor) {
        if (ints[i] < menor) {
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

    private static int factorialRecursivo(int numero) {
        if (numero == 0 || numero == 1){
            return 1;
        }
        return numero * factorialRecursivo(numero - 1);
    }
}