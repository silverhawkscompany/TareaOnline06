package principal;

import utilidades.*;
import estructuraDatos.*;
import static estructuraDatos.Enumerados.TipoMedicamento.*;
import static estructuraDatos.Enumerados.Categoria.*;
import estructuraDatos.Enumerados.TipoMedicamento;
import estructuraDatos.Enumerados.Categoria;

/**
 *
 * @author Daniel Díaz González
 * @version 1.0
 */
public class CPrincipal {
    private static final int TAMANIO_ARRAY = 50;
    private static final Cliente[] MISCLIENTES = new Cliente[TAMANIO_ARRAY];
    private static int contadorClientes = 0;
    private static Productos[] MISPRODUCTOS = new Productos[TAMANIO_ARRAY];
    private static int contadorProdcutos = 0;
    /**
     * @param args Menu principal donde se inicia la ejecución del programa
     */
    public static void main(String[] args) {
        boolean correcto = false;
        int opciones;

        //EJEMPLOS//
        MISCLIENTES[0] = new Cliente("77812475W", "Daniel", "Calle 1", 123456);
        MISCLIENTES[1] = new Cliente("12345678Z", "Elisabeth", "Calle 2", 789012);
        MISPRODUCTOS[0] = new Medicamento("1234567891234", "Med 01", "AAA", 12.50, 100, ANALGESICOS, "Oral", "Ninguno");
        MISPRODUCTOS[1] = new ParaFarmacia("9999991999999", "Par 01", "BBB", 42.50, 50, DENTAL, 5, 10);

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

    

    /**
     *
     * @param id DNI o NIF del cliente que deseamos buscar
     * @return Devuelve true o false, si el cliente ha sido encontrado
     */
    public static Cliente buscarClientes(String id) {
        Cliente cliente = null ;
        for (int i = 0; i < MISCLIENTES.length; i++) {
            if (MISCLIENTES[i] != null && MISCLIENTES[i].getId().equalsIgnoreCase(id)) {
                cliente = MISCLIENTES[i];
            }
        }
        return cliente;
    }

    /**
     *
     * @param codigo Código del producto que deseamos buscar
     * @return Devuelve true o false, si encuentra el producto
     */
    public static Productos buscarProductos(String codigo) {
        Productos productos = null;
        for (int i = 0; i < MISPRODUCTOS.length; i++) {
            if (MISPRODUCTOS[i] != null && MISPRODUCTOS[i].getCodigo().equalsIgnoreCase(codigo)) {
                productos = MISPRODUCTOS[i];
            }
        }
        return productos;
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
        if (buscarClientes(id)!= null) {
            IO_ES.escribirLN(Color.rojo() + "Ya hay un cliente dado de alta con ese DNI/NIF" + Color.reset());
        }
        else if (ValidarDatos.validarNif(id)) {
            nombre = IO_ES.leerCadena("Introduzca el nombre: ");
            direccion = IO_ES.leerCadena("Introduzca la dirección: ");
            telefono = IO_ES.leerInteger("Introduzca el teléfono: ");
            if (ValidarDatos.validarTelefono(telefono)) {
                MISCLIENTES[contadorClientes] = new Cliente(id, nombre, direccion, telefono);
                contadorClientes++;
                IO_ES.escribirLN(Color.verde() + "Cliente añadido" + Color.reset());
            } else {
                IO_ES.escribirLN(Color.rojo() + "El numero de teléfono no es correcto" + Color.reset());
            }
        }
        else {
            IO_ES.escribirLN(Color.rojo() + "El DNI/NIF es incorrecto" + Color.reset());
        }
    }

    /**
     * Método para dar de baja a un cliente
     */
    public static void bajaCliente() {
        String buscar;
        boolean encontrado = false;
        boolean baja = false;

        IO_ES.escribirLN("\n---------------------------------------");
        IO_ES.escribirLN("DAR DE BAJA CLIENTE");
        buscar = IO_ES.leerCadena("Introduzca el DNI/NIF: ", 9);
        for (int i = 0; i < MISCLIENTES.length && !encontrado; i++) {
            if (MISCLIENTES[i] != null && MISCLIENTES[i].getId().equalsIgnoreCase(buscar) && MISCLIENTES[i].getBaja()) {
                IO_ES.escribirLN(Color.rojo() + "El cliente ya estaba dado de baja" + Color.reset());
                encontrado = true;
            }
            if (MISCLIENTES[i] != null && MISCLIENTES[i].getId().equalsIgnoreCase(buscar) && !MISCLIENTES[i].getBaja()) {
                encontrado = true;
                IO_ES.escribirLN("---------------------------------------");
                IO_ES.escribirLN(MISCLIENTES[i].toString());
                baja = IO_ES.leerBoleano("¿Quieres dar de baja al cliente?: ");
            }
            if (encontrado && baja) {
                MISCLIENTES[i].setBaja(baja);
                IO_ES.escribirLN(Color.verde() + "El cliente se ha dado de baja" + Color.reset());
            }
        }
        if (!encontrado) {
            IO_ES.escribirLN(Color.rojo() + "El cliente no se encuentra en la base de datos" + Color.reset());
        }
    }

    /**
     * Método para modificar los datos de un cliente
     */
    public static void modificarCliente() {
        int opciones;
        String buscar;
        boolean correcto = false;
        boolean encontrado = false;

        IO_ES.escribirLN("\n---------------------------------------");
        IO_ES.escribirLN("MODIFICAR CLIENTE");
        buscar = IO_ES.leerCadena("Introduzca el DNI/NIF: ", 9);
        for (int i = 0; i < MISCLIENTES.length && !encontrado; i++) {
            if (MISCLIENTES[i] != null && MISCLIENTES[i].getId().equalsIgnoreCase(buscar)) {
                encontrado = true;
                IO_ES.escribirLN("---------------------------------------");
                IO_ES.escribirLN(MISCLIENTES[i].toString());
            }
        }
        if (encontrado) {
            do {
                IO_ES.escribirLN("---------------------------------------");
                IO_ES.escribirLN("1. Nombre \n2. Dirección \n3. Teléfono \n4. Alta \n0. Salir");
                opciones = IO_ES.leerInteger("Elige una opción para modificar del cliente: ", 0, 4);
                switch (opciones) {
                    case 1:
                        String nombreNuevo = IO_ES.leerCadena("Escribe el nuevo nombre: ");
                        for (int i = 0; i < MISCLIENTES.length; i++) {
                            if (MISCLIENTES[i] != null && MISCLIENTES[i].getId().equalsIgnoreCase(buscar)) {
                                MISCLIENTES[i].setNombre(nombreNuevo);
                                IO_ES.escribirLN(Color.verde() + "El nombre se ha modificado" + Color.reset());
                            }
                        }
                        break;
                    case 2:
                        String dirreccionNuevo = IO_ES.leerCadena("Escribe la nueva dirección: ");
                        for (int i = 0; i < MISCLIENTES.length; i++) {
                            if (MISCLIENTES[i] != null && MISCLIENTES[i].getId().equalsIgnoreCase(buscar)) {
                                MISCLIENTES[i].setDireccion(dirreccionNuevo);
                                IO_ES.escribirLN(Color.verde() + "La dirección se ha modificado" + Color.reset());
                            }
                        }
                        break;
                    case 3:
                        int telefonoNuevo = IO_ES.leerInteger("Escribe el nuevo teléfono: ");
                        if (ValidarDatos.validarTelefono(telefonoNuevo)) {
                            for (int i = 0; i < MISCLIENTES.length; i++) {
                                if (MISCLIENTES[i] != null && MISCLIENTES[i].getId().equalsIgnoreCase(buscar)) {
                                    MISCLIENTES[i].setTelefono(telefonoNuevo);
                                    IO_ES.escribirLN(Color.verde() + "El número de teléfono se ha modificado" + Color.reset());
                                }
                            }
                        } else {
                            IO_ES.escribirLN(Color.rojo() + "El numero de teléfono no es correcto" + Color.reset());
                        }

                        break;
                    case 4:
                        boolean alta = IO_ES.leerBoleano("¿Quieres dar de alta al cliente?: ");
                        for (int i = 0; i < MISCLIENTES.length; i++) {
                            if (MISCLIENTES[i] != null && MISCLIENTES[i].getId().equalsIgnoreCase(buscar) && alta) {
                                if (MISCLIENTES[i].getBaja() == false) {
                                    IO_ES.escribirLN(Color.rojo() + "El cliente ya estaba dado de alta" + Color.reset());
                                } else {
                                    MISCLIENTES[i].setBaja(false);
                                    IO_ES.escribirLN(Color.verde() + "El cliente se ha dado de alta" + Color.reset());
                                }
                            }
                            if (MISCLIENTES[i] != null && MISCLIENTES[i].getId().equalsIgnoreCase(buscar) && !alta) {

                            }
                        }
                        break;
                    case 0:
                        correcto = true;
                        break;
                }
            } while (correcto == false);
        }
        if (!encontrado) {
            IO_ES.escribirLN(Color.rojo() + "El cliente no se encuentra en la base de datos" + Color.reset());
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
                    IO_ES.escribirLN(Color.rojo() + "La base de datos de clientes esta vacia" + Color.reset());
                }
                break;
            case 2:
                buscar = IO_ES.leerCadena("Introduzca el DNI/NIF: ", 9);
                for (int i = 0; i < MISCLIENTES.length && !encontrado; i++) {
                    if (MISCLIENTES[i] != null && buscarClientes(buscar) && MISCLIENTES[i].getBaja() != true) {
                        encontrado = true;
                        IO_ES.escribirLN("---------------------------------------");
                        IO_ES.escribirLN(MISCLIENTES[i].toString());
                    }
                    if (MISCLIENTES[i] != null && MISCLIENTES[i].getBaja()) {
                        encontrado = true;
                        IO_ES.escribirLN(Color.rojo() + "El cliente esta dado de baja" + Color.reset());
                    }
                }
                if (!encontrado) {
                    IO_ES.escribirLN(Color.rojo() + "El cliente no se ha encontrado" + Color.reset());
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
                    IO_ES.escribirLN(Color.rojo() + "No hay clientes dados de baja" + Color.reset());
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
        TipoMedicamento tipoMedicamento = TipoMedicamento.ANALGESICOS;
        int dosisUnidades;
        double descuento;
        double precio;
        int unidades;
        boolean encontrado = false;
        boolean correcto = false;
        int tipoProducto;
        int opciones;

        IO_ES.escribirLN("\n---------------------------------------");
        IO_ES.escribirLN("AÑADIR PRODUCTO");
        do {
            tipoProducto = IO_ES.leerInteger("\n1. Medicamento \n2. Parafarmacia \n0. Salir \nQue tipo de producto vas añadir: ", 0, 2);
            switch (tipoProducto) {
                case 1:
                    codigo = IO_ES.leerCadena("Introduzca el código del medicamento: ");
                    if (!Productos.comprobarCodigo(codigo)) {
                        codigo = "X";
                    }
                    if (buscarProductos(codigo)) {
                        IO_ES.escribirLN("El código del medicamento ya esta asignado");
                    }
                    if (!buscarProductos(codigo)) {
                        nombre = IO_ES.leerCadena("Introduzca el nombre del medicamento: ");
                        for (int i = 0; i < MISPRODUCTOS.length; i++) {
                            if (MISPRODUCTOS[i] != null && MISPRODUCTOS[i].getNombre().equalsIgnoreCase(nombre)) {
                                encontrado = true;
                                IO_ES.escribirLN("El nombre del medicamento ya esta asignado");
                            }
                        }
                        if (!encontrado) {
                            descripcion = IO_ES.leerCadena("Introduzca la descripción del medicamento: ");
                            precio = IO_ES.leerReallargo("Introduzca el precio del medicamento: ");
                            unidades = IO_ES.leerInteger("Introduzca las unidades del medicamento: ", 0);
                            IO_ES.escribirLN("1. ANALGESICOS \n2. LAXANTES \n3. ANTIINFECCIOSOS \n4. ANTIDEPRESIVOS \n4. ANTITUSIVOS \n5. MUCOLITICOS \n6. ANTIACIDOS \n7. ANTIULCEROSOS \n8. ANTIALERGICOS \n9. ANTIFIARREICO");
                            opciones = IO_ES.leerInteger("Indique el tipo de medicamento: ", 1, 9);
                            switch (opciones) {
                                case 1:
                                    tipoMedicamento = TipoMedicamento.ANALGESICOS;
                                    break;
                                case 2:
                                    tipoMedicamento = TipoMedicamento.LAXANTES;
                                    break;
                                case 3:
                                    tipoMedicamento = TipoMedicamento.ANTIINFECCIOSOS;
                                    break;
                                case 4:
                                    tipoMedicamento = TipoMedicamento.ANTIDEPRESIVOS;
                                    break;
                                case 5:
                                    tipoMedicamento = TipoMedicamento.ANTITUSIVOS;
                                    break;
                                case 6:
                                    tipoMedicamento = TipoMedicamento.MUCOLITICOS;
                                    break;
                                case 7:
                                    tipoMedicamento = TipoMedicamento.ANTIACIDOS;
                                    break;
                                case 8:
                                    tipoMedicamento = TipoMedicamento.ANTIULCEROSOS;
                                    break;
                                case 9:
                                    tipoMedicamento = TipoMedicamento.ANTIFIARREICOS;
                                    break;
                            }

                            comoTomar = IO_ES.leerCadena("Introduzca el método para consumir el medicamento: ");
                            efectosAdversos = IO_ES.leerCadena("Introduzca los efectos adversos del medicamentos: ");
                            MISPRODUCTOS[contadorProdcutos] = new Medicamento(codigo, nombre, descripcion, precio, unidades, tipoMedicamento, comoTomar, efectosAdversos);
                            contadorProdcutos++;
                            IO_ES.escribirLN(Color.verde() + "Se ha añadido un medicamento" + Color.reset());
                        }
                    }
                    break;
                case 2:
                    codigo = IO_ES.leerCadena("Introduzca el código del producto de Parafarmacia: ");
                    if (!Productos.comprobarCodigo(codigo)) {
                        codigo = "X";
                    }
                    if (buscarProductos(codigo)) {
                        IO_ES.escribirLN(Color.rojo() + "El código del producto ya esta asignado" + Color.reset());
                    }
                    if (!buscarProductos(codigo)) {
                        nombre = IO_ES.leerCadena("Introduzca el nombre del producto de Parafarmacia: ");
                        for (int i = 0; i < MISPRODUCTOS.length; i++) {
                            if (MISPRODUCTOS[i] != null && MISPRODUCTOS[i].getNombre().equalsIgnoreCase(nombre)) {
                                encontrado = true;
                                IO_ES.escribirLN(Color.rojo() + "El nombre del producto ya esta asignado" + Color.reset());
                            }
                        }
                        if (!encontrado) {
                            descripcion = IO_ES.leerCadena("Introduzca la descripción del producto de Parafarmacia: ");
                            precio = IO_ES.leerReallargo("Introduzca el precio del producto de Parafarmacia: ");
                            unidades = IO_ES.leerInteger("Introduzca las unidades del producto de Parafarmacia: ", 0);
                            dosisUnidades = IO_ES.leerInteger("Introduzca las unidades de las dosis: ", 0);
                            descuento = IO_ES.leerReallargo("Introduzca el descuento (en porcentaje): ");
                            MISPRODUCTOS[contadorProdcutos] = new ParaFarmacia(codigo, nombre, descripcion, precio, unidades, dosisUnidades, descuento);
                            contadorProdcutos++;
                            IO_ES.escribirLN(Color.verde() + "Se ha añadido un producto de Parafarmacia" + Color.reset());
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
        opciones = IO_ES.leerInteger("Escoge una opción: ", 0, 2);
        switch (opciones) {
            case 1:
                for (int i = 0; i < MISPRODUCTOS.length; i++) {
                    if (MISPRODUCTOS[i] != null) {
                        encontrado = true;
                        IO_ES.escribirLN("---------------------------------------");
                        IO_ES.escribirLN(MISPRODUCTOS[i].toString());
                    }
                }
                if (!encontrado) {
                    IO_ES.escribirLN(Color.rojo() + "La base de datos de productos esta vacia" + Color.reset());
                }
                break;
            case 2:
                String codigo = IO_ES.leerCadena("Indica el código del producto: ");
                for (int i = 0; i < MISPRODUCTOS.length; i++) {
                    if (MISPRODUCTOS[i] != null && MISPRODUCTOS[i].getCodigo().equalsIgnoreCase(codigo)) {
                        encontrado = true;
                        IO_ES.escribirLN("---------------------------------------");
                        IO_ES.escribirLN(MISPRODUCTOS[i].toString());
                    }
                }
                if (!encontrado) {
                    IO_ES.escribirLN(Color.rojo() + "El producto no se encuentra en la base de datos" + Color.reset());
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
            if (MISPRODUCTOS[i] != null && buscarProductos(buscar)) {
                encontrado = true;
                IO_ES.escribirLN("---------------------------------------");
                IO_ES.escribirLN(MISPRODUCTOS[i].toString());
                MISPRODUCTOS[i] = null;
                IO_ES.escribirLN("El producto se ha eliminado correctamente");
                contadorProdcutos--;
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
        boolean encontrado = false;

        IO_ES.escribirLN("\n---------------------------------------");
        IO_ES.escribirLN("MODIFICAR PRODUCTO");
        buscar = IO_ES.leerCadena("Introduzca el código del producto: ");
        for (int i = 0; i < MISPRODUCTOS.length && !encontrado; i++) {
            if (MISPRODUCTOS[i] != null && MISPRODUCTOS[i].getCodigo().equalsIgnoreCase(buscar)) {
                encontrado = true;
                IO_ES.escribirLN("---------------------------------------");
                IO_ES.escribirLN(MISPRODUCTOS[i].toString());
            }
        }
        if (!encontrado) {
            IO_ES.escribirLN(Color.rojo() + "El producto no se encuentra en la base de datos" + Color.reset());
        }
        if (encontrado) {
            do {
                for (int i = 0; i < MISPRODUCTOS.length; i++) {
                    if (MISPRODUCTOS[i] instanceof Medicamento && MISPRODUCTOS[i] != null && MISPRODUCTOS[i].getCodigo().equalsIgnoreCase(buscar)) {
                        IO_ES.escribirLN("---------------------------------------");
                        IO_ES.escribirLN("1. Nombre \n2. Descripción \n3. Precio \n4. Toma del medicamento \n5. Efectos adversos\n0. Salir");
                        opciones = IO_ES.leerInteger("Elige una opción para modificar del producto: ", 0, 5);
                        switch (opciones) {
                            case 1:
                                String nuevoNombre = IO_ES.leerCadena("Escribe el nuevo nombre: ");
                                MISPRODUCTOS[i].setNombre(nuevoNombre);
                                IO_ES.escribirLN(Color.verde() + "El nombre se ha modificado" + Color.reset());
                                break;
                            case 2:
                                String nuevaDescripcion = IO_ES.leerCadena("Escribe la nueva descripcion: ");
                                MISPRODUCTOS[i].setDescripcion(nuevaDescripcion);
                                IO_ES.escribirLN(Color.verde() + "La descripción se ha modificado" + Color.reset());
                                break;
                            case 3:
                                double nuevoPrecio = IO_ES.leerReallargo("Escribe el nuevo precio: ");
                                MISPRODUCTOS[i].setPrecio(nuevoPrecio);
                                IO_ES.escribirLN(Color.verde() + "El precio se ha modificado" + Color.reset());
                                break;
                            case 4:
                                String nuevaToma = IO_ES.leerCadena("Escribe la nueva toma del medicamento: ");
                                Medicamento referencia = (Medicamento) MISPRODUCTOS[i];
                                referencia.setComoTomar(nuevaToma);
                                IO_ES.escribirLN(Color.verde() + "La toma se ha modificado" + Color.reset());
                                break;
                            case 5:
                                String nuevoEfectos = IO_ES.leerCadena("Escribe los nuevos efectos adversos del medicamento: ");
                                Medicamento referencia2 = (Medicamento) MISPRODUCTOS[i];
                                referencia2.setEfectosAdversos(nuevoEfectos);
                                IO_ES.escribirLN(Color.verde() + "Los efectos adversos se ha modificado" + Color.reset());
                                break;
                            case 0:
                                correcto = true;
                                break;
                        }
                    }
                    if (MISPRODUCTOS[i] instanceof ParaFarmacia && MISPRODUCTOS[i] != null && MISPRODUCTOS[i].getCodigo().equalsIgnoreCase(buscar)) {
                        IO_ES.escribirLN("---------------------------------------");
                        IO_ES.escribirLN("1. Nombre \n2. Descripción \n3. Precio \n4. Dosis de unidades \n5. Descuento \n0. Salir");
                        opciones = IO_ES.leerInteger("Elige una opción para modificar del producto: ", 0, 5);
                        switch (opciones) {
                            case 1:
                                String nuevoNombre = IO_ES.leerCadena("Escribe el nuevo nombre: ");
                                MISPRODUCTOS[i].setNombre(nuevoNombre);
                                IO_ES.escribirLN(Color.verde() + "El nombre se ha modificado" + Color.reset());
                                break;
                            case 2:
                                String nuevaDescripcion = IO_ES.leerCadena("Escribe la nueva descripcion: ");
                                MISPRODUCTOS[i].setDescripcion(nuevaDescripcion);
                                IO_ES.escribirLN(Color.verde() + "La descripción se ha modificado" + Color.reset());
                                break;
                            case 3:
                                double nuevoPrecio = IO_ES.leerReallargo("Escribe el nuevo precio: ");
                                MISPRODUCTOS[i].setPrecio(nuevoPrecio);
                                IO_ES.escribirLN(Color.verde() + "El precio se ha modificado" + Color.reset());
                                break;
                            case 4:
                                int nuevaDosis = IO_ES.leerInteger("Escribe la nueva dosis del producto: ");
                                ParaFarmacia referencia = (ParaFarmacia) MISPRODUCTOS[i];
                                referencia.setDosisUnidades(nuevaDosis);
                                IO_ES.escribirLN(Color.verde() + "La dosis se ha modificado" + Color.reset());
                                break;
                            case 5:
                                double nuevoDescuento = IO_ES.leerReallargo("Escribe el nuevo descuento del producto: ");
                                ParaFarmacia referencia2 = (ParaFarmacia) MISPRODUCTOS[i];
                                referencia2.setDescuento(nuevoDescuento);
                                IO_ES.escribirLN(Color.verde() + "El descuento se ha modificado" + Color.reset());
                                break;
                            case 0:
                                correcto = true;
                                break;
                        }
                    }
                }
            } while (correcto == false);
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
            if (MISPRODUCTOS[i] != null && MISPRODUCTOS[i].getCodigo().equalsIgnoreCase(buscar)) {
                encontrado = true;
                IO_ES.escribirLN("\n---------------------------------------");
                IO_ES.escribirLN(MISPRODUCTOS[i].toString());
                unidadesAniadidas = IO_ES.leerInteger("Cuantas unidades vas a añadir: ");
                if (MISPRODUCTOS[i].aniadirUnidades(unidadesAniadidas)) {
                    IO_ES.escribirLN(Color.verde() + "Las unidades se han añadido correctamente" + Color.reset());
                }
            }
        }
        if (!encontrado) {
            IO_ES.escribirLN(Color.rojo() + "El producto no se encuentra en la base de datos" + Color.reset());
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
            if (MISPRODUCTOS[i] != null && MISPRODUCTOS[i].getCodigo().equalsIgnoreCase(buscar)) {
                encontrado = true;
                IO_ES.escribirLN("\n---------------------------------------");
                IO_ES.escribirLN(MISPRODUCTOS[i].toString());
                unidadesEliminadas = IO_ES.leerInteger("Cuantas unidades vas a eliminar: ");
                if (MISPRODUCTOS[i].quitarUnidades(unidadesEliminadas)) {
                    IO_ES.escribirLN(Color.verde() + "Las unidades se han eliminado correctamente" + Color.reset());
                }
            }
        }
        if (!encontrado) {
            IO_ES.escribirLN(Color.rojo() + "El producto no se encuentra en la base de datos" + Color.reset());
        }
    }
}
