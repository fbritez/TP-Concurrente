package tpLista;


public class Counter {
	
	// clase monitor
	
	public int tamanio;

	public Counter(int size) {
		tamanio = size;
	}

	public synchronized void decrementar() {
		this.tamanio --;
		notifyAll();
	}

	public synchronized void waitZero() {
		while (tamanio > 0){
			try {
				this.wait();
			} catch (InterruptedException e) { }
		}
		notifyAll();		
	}

	public int size() {
		return this.tamanio;
	}
}
