package procesos;

import java.io.IOException;
import java.io.InputStream;

public class Ej5_Ping {

	public static void main(String[] args) {
		try {
			ProcessBuilder pb = new ProcessBuilder("cmd","/c","ping 128.0.0.1");
		
			Process p;
			p = pb.start();
			
			InputStream is = p.getInputStream();
			
			int c;
			while ((c=is.read()) != -1) {
				System.out.print((char)c);
			}
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
