package Act2_9_potCarrilLockCondition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Pont {
	private boolean ocupat=false; // Indica si el pont està ocupat per algun cotxe
	private Lock lock = new ReentrantLock();
	private Condition pontLliure = lock.newCondition();
	
	public void entraPont() {
		ocupat = true;
		System.out.println("[" +Thread.currentThread().getName()+ "] Entra al pont...");
		//System.out.println("[" +Thread.currentThread().getName()+ "] circul·lant pel pont...");

	}
	
	/*public void pontTancat() {
		System.out.println("[" +Thread.currentThread().getName()+ "] ...");
		//ocupat = true;
	}*/
	
	public void arribar(String direccio, String nom) throws InterruptedException {
		try {
			lock.lock();
			// El cotxe arriba al pont
			System.out.println("[" +Thread.currentThread().getName()+ "] arriba al pont direcció " +direccio);
        
	        // Espera mentre el pont estigui ocupat
	        while (ocupat) {
	        	//pontTancat();
	            System.out.println("[" +Thread.currentThread().getName()+ "] Pont OCUPAT, esperant per entrar al Pont direcció " + direccio);
	            pontLliure.await();
	        }
	        // Quan el pont estigui lliure, el cotxe l'ocupa
	        //entraPont();
	        ocupat = true;
			System.out.println("[" +Thread.currentThread().getName()+ "] Entra al pont...");
		} finally {
	        lock.unlock();
		}
    }

    public void sortir(String direccio, String nom) {
    	try {
    	lock.lock();
        // Allibera el pont quan el cotxe surt
    	//pontTancat();
        ocupat = false;
        System.out.println("[" +Thread.currentThread().getName()+ "]  surt del pont cap a " + direccio);
        // Notifica els altres fils que el pont està lliure
        pontLliure.signalAll();
    	} finally {
        	lock.unlock();
		}
    }
}
