package procesos;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Ej4_AntiguoPrograma {

	public static void main(String[] args) {
		try {
			File ruta=new File(".\\target\\classes");
			ProcessBuilder pb=new ProcessBuilder("java","apuntesPSP.Principal");
			pb.directory(ruta);
			
			Process p;
			p=pb.start();
			
			InputStream is=p.getInputStream();
			int c;
			while((c=is.read())!=-1) {
				System.out.print((char)c);
			}
		
			is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
