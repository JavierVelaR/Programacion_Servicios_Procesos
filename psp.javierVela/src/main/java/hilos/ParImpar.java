package hilos;

public class ParImpar extends Thread{

	int inicio;
    int fin;

    ParImpar(int inicio, int fin) {
        this.inicio = inicio;
        this.fin = fin;
    }
    
    public void run() {
        for (int i = inicio; i <= fin; i += 2) {
            if (i%2==0) {
                System.out.println("El número es par " + i);
            }else {
                System.out.println("El número es impar " + i);
            }
        }
    }

    public static void main(String[] args) {
        ParImpar hiloPar = new ParImpar(0, 20);
        ParImpar hiloImpar = new ParImpar(-1,20);

        hiloPar.start();
        hiloImpar.start();
    }
}
