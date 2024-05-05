package ar.edu.unju.fi.ejercicio06;
import ar.edu.unju.fi.ejercicio06.Model.*;
import ar.edu.unju.fi.ejercicio06.interfaces.funcionales.*;
public class Main {

	public static void main(String[] args) {
		FelinoDomestico gato = new FelinoDomestico("Garfield", (byte) 45, 12f);

        Converter<FelinoDomestico, FelinoSalvaje> converter = x -> new FelinoSalvaje(x.getNombre(),
                x.getEdad(), x.getPeso());

        FelinoSalvaje felino1 = converter.convert(gato);
        
        converter.mostrarObjeto(felino1);

        FelinoSalvaje leon = new FelinoSalvaje("Tanner", (byte) 20, 186f);

        if (Converter.isNotNull(leon)) {
            Converter<FelinoSalvaje, FelinoDomestico> converter2 = x -> new FelinoDomestico(x.getNombre(),
                    x.getEdad(), x.getPeso());

            FelinoDomestico felino2 = converter2.convert(leon);

            converter2.mostrarObjeto(felino2);
        } else {
            System.out.println("El objeto a convertir es nulo.");
        }
	}
}