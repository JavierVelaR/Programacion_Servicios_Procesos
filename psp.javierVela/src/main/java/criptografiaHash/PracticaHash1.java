package criptografiaHash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/*
 * SHA-2 es una version mejorada de SHA-1, al tener un valor de hash más grande es más seguro.
 * SHA-2 es más utilizado a partir de la actualización de enero de 2022.
 */
public class PracticaHash1 {

	public static void main(String[] args) {

		MessageDigest md;
		try {
			//md = MessageDigest.getInstance("SHA-1");
			md = MessageDigest.getInstance("MD5");
			String texto = "Se dice Odú porque lo dice Esttik.";
			byte dataBytes[] = texto.getBytes();// TEXTO A BYTES
			md.update(dataBytes);// SE INTRODUCE TEXTO EN BYTES A RESUMIR
			byte resumen[] = md.digest();// SE CALCULA EL RESUMEN
			System.out.println("Mensaje original: " + texto);
			System.out.println("Número de bytes: " + md.getDigestLength());
			System.out.println("Algoritmo: " + md.getAlgorithm());
			System.out.println("Mensaje resumen: " + new String(resumen));
			System.out.println("Mensaje en Hexadecimal: " + Hexadecimal(resumen));
			
		} catch (NoSuchAlgorithmException e) {
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
