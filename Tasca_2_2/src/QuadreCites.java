
public class QuadreCites {

	public String hores[];
	public String torns[];
	
	//consructor
	public QuadreCites() {
		hores = new String[8];
		torns = new String[8];
		

		System.out.println("[" +Thread.currentThread().getName()+ "] Inicialitzant el quadre de CITA PREVIA");
		int hora = 10, k = 0;
		int min;
		//inicialitzar vector de hores
		for (int i=0; i<2; i++) {//cada hora
			min = 0;
			for (int j=0; j<4; j++) {//cada 15'
				hores[k++] = String.valueOf(hora)+ ":" +String.valueOf(min);
				min = min + 15;
			}
			hora++;
		}
		//inicialitzar vector torns[]
		for (int i=0; i<8; i++) {
			torns[i] = "Ningu";
		}
	}
	
	public int cercaCitaLiure() {
		for (int i=0; i<8; i++) {//cercar espai lliure
			if (torns[i] == "Ningu") {
				return i; //torna el torn lliiure
			}
		}
		return -1; //sino hi ha cap
	}
	
	public void assignaCitaAQuadre(String nomPacient, int i) {
		torns[i] = Thread.currentThread().getName();
	}
	
	public String retornaCita(int i) {
		return hores[i];
	}
	
	public void imprimirQuadre() {
		System.out.println(">>>>>  Quadre CITES  <<<<<<");
		System.out.println("    HORA             PACIENT");
		for (int i=0; i<8; i++) {
			System.out.println("  " +hores[i]+ "h.  ==> " +torns[i]);
		}
		
	}
}
