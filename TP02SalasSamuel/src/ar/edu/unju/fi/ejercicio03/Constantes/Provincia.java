package ar.edu.unju.fi.ejercicio03.Constantes;

public enum Provincia {
	JUJUY(673307, 53219.99),
    SALTA(1448127, 155488),
    TUCUMAN(1694658, 22224),
    CATAMARCA(367828, 102606),
    LA_RIOJA(398648, 89680),
    SANTIAGO_DEL_ESTERO(874006, 136351);

    private int cantidadPoblacion;
    private double superficie;

    private Provincia(int cantidadPoblacion, double superficie) {
        this.cantidadPoblacion = cantidadPoblacion;
        this.superficie = superficie;
    }

    public int getCantidadPoblacion() {
        return cantidadPoblacion;
    }

    public void setCantidadPoblacion(int cantidadPoblacion) {
        this.cantidadPoblacion = cantidadPoblacion;
    }

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public double calcularDensidadPoblacional() {
        return cantidadPoblacion / superficie;
    }
}