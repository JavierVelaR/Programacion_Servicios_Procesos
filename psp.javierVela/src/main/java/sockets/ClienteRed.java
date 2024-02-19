package sockets;

import java.io.IOException;
import java.net.Socket;

public class ClienteRed {

	public static void main(String[] args) {
		Socket cliente = null;

		try {
			cliente = new Socket("localhost", 62000);
		
			cliente.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
