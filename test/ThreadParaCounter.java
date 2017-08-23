package test;

import tpLista.Counter;

public class ThreadParaCounter extends Thread{
	
	Counter c;
	
	public ThreadParaCounter(Counter c){
		super();
		this.c  = c;
	}
	
	@Override
	public void run(){
		c.decrementar();
	}

}
