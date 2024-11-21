package Activitat2_5_Incidencia;

public class Tecnic implements Runnable {

	private ServeiTecnic serveiTecnic;
	private String nomFil;
	
	
	public Tecnic (ServeiTecnic serveiTecnic, String nomFil) {
		this.serveiTecnic = serveiTecnic;
		this.nomFil = nomFil;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (serveiTecnic.esPotResoldre()) {
			int numIncidencia = serveiTecnic.obtenirIncidenciesResoltes();
			if (numIncidencia == -1) {
				break;
			}
			System.out.println(nomFil+ " ==> Atenent incidència " +numIncidencia);
				
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(nomFil+ " ==> Solucionant incidència " +numIncidencia);
			serveiTecnic.incrementarIncidenciaResolta(numIncidencia, nomFil);
		}
		System.out.println(nomFil + " ==> Ha finalitzat seua jornada");
	}
	
}
