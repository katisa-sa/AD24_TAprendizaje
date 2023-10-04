package TA02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TA02_02 {

	public static void main(String[] args) {
		//String fic = args [0];
		String fic = "C:\\Users\\katis\\OneDrive\\Escritorio\\DAM 24\\AD - ACCESO A DATOS\\2023-24\\TEMA01\\Texto.txt\\";
		try ( BufferedReader bf = new BufferedReader (new FileReader (new File(fic)))){
		
					int i = 1;
					String linea = bf.readLine();			
					while (linea != null) {
						System.out.format ("[%5d] %s", i++, linea);
						System.out.println();
						linea = bf.readLine();	
					}
		
		} catch (FileNotFoundException e) {
		      System.out.println("No existe fichero " + fic);
		    } catch (IOException e) {
		      System.out.println("Error de E/S: " + e.getMessage());
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
	}
}


