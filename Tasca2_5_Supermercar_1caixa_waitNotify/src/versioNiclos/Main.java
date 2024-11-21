package versioNiclos;

public class Main {
	
	public static void main(String[] args) {
	Caixa caixa = new Caixa("Caixa Única");
	System.out.println("[" +Thread.currentThread().getName()+ "] S'obri la caixa");

	Thread filCl1 = new Thread(new Client(caixa),"Client 1");
	Thread filCl2 = new Thread(new Client(caixa),"Client 2");
	Thread filCl3 = new Thread(new Client(caixa),"Client 3");
	
	filCl1.start();
	filCl2.start();
	filCl3.start();
	
	try {
		filCl1.join();
		filCl2.join();
		filCl3.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	System.out.println("[" +Thread.currentThread().getName()+ "] Tanca la caixa");
	}
}
