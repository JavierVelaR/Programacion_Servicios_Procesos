package hilos;

public class EjemplosRunnable implements Runnable {

	private String nombre;
	
	public EjemplosRunnable(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public void run() {
		for(byte i=0; i<=10; i++) {
			System.out.println("Hola, soy el " + nombre + " y esta es la vez " + i + " que me ejecuto.");
		}
	}

	public static void main(String[] args) {
		EjemplosRunnable hilo1 = new EjemplosRunnable("Hilo 1");
		EjemplosRunnable hilo2 = new EjemplosRunnable("Hilo 2");
		EjemplosRunnable hilo3 = new EjemplosRunnable("Hilo 3");
		
		new Thread(hilo1).start();
		new Thread(hilo2).start();
		new Thread(hilo3).start();

	}

}
