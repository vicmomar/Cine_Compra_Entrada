package CINE_v21_Compra1EntradaThreads_Victor_Morant;

public class FilCompraEntrada implements Runnable{

	private Cine cine;
	private String nom;
	private AccesTaquilla accesTaquilla;
	
	public FilCompraEntrada(Cine cine, AccesTaquilla accesTaquilla) {
		this.cine = cine;
		this.accesTaquilla = accesTaquilla;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		accesTaquilla.arribaTaquilla();
		System.out.println("[" +Thread.currentThread().getName()+"] iniciant compra de la entrada");
		cine.compraEntradaPelicula();
		accesTaquilla.laCompra();
		System.out.println("[" +Thread.currentThread().getName()+"]compra de la entrada finalitzada.");
		accesTaquilla.acabaCompra();
		
	}

}
