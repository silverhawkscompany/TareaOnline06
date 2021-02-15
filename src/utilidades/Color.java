package utilidades;

/**
 * @author Daniel Díaz González
 * @version 1.0
 */
public class Color {

    /**
     * Método para cambiar las letras a color azul
     *
     * @return Devuelve el color azul
     */
    public static String azul() {
        return "\033[34m";
    }

    /**
     * Método para cambiar las letras a color rojo
     *
     * @return Devuelve el color rojo
     */
    public static String rojo() {
        return "\033[31m";
    }

    /**
     * Método para cambiar las letras a color verde
     *
     * @return Devuelve el color verde
     */
    public static String verde() {
        return "\033[32m";
    }

    /**
     * Método para cambiar las letras a color amarillo
     *
     * @return Devuelve el color amarillo
     */
    public static String amarillo() {
        return "\033[33m";
    }

    /**
     * Método para cambiar las letras a color morado
     *
     * @return Devuelve el color morado
     */
    public static String morado() {
        return "\033[35m";
    }

    /**
     * Método para cambiar las letras a color cian
     *
     * @return Devuelve el color cian
     */
    public static String cyan() {
        return "\033[36m";
    }

    /**
     * Método para volver a poner el color a negro
     *
     * @return Reinicia el color
     */
    public static String reset() {
        return "\u001B[0m";
    }
}
