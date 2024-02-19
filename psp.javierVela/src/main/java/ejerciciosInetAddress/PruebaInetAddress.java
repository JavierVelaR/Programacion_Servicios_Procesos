package ejerciciosInetAddress;

import java.net.*;

public class PruebaInetAddress {

	public static void main(String[] args) {
		// Creo una variable dir que almacenará la dirección de la máquina local
		InetAddress dir;
		System.out.println("===========================================");
		System.out.println("SALIDA PARA LOCALHOST:");
		try {
			
			// dir = InetAddress.getLocalHost();

			// dir = InetAddress.getByName("DESKTOP-MQIP24H");

			dir = InetAddress.getByName("www.cenecmalaga.es");

			pruebaMetodos(dir);//

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	private static void pruebaMetodos(InetAddress dir) {
		System.out.println("\tMetodo getLocalHost(): " + dir);

		// Usamos los métodos vistos
		System.out.println("\tMetodo getHostName(): " + dir.getHostName());
		System.out.println("\tMetodo getHostAddress(): " + dir.getHostAddress());
		System.out.println("\tMetodo getCanonicalHostName(): " + dir.getCanonicalHostName());
	}

}
