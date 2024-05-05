package ar.edu.unju.fi.ejercicio04;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.time.LocalDate;
import ar.edu.unju.fi.ejercicio04.Model.*;
import ar.edu.unju.fi.ejercicio04.Constantes.*;
public class Main {

	public static void main(String[] args) {
		ArrayList<Jugador> jugadores = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int opcion = 0;
        do {
            System.out.println("  ****  MENU  ****  ");
            System.out.println("1 – Alta de jugador");
            System.out.println("2 – Mostrar todos los jugadores");
            System.out.println("3 – Modificar la posicion de un jugador");
            System.out.println("4 – Eliminar un jugador");
            System.out.println("5 – Salir");

            System.out.print("Ingrese su opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    Jugador nuevoJugador = crearJugador(scanner);
                    jugadores.add(nuevoJugador);
                    break;
                case 2:
                    mostrarJugadores(jugadores);
                    break;
                case 3:
                    modificarPosicion(scanner, jugadores);
                    break;
                case 4:
                    eliminarJugador(scanner, jugadores);
                    break;
                case 5:
                    System.out.println("Fin del programa");
                    break;
                default:
                    System.out.println("Opcion no valida. Ingrese una opcion valida");
                    break;
            }
        } while (opcion != 5);

        scanner.close();
    }

    private static Jugador crearJugador(Scanner scanner) {
        System.out.println("Ingrese los datos del jugador:");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Fecha de nacimiento (AAAA-MM-DD): ");
        LocalDate fechaNacimiento = LocalDate.parse(scanner.nextLine());
        System.out.print("Nacionalidad: ");
        String nacionalidad = scanner.nextLine();
        System.out.print("Estatura (metros): ");
        double estatura = scanner.nextDouble();
        System.out.print("Peso (kilogramos): ");
        double peso = scanner.nextDouble();
        scanner.nextLine(); 

        System.out.print("Posicion [DELANTERO, MEDIO, DEFENSA, ARQUERO]: ");
        Posicion posicion = Posicion.valueOf(scanner.nextLine().toUpperCase());

        return new Jugador(nombre, apellido, fechaNacimiento, nacionalidad, estatura, peso, posicion);     
    }
    
    private static void mostrarJugadores(ArrayList<Jugador> jugadores) {
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores registrados");
            return;
        }

        System.out.println("**Jugadores registrados**");
        for (Jugador jugador : jugadores) {
            int edad = jugador.calcularEdad();
            System.out.println("Nombre: " + jugador.getNombre());
            System.out.println("Apellido: " + jugador.getApellido());
            System.out.println("Edad: " + edad + " años");
            System.out.println("Nacionalidad: " + jugador.getNacionalidad());
            System.out.println("Estatura: " + jugador.getEstatura() + " metros");
            System.out.println("Peso: " + jugador.getPeso() + " kilogramos");
            System.out.println("Posicion: " + jugador.getPosicion());
            System.out.println();
        }
    }

    private static void modificarPosicion(Scanner scanner, ArrayList<Jugador> jugadores) {
        System.out.println("Ingrese el nombre y apellido del jugador que desea modificar su posicion:");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();

        for (Jugador jugador : jugadores) {
            if (jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido)) {
                System.out.print("Nueva posicion [DELANTERO, MEDIO, DEFENSA, ARQUERO]: ");
                Posicion nuevaPosicion = Posicion.valueOf(scanner.nextLine().toUpperCase());
                jugador.setPosicion(nuevaPosicion);
                System.out.println("Posicion modificada correctamente");
                return;
            }
        }

        System.out.println("Jugador no encontrado");
    }

    private static void eliminarJugador(Scanner scanner, ArrayList<Jugador> jugadores) {
        System.out.println("Ingrese el nombre y apellido del jugador que desea eliminar:");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();

        Iterator<Jugador> iterator = jugadores.iterator();
        while (iterator.hasNext()) {
            Jugador jugador = iterator.next();
            if (jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido)) {
                iterator.remove();
                System.out.println("Jugador eliminado correctamente");
                return;
            }
        }

        System.out.println("Jugador no encontrado");
	}
}