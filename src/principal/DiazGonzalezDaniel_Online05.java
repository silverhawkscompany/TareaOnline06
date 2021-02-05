package principal;

import utilidades.*;
import estructuraDatos.*;

/**
 *
 * @author Daniel Díaz González
 * @version 1.0
 */
public class DiazGonzalezDaniel_Online05 {

    /**
     * @param args Menu principal donde se inicia la ejecución del programa
     */
    public static void main(String[] args) {
        boolean correcto = false;
        int opciones;

        IO_ES.escribirLN("BIENVENIDOS A LA APLICACIÓN DE FARMACIA");
        do {
            IO_ES.escribirLN("---------------------------------------");
            IO_ES.escribirLN("               LA BOTÍCA               ");
            IO_ES.escribirLN("---------------------------------------");
            IO_ES.escribirLN("1.  Añadir cliente \n2.  Eliminar cliente \n3.  Modificar cliente \n4.  Mostrar clientes");
            IO_ES.escribirLN("\n5.  Añadir producto \n6.  Eliminar producto \n7.  Modificar producto \n8.  Añadir unidades \n9.  Quitar unidades \n10. Mostrar productos");
            IO_ES.escribirLN("0.  Salir");
            opciones = IO_ES.leerInteger("Introduzca una opción: ", 0, 10);
            switch (opciones) {
                case 1:
                    aniadirClientes();
                    break;
                case 2:
                    eliminarCliente();
                    break;
                case 3:
                    modificarCliente();
                    break;
                case 4:
                    mostrarClientes();
                    break;
                case 5:
                    aniadirProducto();
                    break;
                case 6:
                    eliminarProducto();
                    break;
                case 7:
                    modificarProducto();
                    break;
                case 8:
                    aniadirUnidades();
                    break;
                case 9:
                    eliminarUnidades();
                    break;
                case 10:
                    mostrarProductos();
                    break;
                case 0:
                    correcto = true;
                    break;
            }
        } while (correcto == false);

    }

    private static final Clientes[] MISCLIENTES = new Clientes[50];
    private static int contadorClientes = 0;

    private static final Productos[] MISPRODUCTOS = new Productos[50];
    private static int contadorProductos = 0;

    /**
     *
     * @param id DNI o NIF del cliente que deseamos buscar
     * @return Devuelve true o false, si el cliente ha sido encontrado
     */
    public static boolean buscarClientes(String id) {
        boolean encontrado = false;
        for (int i = 0; i < MISCLIENTES.length; i++) {
            if (MISCLIENTES[i] != null) {
                if (MISCLIENTES[i].getId().equalsIgnoreCase(id)) {
                    encontrado = true;
                    IO_ES.escribirLN("---------------------------------------");
                    IO_ES.escribirLN(MISCLIENTES[i].toString());
                }
            }
        }
        return encontrado;
    }

    /**
     *
     * @param codigo Código del producto que deseamos buscar
     * @param mostrarArray Si el valor es "0" no muestra el Array, si es "1" si
     * lo muestra
     * @return Devuelve true o false, si encuentra el producto
     */
    public static boolean buscarProductos(String codigo, int mostrarArray) {
        boolean encontrado = false;
        if (mostrarArray == 0) {
            for (int i = 0; i < MISPRODUCTOS.length; i++) {
                if (MISPRODUCTOS[i] != null) {
                    if (MISPRODUCTOS[i].getCodigo().equalsIgnoreCase(codigo)) {
                        encontrado = true;
                    }
                }
            }
        }
        if (mostrarArray == 1) {
            for (int i = 0; i < MISPRODUCTOS.length; i++) {
                if (MISPRODUCTOS[i] != null) {
                    if (MISPRODUCTOS[i].getCodigo().equalsIgnoreCase(codigo)) {
                        encontrado = true;
                        IO_ES.escribirLN("---------------------------------------");
                        IO_ES.escribirLN(MISPRODUCTOS[i].toString());
                    }
                }
            }
        }

        return encontrado;
    }

    /**
     * Método para añadir un cliente
     */
    public static void aniadirClientes() {
        String id, nombre, direccion;
        int telefono;

        IO_ES.escribirLN("\n---------------------------------------");
        IO_ES.escribirLN("AÑADIR CLIENTE");
        id = IO_ES.leerCadena("Introduzca el NIF/DNI del cliente: ", 9);
        if (ValidarDatos.validarNif(id)) {
            if (!buscarClientes(id)) {
                nombre = IO_ES.leerCadena("Introduzca el nombre: ");
                direccion = IO_ES.leerCadena("Introduzca la dirección: ");
                telefono = IO_ES.leerInteger("Introduzca el teléfono: ");

                MISCLIENTES[contadorClientes] = new Clientes(id, nombre, direccion, telefono);
                contadorClientes++;
                IO_ES.escribirLN("Cliente añadido");
            }
        }
    }

    /**
     * Método para eliminar un cliente
     */
    public static void eliminarCliente() {
        String buscar;
        boolean encontrado = false;

        IO_ES.escribirLN("\n---------------------------------------");
        IO_ES.escribirLN("DAR DE BAJA CLIENTE");
        buscar = IO_ES.leerCadena("Introduzca el DNI: ", 9);
        for (int i = 0; i < MISCLIENTES.length; i++) {
            if (MISCLIENTES[i] != null) {
                if (buscarClientes(buscar)) {
                    encontrado = true;
                    MISCLIENTES[i] = null;
                    IO_ES.escribirLN("El cliente se ha dado de baja");
                    contadorClientes--;
                }
            }
        }
        if (!encontrado) {
            IO_ES.escribirLN("El cliente no se encuentra en la base de datos");
        }
    }

    /**
     * Método para modificar un cliente
     */
    public static void modificarCliente() {
        int opciones;
        String buscar;
        boolean correcto = false;

        IO_ES.escribirLN("\n---------------------------------------");
        IO_ES.escribirLN("MODIFICAR CLIENTE");
        buscar = IO_ES.leerCadena("Introduzca el DNI/NIF: ", 9);
        if (buscarClientes(buscar)) {
            do {
                IO_ES.escribirLN("1. Nombre \n2. Dirección \n3. Teléfono \n0. Salir");
                opciones = IO_ES.leerInteger("Elige una opción para modificar del cliente: ", 0, 4);
                switch (opciones) {
                    case 1:
                        String nombreNuevo = IO_ES.leerCadena("Escribe el nuevo nombre: ");
                        for (int i = 0; i < MISCLIENTES.length; i++) {
                            if (MISCLIENTES[i] != null) {
                                if (MISCLIENTES[i].getId().equalsIgnoreCase(buscar)) {
                                    MISCLIENTES[i].setNombre(nombreNuevo);
                                }
                            }
                        }
                        break;
                    case 2:
                        String dirreccionNuevo = IO_ES.leerCadena("Escribe la nueva dirección: ");
                        for (int i = 0; i < MISCLIENTES.length; i++) {
                            if (MISCLIENTES[i] != null) {
                                if (MISCLIENTES[i].getId().equalsIgnoreCase(buscar)) {
                                    MISCLIENTES[i].setDireccion(dirreccionNuevo);
                                }
                            }
                        }
                        break;
                    case 3:
                        int telefonoNuevo = IO_ES.leerInteger("Escribe el nuevo teléfono: ");
                        for (int i = 0; i < MISCLIENTES.length; i++) {
                            if (MISCLIENTES[i] != null) {
                                if (MISCLIENTES[i].getId().equalsIgnoreCase(buscar)) {
                                    MISCLIENTES[i].setTelefono(telefonoNuevo);
                                }
                            }
                        }
                        break;
                    case 0:
                        correcto = true;
                        break;
                }
            } while (correcto == false);
        } else {
            IO_ES.escribirLN("El cliente no se encuentra en la base de datos");
        }
    }

    /**
     * Método para mostrar a uno o a todos los clientes
     */
    public static void mostrarClientes() {
        int opciones;
        String buscar;
        boolean encontrado = false;

        IO_ES.escribirLN("\n---------------------------------------");
        IO_ES.escribirLN("1. Mostrar todos los clientes \n2. Buscar un clientes \n0. Salir");
        opciones = IO_ES.leerInteger("Elige una opción: ", 0, 3);
        switch (opciones) {
            case 1:
                for (int i = 0; i < MISCLIENTES.length; i++) {
                    if (MISCLIENTES[i] != null) {
                        IO_ES.escribirLN("---------------------------------------");
                        IO_ES.escribirLN(MISCLIENTES[i].toString());
                        encontrado = true;
                    }
                }
                if (!encontrado) {
                    IO_ES.escribirLN("La base de datos de clientes esta vacia");
                }
                break;
            case 2:
                buscar = IO_ES.leerCadena("Introduzca el DNI/NIF: ", 9);
                if (buscarClientes(buscar)) {
                } else {
                    IO_ES.escribirLN("El cliente no se ha encontrado");
                }
                break;
            case 0:
                break;
        }
    }

    /**
     * Método para añadir un producto
     */
    public static void aniadirProducto() {
        String codigo, nombre, descripcion;
        double precio;
        int unidades;
        boolean encontrado = false;

        IO_ES.escribirLN("\n---------------------------------------");
        IO_ES.escribirLN("AÑADIR PRODUCTO");
        codigo = IO_ES.leerCadena("Introduzca el código del producto: ");
        if (buscarProductos(codigo, 1)) {
            IO_ES.escribirLN("El código del producto ya esta asignado");
        } else {
            codigo = "X";
        }
        if (!buscarProductos(codigo, 0) || codigo.equalsIgnoreCase("X")) {
            nombre = IO_ES.leerCadena("Introduzca el nombre del producto: ");
            for (int i = 0; i < MISPRODUCTOS.length; i++) {
                if (MISPRODUCTOS[i] != null) {
                    if (MISPRODUCTOS[i].getNombre().equalsIgnoreCase(nombre)) {
                        encontrado = true;
                        IO_ES.escribirLN("El nombre del producto ya esta asignado");
                    }
                }
            }
            if (!encontrado) {
                descripcion = IO_ES.leerCadena("Introduzca la descripción del producto: ");
                precio = IO_ES.leerReallargo("Introduzca el precio del producto: ");
                unidades = IO_ES.leerInteger("Introduzca las unidades del producto: ", 0);
                MISPRODUCTOS[contadorProductos] = new Productos(codigo, nombre, descripcion, precio, unidades);
                contadorProductos++;
                IO_ES.escribirLN("Se ha añadido un producto");

            }
        }
    }

    /**
     * Método para mostrar uno o todos los productos
     */
    public static void mostrarProductos() {
        int opciones;
        boolean encontrado = false;

        IO_ES.escribirLN("\n---------------------------------------");
        IO_ES.escribirLN("1. Mostrar todos los productos \n2. Buscar un producto \n0. Salir");
        opciones = IO_ES.leerInteger("Escoge una opción: ", 0, 3);
        switch (opciones) {
            case 1:
                for (int i = 0; i < MISPRODUCTOS.length; i++) {
                    if (MISPRODUCTOS[i] != null) {
                        IO_ES.escribirLN("---------------------------------------");
                        IO_ES.escribirLN(MISPRODUCTOS[i].toString());
                        encontrado = true;
                    }
                }
                if (!encontrado) {
                    IO_ES.escribirLN("La base de datos de productos esta vacia");
                }
                break;
            case 2:
                String codigo = IO_ES.leerCadena("Indica el código del producto: ");
                if (buscarProductos(codigo, 1)) {
                } else {
                    IO_ES.escribirLN("El producto no se encuentra en la base de datos");
                }
                break;
            case 0:
                break;
        }
    }

    /**
     * Método para eliminar un producto
     */
    public static void eliminarProducto() {
        String buscar;
        boolean encontrado = false;

        IO_ES.escribirLN("\n---------------------------------------");
        IO_ES.escribirLN("ELIMINAR PRODUCTO");
        buscar = IO_ES.leerCadena("Indique el código del producto: ");
        for (int i = 0; i < MISPRODUCTOS.length; i++) {
            if (MISPRODUCTOS[i] != null) {
                if (buscarProductos(buscar, 1)) {
                    encontrado = true;
                    MISPRODUCTOS[i] = null;
                    IO_ES.escribirLN("El producto se ha eliminado correctamente");
                    contadorProductos--;
                }
            }
        }
        if (!encontrado) {
            IO_ES.escribirLN("El producto no se encuentra en la base de datos");
        }
    }

    /**
     * Método para modificar modificar un producto
     */
    public static void modificarProducto() {
        int opciones;
        String buscar;
        boolean correcto = false;

        IO_ES.escribirLN("\n---------------------------------------");
        IO_ES.escribirLN("MODIFICAR PRODUCTO");
        buscar = IO_ES.leerCadena("Introduzca el código del producto: ");
        if (buscarProductos(buscar, 1)) {
            do {
                IO_ES.escribirLN("1. Nombre \n2. Descripción \n3. Precio \n0. Salir");
                opciones = IO_ES.leerInteger("Elige una opción para modificar del producto: ", 0, 4);
                switch (opciones) {
                    case 1:
                        String nuevoNombre = IO_ES.leerCadena("Escribe el nuevo nombre: ");
                        for (int i = 0; i < MISPRODUCTOS.length; i++) {
                            if (MISPRODUCTOS[i] != null) {
                                if (MISPRODUCTOS[i].getCodigo().equalsIgnoreCase(buscar)) {
                                    MISPRODUCTOS[i].setNombre(nuevoNombre);
                                }
                            }
                        }
                        break;
                    case 2:
                        String nuevaDescripcion = IO_ES.leerCadena("Escribe la nueva descripcion: ");
                        for (int i = 0; i < MISPRODUCTOS.length; i++) {
                            if (MISPRODUCTOS[i] != null) {
                                if (MISPRODUCTOS[i].getCodigo().equalsIgnoreCase(buscar)) {
                                    MISPRODUCTOS[i].setDescripcion(nuevaDescripcion);
                                }
                            }
                        }
                        break;
                    case 3:
                        double nuevoPrecio = IO_ES.leerReallargo("Escribe el nuevo precio: ");
                        for (int i = 0; i < MISPRODUCTOS.length; i++) {
                            if (MISPRODUCTOS[i] != null) {
                                if (MISPRODUCTOS[i].getCodigo().equalsIgnoreCase(buscar)) {
                                    MISPRODUCTOS[i].setPrecio(nuevoPrecio);
                                }
                            }
                        }
                        break;
                    case 0:
                        correcto = true;
                        break;
                }
            } while (correcto == false);
        } else {
            IO_ES.escribirLN("El producto no se encuentra en la base de datos");
        }
    }

    /**
     * Método para añadir unidades a los productos
     */
    public static void aniadirUnidades() {
        int unidadesAniadidas;
        String buscar;
        boolean encontrado = false;

        IO_ES.escribirLN("\n---------------------------------------");
        IO_ES.escribirLN("AÑADIR UNIDADES");
        buscar = IO_ES.leerCadena("Indica el código del producto: ");
        for (int i = 0; i < MISPRODUCTOS.length; i++) {
            if (MISPRODUCTOS[i] != null) {
                if (MISPRODUCTOS[i].getCodigo().equalsIgnoreCase(buscar)) {
                    encontrado = true;
                    IO_ES.escribirLN(MISPRODUCTOS[i].toString());
                    unidadesAniadidas = IO_ES.leerInteger("Cuantas unidades vas a añadir: ");
                    MISPRODUCTOS[i].aniadirUnidades(unidadesAniadidas);
                    IO_ES.escribirLN("Las unidades se han añadido correctamente");
                }
            }
        }
        if (!encontrado) {
            IO_ES.escribirLN("El producto no se encuentra en la base de datos");
        }
    }

    /**
     * Método para eliminar unidades de los productos
     */
    public static void eliminarUnidades() {
        String buscar;
        boolean encontrado = false;
        int unidadesEliminadas;

        IO_ES.escribirLN("\n---------------------------------------");
        IO_ES.escribirLN("ELIMINAR UNIDADES");
        buscar = IO_ES.leerCadena("Indica el código del producto: ");
        for (int i = 0; i < MISPRODUCTOS.length; i++) {
            if (MISPRODUCTOS[i] != null) {
                if (MISPRODUCTOS[i].getCodigo().equalsIgnoreCase(buscar)) {
                    encontrado = true;
                    IO_ES.escribirLN(MISPRODUCTOS[i].toString());
                    unidadesEliminadas = IO_ES.leerInteger("Cuantas unidades vas a eliminar: ");
                    MISPRODUCTOS[i].quitarUnidades(unidadesEliminadas);
                    IO_ES.escribirLN("Las unidades se han eliminado correctamente");
                }
            }
        }
        if (!encontrado) {
            IO_ES.escribirLN("El producto no se encuentra en la base de datos");
        }
    }
}
