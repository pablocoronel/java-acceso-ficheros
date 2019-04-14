package leyendo_escribiendo_bytes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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

		// System.out.println(contador);
		
		// uso del metodo para crear el archivo
		crea_fichero(datos_entrada);
	}

	// metedo para la escritura del nuevo archivo
	// es estatico para usarlo directamente en el matodo main
	public static void crea_fichero(int[] datos_nuevo_fichero) {
		// ruta del archivo nuevo
		String mi_archivo_nuevo = "C:\\Users\\Usuario\\eclipse-workspace\\Acceso_Ficheros\\src\\leyendo_escribiendo_bytes\\imagen_copiada.png";

		try {
			// stream de salida de bytes
			FileOutputStream fichero_nuevo = new FileOutputStream(mi_archivo_nuevo);

			for (int i = 0; i < datos_nuevo_fichero.length; i++) {
				// escribe cada byte
				fichero_nuevo.write(datos_nuevo_fichero[i]);
			}

			fichero_nuevo.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}