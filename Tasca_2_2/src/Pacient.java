
public class Pacient implements Runnable{

	int nPacient;
	Infermera infermera;
	
	public Pacient (int nPacient, Infermera inf) {
		this.nPacient = nPacient;
		this.infermera = inf;
	}
	
	public void run() {
		try {
			entrantAmbulatori();
			Thread.sleep(1000);
			solicitantCitaPrevia();
			Thread.sleep(1000);
			eixintAmbulatori();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void eixintAmbulatori() {
		// TODO Auto-generated method stub
		System.out.println("[" +Thread.currentThread().getName()+ "] Ixint de l'Ambulatòri");
	}

	public void solicitantCitaPrevia() {
		// TODO Auto-generated method stub
		System.out.println("[" +Thread.currentThread().getName()+ "] Sol·licitzant CITA PREVIA a l'infermera.");
		if (!infermera.solicitaCitaPrevia()) {
			System.out.println("[" +Thread.currentThread().getName()+ "] Indicant que en el quadre de CITES queden ...");
		}
	}

	public void entrantAmbulatori() {
		// TODO Auto-generated method stub
		System.out.println("[" +Thread.currentThread().getName()+ "] Entrant a l'Ambulatòri");
	}
	
	
}
