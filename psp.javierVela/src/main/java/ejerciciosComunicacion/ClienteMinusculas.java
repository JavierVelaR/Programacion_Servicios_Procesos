package ejerciciosComunicacion;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class ClienteMinusculas {
	public static void main(String[] args) {
		String host = "localhost";
		int puerto = 62010;
		
		try {
			Socket cliente = new Socket(host,puerto);

			OutputStream salida = cliente.getOutputStream();
			DataOutputStream flujoSalida = new DataOutputStream(salida);

			flujoSalida.writeUTF("TOMA este MENSAJE");
			
			DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());

			System.out.println("Recibiendo del servidor : \n\t" + flujoEntrada.readUTF());
			
			salida.close();
			flujoEntrada.close();
			flujoSalida.close();
			cliente.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
