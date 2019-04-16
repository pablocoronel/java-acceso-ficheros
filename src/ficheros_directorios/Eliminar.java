package ficheros_directorios;

import java.io.File;

public class Eliminar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// ruta base
		String ruta_en_windows = "C:/Users/Usuario/eclipse-workspace/Acceso_Ficheros/src/ficheros_directorios/carpeta_pruebas";
		String ruta_base = ruta_en_windows.replace("/", File.separator);

		// ruta + nombre de archivo
		String archivo_para_escribir = ruta_base.concat(File.separator + "archivo_para_escribir.txt");
		File archivo_creado = new File(archivo_para_escribir);

		// borrar el archivo
		archivo_creado.delete();
	}

}
