package leyendo_escribiendo_bytes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Lectura_Escritura {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// ruta
		String mi_archivo = "C:\\Users\\Usuario\\eclipse-workspace\\Acceso_Ficheros\\src\\leyendo_escribiendo_bytes\\imagen.png";
		int contador = 0; // cuenta los bytes de la imagen
		int[] datos_entrada = new int[2902]; // array para guardar los bytes de la imagen

		try {
			// stream para bytes
			FileInputStream archivo_lectura = new FileInputStream(mi_archivo);

			// indica si llego al final del archivo
			boolean final_archivo = false;

			// recorrido
			while (!final_archivo) {
				int byte_entrada = archivo_lectura.read(); // recorre cada byte

				// si no llego al final
				if (byte_entrada != -1) {
					datos_entrada[contador] = byte_entrada;
				} else {
					// sino, indica para salir del while
					final_archivo = true;
				}

				System.out.println(datos_entrada[contador]);
				contador++; // incrementa el contador
			}

			archivo_lectura.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//System.out.println(contador);
	}

}
