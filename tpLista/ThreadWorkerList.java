package tpLista;

public class ThreadWorkerList extends Thread{
	
	private ConcurrentList concList;
	private Buffer buffer;
	private Counter counter;
	
	
	public ThreadWorkerList(ConcurrentList cl, Buffer b, Counter c){
		this.concList = cl;
		this.counter = c;
		this.buffer = b;
	}
	
	public ThreadWorkerList(ConcurrentList cl) {
		this.concList = cl;
	}

	@Override
	public void run(){
		this.concList.qSort_worker(buffer, counter);
		// Cun el sigiente log en consola, indico que un thread termino su tarea y "murio"
		System.out.println(this + "soy un thread que acaba de morir");
	}
}
