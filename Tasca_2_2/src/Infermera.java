
public class Infermera {

	public QuadreCites cites;

	public Infermera() {
		System.out.println("[" +Thread.currentThread().getName()+ "] Infermera agafa el quadre de CITA PREVIA");
		this.cites = new QuadreCites();
	}
	
	public boolean solicitaCitaPrevia() {
		int posicio;
		System.out.println("[" +Thread.currentThread().getName()+ "] Infermera busca lloc al quadre de CITA PREVIA per a " +Thread.currentThread().getName());
		
		synchronized(cites) {
			posicio = cites.cercaCitaLiure();
			if (posicio != -1) {
				cites.assignaCitaAQuadre(Thread.currentThread().getName(), posicio);//assigna reserva
			} else {
				return false;
			}
		}
		
		System.out.println("[" +Thread.currentThread().getName()+ "] Infermera assigna la CITA PREVIA per a " +Thread.currentThread().getName()+ " a les " +cites.retornaCita(posicio)+ "h");
		return true;
	}
	
	public void mostraTornsQuadre() {
		cites.imprimirQuadre();
	}
}
