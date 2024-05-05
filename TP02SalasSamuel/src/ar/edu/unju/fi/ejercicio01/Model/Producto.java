package ar.edu.unju.fi.ejercicio01.Model;

public class Producto {
	private String codigo;
    private String descripcion;
    private double precioUnitario;
    private OrigenDeFabricacion origenFabricacion;
    private Categoria categoria;

    public enum OrigenDeFabricacion {
        ARGENTINA, CHINA, BRASIL, URUGUAY
    }

    public enum Categoria {
        TELEFONIA, INFORMATICA, ELECTROHOGAR, HERRAMIENTAS
    }

    public Producto(String codigo, String descripcion, double precioUnitario, OrigenDeFabricacion origenFabricacion, Categoria categoria) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.origenFabricacion = origenFabricacion;
        this.categoria = categoria;
    }

    public Producto() {
		
	}

	public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public OrigenDeFabricacion getOrigenFabricacion() {
        return origenFabricacion;
    }

    public void setOrigenFabricacion(OrigenDeFabricacion origenFabricacion) {
        this.origenFabricacion = origenFabricacion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

}