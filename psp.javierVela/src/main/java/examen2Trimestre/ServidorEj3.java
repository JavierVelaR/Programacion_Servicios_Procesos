package examen2Trimestre;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ServidorEj3 {

	public static void main(String[] args) {
		ServerSocket servidor = null;
		Socket cliente = null;
		int puerto = 6000;

		try {

			servidor = new ServerSocket(puerto);
			System.out.println("Esperando cliente en el puerto: " + puerto);
			cliente = servidor.accept();

			//contraseña almacenada en el servidor
			String passServer = "cenec";
			
			//contraseña almacenada en el servidor cifrada en MD5
			String passCodifServer = cifrarContraseña(passServer);

			DataOutputStream outputStream = new DataOutputStream(cliente.getOutputStream());
			outputStream.writeUTF("Introduzca la contraseña:");

			DataInputStream inputStream = new DataInputStream(cliente.getInputStream());
			
			//contraseña introducida por el cliente
			String passCliente = inputStream.readUTF();
			String passClienteCodif = cifrarContraseña(passCliente);

			if (passClienteCodif.equals(passCodifServer)) {
				outputStream.writeUTF("Acceso permitido.");

				ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());
				
				//cliente envia un haunter
				Pokemon pokemonCliente = (Pokemon) ois.readObject();
				System.out.println("Pokemon recibido del cliente.");

				ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());
				oos.writeObject("¿Quieres evolucionar tu " + pokemonCliente.getNombre() + " a Gengar? (Y/N)");

				String respuesta = "" + ois.readObject();
				System.out.println("Respuesta del cliente: " + respuesta);

				if (respuesta.equalsIgnoreCase("y")) {
					//evoluciona y suben las estadisticas x2
					pokemonCliente.setNombre("Gengar");
					pokemonCliente.setVida(pokemonCliente.getVida() * 2);
					pokemonCliente.setAtaque(pokemonCliente.getAtaque() * 2);
					pokemonCliente.setDefensa(pokemonCliente.getDefensa() * 2);

					oos.writeObject("¡Felicidades, tu Haunter ha evolucionado a Gengar!");
					oos.writeObject(pokemonCliente);

				} else if (respuesta.equalsIgnoreCase("n")) {
					oos.writeObject("Qué lástima.");

				} else {
					oos.writeObject("No has contestado correctamente.");
				}

			} else {
				outputStream.writeUTF("Acceso denegado.");
			}

			cliente.close();
			servidor.close();
		} catch (IOException | NoSuchAlgorithmException | ClassNotFoundException e) {
			e.printStackTrace();
		} 
	}

	// cifra en MD5 el String que se introduzca
	private static String cifrarContraseña(String pass) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");

		byte dataBytesPass[] = pass.getBytes();
		md.update(dataBytesPass);
		byte passCodificada[] = md.digest();
		return hexadecimal(passCodificada);
	}

	// convierte un array de bytes a hexadecimal
	private static String hexadecimal(byte[] resumen) {
		String hex = " ";
		for (int i = 0; i < resumen.length; i++) {
			String h = Integer.toHexString(resumen[i] & 0xFF);
			if (h.length() == 1)
				hex += "0";
			hex += h;
		}
		return hex.toUpperCase();
	}

}
