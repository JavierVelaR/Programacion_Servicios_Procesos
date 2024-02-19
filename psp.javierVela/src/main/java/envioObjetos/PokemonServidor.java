package envioObjetos;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class PokemonServidor {

	public static void main(String[] args) {
		Random r = new Random();
		int puerto = 6000;
		ServerSocket servidor;

		try {
			servidor = new ServerSocket(puerto);

			System.out.println("Esperando al cliente en el puerto: " + servidor.getLocalPort());
			Socket cliente = servidor.accept(); // Espera una petición de un cliente, el main se detiene.

			ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());

			Pokemon pokemonOis = (Pokemon) ois.readObject();
			System.out.println("Se ha recibido al Pokemon: " + pokemonOis.getNombre());
			
			ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());
			
			oos.writeObject("El entrenador Gary quiere luchar (Y/N)");;
			
			if(ois.readObject().toString().charAt(0)=='y') {
				if(r.nextInt(0,101)>50) {
					pokemonOis.setNivel(pokemonOis.getNivel()+1);
					System.out.println("Has ganado, tu pokemon ha subido al nivel: " + pokemonOis.getNivel());
					oos.writeObject(pokemonOis);
				}else {
					pokemonOis.setVida(0);
					System.out.println("Tu pokemon "+pokemonOis.getNombre()+" se ha debilitado (Vida: "+pokemonOis.getVida()+")" );
					oos.writeObject(pokemonOis);
				}
				
				
			}else {
				oos.writeObject("Eres un cagao.");
			}
			
			oos.close();
			cliente.close();
			servidor.close();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
