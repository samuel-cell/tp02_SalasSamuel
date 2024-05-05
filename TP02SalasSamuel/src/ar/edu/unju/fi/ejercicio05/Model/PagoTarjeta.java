package ar.edu.unju.fi.ejercicio05.Model;
import java.time.LocalDate;
import ar.edu.unju.fi.ejercicio05.Interfaces.*;
public class PagoTarjeta implements Pago {
	private String numeroTarjeta;
    private LocalDate fechaPago;
    private double montoPagado;

    public PagoTarjeta(String numeroTarjeta, LocalDate fechaPago, double montoPagado) {
        this.numeroTarjeta = numeroTarjeta;
        this.fechaPago = fechaPago;
        this.montoPagado = montoPagado;
    }

    public void realizarPago(double monto) {
        double recargo = monto * 0.15;
        this.montoPagado = monto + recargo;
    }

    public void imprimirRecibo() {
        System.out.println("Numero de tarjeta: " + numeroTarjeta);
        System.out.println("Fecha de pago: " + fechaPago);
        System.out.println("Monto pagado: " + montoPagado);
    }
}