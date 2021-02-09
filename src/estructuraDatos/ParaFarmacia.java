package estructuraDatos;

/**
 *
 * @author Daniel Díaz González
 * @version 1.0
 */
public class ParaFarmacia extends Productos {

    private int dosisUnidades;
    private double descuento;

    private enum Categoria {
        DENTAL, FACIAL, GELES, CORPORAL, CABELLO, ANTIMOSQUITOS, INTIMA,
        NASAL, OCULAR, BOTIQUIN, OIDOS, TOALLITAS, LIMPIEZA, HOGAR, MASCARILLAS
    }

    /**
     * Contructor de la clase ParaFarmacia
     *
     * @param codigo
     * @param nombre
     * @param descripcion
     * @param precio
     * @param unidades
     * @param dosisUnidades
     * @param descuento
     */
    public ParaFarmacia(String codigo, String nombre, String descripcion, double precio, int unidades, int dosisUnidades, double descuento) {
        super(codigo, nombre, descripcion, precio, unidades);
        this.dosisUnidades = dosisUnidades;
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        String datosParaFarmacia = "Código: " + this.codigo + "\nNombre: " + this.nombre + "\nDescripción: " + this.descripcion + "\nPrecio: " + this.precio + "\nUnidades: " + this.unidades + "\nDosis de las unidades: " + this.dosisUnidades + "\nDescuento: " + this.descuento;
        return datosParaFarmacia;
    }

    ///****************************Métodos getter****************************///
    /**
     *
     * @return Devuelve las dosis de cada producto
     */
    public int getDosisUnidades() {
        return this.dosisUnidades;
    }

    /**
     *
     * @return Devuelve el descuento de cada producto
     */
    public double getDescuento() {
        return this.descuento;
    }

    ///****************************Métodos setter****************************///
    /**
     *
     * @param dosisUnidades Nuevas dosis para el producto
     */
    public void setDosisUnidades(int dosisUnidades) {
        this.dosisUnidades = dosisUnidades;
    }

    /**
     *
     * @param descuento Nuevo descuento del producto
     */
    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

}