package examen2Trimestre;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClienteEj1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String host = "localhost";
		int puerto = 6000;
		
		try {
			Socket cliente = new Socket(host,puerto);

			DataInputStream inputStream = new DataInputStream(cliente.getInputStream());
			
			//Servidor pide introducir la contraseña
			System.out.println(inputStream.readUTF());
			
			DataOutputStream outputStream = new DataOutputStream(cliente.getOutputStream());
			outputStream.writeUTF(sc.nextLine());
			
			System.out.println(inputStream.readUTF());
			
			cliente.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
