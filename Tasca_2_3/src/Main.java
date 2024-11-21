
public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		QuadreCites cites = new QuadreCites();
		Infermera infermera1 = new Infermera("Infermera1", cites);
		Infermera infermera2 = new Infermera("Infermera2", cites);
		//Crear 10 pacients i assignar un nom
		Thread[] pacients = new Thread[10];
		for (int i=0; i<pacients.length; i++) {
			if (i%2 == 0) {
				pacients[i] = new Thread(new Pacient(i+1,infermera2), "Pacient" +String.valueOf(i+1));
			} else {
				pacients[i] = new Thread(new Pacient(i+1,infermera1), "Pacient" +String.valueOf(i+1));
			}
		}
		//inicem el conjunt de pacients
		for (int i=0; i<pacients.length; i++) {
			pacients[i].start();
		}
		//esperem finalització del conjunt de pacients
		for (int i=0; i<pacients.length; i++) {
			pacients[i].join();
		}
		infermera1.mostraTornsQuadre();
	}
}
