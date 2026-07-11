package util;

import java.util.Scanner;

/**
 * Clase utilitaria encargada de manejar los mensajes y avisos por consola,
 * y de validar la lectura de datos ingresados por el usuario.
 */
public class Pantalla {

    private static final Scanner scanner = new Scanner(System.in);

    private Pantalla() {
        // Clase utilitaria: no se instancia.
    }

    /**
     * Lee un número entero por consola, validando que el dato ingresado
     * sea realmente un entero. Vuelve a preguntar si el dato es inválido.
     */
    public static int leerEntero(String mensaje) {
        int valor = 0;
        boolean valido = false;
        while (!valido) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine();
            try {
                valor = Integer.parseInt(entrada.trim());
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("Dato inválido. Debe ingresar un número entero.");
            }
        }
        return valor;
    }

    /**
     * Lee un String por consola, validando que no esté vacío.
     * Vuelve a preguntar si el dato ingresado está vacío.
     */
    public static String leerString(String mensaje) {
        String valor = "";
        boolean valido = false;
        while (!valido) {
            System.out.print(mensaje);
            valor = scanner.nextLine();
            if (valor == null || valor.trim().isEmpty()) {
                System.out.println("Dato inválido. No puede ingresar un valor vacío.");
            } else {
                valido = true;
            }
        }
        return valor;
    }

    /**
     * Imprime un mensaje o aviso por consola.
     */
    public static void imprimir(String mensaje) {
        System.out.println(mensaje);
    }
}
