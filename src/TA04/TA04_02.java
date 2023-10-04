package TA04;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import TA02.Consola;

public class TA04_02 {
	public static void main(String[] args) throws IOException {
		String fic = "." + File.separator + "src" + File.separator +"TA04" + File.separator +"Libros.dat";
		final int long_registro = 168; //Longitud del registro 
		int idConsola, idFichero, ejemplaresConsola, ejemplaresFichero, ejemplaresTotal, posicion;
		String tituloFichero, autorFichero, generoFichero, isbnFichero;
		char [] aux = new char[20];
		
		
		try {
			File f = new File (fic);
			System.out.println("Escribe el numero de ID del libro.");
			idConsola = Consola.readInt();
			
			RandomAccessFile raf = new RandomAccessFile(f, "rw");
			posicion = (idConsola-1)*long_registro;
			
			if (posicion>raf.length()) {
				System.out.println ("El libro no existe.");
			} else {
				raf.seek(posicion);
				idFichero=raf.readInt();
			
				if(idFichero!=idConsola) {
					System.out.println("El Libro no existe");
				} else {
					System.out.println("Escribe el numero de ejemplares vendidos este mes.");
					ejemplaresConsola = Consola.readInt();
					//raf.seek(posicion);
					//idFichero=raf.readInt();
					
					for (int i=0;i<20;i++) {
						aux[i]=raf.readChar();
					}
					isbnFichero= new String(aux).trim();
					
					for (int i=0;i<20;i++) {
						aux[i]=raf.readChar();
					}
					tituloFichero= new String(aux).trim();
					
					for (int i=0;i<20;i++) {
						aux[i]=raf.readChar();
					}
					autorFichero= new String(aux).trim();
					
					for (int i=0;i<20;i++) {
						aux[i]=raf.readChar();
					}
					generoFichero= new String(aux).trim();
					
					ejemplaresFichero = raf.readInt();
					ejemplaresTotal = ejemplaresFichero + ejemplaresConsola;
					raf.seek(posicion+164); //Saltamos hasta ejemplares
					raf.writeInt(ejemplaresTotal);
					System.out.println("ID del libro:" +isbnFichero);
					System.out.println("ISBN del libro:" +isbnFichero);
					System.out.println("Titulo del libro:" +tituloFichero);
					System.out.println("Autor del libro:" +autorFichero);
					System.out.println("Genero del libro:" +generoFichero);
					System.out.println("Numero de ejemplares anterior:" +ejemplaresFichero);
					System.out.println("Nuevo numero de ejemplares:" +ejemplaresTotal);
					
				}
			}
		
		} catch (IOException ex) {
			ex.printStackTrace();
		}
}
}
