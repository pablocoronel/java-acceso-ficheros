package escribiendo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Buffer_Escribir_Fichero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Escribiendo_Buffer escribiendo = new Escribiendo_Buffer();
		escribiendo.escribir();
	}

}

class Escribiendo_Buffer {
	public void escribir() {
		String frase = "Esto es una prueba de escritura";

		String mi_archivo = "C:\\Users\\Usuario\\eclipse-workspace\\Acceso_Ficheros\\src\\escribiendo\\archivo_para_escribir.txt";

		try {
			// creacion o sobreescritura del archivo
			// con FileWriter(mi_archivo, true) de 2do parametro, agrega texto a lo ya
			// existente
			FileWriter escritura = new FileWriter(mi_archivo);
			
			BufferedWriter mi_buffered = new BufferedWriter(escritura);
			
			// no funciona
			mi_buffered.write(frase);
			escritura.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}