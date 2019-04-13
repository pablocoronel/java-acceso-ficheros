package leyendo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Acceso_Fichero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Leeer_Fichero lee = new Leeer_Fichero();
		// uso del metodo de la clase que tiene el archivo para leer
		lee.lee();
	}

}

class Leeer_Fichero {
	// metedor para leer un archivo
	public void lee() {
		// usa la clase FileReader
		try {
			// ruta del archivo
			String mi_archivo = "C:\\Users\\Usuario\\eclipse-workspace\\Acceso_Ficheros\\src\\indice.txt";

			// instancia lectora
			FileReader entrada = new FileReader(mi_archivo);

			// devolucion de cada caracter
			int un_caracter = entrada.read();

			// recorrido de los caracteres
			while (un_caracter != -1) {
				// casteo de unicode a char
				char c = (char) un_caracter;
				System.out.print(c);

				// siguiente caracter
				un_caracter = entrada.read();
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