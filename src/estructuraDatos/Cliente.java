package estructuraDatos;

/**
 *
 * @author Daniel Díaz González
 * @version 1.0
 */
public class Cliente {

    private String id;
    private String nombre;
    private String direccion;
    private int telefono;
    private boolean baja;

    /**
     * Método constructor
     *
     * @param id NIF del cliente
     * @param nombre Nombre del cliente
     * @param direccion Dirección del cliente
     * @param telefono Teléfono del cliente
     */
    public Cliente(String id, String nombre, String direccion, int telefono) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.baja = false;
    }

    @Override
    public String toString() {
        String datosCliente = "DNI: " + this.id + "\nNombre: " + this.nombre + "\nTeléfono: " + this.telefono + "\nDirección: " + this.direccion;
        return datosCliente;
    }

    ///****************************Métodos getter****************************///
    /**
     *
     * @return Devuelve el NIF del cliente
     */
    public String getId() {
        return this.id;
    }

    /**
     *
     * @return Devuelve el nombre del cliente
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     *
     * @return Devuelve la dirección del cliente
     */
    public String getDireccion() {
        return this.direccion;
    }

    /**
     *
     * @return Devuelve el teléfono del cliente
     */
    public int getTelefono() {
        return this.telefono;
    }

    /**
     *
     * @return Devuelve si el cliente esta de baja
     */
    public boolean getBaja() {
        return baja;
    }

    ///****************************Métodos setter****************************///
    /**
     *
     * @param id Nuevo NIF
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @param nombre Nuevo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @param direccion Nueva dirección
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     *
     * @param telefono Nuevo teléfono
     */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    /**
     *
     * @param baja
     */
    public void setBaja(boolean baja) {
        this.baja = baja;
    }
}
