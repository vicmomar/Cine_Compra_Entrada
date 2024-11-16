package CINE_v21_Compra1EntradaThreads_Victor_Morant;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AccesTaquilla {

	private boolean ocupada = false;
	private final Lock lock = new ReentrantLock();
	private final Condition taquilla = lock.newCondition();
	
	public void arribaTaquilla() {
		lock.lock();
		ocupada = true;
		System.out.println("[" +Thread.currentThread().getName()+"] Arriba a la taquilla");
	}
	
	public void laCompra() {
		lock.lock();
		
		while(ocupada) {
			System.out.println("[" +Thread.currentThread().getName()+"] Esperant per fer la compra de la entrada...");
			try {
				taquilla.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		ocupada = true;
		System.out.println("[" +Thread.currentThread().getName()+"] iniciant compra de la entrada");
		lock.unlock();
	}
	
	public void acabaCompra() {
		lock.lock();
		
		ocupada = false;
		System.out.println("[" +Thread.currentThread().getName()+"] Abandona la taquilla");
		taquilla.signalAll();
		lock.unlock();
	}
}
