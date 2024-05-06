package ar.edu.unju.fi.ejercicio07;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import ar.edu.unju.fi.ejercicio07.Model.*;
public class Main {
	private static List<Producto> productos;
	
	public static void main(String[] args) {
		productos = Producto.precargarProductos();

        Scanner scanner = new Scanner(System.in);
        boolean band = true;

        while (band) {
            mostrarMenu();
            String op = scanner.nextLine();
            switch (op) {
                case "1": {
                    Consumer<Producto> prodDisponible = n -> {
                        if (n.isEstado()) n.MostrarDatos();
                    };
                    productos.forEach(prodDisponible);
                }
                break;

                case "2": {
                    Predicate<Producto> noDisponible = n -> !n.isEstado();
                    List<Producto> prod = productos.stream().filter(noDisponible).collect(Collectors.toList());
                    prod.forEach(Producto::MostrarDatos);
                }
                break;

                case "3": {
                    Function<Producto, Producto> incremento = (n) -> {
                        Producto prod = n;
                        prod.setPrecio(n.getPrecio() + 0.20 * n.getPrecio());
                        return prod;
                    };
                    List<Producto> prodIncremento = productos.stream().map(incremento).collect(Collectors.toList());
                    prodIncremento.forEach(Producto::MostrarDatos);
                }
                break;

                case "4": {
                    Predicate<Producto> cat = n -> n.getCategoria().equals("ELECTROHOGAR");
                    List<Producto> prod = productos.stream().filter(cat).collect(Collectors.toList());
                    prod.forEach(Producto::MostrarDatos);
                }
                break;

                case "5": {
                    productos.sort((p1, p2) -> Double.compare(p2.getPrecio(), p1.getPrecio()));
                    productos.forEach(Producto::MostrarDatos);
                }
                break;

                case "6": {
                    Function<Producto, Producto> mayuscula = (n) -> {
                        Producto prod = n;
                        prod.setNombre(n.getNombre().toUpperCase());
                        return prod;
                    };
                    List<Producto> prodMayus = productos.stream().map(mayuscula).collect(Collectors.toList());
                    prodMayus.forEach(Producto::MostrarDatos);
                }
                break;

                case "7": {
                    System.out.println("Fin del programa");
                    band = false;
                }
                break;

                default:
                    System.out.println("Opcion no valida. Ingrese una opcion valida");
            }
        }

        scanner.close();
    }

    public static void mostrarMenu() {
        System.out.println("  ****  MENU  ****  ");
        System.out.println("1 – Mostrar productos disponibles");
        System.out.println("2 – Mostrar productos no disponibles");
        System.out.println("3 – Incrementar precios de productos en un 20%");
        System.out.println("4 – Mostrar productos de la categoria ELECTROHOGAR");
        System.out.println("5 – Ordenar productos por precio de forma descendente");
        System.out.println("6 – Mostrar nombres de productos en mayusculas");
        System.out.println("7 - Salir");
        System.out.print("Ingrese su opcion: ");
	}
}