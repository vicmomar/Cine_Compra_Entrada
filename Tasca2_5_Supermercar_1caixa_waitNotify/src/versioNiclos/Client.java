package versioNiclos;

import java.util.Random;

public class Client implements Runnable {
	Caixa caixa;
	float importCompra;
	
	public Client( Caixa caixa) {
		this.caixa = caixa;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		compraProductes();
		System.out.println("[" +Thread.currentThread().getName()+ "] va a la caixa " +caixa.getNomCaixa());
		System.out.println("[" +Thread.currentThread().getName()+ "] fent cua en " +caixa.getNomCaixa());
		caixa.agafaCompra();

		//***************SECCIO CRITICA*************************
		caixa.cobramentCompra(importCompra);
		System.out.println("[" +Thread.currentThread().getName()+ "] Pagant la compra de " +String.format("%.2f", importCompra)+ "€ en " +caixa.getNomCaixa());
		//simulant el pagament
		for (int i=0; i<10000; i++) {
			//passar el temps sense fer res
		}
		//*************** FI SECCIO CRITICA*************************

		caixa.ticketCompra();
		System.out.println("[" +Thread.currentThread().getName()+ "] recollint la compra en " +caixa.getNomCaixa());
		System.out.println("[" +Thread.currentThread().getName()+ "] Eixint del supermercat.");

	}
	
	public void compraProductes() {
		float minim = 5F;
		float maxim = 10F;
		float generateFloat = 0F;
		//generar una compra de 5 productes d'un preu entre 5 i 10 €
		for (int i=0; i<5; i++) {
			generateFloat += minim + new Random().nextFloat() * (maxim-minim);
		}
		System.out.println("[" +Thread.currentThread().getName()+ "] Ha fet la recollida dels  productes");
		importCompra = generateFloat;
	}
}
