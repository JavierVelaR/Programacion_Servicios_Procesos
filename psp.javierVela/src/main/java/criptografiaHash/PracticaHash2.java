package criptografiaHash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class PracticaHash2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");
			
			String passInicial = "irene";
			
			byte dataBytes[] = passInicial.getBytes();// TEXTO A BYTES
			md.update(dataBytes);// SE INTRODUCE TEXTO EN BYTES A RESUMIR
			byte passInicialCodificada[] = md.digest();// SE CALCULA EL RESUMEN
			String passFinal = Hexadecimal(passInicialCodificada);
			
			System.out.println("Contraseña inicial en Hexadecimal: " + passFinal);
			
			System.out.println("Introduce la contraseña:");
			String pass = sc.nextLine();
			
			byte dataBytesPass[] = pass.getBytes();// TEXTO A BYTES
			md.update(dataBytesPass);// SE INTRODUCE TEXTO EN BYTES A RESUMIR
			byte passCodificada[] = md.digest();// SE CALCULA EL RESUMEN
			String password = Hexadecimal(passInicialCodificada);
			
			if(passFinal.equals(password)) {
				System.out.println("Contraseña correcta.");
			}else {
				System.err.println("Nunca acertarás la admin_password, a reinstalar Odoo 😈");
			}
			
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
