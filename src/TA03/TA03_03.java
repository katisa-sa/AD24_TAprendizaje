package TA03;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import TA02.Consola;

public class TA03_03 {

	public static void main(String[] args) {
		String f = "C:\\Users\\katis\\OneDrive\\Escritorio\\DAM 24\\AD - ACCESO A DATOS\\2023-24\\TEMA01\\Texto.txt\\";
		
		try (FileReader fr = new FileReader (new File (f))){
			System.out.print("Elija una letra.");
			
			char ll = Consola.readChar();
			int i = 1;
			char letra = 0;	
			int cont = 0;
			while ((i = fr.read())!=-1) {
				letra = (char)i;
				char letra2 = (char)ll;
				if(letra == letra2){
					cont = cont+1;
		    	}
		    } 
			System.out.print("La letra " + ll + " se repite " + cont + " veces.");
			fr.close();
					
		} catch (IOException ex) {
	        ex.printStackTrace();
			}
	}
	}
