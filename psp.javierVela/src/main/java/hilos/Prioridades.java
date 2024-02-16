package hilos;

public class Prioridades extends Thread{

	private int ejecuciones;
	
	private String nombre;
	
	public Prioridades(String nombre) {
		this.nombre = nombre;
	}
	
	public void run() {
		
		int tiempoActual = (int) System.currentTimeMillis();
		int tiempoFinal = tiempoActual+3000;
		
		while(tiempoActual < tiempoFinal) {
			tiempoActual = (int) System.currentTimeMillis();
			ejecuciones++;
		}
				
		System.out.println("Soy el hilo " + nombre + " y me he ejecutado " + ejecuciones + " veces.");
	}

	public static void main(String[] args) {
		Prioridades h1 = new Prioridades("Hilo 1");
		Prioridades h2 = new Prioridades("Hilo 2");
		Prioridades h3 = new Prioridades("Hilo 3");
		h1.setPriority(MAX_PRIORITY);
		h2.setPriority(NORM_PRIORITY);
		h3.setPriority(MIN_PRIORITY);
		h1.start();
		h2.start();
		h3.start();
		
		try {
			Thread.sleep(3500);
			System.out.println();
			
			if(h1.ejecuciones > h2.ejecuciones && h1.ejecuciones > h3.ejecuciones) {
				System.out.println("El hilo 1 se ha ejecutado más veces, con un total de " + h1.ejecuciones + " veces.");
			}else if(h2.ejecuciones > h1.ejecuciones && h2.ejecuciones > h3.ejecuciones) {
				System.out.println("El hilo 2 se ha ejecutado más veces, con un total de " + h2.ejecuciones + " veces.");
			}else {
				System.out.println("El hilo 3 se ha ejecutado más veces, con un total de " + h3.ejecuciones + " veces.");
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
