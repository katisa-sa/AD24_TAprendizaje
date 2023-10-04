package TA03;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class TA03_01 {

	public static void main(String[] args) {
		
		File f = new File ("C:"+File.separator+"Users"+File.separator+"katis"+File.separator+"OneDrive"+File.separator+"Escritorio"+File.separator+"DAM 24"+File.separator+"AD - ACCESO A DATOS"+File.separator+"2023-24"+File.separator+"TEMA01"+File.separator+"OK.png");
		
		int[] pngSignature = {137, 80, 78, 71, 13, 10, 26, 10}; //cabecera de PNG en decimal
       // byte[] ihdrSignature = {73, 72, 68, 82};
		
        try (InputStream fis = new FileInputStream (f)) {
		
			int[] lpng = new int[8];
			for (int i = 0; i<8; i++) {
				lpng[i] = fis.read();
			}
			if (!Arrays.equals(lpng, pngSignature)) {
				System.out.println("No es un fichero PNG");
                System.exit(-1);
			} else {
				System.out.println("Es un fichero PNG");
	           
				// lee los siguientes 4 bytes para obtener anchura (width) 
	            byte[] bytes = new byte[4];
	            fis.read(bytes);
	            ByteBuffer wrapped = ByteBuffer.wrap(bytes);
	            int width = wrapped.getInt();
	 
	            System.out.println("Width = " + width);
	 
	            // lee los siguientes 4 bytes para obtener altura (height) 
	            // dos formas diferentes de obtener int desde un array de bytes
	            
	            fis.read(bytes);
	            int height = new BigInteger(bytes).intValue();
	 
	            System.out.println("Height = " + height);
			} fis.close();
		}catch (IOException ex) {
        ex.printStackTrace();
		}
	}
}
