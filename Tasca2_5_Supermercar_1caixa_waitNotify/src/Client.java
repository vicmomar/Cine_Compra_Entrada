
public class Client extends Thread {

	private String nomFil;
	Caixa caixa;
	float importCompra;
	
	public Client(String nomFil, Caixa caixa) {
		this.nomFil = nomFil;
		this.caixa = caixa;
		this.importCompra= (float) (5+Math.random() * 5); //núm aleatori entre 5 i 10
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			//System.out.println("[" +Thread.currentThread()+ "] ha fet la recollida de productes.");
			System.out.println("[" +nomFil+ "] ha fet la recollida de productes.");
			Thread.sleep(2000);
			//System.out.println("[" +Thread.currentThread()+ "] es dirigeix cap a " +caixa.getNomCaixa());
			System.out.println("[" +nomFil+ "] anant a la caixa.");
			
			caixa.agafaCompra(nomFil);
			caixa.cobramentCompra(nomFil,importCompra);
			caixa.ticketCompra(nomFil);
			System.out.println("[" +nomFil+ "] recollint la compra en " +caixa.getNomCaixa());
			System.out.println("[" +nomFil+ "] ixint del supermercat.");

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	
}
