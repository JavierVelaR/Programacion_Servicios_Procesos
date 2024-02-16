package procesos;

import java.io.File;
import java.io.IOException;

public class Ej3_Errores {
	
	public static void main(String[] args) {
		try {
			ProcessBuilder pb=new ProcessBuilder ("CMD","/C","tasklist");
			File fOut=new File("Salida.txt");
			File fErr=new File("Error.txt");
			
			pb.redirectOutput(fOut);
			pb.redirectError(fErr);
			
			pb.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
