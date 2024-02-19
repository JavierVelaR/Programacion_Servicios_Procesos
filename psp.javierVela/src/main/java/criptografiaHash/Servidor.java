package criptografiaHash;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Servidor {

	public static void main(String[] args) {
		ServerSocket servidor = null;
		Socket cliente = null;
		int puerto = 62000;
		MessageDigest md;

		try {
			servidor = new ServerSocket(puerto);
			System.out.println("Esperando cliente en el puerto: " + puerto);
			cliente = servidor.accept(); // el main se detiene aquí hasta aceptar a un cliente.

			String mensaje = "El cuco está en el nido.";
			
			md = MessageDigest.getInstance("SHA-256");
			byte dataBytes[] = mensaje.getBytes();// TEXTO A BYTES
			md.update(dataBytes);// SE INTRODUCE TEXTO EN BYTES A RESUMIR
			byte passInicialCodificada[] = md.digest();// SE CALCULA EL RESUMEN
			String mensajeFinal = Hexadecimal(passInicialCodificada);

			System.out.println("Mensaje en Hexadecimal: " + mensajeFinal);

			DataInputStream inputStream = new DataInputStream(cliente.getInputStream());
			String msgCliente = inputStream.readUTF();
			
			byte dataBytesMsg[] = msgCliente.getBytes();// TEXTO A BYTES
			md.update(dataBytesMsg);// SE INTRODUCE TEXTO EN BYTES A RESUMIR
			byte msgClienteCodificado[] = md.digest();// SE CALCULA EL RESUMEN
			String msgClienteCodif = Hexadecimal(msgClienteCodificado);
			
			DataOutputStream outputStream = new DataOutputStream(cliente.getOutputStream());
			
			if(msgClienteCodif.equals(mensajeFinal)) {
				outputStream.writeUTF("Mensaje recibido.");
			}else {
				outputStream.writeUTF("El mensaje ha sido interceptado");
			}
			
			cliente.close();
			servidor.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// CONVIERTE UN ARRAY DE BYTES A HEXADECIMAL
	static String Hexadecimal(byte[] resumen) {
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
