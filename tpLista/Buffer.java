package tpLista;

import java.util.ArrayList;
import java.util.List;

public class Buffer {

	/*
	 * Buffer generico para guardar <Object>
	 */
	
	private List<Object> values;
	
	boolean isEmpty() { return getValues().isEmpty(); }

	
	public Buffer() {
		values = new ArrayList<Object>();
	}
	
	public synchronized void push(Range v) {
		getValues().add(v);
		notifyAll();
	}
	
	public synchronized Object pop() {
		while(isEmpty()){
			notifyAll();
			try {wait(); } catch (InterruptedException e) {}
		}
		Object result = getValues().get(this.values.size() -1);
		getValues().remove(this.values.size() -1);
		notifyAll();
		return result;
	}


	public List<Object> getValues() {
		
		return values;
	}


	public void setValues(List<Object> values) {
		this.values = values;
	}
	
	/*
	 * Funciones para poder testear
	 */
	public int size() {
		return this.values.size();
	}
}
