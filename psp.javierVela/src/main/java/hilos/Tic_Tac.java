package hilos;

public class Tic_Tac extends Thread {

	String nombre;
	
	public Tic_Tac(String nombre) {
		this.nombre = nombre;
	}
	
	public void run() {
		while(true) {
			if(this.nombre.equals("Tic")) {
				System.out.println("Hola, soy el hilo Tic");
			}else {
				System.out.println("Hola, soy el hilo Tac");
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Tic_Tac tic = new Tic_Tac("Tic");
		Tic_Tac tac = new Tic_Tac("Tac");
		tic.start();
		tac.start();
	}

}
