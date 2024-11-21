
public class Infermera {

	public QuadreCites cites;
	public String nom;

	public Infermera(String nomInfermera, QuadreCites cites) {
		nom = nomInfermera;
		System.out.println("[" +Thread.currentThread().getName()+ "] Infermera agafa el quadre de CITA PREVIA");
		this.cites = new QuadreCites();
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public boolean solicitaCitaPrevia() {
		int posicio;
		System.out.println("[" +Thread.currentThread().getName()+ "] " +nom+ " busca lloc al quadre de CITA PREVIA per a " +Thread.currentThread().getName());
		posicio = cites.cercaCitaLiure();
		
		synchronized(cites) {
			
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
