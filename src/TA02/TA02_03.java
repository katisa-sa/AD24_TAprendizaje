package TA02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TA02_03 {

	public static void main(String[] args) {
		String fic = "C:\\Users\\katis\\OneDrive\\Escritorio\\DAM 24\\AD - ACCESO A DATOS\\2023-24\\TEMA01\\Texto.txt\\";
		
		System.out.println("Indica por favor la cadena que quieres buscar");
		
		
		try ( BufferedReader bf = new BufferedReader (new FileReader (new File(fic)))){
			String ent = Consola.readString();
			int i = 1;
			int col = 0;
			String linea = bf.readLine();	
			
			while (linea != null) {
				if (linea.indexOf(ent)!= -1) {
					col = linea.indexOf(ent);
				        System.out.format("[%d,%d] %s", i, col, linea);
				        System.out.println();
				}
				i++;   	
				linea = bf.readLine();
				
			}	bf.close();
			
		
		} catch (FileNotFoundException e) {
		      System.out.println("No existe fichero " + fic);
		    } catch (IOException e) {
		      System.out.println("Error de E/S: " + e.getMessage());
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
	}

}
