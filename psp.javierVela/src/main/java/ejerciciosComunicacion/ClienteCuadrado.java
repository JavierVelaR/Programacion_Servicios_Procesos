package ejerciciosComunicacion;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClienteCuadrado {
	public static void main(String[] args) {
		String host = "localhost";
		int puerto = 62010;
		
		try {
			Socket cliente = new Socket(host,puerto);

			OutputStream salida = cliente.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(salida);

			int num = 15;
			
			oos.writeObject(15);
			System.out.println("Enviando al servidor: " + num);
			
			InputStream entrada = cliente.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(entrada);
			
			String msg = ois.readObject().toString();
			
			System.out.println("Recibiendo del servidor : \n\t" + msg);
			
			cliente.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
