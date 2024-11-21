package Exemple2_11_CotxeCompartit_SemaforComptador;

public class MembreFamiliar  implements Runnable {

	int tempsUsCotxe;
	String llocUsCotxe;
	Cotxe cotxe1;
	Cotxe cotxe2;

	
	public MembreFamiliar(String llocNecessitatCotxe, int tempsNecessitatCotxe, Cotxe cotxe1, Cotxe cotxe2) {
		llocUsCotxe = llocNecessitatCotxe;
		tempsUsCotxe = tempsNecessitatCotxe;
		this.cotxe1 = cotxe1;
		this.cotxe2 = cotxe2;

		
		System.out.println("[" +Thread.currentThread().getName()+ "] Creat el membre familiar");
	}
	
	public void run() {
		System.out.println("[" +Thread.currentThread().getName()+ "] Necessita un cotxe per anar a " +llocUsCotxe+ 
				" durant " +tempsUsCotxe/1000+ " secs ...");
		Cotxe cotxe;
		if (cotxe1.cercaCotxe()) {//si el primer cotxe no està ocupat, s'agafa
			cotxe = cotxe1;
		} else {
			cotxe = cotxe2;
		}
		
		cotxe.agafaCotxe(); //entrant en secció crítica
		cotxe.usarCotxe(tempsUsCotxe, llocUsCotxe); //secció crítica
			//cotxe.metodeCanviaEstatClau(); //alliberamwnt condició
		cotxe.deixaCotxe();
	}

}