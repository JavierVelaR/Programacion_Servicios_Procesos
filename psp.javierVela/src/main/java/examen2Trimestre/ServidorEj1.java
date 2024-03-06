package examen2Trimestre;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ServidorEj1 {

	public static void main(String[] args) {
		ServerSocket servidor = null;
		Socket cliente = null;
		int puerto = 6000;

		try {

			servidor = new ServerSocket(puerto);
			System.out.println("Esperando cliente en el puerto: " + puerto);
			cliente = servidor.accept();

			String passServer = "cenec";
			String passCodifServer = cifrarContraseña(passServer);

			System.out.println("Contraseña en Hexadecimal: " + passCodifServer);

			DataOutputStream outputStream = new DataOutputStream(cliente.getOutputStream());
			outputStream.writeUTF("Introduzca la contraseña:");

			DataInputStream inputStream = new DataInputStream(cliente.getInputStream());
			String passCliente = inputStream.readUTF();

			String passClienteCodif = cifrarContraseña(passCliente);

			if (passClienteCodif.equals(passCodifServer)) {
				outputStream.writeUTF("Acceso permitido.");
			} else {
				outputStream.writeUTF("Acceso denegado.");
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
	
	//cifra en MD5 el String que se introduzca
	private static String cifrarContraseña(String pass) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");

		byte dataBytesPass[] = pass.getBytes();
		md.update(dataBytesPass);
		byte passCodificada[] = md.digest();
		return Hexadecimal(passCodificada);
	}
	
	//convierte un array de bytes a hexadecimal
	private static String Hexadecimal(byte[] resumen) {
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
