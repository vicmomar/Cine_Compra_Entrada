
public class Main {

	public static void main(String[] args) {
		
		Caixa caixa = new Caixa("Caixa Única");
		
		Client cl1 = new Client("Client 1", caixa);
		Client cl2 = new Client("Client 2", caixa);
		Client cl3 = new Client("Client 3", caixa);
		
		System.out.println("S'obri la caixa");

		cl1.start();
		cl2.start();
		cl3.start();
		
		try {
			cl1.join();
			cl2.join();
			cl3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Tanca la caixa");
	}
}
