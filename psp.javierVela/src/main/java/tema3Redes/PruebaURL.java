package tema3Redes;

import java.net.*;

public class PruebaURL {

	public static void main(String[] args) {
		URL url;
		try {
			System.out.println("Constructor simple para URL:");
			url = new URL("https://www.youtube.com/watch?v=SMTA7QEnWD4");
			Visualizar(url);
			
		} catch(MalformedURLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	private static void Visualizar(URL url) {
			System.out.println("\tURL completa: " + url);
			System.out.println("\tgetProtocol(): " + url.getProtocol());
			System.out.println("\tgetHost(): " + url.getHost());
			System.out.println("\tgetDefaultPort(): " + url.getDefaultPort());
			System.out.println("\tgetPort(): " + url.getPort());
			System.out.println("\tgetPath(): " + url.getPath());
			System.out.println("\tgetQuery(): " + url.getQuery());
			System.out.println("\tgetFile(): " + url.getFile());
			System.out.println("\tgetAuthority(): " + url.getAuthority());
			System.out.println("========================================================");

		}
}
