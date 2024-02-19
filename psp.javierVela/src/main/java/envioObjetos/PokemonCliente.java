package envioObjetos;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class PokemonCliente {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String host = "localhost";
		int puerto = 6000;

		try {
			Socket cliente = new Socket(host, puerto);
			System.out.println("Conectado con Servidor en el puerto: " + cliente.getPort());
			
			ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());

			Pokemon pokemon = new Pokemon("Adelio", 45.0, 12);
			
			oos.writeObject(pokemon);
			
			System.out.println("Se ha enviado al servidor el Pokemon: " + pokemon.getNombre() +
					"\n\tVida: " + pokemon.getVida() + "\n\tNivel: " + pokemon.getNivel());
			
			ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());
			
			System.out.println(ois.readObject());
			
			char resp = sc.nextLine().charAt(0);
			
			if(resp=='y') {
				
				oos.writeObject('y');
				
			}else {
				oos.writeObject('n');
			}
			
			pokemon = (Pokemon) ois.readObject();
			
			System.out.println("Estado actual del pokemon:\n" + pokemon);
			
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
