import java.io.IOException;

public class Component {

	private String nomComponent;
	private boolean disponible;
	
	public Component(String nomComponent) throws IOException {
		try {
		this.nomComponent = nomComponent;
		//demanar component al dept
		System.out.println("[" +Thread.currentThread().getName()+ "] ==> Encarregant 1 component " +nomComponent+ " a dept VENDES...");
		Thread.sleep(30);
		System.out.println("[" +Thread.currentThread().getName()+ "] ==> Component " +nomComponent+ " disponible.");
		
		disponible = true; //disponible per usar-lo
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String getNomComponent() {
		return nomComponent;
	}

	public void setNomComponent(String nomComponent) {
		this.nomComponent = nomComponent;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		try {
			Thread.sleep(1);
			this.disponible = disponible;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}
