package Exemple2_11_CotxeCompartit_SemaforComptador;

public class SemaforComptador {

	//atributs
	private int numRecursosDisponibles;
	//Constructor
	public SemaforComptador(int numAccessos) {
		this.numRecursosDisponibles = numAccessos;
		System.out.println("Creat el SEMÀFOR COMPTADOR amb " +numAccessos+ " permesos");
	}
	
	public synchronized void metodeWait() {
		while (numRecursosDisponibles == 0) {//mentre no condició 
			try {
				System.out.println("SEMAFOR bloqueja execució -> Espera zZzZzZz...");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		numRecursosDisponibles--; //canvia condició, bloquejat el fil executor
	}
	
	public synchronized void metodeWakeup() {
		numRecursosDisponibles++;//canvia condició, desbloquejat fil executor
		System.out.println("SEMAFOR desperta execució -> desperta fils...");
		notifyAll();  //notify() també es pot utilitzar
	}
}
