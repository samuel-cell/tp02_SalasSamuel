package ar.edu.unju.fi.ejercicio05;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import ar.edu.unju.fi.ejercicio05.Model.*;
public class Main {

	public static void main(String[] args) {
		ArrayList<Producto> productos = Producto.precargarProductos();

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("  ****  MENU  ****  ");
            System.out.println("1 – Mostrar productos");
            System.out.println("2 – Realizar compra");
            System.out.println("3 – Salir");
            System.out.print("Ingrese su opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    mostrarProductos(productos);
                    break;
                case 2:
                    realizarCompra(productos, scanner);
                    break;
                case 3:
                    System.out.println("Fin del programa");
                    break;
                default:
                    System.out.println("Opcion no valida. Ingrese una opcion valida");
                    break;
            }
        } while (opcion != 3);

        scanner.close();
    }

    private static void mostrarProductos(ArrayList<Producto> productos) {
        System.out.println("Productos disponibles:");
        for (Producto producto : productos) {
            System.out.println("Codigo: " + producto.getCodigo() + ", Nombre: " + producto.getNombre() + ", Precio: " + producto.getPrecio() + ", Estado: " + (producto.isEstado() ? "Disponible" : "No disponible"));
        }
    }

    private static void realizarCompra(ArrayList<Producto> productos, Scanner scanner) {
        ArrayList<Producto> productosSeleccionados = new ArrayList<>();
        double total = 0;

        System.out.println("Seleccione los productos que desea comprar:");
        mostrarProductos(productos);
        int opcion;
        do {
            System.out.print("Ingrese el numero del producto o [0] para finalizar: ");
            opcion = scanner.nextInt();
            if (opcion >= 1 && opcion <= productos.size()) {
                Producto productoSeleccionado = productos.get(opcion - 1);
                if (productoSeleccionado.isEstado()) {
                    productosSeleccionados.add(productoSeleccionado);
                    total += productoSeleccionado.getPrecio();
                    productoSeleccionado.setEstado(false);
                } else {
                    System.out.println("El producto seleccionado no esta disponible");
                }
            } else if (opcion != 0) {
                System.out.println("Opcion no valida");
            }
        } while (opcion != 0);

        System.out.println("Seleccione el metodo de pago:");
        System.out.println("1 – Pago efectivo");
        System.out.println("2 – Pago con tarjeta");
        int metodoPago = scanner.nextInt();
        switch (metodoPago) {
            case 1:
                PagoEfectivo pagoEfectivo = new PagoEfectivo(0, LocalDate.now());
                pagoEfectivo.realizarPago(total);
                pagoEfectivo.imprimirRecibo();
                break;
            case 2:
                scanner.nextLine();
                System.out.print("Ingrese el numero de tarjeta: ");
                String numeroTarjeta = scanner.nextLine();
                PagoTarjeta pagoTarjeta = new PagoTarjeta(numeroTarjeta, LocalDate.now(), 0);
                pagoTarjeta.realizarPago(total);
                pagoTarjeta.imprimirRecibo();
                break;
            default:
                System.out.println("Opcion no valida");
                break;
        }
	}
}