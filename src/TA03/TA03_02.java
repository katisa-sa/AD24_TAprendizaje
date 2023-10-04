package TA03;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TA03_02 {

	public static void main(String[] args) {
		String f = "C:\\Users\\katis\\OneDrive\\Escritorio\\DAM 24\\AD - ACCESO A DATOS\\2023-24\\TEMA01\\Texto.txt\\";
		try (FileReader fr = new FileReader (new File (f))){
			int i = 1;
			char letra = 0;	
			while ((i = fr.read())!=-1) {
				letra = (char)i;
				if(letra>=97 && letra<=122){
					letra-=32;
		    	} else if(letra>=65 && letra<=90){
		    		letra+=32;
		    	}
		    	System.out.print(letra);
		    }
				fr.close();
					
		} catch (IOException ex) {
	        ex.printStackTrace();
			}
	}
}


