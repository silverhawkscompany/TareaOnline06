package utilidades;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Daniel Díaz González
 * @version 1.0
 */
public class IO_ES {

    /**
     * Método para la lectura de un dato entero
     *
     * @return Devuelve un número entero
     */
    public static int leerInteger() {
        int numero = 0;
        boolean correcto = false;
        Scanner entrada = new Scanner(System.in);
        do {
            try {
                numero = Integer.parseInt(entrada.nextLine());
                correcto = true;
            } catch (InputMismatchException | NumberFormatException e) {
                System.err.println("Dato entero no válido");
            }
        } while (correcto == false);
        return numero;
    }

    /**
     * Método para la lectura de un dato entero añadiendo una cadena de texto
     *
     * @param mensaje Introducimos como parámetro la cadena de texto para
     * indicar que dato introducir
     * @return Devuelve un número entero
     */
    public static int leerInteger(String mensaje) {
        int numero = 0;
        boolean correcto = false;
        Scanner entrada = new Scanner(System.in);
        do {
            try {
                System.out.print(mensaje);
                numero = Integer.parseInt(entrada.nextLine());
                correcto = true;
            } catch (InputMismatchException | NumberFormatException e) {
                System.err.println("Dato entero no válido");
            }
        } while (correcto == false);
        return numero;
    }

    /**
     * Método para la lectura de un dato entero añadiendo una cadena de texto
     *
     * @param frase Introducimos como parámetro la cadena de texto para indicar
     * que dato introducir
     * @param min Número minimo que debemos introducir
     * @return Devuelve un número entero
     */
    public static int leerInteger(String frase, int min) {
        int numero = 0;
        boolean correcto = false;
        Scanner entrada = new Scanner(System.in);

        do {
            try {
                System.out.print(frase);
                numero = Integer.parseInt(entrada.nextLine());
                if (numero >= min) {
                    correcto = true;
                } else {
                    System.out.println("El número introducido debe ser mayor o igual a: " + min);
                }
            } catch (InputMismatchException | NumberFormatException e) {
                System.err.println("Dato entero no válido");
            }
        } while (correcto == false);
        return numero;
    }

    /**
     * Método para la lectura de un dato entero añadiendo una cadena de texto
     *
     * @param frase Introducimos como parámetro la cadena de texto para indicar
     * que dato introducir
     * @param min Número minimo que debemos introducir
     * @param max Número minimo que debemos introducir
     * @return Devuelve un número entero
     */
    public static int leerInteger(String frase, int min, int max) {
        int numero = 0;
        boolean correcto = false;
        Scanner entrada = new Scanner(System.in);

        do {
            try {
                System.out.print(frase);
                numero = Integer.parseInt(entrada.nextLine());
                if (numero >= min && max >= numero) {
                    correcto = true;
                } else {
                    System.out.println("El número introducido debe estar entre: " + min + " y " + max);
                }
            } catch (InputMismatchException | NumberFormatException e) {
                System.err.println("Dato entero no válido");
            }
        } while (correcto == false);
        return numero;
    }

    /**
     * Método para la lectura de un dato entero largo
     *
     *
     * @return Devuelve un número entero largo
     */
    public static long leerIntegerlargo() {
        long numero = 0;
        boolean correcto = false;
        Scanner entrada = new Scanner(System.in);
        do {
            try {
                numero = Long.parseLong(entrada.nextLine());
                correcto = true;
            } catch (InputMismatchException | NumberFormatException e) {
                System.err.println("Dato entero no válido");
                entrada.nextLine();
            }
        } while (correcto == false);
        return numero;
    }

    /**
     * Método para la lectura de un dato entero largo añadiendo una cadena de
     * texto
     *
     * @param frase Introducimos como parámetro la cadena de texto para indicar
     * que dato introducir
     * @return Devuelve un número entero largo
     */
    public static long leerIntegerlargo(String frase) {
        long numero = 0;
        boolean correcto = false;
        Scanner entrada = new Scanner(System.in);
        do {
            try {
                System.out.print(frase);
                numero = Long.parseLong(entrada.nextLine());
                correcto = true;
            } catch (InputMismatchException | NumberFormatException e) {
                System.err.println("Dato entero no válido");
                entrada.nextLine();
            }
        } while (correcto == false);
        return numero;
    }

    /**
     * Método para la lectura de un dato con decimal
     *
     *
     * @return Devuelve un número con decimal
     */
    public static float leerReal() {
        float numero = 0;
        boolean correcto = false;
        Scanner entrada = new Scanner(System.in);
        do {
            try {
                numero = Float.parseFloat(entrada.nextLine());
                correcto = true;
            } catch (InputMismatchException | NumberFormatException e) {
                System.err.println("Dato real no válido");
            }
        } while (correcto == false);
        return numero;
    }

    /**
     * Método para la lectura de un dato con decimal añadiendo una cadena de
     * texto
     *
     * @param frase Introducimos como parámetro la cadena de texto para indicar
     * que dato introducir
     * @return Devuelve un número con decimal
     */
    public static float leerReal(String frase) {
        float numero = 0;
        boolean correcto = false;
        Scanner entrada = new Scanner(System.in);
        do {
            try {
                System.out.print(frase);
                numero = Float.parseFloat(entrada.nextLine());
                correcto = true;
            } catch (InputMismatchException | NumberFormatException e) {
                System.err.println("Dato real no válido");
            }
        } while (correcto == false);
        return numero;
    }

    /**
     * Método para la lectura de un dato con decimal añadiendo una cadena de
     * texto
     *
     * @param frase Introducimos como parámetro la cadena de texto para indicar
     * que dato introducir
     * @param min Número mínimo que debemos escribir
     * @return Devuelve un número con decimal
     */
    public static float leerReal(String frase, float min) {
        float numero = 0;
        boolean correcto = false;
        Scanner entrada = new Scanner(System.in);
        do {
            try {
                System.out.print(frase);
                numero = Float.parseFloat(entrada.nextLine());
                if (numero >= min) {
                    correcto = true;
                } else {
                    System.out.println("El número introducido debe ser mayor o igual a: " + min);
                }
            } catch (InputMismatchException | NumberFormatException e) {
                System.err.println("Dato real no válido");
            }
        } while (correcto == false);
        return numero;
    }

    /**
     * Método para la lectura de un dato real largo
     *
     *
     * @return Devuelve un número real largo
     */
    public static double leerReallargo() {
        double numero = 0;
        boolean correcto = false;
        Scanner entrada = new Scanner(System.in);
        do {
            try {
                numero = Double.parseDouble(entrada.nextLine());
                correcto = true;
            } catch (InputMismatchException | NumberFormatException e) {
                System.err.println("Dato real no válido");
            }
        } while (correcto == false);
        return numero;
    }

    /**
     * Método para la lectura de un dato real largo añadiendo una cadena de
     * texto
     *
     * @param frase Introducimos como parámetro la cadena de texto para indicar
     * que dato introducir
     * @return Devuelve un número real largo
     */
    public static double leerReallargo(String frase) {
        double numero = 0;
        boolean correcto = false;
        Scanner entrada = new Scanner(System.in);
        do {
            try {
                System.out.print(frase);
                numero = Double.parseDouble(entrada.nextLine());
                correcto = true;
            } catch (InputMismatchException | NumberFormatException e) {
                System.err.println("Dato real no válido");
            }
        } while (correcto == false);
        return numero;
    }

    /**
     *
     * @return Devuelve lo que escribimos almacenado en una variable llamada
     * "cadena"
     */
    public static String leerCadena() {
        String cadena;
        Scanner entrada = new Scanner(System.in);

        System.out.print("Escribe una cadena: ");
        cadena = entrada.nextLine();

        return cadena;
    }

    /**
     *
     * @param mensaje Escribimos la informacion sobre que debemos escribir
     * @return Devuelve lo que escribimos almacenado en una variable llamada
     * "cadena"
     */
    public static String leerCadena(String mensaje) {
        String cadena;
        Scanner entrada = new Scanner(System.in);

        System.out.print(mensaje);
        cadena = entrada.nextLine();

        return cadena;
    }

    /**
     *
     * @param mensaje Escribimos la informacion sobre que debemos escribir
     * @param longitud Longitud de la cadena que vamos a escribir
     * @return Devuelve lo que escribimos almacenado en una variable llamada
     * "cadena"
     */
    public static String leerCadena(String mensaje, int longitud) {
        String cadena = null;
        Scanner entrada = new Scanner(System.in);
        boolean correcto = false;
        do {
            System.out.print(mensaje);
            cadena = entrada.nextLine();
            if (cadena.length() == longitud) {
                correcto = true;
            } else {
                System.out.println("La cadena debe tener " + longitud + " caracteres");
            }
        } while (correcto == false);
        return cadena;
    }

    /**
     *
     * @return Devuleve el primer caracter de la cadena que escribamos
     */
    public static char leerCaracter() {
        Scanner entrada = new Scanner(System.in);
        String cadena;
        char caracter;

        System.out.print("Escribe: ");
        cadena = entrada.nextLine();
        caracter = cadena.charAt(0);

        return caracter;
    }

    /**
     *
     * @param mensaje Escribe en este parámetro la frase que deseas que aparezca
     * por consola
     * @return Devuleve el primer caracter de la cadena que escribamos
     */
    public static char leerCaracter(String mensaje) {
        Scanner entrada = new Scanner(System.in);
        String cadena;
        char caracter;

        System.out.print(mensaje);
        cadena = entrada.nextLine();
        caracter = cadena.charAt(0);

        return caracter;
    }

    /**
     *
     * @return Devuelver true si hemos escrito "S" o false si ha sido "N"
     */
    public static boolean leerBoleano() {
        Scanner entrada = new Scanner(System.in);
        String valor;
        String verdadero = "s";
        String falso = "n";
        boolean boleano = false;
        boolean correcto = false;

        do {
            System.out.print("Escribe S/N: ");
            valor = entrada.nextLine();
            if (valor.equalsIgnoreCase(verdadero) || valor.equalsIgnoreCase(falso)) {
                if (valor.equalsIgnoreCase(verdadero)) {
                    boleano = true;
                }
                if (valor.equalsIgnoreCase(falso)) {
                    boleano = false;
                }
                correcto = true;
            } else {
                System.out.println("Solo puedes responder S/N");
            }
        } while (correcto == false);

        return boleano;
    }

    /**
     *
     * @param mensaje Parámetro para elegir el mensaje que deseamos mostrar por
     * consola
     * @return Devuelver true si hemos escrito "S" o false si ha sido "N"
     */
    public static boolean leerBoleano(String mensaje) {
        Scanner entrada = new Scanner(System.in);
        String valor;
        String verdadero = "s";
        String falso = "n";
        boolean boleano = false;
        boolean correcto = false;

        do {
            System.out.print(mensaje);
            valor = entrada.nextLine();
            if (valor.equalsIgnoreCase(verdadero) || valor.equalsIgnoreCase(falso)) {
                if (valor.equalsIgnoreCase(verdadero)) {
                    boleano = true;
                }
                if (valor.equalsIgnoreCase(falso)) {
                    boleano = false;
                }
                correcto = true;
            } else {
                System.out.println("Solo puedes responder S/N");
            }
        } while (correcto == false);

        return boleano;
    }

    /**
     * Método para la lectura de una cadena de texto sin salto de linea
     *
     * @param mensaje Introducir el mensaje que queremos mostrar por consola
     */
    public static void escribir(String mensaje) {
        System.out.print(mensaje);
    }

    /**
     * Método para la lectura de una cadena de texto con salto de linea
     *
     * @param mensaje Introducir el mensaje que queremos mostrar por consola,
     * nos añade un salto de linea
     */
    public static void escribirLN(String mensaje) {
        System.out.println(mensaje);
    }
}
