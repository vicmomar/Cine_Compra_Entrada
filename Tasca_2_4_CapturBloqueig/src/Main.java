import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException, InterruptedException {
		System.out.println("Programa muntatge INTERBLOQUEIG COTXES RENAULT\n================================");
		//creació dels components
		Component carrosseria = new Component("CARROSSERIA");
		Component motor = new Component("MOTOR");
		Component rodes = new Component("RODES");
		
		//noms a assignar als fils
		String l1 = "lineaA";
		String l2 = "lineaB";
		String l3 = "lineaC";

		//creació dels fils a partir dels objectes Runnable
		Thread fil1 = new Thread(new LineaMuntatge(l1, carrosseria, motor, rodes), l1);
		Thread fil2 = new Thread(new LineaMuntatge(l2, carrosseria, motor, rodes), l2);
		Thread fil3 = new Thread(new LineaMuntatge(l3, carrosseria, motor, rodes), l3);
		
		//iniciem els fils
		fil1.start();
		fil2.start();
		fil3.start();
		
		//espera finals dels fils
		fil1.join();
		fil2.join();
		fil3.join();
		
		System.out.println("[" +Thread.currentThread().getName()+ "] ==> Final del programa principal.");
	}
}

