package ejerciciosComunicacion;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorCuadrado {
	public static void main(String[] args) {
		ServerSocket servidor = null;
		Socket cliente = null;
		int puerto = 62010;
		try {
			servidor = new ServerSocket(puerto);
			System.out.println("Esperando cliente en el puerto: " + puerto);
			cliente = servidor.accept(); // el main se detiene aquí hasta aceptar a un cliente.

			InputStream entrada = cliente.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(entrada);

			int n = (int)ois.readObject();
			System.out.println("Recibe del cliente: " + n);
			
			int cuadrado = n*n;
			System.out.println("Envia al cliente: " + cuadrado);
			
			OutputStream salida = cliente.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(salida);
			
			oos.writeObject(cuadrado);

			cliente.close();
			servidor.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
