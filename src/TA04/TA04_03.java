package TA04;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import TA02.Consola;

public class TA04_03 {
	public static void main(String[] args) throws IOException {
		String fic = "." + File.separator + "src" + File.separator +"TA04" + File.separator +"Libros.dat";
		final int long_registro = 168; //Longitud del registro 
		int ejemplaresFichero;
		boolean existeGenero = false;
		String tituloFichero, autorFichero, generoFichero, isbnFichero, generoConsola;
		
		try {
			File f = new File (fic);
			System.out.println("Escribe un genero de libro [Amor, Acción o Ciencia Ficción].");
			generoConsola = Consola.readString();
			RandomAccessFile raf = new RandomAccessFile(f, "rw");
			
			
			for (int p = 0; p<raf.length(); p+=long_registro) {
				raf.seek(p);;
				raf.skipBytes(124);
				char[] auxGenero = new char[20];
				
				for (int i=0; i<20; i++) {
					auxGenero[i] = raf.readChar();
					}
				
				generoFichero = new String (auxGenero);
				if (generoFichero.trim().equalsIgnoreCase(generoConsola)) {
					existeGenero = true;
					raf.seek(p);
					raf.skipBytes(4);//Salto el código
					//Recojo el ISBN
					char[] auxIsbn =new char[20];
					for(int i=0;i<20;i++)
					{
						auxIsbn[i]=raf.readChar();
					}
					isbnFichero = new String(auxIsbn).trim();
					
					//Recojo el titulo
					char[] auxTitulo =new char[20];
					for(int i=0;i<20;i++)
					{
						auxTitulo[i]=raf.readChar();
					}
					tituloFichero = new String(auxTitulo).trim();
					//Recojo el autor
					char[] auxAutor =new char[20];
					for(int i=0;i<20;i++)
					{
						auxAutor[i]=raf.readChar();
					}
					autorFichero = new String(auxAutor).trim();
					
					raf.skipBytes(40);//Salto el género porque ya lo tengo
					ejemplaresFichero= raf.readInt();
										
					System.out.println("\tTítulo: "+isbnFichero);
					System.out.println("\tTítulo: "+tituloFichero);
					System.out.println("\tAutor: "+autorFichero);
					System.out.println("\tGénero: "+generoFichero);
					System.out.println("\tEjemplares vendidos: "+ejemplaresFichero);
					System.out.println();
				}
			}
			if(!existeGenero)
				System.out.println("El género introducido no existe.");
			raf.close();
		}
		catch (FileNotFoundException e){}
	}
}