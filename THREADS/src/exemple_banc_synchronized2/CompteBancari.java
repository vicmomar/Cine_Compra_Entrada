package exemple_banc_synchronized2;

import java.io.IOException;

public class CompteBancari {

		private float saldo ;
			
			public CompteBancari (float saldoInicial) throws IOException {
				this.setSaldo(saldoInicial);
			}

			public void setSaldo(float saldo) {
				// TODO Auto-generated method stub
				this.saldo = saldo;
				
			}
			
			public float getSaldo() {
				return saldo;
			}
			
			public synchronized  void ingresarEnCuenta (float diners, String nomFil)throws IOException, InterruptedException {
				float aux;
				
				System.out.println("[" +nomFil+ "] Ingressant " +diners+ "€...");
				aux = getSaldo();
				System.out.println("[" +nomFil+ "]" +aux+ " = getSaldo() + " +diners+ "€");
				aux = aux+diners;
				System.out.println("[" +nomFil+ "] setSaldo(" +aux+ ")");
				setSaldo(aux);
			}
			
			public synchronized void sacarDeCuenta (float diners, String nomFil)throws IOException, InterruptedException {
				float aux;
				
				System.out.println("[" +nomFil+ "] Traguent " +diners+ "€...");
				aux = getSaldo();
				System.out.println("[" +nomFil+ "]" +aux+ " = getSaldo() - " +diners+ "€");
				aux = aux-diners;
				System.out.println("[" +nomFil+ "] setSaldo(" +aux+ ")");
				setSaldo(aux);
			}
}
