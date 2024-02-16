package procesos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Ej6_Fecha {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa la nueva fecha (en formato MM-dd-yyyy):");
        String fecha = scanner.nextLine();

        ProcessBuilder pb = new ProcessBuilder("cmd", "/C", "date");
        try {
            Process p = pb.start();
            cambiarFecha(p, fecha);
            p.waitFor();
            mostrarResultadosDir(p);
            mostrarErroresDir(p);
        } catch (IOException | InterruptedException e) {
            System.out.println("Error al lanzar el comando cmd: " + e.getMessage());
            System.out.println("El cliente no dispone de los privilegios requeridos.");
        }
        scanner.close();
    }

    private static void cambiarFecha(Process p, String fecha) {
        try (OutputStream os = p.getOutputStream();
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os))) {
            bw.write(fecha);
        } catch (IOException e) {
            System.out.println("Error al escribir en el proceso: " + e.getMessage());
        }
    }

    private static void mostrarErroresDir(Process p) {
        try (InputStream is = p.getErrorStream();
             InputStreamReader ir = new InputStreamReader(is, "UTF-8");
             BufferedReader br = new BufferedReader(ir)) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al mostrar errores del proceso hijo: " + e.getMessage());
        }
    }

    private static void mostrarResultadosDir(Process p) {
        try (InputStream is = p.getInputStream();
             InputStreamReader ir = new InputStreamReader(is, "UTF-8");
             BufferedReader br = new BufferedReader(ir)) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al mostrar resultados del proceso hijo: " + e.getMessage());
        }

	}

}
