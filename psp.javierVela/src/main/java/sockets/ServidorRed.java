package sockets;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorRed {

	public static void main(String[] args) {

		ServerSocket servidor = null;
		Socket cliente = null;
		int puerto = 62000;
		try {
			servidor = new ServerSocket(puerto);
			System.out.println("Esperando cliente en el puerto: " + puerto);
			cliente = servidor.accept(); // el main se detiene aquí hasta aceptar a un cliente.

			cliente.close();
			servidor.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}