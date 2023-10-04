package TA03;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TA03_04a {

	public static void main(String[] args) throws IOException {
		String fic = "C:\\Users\\katis\\OneDrive\\Escritorio\\DAM 24\\AD - ACCESO A DATOS\\2023-24\\TEMA01\\Alumno.dat";
		File f = new File (fic);
		
		if (!f.exists() && !f.isDirectory()) {
			f.createNewFile();
			System.out.println("Se ha creado un nuevo fichero");
		}			
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f))) {
			List <Alumno> listaAlumno = new ArrayList<>();
			listaAlumno.add(new Alumno("Mikel","Bergara",LocalDate.parse("1997-08-28"), 654789562));
			listaAlumno.add(new Alumno("Asier","Etxebarria",LocalDate.parse("1996-03-25"), 66489565));
			
			for (Alumno alum: listaAlumno) {
				oos.writeObject(alum);
			}
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
