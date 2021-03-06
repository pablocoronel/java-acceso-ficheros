package ficheros_directorios;

import java.io.File;

public class Acceso_Ficheros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String ruta_en_windows = "C:/Users/Usuario/eclipse-workspace/Acceso_Ficheros/src/ficheros_directorios/carpeta_pruebas";

		String ruta_multisistema = ruta_en_windows.replace("/", File.separator); // adapata la barra segun el sistema
																					// operativo
		System.out.println(ruta_multisistema);

		File ruta = new File(ruta_multisistema);

		System.out.println(ruta.getAbsolutePath());

		// ver listado de archivos en la carpeta

		String[] listado_archivos = ruta.list();

		for (int i = 0; i < listado_archivos.length; i++) {
			System.out.println(listado_archivos[i]);

			// devuelve la ruta + el archivo
			File f = new File(ruta.getAbsolutePath(), listado_archivos[i]);

			// System.out.println(f);
			if (f.isDirectory()) {
				String[] archivos_subcarpeta = f.list();

				for (int j = 0; j < archivos_subcarpeta.length; j++) {
					System.out.println(archivos_subcarpeta[j]);
				}
			}
		}
	}

}
