package estructuraDatos;

import estructuraDatos.Enumerados.Categoria;

/**
 *
 * @author Daniel Díaz González
 * @version 1.0
 */
public class ParaFarmacia extends Producto {

    private Categoria categoria;
    private int dosisUnidades;
    private double descuento;

    /**
     * Contructor de la clase ParaFarmacia
     *
     * @param codigo
     * @param nombre
     * @param descripcion
     * @param precio
     * @param unidades
     * @param categoria
     * @param dosisUnidades
     * @param descuento
     */
    public ParaFarmacia(String codigo, String nombre, String descripcion, double precio, int unidades, Categoria categoria, int dosisUnidades, double descuento) {
        super(codigo, nombre, descripcion, precio, unidades);
        this.categoria = categoria;
        this.dosisUnidades = dosisUnidades;
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        String datosParaFarmacia = "Código: " + this.codigo + "\nNombre: " + this.nombre + "\nDescripción: " + this.descripcion + "\nPrecio: " + this.precio + "\nUnidades: " + this.unidades + "\nCategoria: " + this.categoria + "\nDosis de las unidades: " + this.dosisUnidades + "\nDescuento: " + this.descuento;
        return datosParaFarmacia;
    }

    ///****************************Métodos getter****************************///
    /**
     *
     * @return Devuelve la categgoria del producto de Parafarmacia
     */
    public Categoria getCategoria() {
        return this.categoria;
    }

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
     * @param categoria Nueva categoria del producto de Parafarmacia
     */
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

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
