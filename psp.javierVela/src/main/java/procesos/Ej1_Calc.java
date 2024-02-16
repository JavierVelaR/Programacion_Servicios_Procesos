package procesos;

import java.io.File;
import java.io.IOException;

public class Ej1_Calc {

	public static void main(String[] args) {
		try {
			File ruta = new File("");
			//ProcessBuilder pb = new ProcessBuilder("CMD", "/C", "Start Calc");
			ProcessBuilder pb = new ProcessBuilder("Chrome");
			pb.directory(ruta);
			pb.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
