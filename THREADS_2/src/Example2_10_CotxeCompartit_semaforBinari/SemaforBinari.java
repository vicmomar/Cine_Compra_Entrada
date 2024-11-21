package Example2_10_CotxeCompartit_semaforBinari;

public class SemaforBinari {
	//atributs
		private boolean condicio;
		
		//constructor
		public SemaforBinari() {
			System.out.println("[" +Thread.currentThread().getName()+ "] Creat el SEMÀFOR BINARI.");
			condicio = true;
		
		}
		
		public synchronized void metodeWait() {
			while (!condicio) {
				try {
					System.out.println("SEMAFOR bloqueja execucuió");
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			condicio = false;
		}
		
		public synchronized void metodeWakeup() {
			condicio = true;
			System.out.println("SEMAFOR desperta execució.");
			notify();
		}
}
