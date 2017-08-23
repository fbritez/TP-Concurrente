package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import tpLista.Counter;

public class CounterTestCase {
	
	Counter counterTest;
	
	@Before
	public void setUp(){
		counterTest = new Counter(5);
	}

	@Test
	public void DadoUnCounterVerificoSiElTamañoDisminuye() {
		counterTest.decrementar();
		
		assertEquals(counterTest.tamanio, 4);
	}
	
//	@Test
//	public void VerificoSiEl() {
//		counterTest.decrementar();
//		
//		assertEquals(counterTest.tamanio, 4);
//	}
//	
}
