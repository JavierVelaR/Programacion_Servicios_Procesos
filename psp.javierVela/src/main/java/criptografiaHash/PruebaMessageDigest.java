package criptografiaHash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PruebaMessageDigest {

	public static void main(String[] args) {

		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");
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