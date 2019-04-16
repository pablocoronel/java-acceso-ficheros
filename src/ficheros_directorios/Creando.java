package ficheros_directorios;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Creando {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String ruta_en_windows = "C:/Users/Usuario/eclipse-workspace/Acceso_Ficheros/src/ficheros_directorios/carpeta_pruebas";
		// adapata la barra segun el sistema operativo
		String ruta_base = ruta_en_windows.replace("/", File.separator);

		// crear nueva carpeta
		String ruta_de_nueva_carpeta = ruta_base.concat(File.separator + "carpeta_creada");
		System.out.println(ruta_de_nueva_carpeta);
		File nueva_carpeta = new File(ruta_de_nueva_carpeta);
		// creacion de la nueva carpeta, a partir de una instancia File con la nueva
		// ruta
		nueva_carpeta.mkdir();

		// nuevo archivo
		String ruta_de_nuevo_archivo = ruta_base.concat(File.separator + "archivo_creado.txt");
		File archivo_creado = new File(ruta_de_nuevo_archivo);

		// creacion de nuevo archivo
		try {
			archivo_creado.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// creacion y escritura en un archivo
		String archivo_para_escribir = ruta_base.concat(File.separator + "archivo_para_escribir.txt");
		System.out.println(archivo_para_escribir);

		Escribiendo.escribir(archivo_para_escribir, "Quiero escribir esto");

	}

}

class Escribiendo {
	// hago el metodo estatico para llamarlo sin instanciar
	public static void escribir(String ruta_archivo, String frase) {

		try {
			// creacion del archivo a escribir
			FileWriter escritura = new FileWriter(ruta_archivo);
			escritura.write(frase);

			escritura.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}