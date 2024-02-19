package criptografiaHash;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Cliente {
	public static void main(String[] args) {
		String host = "localhost";
		int puerto = 62000;
		MessageDigest md;

		try {
			Socket cliente = new Socket(host, puerto);
			md = MessageDigest.getInstance("SHA-256");

			DataOutputStream outputStream = new DataOutputStream(cliente.getOutputStream());
			
			String mensaje = "El cuco está en el nido.";
			outputStream.writeUTF(mensaje);
			
			byte dataBytes[] = mensaje.getBytes();// TEXTO A BYTES
			md.update(dataBytes);// SE INTRODUCE TEXTO EN BYTES A RESUMIR
			byte passInicialCodificada[] = md.digest();// SE CALCULA EL RESUMEN
			String mensajeFinal = Hexadecimal(passInicialCodificada);

			outputStream.writeUTF(mensajeFinal);
			
			System.out.println("Mensaje en Hexadecimal: " + mensajeFinal);

			DataInputStream inputStream = new DataInputStream(cliente.getInputStream());

			String msgServidor = inputStream.readUTF();
			
			System.out.println(msgServidor);
			
			cliente.close();
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
