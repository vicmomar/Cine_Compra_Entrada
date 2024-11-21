import java.io.IOException;

public class LineaMuntatge implements Runnable {
	private String nom;
	private Component[] component = new Component[3];
	private boolean [] isCompAssembled = new boolean[3];

	
	
	public LineaMuntatge(String nomLinia, Component carrosseria, Component motor,Component rodes) {
		nom = nomLinia;
		this.component = component;
		System.out.println("[" +Thread.currentThread().getName()+ "] ==> Iniciant la línia de muntatge " +nom);
		//assignem els components al vector
		this.component[0] = carrosseria;
		this.component[1] = motor;
		this.component[2] = rodes;
		//inicialitzem els components a false
		for (int i=0; i<isCompAssembled.length; i++) {
			isCompAssembled[i] = false;
		}
	}

	public boolean obteComponent(Component component) throws IOException, InterruptedException {
		
		synchronized (component) {
			if (component.isDisponible()) {
				component.setDisponible(false);
				return true;
			} else 
				return false;
		}
	}


	//3:24
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			for (int i=0; i<component.length; i++) {
				System.out.println("[" +Thread.currentThread().getName()+ "] ==> Cercant component " +component[i].getNomComponent()+ "...");
				Thread.sleep(30);
				if(obteComponent(component[i])) {
					System.out.println("[" +Thread.currentThread().getName()+ "] ==> Recull component " +component[i].getNomComponent()+ "...");
					Thread.sleep(30);
					System.out.println("[" +Thread.currentThread().getName()+ "] ==> Ensambla component " +component[i].getNomComponent()+ "...");
					Thread.sleep(100);
					component[i].setDisponible(false);
					isCompAssembled[i] = true;

				} else 
					System.out.println("[" +Thread.currentThread().getName()+ "] ==> Esperant nou component " +component[i].getNomComponent()+ "...");
					break;

			}
			//comprovar el cotxe muntat
			boolean isCarAssembled = true;
			for (int i=0; i<isCompAssembled.length; i++) {
				if (!isCompAssembled[i]) {
					isCarAssembled = false;
					break;
				}
			}
			if (isCarAssembled)
				System.out.println("[" +Thread.currentThread().getName()+ "] ==> Cotxe Montat!!! ");
			else {
				System.out.println("[" +Thread.currentThread().getName()+ "] ==> Línia Bloquejada!!! ");
				System.out.println("[" +Thread.currentThread().getName()+ "] ==> Cotxe NO	 Montat!!! ");

				
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
