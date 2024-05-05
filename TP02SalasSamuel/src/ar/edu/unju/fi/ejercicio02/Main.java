package ar.edu.unju.fi.ejercicio02;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import ar.edu.unju.fi.ejercicio02.Model.*;
import ar.edu.unju.fi.ejercicio02.Constantes.*;
public class Main {

	public static void main(String[] args) {
		List<Efemeride> efemerides = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        do {
            mostrarMenu();
            int opcion = obtenerEntero(scanner);

            switch (opcion) {
                case 1:
                    crearEfemeride(scanner, efemerides);
                    break;
                case 2:
                    mostrarEfemerides(efemerides);
                    break;
                case 3:
                    eliminarEfemeride(scanner, efemerides);
                    break;
                case 4:
                    modificarEfemeride(scanner, efemerides);
                    break;
                case 5:
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
        System.out.println("1 - Crear efemeride");
        System.out.println("2 - Mostrar efemerides");
        System.out.println("3 - Eliminar efemeride");
        System.out.println("4 - Modificar efemeride");
        System.out.println("5 - Salir");
        System.out.print("Ingrese su opcion: ");
    }

    private static int obtenerEntero(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Ingrese un numero entero valido");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static void crearEfemeride(Scanner scanner, List<Efemeride> efemerides) {
        System.out.println("Ingrese el codigo de la efemeride:");
        String codigo = scanner.next();

        System.out.println("Ingrese el mes [1-12]:");
        int numMes = obtenerEntero(scanner);
        Mes mes = obtenerMes(numMes);

        System.out.println("Ingrese el dia:");
        int dia = obtenerEntero(scanner);

        System.out.println("Ingrese el detalle:");
        String detalle = scanner.next();

        Efemeride efemeride = new Efemeride(codigo, mes, dia, detalle);
        efemerides.add(efemeride);
        System.out.println("Efemeride creada correctamente");
    }

    private static Mes obtenerMes(int numMes) {
        Mes mes;
        switch (numMes) {
            case 1:
                mes = Mes.ENERO;
                break;
            case 2:
                mes = Mes.FEBRERO;
                break;
            case 3:
                mes = Mes.MARZO;
                break;
            case 4:
                mes = Mes.ABRIL;
                break;
            case 5:
                mes = Mes.MAYO;
                break;
            case 6:
                mes = Mes.JUNIO;
                break;
            case 7:
                mes = Mes.JULIO;
                break;
            case 8:
                mes = Mes.AGOSTO;
                break;
            case 9:
                mes = Mes.SEPTIEMBRE;
                break;
            case 10:
                mes = Mes.OCTUBRE;
                break;
            case 11:
                mes = Mes.NOVIEMBRE;
                break;
            case 12:
                mes = Mes.DICIEMBRE;
                break;
            default:
                mes = null;
                break;
        }
        return mes;
    }

private static void mostrarEfemerides(List<Efemeride> efemerides) {
    System.out.println("**LISTADO DE EFEMERIDES**");
    for (Efemeride efemeride : efemerides) {
        System.out.println("Codigo: " + efemeride.getCodigo());
        System.out.println("Mes: " + efemeride.getMes());
        System.out.println("Dia: " + efemeride.getDia());
        System.out.println("Detalle: " + efemeride.getDetalle());
        System.out.println();
    }
}


    private static void eliminarEfemeride(Scanner scanner, List<Efemeride> efemerides) {
        System.out.println("Ingrese el codigo de la efemeride a eliminar:");
        String codigo = scanner.next();

        for (Efemeride efemeride : efemerides) {
            if (efemeride.getCodigo().equals(codigo)) {
                efemerides.remove(efemeride);
                System.out.println("Efemeride eliminada correctamente");
                return;
            }
        }
        System.out.println("No se encontro ninguna efemeride con el codigo ingresado");
    }

    private static void modificarEfemeride(Scanner scanner, List<Efemeride> efemerides) {
        System.out.println("Ingrese el codigo de la efemeride a modificar:");
        String codigo = scanner.next();

        for (Efemeride efemeride : efemerides) {
            if (efemeride.getCodigo().equals(codigo)) {
                System.out.println("Seleccione el campo a modificar:");
                System.out.println("1 - Mes");
                System.out.println("2 - Dia");
                System.out.println("3 - Detalle");
                int opcion = obtenerEntero(scanner);

                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese el nuevo mes [1-12]:");
                        int numMes = obtenerEntero(scanner);
                        efemeride.setMes(obtenerMes(numMes));
                        break;
                    case 2:
                        System.out.println("Ingrese el nuevo dia:");
                        int dia = obtenerEntero(scanner);
                        efemeride.setDia(dia);
                        break;
                    case 3:
                        System.out.println("Ingrese el nuevo detalle:");
                        String detalle = scanner.next();
                        efemeride.setDetalle(detalle);
                        break;
                    default:
                        System.out.println("Opcion no valida. Intente de nuevo");
                        break;
                }
                System.out.println("Efemeride modificada correctamente");
                return;
            }
        }
        System.out.println("No se encontro ninguna efemeride con el codigo ingresado");
	}
}