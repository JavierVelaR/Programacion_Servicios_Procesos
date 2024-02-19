package ejerciciosStreams;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class ClienteSuma {
	public static void main(String[] args) {
		String host = "localhost";
		int puerto = 62001;
		
		try {
			Socket cliente = new Socket(host,puerto);

			OutputStream salida = cliente.getOutputStream();
			DataOutputStream flujoSalida = new DataOutputStream(salida);

			int num1 = 55;
			int num2 = 12;
			
			flujoSalida.writeInt(num1);
			flujoSalida.writeInt(num2);
			System.out.println("Enviado al servidor los numeros.");
			
			DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());

			String msgServidor = flujoEntrada.readUTF();
			
			System.out.println("Recibiendo del servidor : \n\t" + msgServidor);
			
			flujoEntrada.close();
			flujoSalida.close();
			cliente.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
