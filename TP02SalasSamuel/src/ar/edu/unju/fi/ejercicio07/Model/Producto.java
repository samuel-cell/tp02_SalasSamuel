package ar.edu.unju.fi.ejercicio07.Model;
import java.util.ArrayList;

public class Producto {
	private String codigo;
    private String nombre;
    private double precio;
    private boolean estado;
    private String categoria;

    public Producto(String codigo, String nombre, double precio, boolean estado, String categoria) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.estado = estado;
        this.categoria = categoria;
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
    
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
	public void MostrarDatos() {
		System.out.println();
		System.out.println("Codigo: "+codigo);
		System.out.println("Nombre del producto "+nombre);
		System.out.println("Categoria: " + categoria);
		System.out.println("Precio: "+precio);
		if(estado) {
			System.out.println("Estado: Disponible");
		}
		else {
			System.out.println("Estado: No Disponible");
		}
	}
	
	public static ArrayList<Producto> precargarProductos() {
        ArrayList<Producto> productos = new ArrayList<>();
        productos.add(new Producto("01", "Celular", 900000.50, true, "TELEFONIA"));
        productos.add(new Producto("02", "Notebook", 1500000.20, true, "INFORMATICA"));
        productos.add(new Producto("03", "Aspiradora", 500000.70, false, "ELECTROHOGAR"));
        productos.add(new Producto("04", "Taladro", 35000.10, true, "HERRAMIENTAS"));
        productos.add(new Producto("05", "Tablet", 1200000.90, true, "TELEFONIA"));
        productos.add(new Producto("06", "Impresora", 620000.0, false, "INFORMATICA"));
        productos.add(new Producto("07", "Plancha", 250000.30, true, "ELECTROHOGAR"));
        productos.add(new Producto("08", "Destornillador", 3000.20, true, "HERRAMIENTAS"));
        productos.add(new Producto("09", "Martillo", 8000.0, false, "HERRAMIENTAS"));
        productos.add(new Producto("10", "Monitor", 90000.80, true, "INFORMATICA"));
        productos.add(new Producto("11", "Microondas", 750000.20, true, "ELECTROHOGAR"));
        productos.add(new Producto("12", "Sierra", 55000.0, false, "HERRAMIENTAS"));
        productos.add(new Producto("13", "Licuadora", 75000.30, true, "ELECTROHOGAR"));
        productos.add(new Producto("14", "Teclado", 25000.0, true, "INFORMATICA"));
        productos.add(new Producto("15", "Heladera", 1700000.90, true, "ELECTROHOGAR"));
        return productos;
    }
}