package criptografiaHash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PracticaHash3 {

	public static void main(String[] args) {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");
			
			String mensaje = "El cuco está en el nido.";
			
			byte dataBytes[] = mensaje.getBytes();// TEXTO A BYTES
			md.update(dataBytes);// SE INTRODUCE TEXTO EN BYTES A RESUMIR
			byte passInicialCodificada[] = md.digest();// SE CALCULA EL RESUMEN
			String mensajeFinal = Hexadecimal(passInicialCodificada);
			
			System.out.println("Mensaje en Hexadecimal: " + mensajeFinal);
			
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
