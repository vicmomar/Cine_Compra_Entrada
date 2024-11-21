package exemple_banc_synchronized2;

import java.io.IOException;

public class CaixerBanc implements Runnable {

	private final CompteBancari compte;
	private int operacioAfter;
	
	public CaixerBanc(CompteBancari compte, int operacio) {
		this.compte = compte;
		this.operacioAfter = operacio;
	}
	
	public void ingresar (float diners) throws IOException, InterruptedException {
		this.compte.ingresarEnCuenta(diners, Thread.currentThread().getName());
	}
	
	public void retirar (float diners) throws IOException, InterruptedException {
		this.compte.sacarDeCuenta(diners, Thread.currentThread().getName());
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			switch (operacioAfter) {
			case 1:
				synchronized (compte) {
				System.out.println("[" +Thread.currentThread().getName()+ "] (1/2) Ingressant 400...");
				ingresar(400);
				System.out.println("[" +Thread.currentThread().getName()+ "] Ara ha de retirar 200 després d'ingressar 400");
				
				System.out.println("[" +Thread.currentThread().getName()+ "] (2/2) Retirant 200...");
				retirar(200);
				}
				break;
			default:
				synchronized(compte) {
				System.out.println("[" +Thread.currentThread().getName()+ "] (1/2) Retirant 600...");
				retirar(600);
				System.out.println("[" +Thread.currentThread().getName()+ "] (2/2) Ingreassant 200...");
				ingresar(200);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
