package TA04;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class TA04_01 {

	public static void main(String[] args) throws IOException {
		String fic = "." + File.separator + "src" + File.separator +"TA04" + File.separator +"Libros.dat";
		File f = new File (fic);
		final int long_registro = 168; //Longitud del registro 
		if(f.exists()){
			f.delete();
		}
		RandomAccessFile file = new RandomAccessFile(f, "rw");
		 //Arrays con los datos de los libros
		int [] ids= {1, 2, 3, 4, 5, 6};
		String[] isbns= {"978-6-0654-9819-8", "978-8-9523-1353-9", "978-3-2580-1238-4", "978-2-9722-8669-9", "978-6-4710-4331-9", "978-0-2782-5910-2"};
		String[] titulos= {"Harry Potter", "1984", "Yo, Robot", "Neuromante" , "American Gods", "La camana"};
		String[] autores = {"JK Rowling", "George Orwell", "Isaac Asimov", "William Gibson", "Neil Gaiman", "Annette Heiss"};
		String[] generos = {"Accion", "Ciencia Ficcion", "Ciencia Ficcion", "Ciencia Ficcion", "Accion", "Accion"};
		int[] ejemplaresVendidos = {76664, 44478, 54578, 35467, 65677, 74788};

		StringBuffer bufferIsbn = null;
		StringBuffer bufferTit = null;
		StringBuffer bufferAut = null;
		StringBuffer bufferGen = null;
		int cuantos=isbns.length;
		int posicion = 0;
				
		for (int i=0;i<cuantos; i++){
			posicion=i*long_registro;
			file.seek(posicion);
			
			 //System.out.println("Insertando libro: "+ titulos[i] " );
			file.writeInt(ids[i]);
			
			bufferIsbn = new StringBuffer( isbns[i] );      //ISBN
			bufferIsbn.setLength(20); 
			file.writeChars(bufferIsbn.toString());
			
			bufferTit = new StringBuffer( titulos[i] );      //Titulo
			bufferTit.setLength(20); 
			file.writeChars(bufferTit.toString());
			
			bufferAut = new StringBuffer( autores[i] );      //Autor
			bufferAut.setLength(20); 
			file.writeChars(bufferAut.toString());
			
			bufferGen = new StringBuffer( generos[i] );      //Genero
			bufferGen.setLength(20); 
			file.writeChars(bufferGen.toString());
			
			file.writeInt(ejemplaresVendidos[i]);
		 }     
		file.close();
		System.out.println("La carga de los libros ha terminado correctamente.");	
		
			
		
		
		/*
		
		int [] ids= {1, 2, 3, 4, 5, 6};
		String[] isbns= {"978-6-0654-9819-8", "978-8-9523-1353-9", "978-3-2580-1238-4", "978-2-9722-8669-9", "978-6-4710-4331-9", "978-0-2782-5910-2"};
		String[] titulos= {"Harry Potter", "1984", "Yo, Robot", "Neuromante" , "American Gods", "La casa alemana"};
		String[] autores = {"JK Rowling", "George Orwell", "Isaac Asimov", "William Gibson", "Neil Gaiman", "Annette Heiss"};
		String[] generos = {"Accion", "Ciencia Ficcion", "Ciencia Ficcion", "Ciencia Ficcion", "Accion", "Accion"};
		int[] ejemplaresVendidos = {76664, 44478, 54578, 35467, 65677, 74788};
		
		if (!f.exists() && !f.isDirectory()) {
			f.createNewFile();
			System.out.println("Se ha creado un nuevo fichero");
		}			
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f))) {
			List <Libros> listaLibros = new ArrayList<>();
			
			for (int i =0;i<ids.length;i++) {
			listaLibros.add(new Libros(ids[i],isbns[i],titulos[i],autores[i],generos[i],ejemplaresVendidos[i]));
			
			}
						
			for (Libros lib: listaLibros) {
				oos.writeObject(lib);
			} 
			System.out.println("La carga de libros ha terminado.");
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}*/
}
}