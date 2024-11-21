package Act2_8_pont1carril_waitNotify;

public class Pont {

	private boolean ocupat; // Indica si el pont està ocupat per algun cotxe

    
	public boolean camiLLiure() {
		/*if (ocupat) {
			return true;
		} else
			return false;*/
		return !ocupat;
	}
	
	public void entraPont() {
		System.out.println("[" +Thread.currentThread().getName()+ "] Passant pel pont...");
		ocupat = true;
	}
	
	public void pontTancat() {
		System.out.println("[" +Thread.currentThread().getName()+ "] Pont OCUPAT...");
		//ocupat = true;
	}
	
	public synchronized void arribar(String direccio, String nom) throws InterruptedException {
        // El cotxe arriba al pont
        System.out.println("[" +Thread.currentThread().getName()+ "] arriba al pont direcció " +direccio);
        
        // Espera mentre el pont estigui ocupat
        while (!camiLLiure()) {
        	//pontTancat();
            System.out.println("[" +Thread.currentThread().getName()+ "] esperant per entrar al Pont direcció " + direccio);
            wait();
        }
        // Quan el pont estigui lliure, el cotxe l'ocupa
        entraPont();
        //pontTancat();
    }

    public synchronized void sortir(String direccio, String nom) {
        // Allibera el pont quan el cotxe surt
    	//pontTancat();
        ocupat = false;
        System.out.println("[" +Thread.currentThread().getName()+ "]  surt del pont cap a " + direccio);
        // Notifica els altres fils que el pont està lliure
        notifyAll();
    }
}
