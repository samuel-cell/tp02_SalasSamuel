package ar.edu.unju.fi.ejercicio01;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import ar.edu.unju.fi.ejercicio01.Model.*;
public class Main {

	public static void main(String[] args) {
		List<Producto> productos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        do {
            mostrarMenu();
            int opcion = obtenerEntero(scanner);

            switch (opcion) {
                case 1:
                    Producto producto = crearProducto(scanner);
                    productos.add(producto);
                    System.out.println("Producto creado correctamente");
                    break;
                case 2:
                    mostrarProductos(productos);
                    break;
                case 3:
                    modificarProducto(scanner, productos);
                    break;
                case 4:
                    salir = true;
                    System.out.println("Fin del programa");
                    break;
                default:
                    System.out.println("Opcion no valida. Intente de nuevo");
                    break;
            }
        } while (!salir);
        
        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("  ****  MENU  ****  ");
        System.out.println("1 - Crear Producto");
        System.out.println("2 - Mostrar Productos");
        System.out.println("3 - Modificar Producto");
        System.out.println("4 - Salir");
        System.out.print("Ingrese su opcion: ");
    }

   private static int obtenerEntero(Scanner scanner) {
    int opcion;
    while (!scanner.hasNextInt()) {
        System.out.println("Ingrese un numero entero valido");
        scanner.next();
    }
    opcion = scanner.nextInt();
    return opcion;
}


    private static Producto crearProducto(Scanner scanner) {
        Producto producto = new Producto();
        System.out.println("Ingrese el codigo del producto:");
        producto.setCodigo(scanner.next());

        System.out.println("Ingrese la descripcion del producto:");
        producto.setDescripcion(scanner.next());

        System.out.println("Ingrese el precio unitario del producto:");
        producto.setPrecioUnitario(scanner.nextDouble());

        System.out.println("Seleccione el origen de fabricacion:");
        mostrarOrigenesDeFabricacion();
        producto.setOrigenFabricacion(obtenerOrigen(scanner));

        System.out.println("Seleccione la categoria del producto:");
        mostrarCategorias();
        producto.setCategoria(obtenerCategoria(scanner));

        return producto;
    }

    private static void mostrarOrigenesDeFabricacion() {
    	System.out.println("**Origen de fabricacion**");
        System.out.println("1 - Argentina");
        System.out.println("2 - China");
        System.out.println("3 - Brasil");
        System.out.println("4 - Uruguay");
        System.out.println();
    }

    private static Producto.OrigenDeFabricacion obtenerOrigen(Scanner scanner) {
        int opcion = obtenerEntero(scanner);
        switch (opcion) {
            case 1:
                return Producto.OrigenDeFabricacion.ARGENTINA;
            case 2:
                return Producto.OrigenDeFabricacion.CHINA;
            case 3:
                return Producto.OrigenDeFabricacion.BRASIL;
            case 4:
                return Producto.OrigenDeFabricacion.URUGUAY;
            default:
                return null;
        }
    }

    private static void mostrarCategorias() {
    	System.out.println("**Categoria**");
        System.out.println("1 - Telefonia");
        System.out.println("2 - Informatica");
        System.out.println("3 - Electrohogar");
        System.out.println("4 - Herramientas");
        System.out.println();
    }

    private static Producto.Categoria obtenerCategoria(Scanner scanner) {
        int opcion = obtenerEntero(scanner);
        switch (opcion) {
            case 1:
                return Producto.Categoria.TELEFONIA;
            case 2:
                return Producto.Categoria.INFORMATICA;
            case 3:
                return Producto.Categoria.ELECTROHOGAR;
            case 4:
                return Producto.Categoria.HERRAMIENTAS;
            default:
                return null;
        }
    }

  private static void mostrarProductos(List<Producto> productos) {
    System.out.println("**LISTADO DE PRODUCTOS**");
    for (Producto producto : productos) {
        System.out.println("Codigo: " + producto.getCodigo());
        System.out.println("Descripcion: " + producto.getDescripcion());
        System.out.println("Precio unitario: " + producto.getPrecioUnitario());
        System.out.println("Origen de fabricacion: " + producto.getOrigenFabricacion());
        System.out.println("Categoria: " + producto.getCategoria());
        System.out.println();
    }
}


    private static void modificarProducto(Scanner scanner, List<Producto> productos) {
        System.out.println("Ingrese el codigo del producto a modificar:");
        String codigo = scanner.next();

        for (Producto producto : productos) {
            if (producto.getCodigo().equals(codigo)) {
                System.out.println("Seleccione el campo a modificar:");
                System.out.println("1 - Descripcion");
                System.out.println("2 - Precio unitario");
                System.out.println("3 - Origen de fabricacion");
                System.out.println("4 - Categoria");
                int opcion = obtenerEntero(scanner);

                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese la nueva descripcion:");
                        producto.setDescripcion(scanner.next());
                        break;
                    case 2:
                        System.out.println("Ingrese el nuevo precio unitario:");
                        producto.setPrecioUnitario(scanner.nextDouble());
                        break;
                    case 3:
                        System.out.println("Seleccione el nuevo origen de fabricacion:");
                        mostrarOrigenesDeFabricacion();
                        producto.setOrigenFabricacion(obtenerOrigen(scanner));
                        break;
                    case 4:
                        System.out.println("Seleccione la nueva categoria:");
                        mostrarCategorias();
                        producto.setCategoria(obtenerCategoria(scanner));
                        break;
                    default:
                        System.out.println("Opcion no valida. Intente de nuevo");
                        break;
                }
                System.out.println("Producto modificado correctamente");
                return;
            }
        }
        System.out.println("No se encontro ningun producto con el codigo ingresado");
	}
}