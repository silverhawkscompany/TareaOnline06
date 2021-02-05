package estructuraDatos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import utilidades.IO_ES;

/**
 *
 * @author Daniel Díaz González
 * @version 1.0
 */
public class Productos {

    private String codigo;
    private String nombre;
    private String descripcion;
    private double precio;
    private int unidades;

    /**
     * Método constructor
     *
     * @param codigo del Producto
     * @param nombre del Producto
     * @param descripcion del Producto
     * @param precio del Producto
     * @param unidades del Producto
     */
    public Productos(String codigo, String nombre, String descripcion, double precio, int unidades) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.unidades = unidades;

        if (precio < 0) {
            this.precio = 0;
        }
        if (unidades < 0) {
            this.unidades = 0;
        }
        if (!comprobarCodigo(codigo)) {
            this.codigo = "X";
        }
    }

    @Override
    public String toString() {
        String datosProducto = "Código: " + this.codigo + "\nNombre: " + this.nombre + "\nDescripción: " + this.descripcion + "\nPrecio: " + this.precio + "\nUnidades: " + this.unidades;
        return datosProducto;

    }

    /**
     *
     * @param codigo del Producto
     * @return Devuelve true o false si el codigo es correcto o falso
     */
    public static boolean comprobarCodigo(String codigo) {
        Pattern codigoPattern = Pattern.compile("[0-9]{13}"); // Patrón para comprobar el código de los productos
        Matcher m = codigoPattern.matcher(codigo);
        return m.matches();
    }

    /**
     *
     * @param unidades Número de unidades para añadir
     * @return Devuelve true o false si se ha permitido añadir nuevas unidades
     */
    public boolean aniadirUnidades(int unidades) {
        boolean permitido;
        if (unidades > 0) {
            this.unidades += unidades;
            permitido = true;
        } else {
            IO_ES.escribirLN("No se ha realizado la actualización de los datos");
            permitido = false;
        }
        return permitido;
    }

    /**
     *
     * @param unidades Número de unidades para eliminar
     * @return Devuelve true o false si se ha permitido eliminar nuevas unidades
     */
    public boolean quitarUnidades(int unidades) {
        boolean permitido;
        if (unidades > 0) {
            if (unidades > this.unidades) {
                this.unidades -= this.unidades;
            } else {
                this.unidades -= unidades;
            }
            permitido = true;
        } else {
            IO_ES.escribirLN("No se ha realizado la actualización de los datos");
            permitido = false;
        }
        return permitido;
    }

    ///****************************Métodos getter****************************///
    /**
     *
     * @return Devuelve el código del producto
     */
    public String getCodigo() {
        return this.codigo;
    }

    /**
     *
     * @return Devuelve el nombre del producto
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     *
     * @return Devuelve la descripción del producto
     */
    public String getDescripcion() {
        return this.descripcion;
    }

    /**
     *
     * @return Devuelve el precio del producto
     */
    public double getPrecio() {
        return this.precio;
    }

    /**
     *
     * @return Devuelve las unidades del producto
     */
    public int getUnidades() {
        return this.unidades;
    }

    ///****************************Métodos setter****************************///
    /**
     *
     * @param codigo Nuevo código para el producto
     */
    public void setCodigo(String codigo) {
        if (comprobarCodigo(codigo)) {
            this.codigo = codigo;
        }
    }

    /**
     *
     * @param nombre Nuevo nombre para el producto
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @param descripcion Nueva descripción para el producto
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     *
     * @param precio Nuevo precio para el producto
     */
    public void setPrecio(double precio) {
        if (precio >= 0) {
            this.precio = precio;
        }
    }
}
