package exemple_banc;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		CompteBancari compte = new CompteBancari(0);
		System.out.println("Programa principal ==> Saldo inicial: " +compte.getSaldo());
		
		CaixerBanc obj1 = new CaixerBanc(compte, 1);
		CaixerBanc obj2 = new CaixerBanc(compte, 2);
		
		Thread filOne = new Thread(obj1, "Rita");
		Thread filTwo = new Thread(obj2, "Susi");
		
		filOne.start();
		filTwo.start();
		
		filOne.join();
		filTwo.join();
		
		System.out.println("Programa principal ==> Saldo final: " +compte.getSaldo()+ "€");
	}
}
