package TA02;

import java.io.File;

public class TA02_01 {
	public static void main(String[] args) {
		String dir = "C:" + File.separator + "Windows";
		// si tiene arguments en el main, la direccion, coge la ruta de alli
		if (args.length >= 1)
			dir = args[0];
		
		File fic = new File(dir);
		
		
		if (!fic.exists()) {
			System.out.println("El fichero o directorio " + dir + "no existe");
		} else {

			if (fic.isFile()) {
				System.out.println(dir + "es un fichero");
			} else {
				System.out.println(dir + "es un directorio. Contiene:");
				File[] lista = fic.listFiles();
				for (int i = 0; i < lista.length; i++) {

					String textoDescr = lista[i].isDirectory() ? "/" : lista[i].isFile() ? "_" : "?";
					System.out.println("(" + textoDescr + ") " + lista[i].getName());
				}
			}
		}

	}

}
