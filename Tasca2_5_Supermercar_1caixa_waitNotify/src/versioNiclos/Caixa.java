package versioNiclos;
public class Caixa {

	private String nom;
	private boolean disponible;
	
	public Caixa (String nomCaixa) {
		nom = nomCaixa;
		disponible = true;
		System.out.println("Oberta la caixa << " +nom+ " >>" );
	}

	public String getNomCaixa() {
		return nom;
	}


	public synchronized void agafaCompra() {
		try {
		while(!disponible) {
			System.out.println("[" +Thread.currentThread().getName()+ "] Caixa ocupada, esperant...");		
				wait();
		}
		
		this.disponible = false;
		
		System.out.println("[" +this.nom+ "] Llegint la compra de " +Thread.currentThread().getName());
		Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public void cobramentCompra( float importe) {
		System.out.println("[" +this.nom+ "] L'import de la compra de " +Thread.currentThread().getName()+
						" és de " +importe+ ".");
	}
	
	public synchronized void ticketCompra() {
		try {
			System.out.println("[" +this.nom+ "] Donant ticket de la compra a " +Thread.currentThread().getName());
			Thread.sleep(1000);
			this.disponible = true;
			notifyAll();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
