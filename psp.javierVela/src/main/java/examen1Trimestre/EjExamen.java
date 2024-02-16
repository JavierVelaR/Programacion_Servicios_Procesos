package examen1Trimestre;

public class EjExamen implements Runnable{

	private String nombre;

    public EjExamen(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        int saltos = 0;
    	
    	switch(nombre) {
    	case "descarga 1":
    		saltos = 1;
    	case "descarga 2":
    		saltos = 2;
    		break;
    	case "descarga 3":
    		saltos = 3;
    		break;
    	}
    	for (int i = 1; i <= 99; i = i + saltos) {
            System.out.println(nombre + ": Descargando " + i + "%");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("La " + nombre + " se ha completado.");
    }

    public static void main(String[] args) {
    	EjExamen d1 = new EjExamen("descarga 1");
    	EjExamen d2 = new EjExamen("descarga 2");
        EjExamen d3 = new EjExamen("descarga 3");

        Thread hilo1 = new Thread(d1);
        Thread hilo2 = new Thread(d2);
        Thread hilo3 = new Thread(d3);

        //Hilo 3 máxima prioridad, hilo 2 mínima prioridad, hilo 1 normal prioridad
        hilo3.setPriority(Thread.MAX_PRIORITY);
        hilo2.setPriority(Thread.MIN_PRIORITY);
        hilo1.setPriority(Thread.NORM_PRIORITY);
        
        hilo1.start();
        hilo2.start();
        hilo3.start();
        
        //Cuando se terminen las ejecuciones, se mostrará que se han completado todas las descargas
        try {
        	hilo1.join();
        	hilo2.join();
        	hilo3.join();
        }catch(InterruptedException e) {
        	e.printStackTrace();
        }
        
        System.out.println("Todas las descargas han finalizado.");
    }


}
