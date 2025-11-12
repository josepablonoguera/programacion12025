/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package recursividad;

/**
 *
 * @author pablonoguera
 */
public class Recursividad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int powIterativo = powIterativo(2, 5);
        System.out.println("powIterativo = " + powIterativo);
        int powRecursivo = powR(2, 5);
        System.out.println("powRecursivo = " + powRecursivo);
        int vector[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < vector.length; i++) {
            System.out.print(" " + vector[i]);
        }
        System.out.println("");
        int v[] = duplicar(vector, 0);
        for (int i = 0; i < v.length; i++) {
            System.out.print("V: " + v[i]);
        }
        System.out.println("");
        int matriz[][] = {{10, 2, 3},
        {4, 10, 6},
        {7, 8, 10}};
        int diagonal = calcularDiagonal(matriz, 0, 0);
        System.out.println("diagonal = " + diagonal);

        int res = sumaEsquinas(matriz);
        System.out.println("res = " + res);

        boolean par = esPar(7);
        if (par) {
            System.out.println("Es par");

        } else {
            System.out.println("No es par");
        }

    }

    private static int powIterativo(int b, int exp) {

        if (exp == 0) {
            return 1;
        }
        if (exp == 1) {
            return b;
        }

        int resp = 1;

        for (int i = 0; i < exp; i++) {
            resp = resp * b;
        }

        return resp;

    }

    private static int powR(int b, int exp) {

        if (exp == 0) {
            return 1;
        }
        if (exp == 1) {
            return b;
        }

        return powR(b, exp - 1) * b;

    }

    private static int[] duplicar(int[] vector, int i) {

        if (i == vector.length - 1) {
            vector[i] = vector[i] * 2;
            return vector;
        }
        vector[i] = vector[i] * 2;

        return duplicar(vector, i + 1);

    }

    private static int calcularDiagonal(int[][] matriz, int i, int j) {

        if (matriz.length != matriz[0].length) {

            return 0;
        }

        if (i == matriz.length - 1) {
            return matriz[i][j];
        }

        return matriz[i][j] + calcularDiagonal(matriz, i + 1, j + 1);
    }

    private static int sumaEsquinas(int matriz[][]) {

        return matriz[0][0]
                + matriz[0][matriz[0].length - 1]
                + matriz[matriz.length - 1][0]
                + matriz[matriz.length - 1][matriz[0].length - 1];

    }

    private static boolean esPar(int n) {

        if (n % 2 == 0) {
            return true;
        }

        return esImpar(n );
    }

    private static boolean esImpar(int n) {

        if (n % 2 != 0) {
            return false;
        }
        return esPar(n );
    }
}
