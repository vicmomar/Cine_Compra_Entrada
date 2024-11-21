package Exemple2_11_CotxeCompartit_SemaforComptador;

public class Cotxe {
	//atributs
			private String nom;
			private boolean disponible;
			private final SemaforComptador semafor;

			//constructor
			public Cotxe(String nomCotxe, SemaforComptador semafor) {
				nom = nomCotxe;
				disponible = true;
				this.semafor = semafor;
			}
			
			
			//getter & setter
			public String getNom() {
				return nom;
			}


			public void setDisponible(boolean disponible) {
				this.disponible = disponible;
			}


			//mètodes
			public boolean cercaCotxe() {
				semafor.metodeWait(); //entrant en SECCIÓ CRÍTICA amb protecció
				//*********** SECCIÓ CRÍTICA ****************
				return disponible;
			}
			
			public void agafaCotxe() {
				//fer temps per a modificar variable booleana
				for (int i=0; i<10000; i++) {
					// No fer res
				}
				setDisponible(false);
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
				setDisponible(true);
				// SECCIÓ CRÍTICA
				semafor.metodeWakeup(); //alliberar la condició
			}
}
