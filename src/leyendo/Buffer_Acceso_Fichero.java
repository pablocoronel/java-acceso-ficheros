package leyendo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Buffer_Acceso_Fichero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Leeer_Fichero_Buffer lee = new Leeer_Fichero_Buffer();
		// uso del metodo de la clase que tiene el archivo para leer
		lee.lee();
	}

}

class Leeer_Fichero_Buffer {
	// metedor para leer un archivo
	public void lee() {
		// usa la clase FileReader
		try {
			// ruta del archivo
			String mi_archivo = "C:\\Users\\Usuario\\eclipse-workspace\\Acceso_Ficheros\\src\\indice.txt";

			// instancia lectora
			FileReader entrada = new FileReader(mi_archivo);

			// Creacion del buffer
			BufferedReader mi_buffered = new BufferedReader(entrada);

			String linea = mi_buffered.readLine();

			// recorrido de los caracteres
			while (linea != null) {
				System.out.println(linea);
				
				linea = mi_buffered.readLine();
			}

			entrada.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("No se encontró el archivo");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}
}