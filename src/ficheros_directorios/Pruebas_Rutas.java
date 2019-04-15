package ficheros_directorios;

import java.io.File;

public class Pruebas_Rutas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// sin especificar la ruta, por defecto es la dirección de la carpeta del proyecto
		File mi_archivo = new File("bin");
		
		// ver ruta absoluta
		System.out.println(mi_archivo.getAbsolutePath());
		
		// ver si existe
		System.out.println(mi_archivo.exists());
	}

}
