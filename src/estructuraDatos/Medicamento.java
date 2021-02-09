package estructuraDatos;

/**
 *
 * @author Daniel Díaz González
 * @version 1.0
 */
public class Medicamento extends Productos {

    private String comoTomar;
    private String efectosAdversos;

    private enum TipoMedicamento {
        ANALGESICOS, LAXANTES, ANTIINFECCIOSOS, ANTIDEPRESIVOS, ANTITUSIVOS, MUCOLITICOS, ANTIACIDOS,
        ANTIULCEROSOS, ANTIALERGICOS, ANTIFIARREICOS
    };

    /**
     * Contructor de la clase Medicamentos
     *
     * @param codigo
     * @param nombre
     * @param descripcion
     * @param precio
     * @param unidades
     * @param comoTomar
     * @param efectosAdversos
     */
    public Medicamento(String codigo, String nombre, String descripcion, double precio, int unidades, String comoTomar, String efectosAdversos) {
        super(codigo, nombre, descripcion, precio, unidades);
        this.comoTomar = comoTomar;
        this.efectosAdversos = efectosAdversos;
    }

    @Override
    public String toString() {
        String datosMedicamento = "Código: " + this.codigo + "\nNombre: " + this.nombre + "\nDescripción: " + this.descripcion + "\nPrecio: " + this.precio + "\nUnidades: " + this.unidades + "\nToma del medicamento: " + this.comoTomar + "\nEfectos adversos: " + this.efectosAdversos;
        return datosMedicamento;
    }

    ///****************************Métodos getter****************************///
    /**
     *
     * @return Devuelve como tomar un medicamento
     */
    public String getComoTomar() {
        return this.comoTomar;
    }

    /**
     *
     * @return Devuelve los efectos adversos de los medicamentos
     */
    public String getEfectosAdversos() {
        return this.efectosAdversos;
    }

    ///****************************Métodos setter****************************///
    /**
     *
     * @param comoTomar Nueva forma de tomar un medicamento
     */
    public void setComoTomar(String comoTomar) {
        this.comoTomar = comoTomar;
    }

    /**
     *
     * @param efectosAdversos Nuevos efectos adeversos para los medicamentos
     */
    public void setEfectosAdversos(String efectosAdversos) {
        this.efectosAdversos = efectosAdversos;
    }

}
