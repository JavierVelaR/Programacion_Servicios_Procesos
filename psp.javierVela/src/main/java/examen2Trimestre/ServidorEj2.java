package examen2Trimestre;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorEj2 {

	public static void main(String[] args) {
		ServerSocket servidor = null;
		Socket cliente = null;
		int puerto = 61000;

		try {
			
			servidor = new ServerSocket(puerto);
			System.out.println("Esperando cliente en el puerto: " + puerto);
			cliente = servidor.accept();			
			
			ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());

			//cliente envia un haunter
			Pokemon pokemonCliente = (Pokemon) ois.readObject();
			System.out.println("Pokemon recibido del cliente.");
			
			ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());
			oos.writeObject("¿Quieres evolucionar tu "+pokemonCliente.getNombre()+" a Gengar? (Y/N)");
			
			String respuesta = ""+ois.readObject();
			System.out.println("Respuesta del cliente: " + respuesta);
			
			if(respuesta.equalsIgnoreCase("y")) {
				pokemonCliente.setNombre("Gengar");
				pokemonCliente.setVida(pokemonCliente.getVida()*2);
				pokemonCliente.setAtaque(pokemonCliente.getAtaque()*2);
				pokemonCliente.setDefensa(pokemonCliente.getDefensa()*2);
				
				oos.writeObject("¡Felicidades, tu Haunter ha evolucionado a Gengar!");
				oos.writeObject(pokemonCliente);
				
			}else if(respuesta.equalsIgnoreCase("n")) {
				oos.writeObject("Qué lástima.");
				
			}else {
				oos.writeObject("No has contestado correctamente.");
			}
			
			cliente.close();
			servidor.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
