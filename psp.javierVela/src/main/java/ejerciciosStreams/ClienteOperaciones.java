package ejerciciosStreams;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteOperaciones {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String host = "localhost";
		int puerto = 62001;
		
		System.out.println("Indica la operacion:");
		String operacion = sc.nextLine();
		
		System.out.println("Operando 1:");
		int num1 = Integer.parseInt(sc.nextLine());
		
		System.out.println("Operando 2:");
		int num2 = Integer.parseInt(sc.nextLine());
		
		try {
			Socket cliente = new Socket(host,puerto);

			OutputStream salida = cliente.getOutputStream();
			DataOutputStream flujoSalida = new DataOutputStream(salida);
			
			flujoSalida.writeUTF(operacion);
			flujoSalida.writeInt(num1);
			flujoSalida.writeInt(num2);
			System.out.println("Enviado al servidor la operacion y los numeros.");
			
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
