package Act2_8_pont1carril_waitNotify;

public class Vehicle implements Runnable {
	
	private Pont pont;
    private String direccio;
    private String nom;

    public Vehicle(String nom, String direccio, Pont pont) {
        this.nom = nom;
        this.direccio = direccio;
        this.pont = pont;
    }

    public String getNom() {
    	return nom;
    }
    @Override
    public void run() {
        try {
            pont.arribar(direccio, nom);
            // Simulació de temps que tarda en travessar el pont
            Thread.sleep(2000);
            pont.sortir(direccio, nom);
        } catch (InterruptedException e) {
            System.out.println("[main] Vehicle cotxe" + nom + " ha estat interromput.");
        }
    }
	}
	
	

