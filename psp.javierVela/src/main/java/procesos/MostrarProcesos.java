package procesos;

import java.io.IOException;
import java.io.InputStream;

public class MostrarProcesos {

	public static void main(String[] args) {
		try {
			ProcessBuilder pb=new ProcessBuilder ("CMD","/C","tasklist");
			Process p;
			p=pb.start();
			
			InputStream is=p.getInputStream();
			int c;
			while((c=is.read())!=-1) {
				System.out.print((char)c);
			}
		
			is.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
