
public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		Infermera infermera = new Infermera();
		//Crear 10 pacients i assignar un nom
		Thread[] pacients = new Thread[9];
		for (int i=0; i<pacients.length; i++) {
			pacients[i] = new Thread(new Pacient(i+1,infermera), "Pacient" +String.valueOf(i+1));
		}
		//inicem el conjunt de pacients
		for (int i=0; i<pacients.length; i++) {
			pacients[i].start();
		}
		//esperem finalització del conjunt de pacients
		for (int i=0; i<pacients.length; i++) {
			pacients[i].join();
		}
		infermera.mostraTornsQuadre();
	}
}
