package ejerciciosStreams;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorMonedas {

	public static void main(String[] args) {
		ServerSocket servidor = null;
		Socket cliente = null;
		int puerto = 62001;
		try {
			servidor = new ServerSocket(puerto);
			System.out.println("Esperando cliente en el puerto: " + puerto);
			cliente = servidor.accept(); // el main se detiene aquí hasta aceptar a un cliente.

			InputStream entrada = cliente.getInputStream();
			DataInputStream flujoEntrada = new DataInputStream(entrada);

			String msg = flujoEntrada.readUTF();
			
			System.out.println("Recibiendo del cliente: \n\t"+ msg);
			
			double euros = Double.parseDouble(msg);
			double dolares = euros * 1.14;
			double libras = euros * 0.87;
			
			OutputStream salida = cliente.getOutputStream();
			DataOutputStream flujoSalida = new DataOutputStream(salida);

			flujoSalida.writeUTF("Cantidad en euros: " + euros + "\n" + "Cantidad en dólares: " + dolares + "\n"
					+ "Cantidad en libras: " + libras);

			entrada.close();
			flujoEntrada.close();
			salida.close();
			flujoSalida.close();
			cliente.close();
			servidor.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
