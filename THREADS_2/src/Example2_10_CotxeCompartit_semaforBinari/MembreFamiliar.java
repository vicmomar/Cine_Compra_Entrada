package Example2_10_CotxeCompartit_semaforBinari;

public class MembreFamiliar  implements Runnable {

	int tempsUsCotxe;
	String llocUsCotxe;
	Cotxe cotxe;
	
	public MembreFamiliar(String llocNecessitatCotxe, int tempsNecessitatCotxe, Cotxe cotxe) {
		llocUsCotxe = llocNecessitatCotxe;
		tempsUsCotxe = tempsNecessitatCotxe;
		this.cotxe = cotxe;
		
		System.out.println("[" +Thread.currentThread().getName()+ "] Creat el membre familiar");
	}
	
	public void run() {
		System.out.println("[" +Thread.currentThread().getName()+ "] Necessita el cotxe " +cotxe.getNom()+ " per anar a " +llocUsCotxe+ 
				" durant " +tempsUsCotxe/1000+ " secs ...");
		
		//if (cotxe.isCotxeDisponible()) {
			cotxe.agafaCotxe();
			//cotxe.metodeWait(); //entrant en secció crítica
			cotxe.usarCotxe(tempsUsCotxe, llocUsCotxe); //secció crítica
			//cotxe.metodeCanviaEstatClau(); //alliberamwnt condició
			cotxe.deixaCotxe();
		/*} else {
			System.out.println("[" +Thread.currentThread().getName()+ "] El cotxe no està disponible, espera");
		}*/
	}

}
