package Activitat2_5_Incidencia;

public class ServeiTecnic {

	private int numIncidenciaResolta = 0;
	private int idNovaIncidencia = 1;
	private int maxIncidencies = 5;
	
	
	public int obtenirNovaIncidencia() {
		if (numIncidenciaResolta < maxIncidencies) {
			int numIncidencia = idNovaIncidencia;
			numIncidencia++;
			return numIncidencia;
		}
		return -1; //quan arriba al max incidències
	}
	
	public synchronized void incrementarIncidenciaResolta (int numIncidencia, String nomFil) {
		if (numIncidenciaResolta < maxIncidencies) {
			System.out.println(nomFil+ " ==> Demana incrementar incidències resoltes (quantitat actual: " +numIncidencia+ ")");
			numIncidenciaResolta++;
			System.out.println(nomFil+ " ==> Num Incidències resoltes: " +numIncidenciaResolta);		}
	}
	
	public boolean esPotResoldre() {
		return numIncidenciaResolta < maxIncidencies;
	}
	
	public int obtenirIncidenciesResoltes() {
		return numIncidenciaResolta;
	}

}
		

