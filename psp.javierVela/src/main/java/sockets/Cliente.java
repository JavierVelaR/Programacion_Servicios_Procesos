package sockets;

import java.io.IOException;
import java.net.Socket;

public class Cliente {
	public static void main(String[] args) {
		String host = "localhost";
		int puerto = 62000;
		
		try {
			Socket cliente = new Socket(host,puerto);
			System.out.println("Hola");

			cliente.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
