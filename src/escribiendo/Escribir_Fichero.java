package escribiendo;

import java.io.FileWriter;
import java.io.IOException;

public class Escribir_Fichero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Escribiendo escribiendo = new Escribiendo();
		escribiendo.escribir();
	}

}

class Escribiendo {
	public void escribir() {
		String frase = "Esto es una prueba de escritura";

		String mi_archivo = "C:\\Users\\Usuario\\eclipse-workspace\\Acceso_Ficheros\\src\\archivo_para_escribir.txt";

		try {
			// creacion o sobreescritura del archivo
			// con FileWriter(mi_archivo, true) de 2do parametro, agrega texto a lo ya
			// existente
			FileWriter escritura = new FileWriter(mi_archivo);

			// con un for se agrega cada caracter
			for (int i = 0; i < frase.length(); i++) {
				// toma de a un caracter de la frase
				escritura.write(frase.charAt(i));
			}

			escritura.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}