package ejerciciosStreams;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorSuma {
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

			int n1 = flujoEntrada.readInt();
			int n2 = flujoEntrada.readInt();

			System.out.println("Recibiendo del cliente: "+n1+" y "+n2);
			
			int suma = n1 + n2;
			
			OutputStream salida = cliente.getOutputStream();
			DataOutputStream flujoSalida = new DataOutputStream(salida);

			flujoSalida.writeUTF("Suma de los numeros: " + suma);

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
