package Act2_8_pont1carril_waitNotify;

public class Main {

	 public static void main(String[] args) {
		Pont pont = new Pont();
		
		System.out.println("[" +Thread.currentThread().getName()+ "] S'inicia la circul·lació pel Pont");
	
		Thread filCotxe = new Thread(new Vehicle("cotxe","est",pont),"cotxe");
		Thread filCamio = new Thread(new Vehicle("camió","est",pont),"camió");
		Thread filFurgo = new Thread(new Vehicle("furgoneta","oest",pont),"furgoneta");
		Thread filAutobus = new Thread(new Vehicle("autobus","oest",pont),"autobus");
		
		filCotxe.start();
		filCamio.start();
		filFurgo.start();
		filAutobus.start();
	
		try {
			filCotxe.join();
			filCamio.join();
			filFurgo.join();
			filAutobus.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("[" +Thread.currentThread().getName()+ "] Pont tancat. Ha pujat la marea");
	
	}
}
