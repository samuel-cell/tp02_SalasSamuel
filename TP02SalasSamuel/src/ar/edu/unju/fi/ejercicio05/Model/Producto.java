package ar.edu.unju.fi.ejercicio05.Model;
import java.util.ArrayList;

public class Producto {
	private String codigo;
    private String nombre;
    private double precio;
    private boolean estado;

    public Producto(String codigo, String nombre, double precio, boolean estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.estado = estado;
    }

    public Producto(String string, int i, boolean b) {
    	
	}

	public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
	public void MostrarDatos() {
		System.out.println();
		System.out.println("Codigo: "+codigo);
		System.out.println("Nombre del producto "+nombre);
		if(estado) {
			System.out.println("Estado: Disponible");
			System.out.println("Precio: "+precio);
		}
	}
	public static ArrayList<Producto> precargarProductos() {
        ArrayList<Producto> productos = new ArrayList<>();
        productos.add(new Producto("01", "Remera", 9000.99, true));
        productos.add(new Producto("02", "Pantalones", 14000.45, true));
        productos.add(new Producto("03", "Zapatos", 50000.0, false));
        productos.add(new Producto("04", "Zapatillas", 36000.50, true));
        productos.add(new Producto("05", "Gorra", 3500.75, true));
        productos.add(new Producto("06", "Bufanda", 2500.0, false));
        productos.add(new Producto("07", "Campera", 11000.25, true));
        productos.add(new Producto("08", "Medias", 2300.0, true));
        productos.add(new Producto("09", "Guantes", 1850.60, false));
        productos.add(new Producto("10", "Pantalon corto", 12400.70, false));
        productos.add(new Producto("11", "Vestido", 20000.99, true));
        productos.add(new Producto("12", "Falda", 16700.20, true));
        productos.add(new Producto("13", "Corbata", 2800.50, true));
        productos.add(new Producto("14", "Sombrero", 3800.20, true));
        productos.add(new Producto("15", "Bolso", 40000.0, true));
        return productos;
    }
}