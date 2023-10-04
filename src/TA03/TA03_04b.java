package TA03;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class TA03_04b {
	public static void main(String[] args){
		String fic = "C:\\Users\\katis\\OneDrive\\Escritorio\\DAM 24\\AD - ACCESO A DATOS\\2023-24\\TEMA01\\Alumno.dat";
		File f = new File (fic);
		Alumno alumno = new Alumno();
		if (!f.exists()) {
			System.out.println("El fichero no existe");
		}			
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
			
			while (true) {
				 alumno = (Alumno)ois.readObject();
				 System.out.printf("Nombre: %s, Apellido: %s, Fecha de nacimiento: %s, Telefono: %d \n",
				        	alumno.getNombre(), alumno.getApellido(), alumno.getFecha_nac(), alumno.getTelefono());
			}
			
		}catch (EOFException eo) {
			System.out.println("Fin de lectura del fichero");
		}catch (IOException ex) {
			ex.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
