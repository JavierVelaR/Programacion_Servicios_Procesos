package examen2Trimestre;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteEj2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String host = "localhost";
		int puerto = 61000;

		try {
			Socket cliente = new Socket(host, puerto);
			System.out.println("Conectado con Servidor en el puerto: " + cliente.getPort());
			
			ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());

			Pokemon pokemon = new Pokemon("Haunter", 80, 20, 30);
			
			oos.writeObject(pokemon);
			System.out.println("Pokemon enviado a servidor.");
			
			ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());
			//Servidor pregunta si quiere evolucionar
			System.out.println(ois.readObject());
			
			String respuesta = ""+sc.nextLine().charAt(0);
			
			oos.writeObject(respuesta);
			System.out.println("Respuesta enviada al servidor");
			
			System.out.println(ois.readObject());
			
			if(respuesta.equalsIgnoreCase("y")) {
				Pokemon gengar = (Pokemon) ois.readObject();
				
				System.out.println("Estadísticas del pokemon:\n" + gengar);
			}
			
			ois.close();
			oos.close();
			cliente.close();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
}
