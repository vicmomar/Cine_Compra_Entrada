package exemple_banc;

import java.io.IOException;

public class CaixerBanc implements Runnable {

	private CompteBancari compte;
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
				System.out.println("[" +Thread.currentThread().getName()+ "] Ingressant 400€");
				ingresar(400);
				break;
			default:
				System.out.println("[" +Thread.currentThread().getName()+ "] Retirant 600€");
				retirar(600);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
