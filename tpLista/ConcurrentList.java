package tpLista;

import java.util.ArrayList;
import java.util.List;

public class ConcurrentList{

	private List<Integer> list;

	public ConcurrentList(){
		list = new ArrayList<Integer>();
	}
	
	/*
	 *  funciones de la interface de ConcurrentList
	 */
	
	public synchronized int size(){
		return list.size();	
	}
	
	public synchronized boolean isEmpty(){
		return list.isEmpty();	
	}
	
	public synchronized boolean contains(Integer nro){
		return list.contains(nro);
	}
	
	public synchronized void add(Integer nro){
		list.add(nro);
	}
	
	public synchronized Integer get(Integer pos){
		return list.get(pos);
	}
	
	public synchronized void set(Integer pos, Integer nro){
		list.set(pos,  nro);
	}
	
	
	public synchronized void quickSort(Integer nroThreadMaximos){
		Buffer b = new Buffer();
		Counter c = new Counter(this.size());
		int counterRepeat = 0;
		while(counterRepeat < nroThreadMaximos){
			ThreadWorkerList t = new ThreadWorkerList(this, b, c);
			t.start();			
			counterRepeat++;
		}
		
		Range rangoInicial = new Range(0, this.size() - 1);
		b.push(rangoInicial);

		while (c.size() > 0){
			try {wait();} catch (InterruptedException e) { }
		}

		while(counterRepeat <= 0){
			b.push(new Range(-1,0));
			counterRepeat --;
		}
	}

	public synchronized void swap(ConcurrentList cl, Integer x, Integer y){
		Integer a = cl.get(x);
		Integer b = cl.get(y);
		
		cl.set(x, b);
		cl.set(y,a);
	}
	
	public synchronized Integer qSort_partition(Integer start, Integer end){
		Integer j = 0;
		Integer pivot = this.get(start);
		for(int i = start +1; i <= end; i++){
			if(this.get(i) <= pivot){
				this.swap(this, i, start + 1 + j);
				j++;
			}
		}
		this.swap(this, start, start + j);
		notifyAll();
		return j;
	}
	
	public synchronized void qSort_worker(Buffer b, Counter c){
		while(true){
			Range r = (Range) b.pop();
			if(r.isInvalid()){
				if(c.size() <= 0){
					break;
				}
			}
			if(r.size() >= 1){
				Integer count = this.qSort_partition(r.start(), r.end());
				Range leftRange = new Range(r.start(), r.start() + count -1);
				Range rightRange = new Range(r.start()+count +1, r.end());
				b.push(leftRange);
				b.push(rightRange);
			}
			if(!r.isEmpty()){
				c.decrementar();
			}
		}		
	}
	
	
	/*
	 *  funciones para poder testear, no necesarias en el funcionamiento del quickSort
	 */
	
	public synchronized Integer head() {
		return this.list.get(0);
	}
	
	public synchronized Integer last() {
		return this.list.get(this.list.size()-1);
	}
	
	/*
	 * Funcion para printer la lista "desde afuera"
	 */

	public void printMe() {
		System.out.println(this.list);
		
	}
}
