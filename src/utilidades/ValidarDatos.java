package utilidades;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Daniel Díaz González
 * @version 1.0
 */
public class ValidarDatos {

    /**
     *
     * @param id DNI del cliente
     * @return Devuelve true o false si el DNI es correcto o no
     */
    public static boolean validarNif(String id) {
        boolean valido = false;
        String[] letra_dni = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};
        String[] letra_nif = {"J", "A", "B", "C", "D", "E", "F", "G", "H", "I"};
        //Patrón DNI//
        Pattern dni = Pattern.compile("[0-9]{8}[TRWAGMYFPDXBNJZSQVHLCKE]{1}", Pattern.CASE_INSENSITIVE);
        Matcher m_dni = dni.matcher(id);
        //Patrón NIF//
        Pattern nif = Pattern.compile("[ABCDEFGHJKLMNPQRSUVWXYZ]{1}[0-9]{7}[JABCDEFGHI0-9]{1}", Pattern.CASE_INSENSITIVE);
        Matcher m_nif = nif.matcher(id);
        //Patrón para conocer si es numerico o alfabetico
        Pattern numericos = Pattern.compile("[ABCDEFGHJKLMXYZ]");
        Matcher m_numericos = numericos.matcher(id.substring(0, 1));

        if (m_dni.matches()) {
            //Cadena de números
            String numeros = id.substring(0, 8);
            //Números convertidos a entero
            int numerosConvertido = Integer.parseInt(numeros);
            //Módulo de 23
            int resto = numerosConvertido % 23;
            //Asignación de letra
            String letra = letra_dni[resto];

            if (letra.equalsIgnoreCase(id.substring(8))) {
                valido = true;
            } else {
                valido = false;
            }
        }

        if (m_nif.matches()) {
            if (m_numericos.matches()) {
                //Cadena de números pares
                String numeros2 = id.substring(2, 3);
                String numeros4 = id.substring(4, 5);
                String numeros6 = id.substring(6, 7);
                int numerosParSuma = Integer.parseInt(numeros2) + Integer.parseInt(numeros4) + Integer.parseInt(numeros6);
                //Cadena de números impares
                String numeros1 = id.substring(1, 2);
                String numeros3 = id.substring(3, 4);
                String numeros5 = id.substring(5, 6);
                String numeros7 = id.substring(7, 8);
                int numerosInparSuma = (Integer.parseInt(numeros1) + Integer.parseInt(numeros3) + Integer.parseInt(numeros5) + Integer.parseInt(numeros7)) * 2;
                //**********//
                //Suma ambos numeros
                int suma = (numerosParSuma + numerosInparSuma);
                String sum = Integer.toString(suma);
                String digito1 = sum.substring(0, 1);
                //A 10 le restamos el primer dígito
                int diferencia = 10 - Integer.parseInt(digito1);
                String resta = Integer.toString(diferencia);
                //Asignación de letra
                if (resta.equalsIgnoreCase(id.substring(8))) {
                    valido = true;
                } else {
                    valido = false;
                }
            }
            if (!m_numericos.matches()) {
                //Cadena de números pares
                String numeros2 = id.substring(2, 3);
                String numeros4 = id.substring(4, 5);
                String numeros6 = id.substring(6, 7);
                int numerosParSuma = Integer.parseInt(numeros2) + Integer.parseInt(numeros4) + Integer.parseInt(numeros6);
                //Cadena de números impares
                String numeros1 = id.substring(1, 2);
                String numeros3 = id.substring(3, 4);
                String numeros5 = id.substring(5, 6);
                String numeros7 = id.substring(7, 8);
                int numerosInparSuma = (Integer.parseInt(numeros1) + Integer.parseInt(numeros3) + Integer.parseInt(numeros5) + Integer.parseInt(numeros7)) * 2;
                //**********//
                //Suma ambos numeros
                int suma = (numerosParSuma + numerosInparSuma);
                String sum = Integer.toString(suma);
                String digito1 = sum.substring(0, 1);
                //A 10 le restamos el primer dígito
                int diferencia = 10 - Integer.parseInt(digito1);
                //Asignación de letra
                String letra = letra_nif[diferencia];
                if (letra.equalsIgnoreCase(id.substring(8))) {
                    valido = true;
                } else {
                    valido = false;
                }
            }
        }

        return valido;
    }

    /**
     *
     * @param telefono Nuemero de teléfono para verificar
     * @return Devuleve true o false según sea valido o no el número
     */
    public static boolean validarTelefono(int telefono) {
        String s;

        s = Integer.toString(telefono);
        Pattern p = Pattern.compile("[0-9]{9}");
        Matcher m = p.matcher(s);

        return m.matches();
    }
}
