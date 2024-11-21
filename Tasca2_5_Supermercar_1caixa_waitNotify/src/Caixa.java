
public class Caixa {

	private String nomCaixa;
	//private float importe;
	private boolean ocupada;
	
	public Caixa (String nomCaixa) {
		this.nomCaixa = nomCaixa;
		this.ocupada = false;
	}

	public String getNomCaixa() {
		return nomCaixa;
	}


	public synchronized void agafaCompra(String nomFil) throws InterruptedException {
		while(ocupada) {
			System.out.println("[" +nomCaixa+ "] ocupada, esperant...");
			wait();
		}
		System.out.println("[" +nomCaixa+ "] Llegint la compra de " +nomFil);
		ocupada = true;
	}
	
	public synchronized void cobramentCompra(String nomFil, float importe) {
		System.out.println("[" +nomCaixa+ "] Import de la compra " +nomFil+
						" és de " +importe+ ".");
	}
	
	public synchronized void ticketCompra(String nomFil) {
		System.out.println("[" +nomCaixa+ "] Donant ticket de la compra a " +nomFil);
		ocupada = false;
		notifyAll();
	}
}
