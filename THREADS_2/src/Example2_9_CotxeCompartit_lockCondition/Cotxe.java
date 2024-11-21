package Example2_9_CotxeCompartit_lockCondition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Cotxe {
	//atributs
	private String nom;
	private boolean clau;
	private Lock cadenat;
	private Condition disponible;

	//constructor
	public Cotxe(String nom) {
		this.nom = nom;
		clau = true;
		cadenat = new ReentrantLock();
		disponible = cadenat.newCondition();
	}
	
	
	//getter & setter
	public String getNom() {
		return nom;
	}


	public void setClau(boolean clau) {
		this.clau = clau;
	}


	//mètodes
	public boolean isCotxeDisponible() {
		if (clau) {
			return true;
		} else {
			return false;
		}
	}
	
	public void agafaCotxe() {
		//fer temps per a modificar variable booleana
		for (int i=0; i<10000; i++) {
			// No fer res
		}
		this.clau = false;
		System.out.println("[" +Thread.currentThread().getName()+ "] Agafant cotxe " +this.nom+ "...*****");
	}
	
	public void usarCotxe(int tempsUsCotxe, String llocUsCotxe) {
		try {
			System.out.println("[" +Thread.currentThread().getName()+ "] Usant el cotxe " +this.nom+ " per anar a " +llocUsCotxe+ 
					" durant " +tempsUsCotxe/1000+ " secs ...");
			Thread.sleep(tempsUsCotxe);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void deixaCotxe() {
		System.out.println("[" +Thread.currentThread().getName()+ "] Deixant cotxe " +this.nom+ "...");
		this.clau = true;
	}
	
	public void metodeWait() throws InterruptedException {
		try {
			cadenat.lock();
			while(!isCotxeDisponible()) {
				System.out.println("[" +Thread.currentThread().getName()+ "] metodeWait() ==> El cotxe no està disponible... Toca esperar");
				disponible.await();
			}
			agafaCotxe();
			cadenat.unlock();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void metodeCanviaEstatClau() throws InterruptedException{
		cadenat.lock();
		deixaCotxe();
		System.out.println("[" +Thread.currentThread().getName()+ "] metodeCanviaEstatClau() ==> El cotxe ja està disponible... Despertem fils");
		disponible.signalAll();
		cadenat.unlock();
	}
}
