package principal;

import Utilidades.Color;
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
        //MISCLIENTES[0] = new Clientes("77812475W", "Daniel", "Calle 1", 123456);
        //MISCLIENTES[1] = new Clientes("12345678Z", "Elisabeth", "Calle 2", 789012);

        IO_ES.escribirLN(Color.azul() + "BIENVENIDOS A LA APLICACIÓN DE FARMACIA");
        do {
            IO_ES.escribirLN(Color.azul() + "---------------------------------------");
            IO_ES.escribirLN(Color.azul() + "               LA BOTÍCA               ");
            IO_ES.escribirLN(Color.azul() + "---------------------------------------" + Color.reset());
            IO_ES.escribirLN("1.  Añadir cliente \n2.  Dar de baja cliente \n3.  Modificar cliente \n4.  Mostrar clientes");
            IO_ES.escribirLN("\n5.  Añadir producto \n6.  Eliminar producto \n7.  Modificar producto \n8.  Añadir unidades \n9.  Quitar unidades \n10. Mostrar productos \n0.  Salir");
            opciones = IO_ES.leerInteger("Introduzca una opción: ", 0, 10);

            switch (opciones) {
                case 1:
                    aniadirClientes();
                    break;
                case 2:
                    bajaCliente();
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

    private static final int TAMANIO_ARRAY = 50;

    private static final Clientes[] MISCLIENTES = new Clientes[TAMANIO_ARRAY];
    private static int contadorClientes = 0;

    private static final Medicamento[] MISMEDICAMENTOS = new Medicamento[TAMANIO_ARRAY];
    private static final ParaFarmacia[] MISPARAFARMACIA = new ParaFarmacia[TAMANIO_ARRAY];
    private static int contadorMedicamento = 0;
    private static int contadorParaFarmacia = 0;

    /**
     *
     * @param id DNI o NIF del cliente que deseamos buscar
     * @return Devuelve true o false, si el cliente ha sido encontrado
     */
    public static boolean buscarClientes(String id) {
        boolean encontrado = false;
        for (int i = 0; i < MISCLIENTES.length; i++) {
            if (MISCLIENTES[i] != null && MISCLIENTES[i].getId().equalsIgnoreCase(id)) {
                encontrado = true;
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
            for (int i = 0; i < MISMEDICAMENTOS.length; i++) {
                if (MISMEDICAMENTOS[i] != null) {
                    if (MISMEDICAMENTOS[i].getCodigo().equalsIgnoreCase(codigo)) {
                        encontrado = true;
                    }
                }
            }
        }
        if (mostrarArray == 1) {
            for (int i = 0; i < MISMEDICAMENTOS.length; i++) {
                if (MISMEDICAMENTOS[i] != null) {
                    if (MISMEDICAMENTOS[i].getCodigo().equalsIgnoreCase(codigo)) {
                        encontrado = true;
                        IO_ES.escribirLN("---------------------------------------");
                        IO_ES.escribirLN(MISMEDICAMENTOS[i].toString());
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
        if (ValidarDatos.validarNif(id) && !buscarClientes(id)) {
            nombre = IO_ES.leerCadena("Introduzca el nombre: ");
            direccion = IO_ES.leerCadena("Introduzca la dirección: ");
            telefono = IO_ES.leerInteger("Introduzca el teléfono: ");

            MISCLIENTES[contadorClientes] = new Clientes(id, nombre, direccion, telefono);
            contadorClientes++;
            IO_ES.escribirLN(Color.verde() + "Cliente añadido" + Color.reset());
        }
    }

    /**
     * Método para dar de baja a un cliente
     */
    public static void bajaCliente() {
        String buscar;
        boolean encontrado = false;
        boolean baja;

        IO_ES.escribirLN("\n---------------------------------------");
        IO_ES.escribirLN("DAR DE BAJA CLIENTE");
        buscar = IO_ES.leerCadena("Introduzca el DNI/NIF: ", 9);
        for (int i = 0; i < MISCLIENTES.length && !encontrado; i++) {
            if (MISCLIENTES[i] != null && MISCLIENTES[i].getBaja() != true && buscarClientes(buscar) && MISCLIENTES[i].getId().equalsIgnoreCase(buscar)) {
                encontrado = true;
                IO_ES.leerCadena(MISCLIENTES[i].toString());
                baja = IO_ES.leerBoleano("¿Quieres si quieres dar de baja al cliente?: ");
                MISCLIENTES[i].setBaja(baja);
                IO_ES.escribirLN("El cliente se ha dado de baja");
            }
            if (!encontrado && MISCLIENTES[i].getBaja() == true) {
                IO_ES.escribirLN("El cliente ya estaba dado de baja");
            }
        }
        if (!encontrado) {
            IO_ES.escribirLN("El cliente no se encuentra en la base de datos");
        }
    }

    /**
     * Método para modificar los datos de un cliente
     */
    public static void modificarCliente() {
        int opciones;
        String buscar;
        boolean correcto = false;

        IO_ES.escribirLN("\n---------------------------------------");
        IO_ES.escribirLN("MODIFICAR CLIENTE");
        buscar = IO_ES.leerCadena("Introduzca el DNI/NIF: ", 9);
        if (buscarClientes(buscar)) {
            for (int i = 0; i < MISCLIENTES.length; i++) {
                if (MISCLIENTES[i] != null && MISCLIENTES[i].getId().equalsIgnoreCase(buscar)) {
                    IO_ES.escribirLN("\n---------------------------------------");
                    IO_ES.leerCadena(MISCLIENTES[i].toString());
                }
            }
            do {
                IO_ES.escribirLN("\n---------------------------------------");
                IO_ES.escribirLN("1. Nombre \n2. Dirección \n3. Teléfono \n4. Alta\n0. Salir");
                opciones = IO_ES.leerInteger("Elige una opción para modificar del cliente: ", 0, 4);
                switch (opciones) {
                    case 1:
                        String nombreNuevo = IO_ES.leerCadena("Escribe el nuevo nombre: ");
                        for (int i = 0; i < MISCLIENTES.length; i++) {
                            if (MISCLIENTES[i] != null && MISCLIENTES[i].getId().equalsIgnoreCase(buscar)) {
                                MISCLIENTES[i].setNombre(nombreNuevo);
                            }
                        }
                        break;
                    case 2:
                        String dirreccionNuevo = IO_ES.leerCadena("Escribe la nueva dirección: ");
                        for (int i = 0; i < MISCLIENTES.length; i++) {
                            if (MISCLIENTES[i] != null && MISCLIENTES[i].getId().equalsIgnoreCase(buscar)) {
                                MISCLIENTES[i].setDireccion(dirreccionNuevo);
                            }
                        }
                        break;
                    case 3:
                        int telefonoNuevo = IO_ES.leerInteger("Escribe el nuevo teléfono: ");
                        for (int i = 0; i < MISCLIENTES.length; i++) {
                            if (MISCLIENTES[i] != null && MISCLIENTES[i].getId().equalsIgnoreCase(buscar)) {
                                MISCLIENTES[i].setTelefono(telefonoNuevo);
                            }
                        }
                        break;
                    case 4:
                        boolean encontrado = false;
                        boolean baja = IO_ES.leerBoleano("¿Quieres dar de alta al cliente?: ");
                        for (int i = 0; i < MISCLIENTES.length; i++) {
                            if (MISCLIENTES[i] != null && MISCLIENTES[i].getId().equalsIgnoreCase(buscar) && baja) {
                                encontrado = true;
                                MISCLIENTES[i].setBaja(false);
                            }
                            if (MISCLIENTES[i] != null && MISCLIENTES[i].getBaja() == false && !encontrado) {
                                IO_ES.escribirLN("El cliente se encuentra dado de alta");
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
        IO_ES.escribirLN("MOSTRAR CLIENTES");
        IO_ES.escribirLN("1. Mostrar todos los clientes \n2. Buscar un cliente \n3. Mostrar los clientes dado de baja \n0. Salir");
        opciones = IO_ES.leerInteger("Elige una opción: ", 0, 3);
        switch (opciones) {
            case 1:
                for (int i = 0; i < MISCLIENTES.length; i++) {
                    if (MISCLIENTES[i] != null && MISCLIENTES[i].getBaja() != true) {
                        encontrado = true;
                        IO_ES.escribirLN("---------------------------------------");
                        IO_ES.escribirLN(MISCLIENTES[i].toString());
                    }
                }
                if (!encontrado) {
                    IO_ES.escribirLN("La base de datos de clientes esta vacia");
                }
                break;
            case 2:
                buscar = IO_ES.leerCadena("Introduzca el DNI/NIF: ", 9);
                for (int i = 0; i < MISCLIENTES.length && !encontrado; i++) {
                    if (MISCLIENTES[i] != null && MISCLIENTES[i].getId().equalsIgnoreCase(buscar) && MISCLIENTES[i].getBaja() != true) {
                        encontrado = true;
                        IO_ES.escribirLN("---------------------------------------");
                        IO_ES.escribirLN(MISCLIENTES[i].toString());
                    }
                    if (MISCLIENTES[i] != null && MISCLIENTES[i].getBaja()) {
                        encontrado = true;
                        IO_ES.escribirLN("El cliente esta dado de baja");
                    }
                }
                if (!encontrado) {
                    IO_ES.escribirLN("El cliente no se ha encontrado");
                }
                break;
            case 3:
                for (int i = 0; i < MISCLIENTES.length; i++) {
                    if (MISCLIENTES[i] != null && MISCLIENTES[i].getBaja() == true) {
                        IO_ES.escribirLN("---------------------------------------");
                        IO_ES.escribirLN(MISCLIENTES[i].toString());
                        encontrado = true;
                    }
                }
                if (!encontrado) {
                    IO_ES.escribirLN("No hay clientes dados de baja");
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
        String codigo, nombre, descripcion, comoTomar, efectosAdversos;
        int dosisUnidades;
        double descuento;
        double precio;
        int unidades;
        boolean encontrado = false;
        boolean correcto = false;
        int tipoProducto;

        IO_ES.escribirLN("\n---------------------------------------");
        IO_ES.escribirLN("AÑADIR PRODUCTO");
        do {
            tipoProducto = IO_ES.leerInteger("\n1. Medicamento \n2. Parafarmacia \n0. Salir \nQue tipo de producto vas añadir: ", 0, 2);
            switch (tipoProducto) {
                case 1:
                    codigo = IO_ES.leerCadena("Introduzca el código del medicamento: ");
                    if (buscarProductos(codigo, 1)) {
                        IO_ES.escribirLN("El código del medicamento ya esta asignado");
                    } else {
                        codigo = "X";
                    }
                    if (!buscarProductos(codigo, 0)) {
                        nombre = IO_ES.leerCadena("Introduzca el nombre del medicamento: ");
                        for (int i = 0; i < MISMEDICAMENTOS.length; i++) {
                            if (MISMEDICAMENTOS[i] != null) {
                                if (MISMEDICAMENTOS[i].getNombre().equalsIgnoreCase(nombre)) {
                                    encontrado = true;
                                    IO_ES.escribirLN("El nombre del medicamento ya esta asignado");
                                }
                            }
                        }
                        if (!encontrado) {
                            descripcion = IO_ES.leerCadena("Introduzca la descripción del medicamento: ");
                            precio = IO_ES.leerReallargo("Introduzca el precio del medicamento: ");
                            unidades = IO_ES.leerInteger("Introduzca las unidades del medicamento: ", 0);
                            comoTomar = IO_ES.leerCadena("Introduzca el método para consumir el medicamento: ");
                            efectosAdversos = IO_ES.leerCadena("Introduzca los efectos adversos del medicamentos: ");
                            MISMEDICAMENTOS[contadorMedicamento] = new Medicamento(codigo, nombre, descripcion, precio, unidades, comoTomar, efectosAdversos);
                            contadorMedicamento++;
                            IO_ES.escribirLN("Se ha añadido un medicamento");
                        }
                    }
                    break;
                case 2:
                    codigo = IO_ES.leerCadena("Introduzca el código del producto de Parafarmacia: ");
                    if (buscarProductos(codigo, 1)) {
                        IO_ES.escribirLN("El código del producto ya esta asignado");
                    } else {
                        codigo = "X";
                    }
                    if (!buscarProductos(codigo, 0)) {
                        nombre = IO_ES.leerCadena("Introduzca el nombre del producto de Parafarmacia: ");
                        for (int i = 0; i < MISPARAFARMACIA.length; i++) {
                            if (MISPARAFARMACIA[i] != null) {
                                if (MISPARAFARMACIA[i].getNombre().equalsIgnoreCase(nombre)) {
                                    encontrado = true;
                                    IO_ES.escribirLN("El nombre del producto ya esta asignado");
                                }
                            }
                        }
                        if (!encontrado) {
                            descripcion = IO_ES.leerCadena("Introduzca la descripción del producto de Parafarmacia: ");
                            precio = IO_ES.leerReallargo("Introduzca el precio del producto de Parafarmacia: ");
                            unidades = IO_ES.leerInteger("Introduzca las unidades del producto de Parafarmacia: ", 0);
                            dosisUnidades = IO_ES.leerInteger("Introduzca las unidades de las dosis: ", 0);
                            descuento = IO_ES.leerReallargo("Introduzca el descuento (en porcentaje): ");
                            MISPARAFARMACIA[contadorMedicamento] = new ParaFarmacia(codigo, nombre, descripcion, precio, unidades, dosisUnidades, descuento);
                            contadorParaFarmacia++;
                            IO_ES.escribirLN("Se ha añadido un producto de Parafarmacia");
                        }
                    }
                    break;
                case 0:
                    correcto = true;
                    break;
            }
        } while (correcto == false);

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
                for (int i = 0; i < MISMEDICAMENTOS.length; i++) {
                    if (MISMEDICAMENTOS[i] != null) {
                        IO_ES.escribirLN("---------------------------------------");
                        IO_ES.escribirLN(MISMEDICAMENTOS[i].toString());
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
        for (int i = 0; i < MISMEDICAMENTOS.length; i++) {
            if (MISMEDICAMENTOS[i] != null) {
                if (buscarProductos(buscar, 1)) {
                    encontrado = true;
                    MISMEDICAMENTOS[i] = null;
                    IO_ES.escribirLN("El producto se ha eliminado correctamente");
                    contadorMedicamento--;
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
                        for (int i = 0; i < MISMEDICAMENTOS.length; i++) {
                            if (MISMEDICAMENTOS[i] != null) {
                                if (MISMEDICAMENTOS[i].getCodigo().equalsIgnoreCase(buscar)) {
                                    MISMEDICAMENTOS[i].setNombre(nuevoNombre);
                                }
                            }
                        }
                        break;
                    case 2:
                        String nuevaDescripcion = IO_ES.leerCadena("Escribe la nueva descripcion: ");
                        for (int i = 0; i < MISMEDICAMENTOS.length; i++) {
                            if (MISMEDICAMENTOS[i] != null) {
                                if (MISMEDICAMENTOS[i].getCodigo().equalsIgnoreCase(buscar)) {
                                    MISMEDICAMENTOS[i].setDescripcion(nuevaDescripcion);
                                }
                            }
                        }
                        break;
                    case 3:
                        double nuevoPrecio = IO_ES.leerReallargo("Escribe el nuevo precio: ");
                        for (int i = 0; i < MISMEDICAMENTOS.length; i++) {
                            if (MISMEDICAMENTOS[i] != null) {
                                if (MISMEDICAMENTOS[i].getCodigo().equalsIgnoreCase(buscar)) {
                                    MISMEDICAMENTOS[i].setPrecio(nuevoPrecio);
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
        for (int i = 0; i < MISMEDICAMENTOS.length; i++) {
            if (MISMEDICAMENTOS[i] != null) {
                if (MISMEDICAMENTOS[i].getCodigo().equalsIgnoreCase(buscar)) {
                    encontrado = true;
                    IO_ES.escribirLN(MISMEDICAMENTOS[i].toString());
                    unidadesAniadidas = IO_ES.leerInteger("Cuantas unidades vas a añadir: ");
                    MISMEDICAMENTOS[i].aniadirUnidades(unidadesAniadidas);
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
        for (int i = 0; i < MISMEDICAMENTOS.length; i++) {
            if (MISMEDICAMENTOS[i] != null) {
                if (MISMEDICAMENTOS[i].getCodigo().equalsIgnoreCase(buscar)) {
                    encontrado = true;
                    IO_ES.escribirLN(MISMEDICAMENTOS[i].toString());
                    unidadesEliminadas = IO_ES.leerInteger("Cuantas unidades vas a eliminar: ");
                    MISMEDICAMENTOS[i].quitarUnidades(unidadesEliminadas);
                    IO_ES.escribirLN("Las unidades se han eliminado correctamente");
                }
            }
        }
        if (!encontrado) {
            IO_ES.escribirLN("El producto no se encuentra en la base de datos");
        }
    }
}
