package exemple_banc_synchronized;

import java.io.IOException;

import exemple_banc.CaixerBanc;
import exemple_banc.CompteBancari;

public class Main {

public static void main(String[] args) throws IOException, InterruptedException {
		
		CompteBancari compte = new CompteBancari(0);
		System.out.println("Programa principal ==> Saldo inicial: " +compte.getSaldo());
		
		CaixerBanc obj1 = new CaixerBanc(compte, 1);
		CaixerBanc obj2 = new CaixerBanc(compte, 2);
		
		Thread filOne = new Thread(obj1, "Home");
		Thread filTwo = new Thread(obj2, "Dona");
		
		filOne.start();
		filTwo.start();
		
		filOne.join();
		filTwo.join();
		
		System.out.println("Programa principal ==> Saldo final: " +compte.getSaldo()+ "€");
	}
}
