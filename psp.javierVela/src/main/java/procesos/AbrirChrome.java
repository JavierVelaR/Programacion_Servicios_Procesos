package procesos;

import java.io.IOException;

public class AbrirChrome {

	public static void main(String[] args) {
		try {
			ProcessBuilder pb = new ProcessBuilder("CMD", "/C", "Start Chrome");
			pb.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
