package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import tpLista.Buffer;
import tpLista.ConcurrentList;
import tpLista.Counter;
import tpLista.Range;

public class ConcurrentListTestCase {
	
	ConcurrentList cl;
	
	@Before
	public void setUp(){
		cl = new ConcurrentList();
	}
	
	@Test
	public void DadaUnaConcurrentListaAgrego3ElementosTesteoSuTamaño() {
		cl.add(1);
		cl.add(1);
		cl.add(1);
		
		assertEquals(cl.size(), 3);
	}
	
	@Test
	public void dadoUnaConcurrentListaDe2ElementosVerificoElIntercambioConlaFuncionSWAP() {
		cl.add(1);
		cl.add(2);
		
		assertTrue(cl.head() == 1);
		assertTrue(cl.last() == 2);
		
		cl.swap(cl, 0, 1);
		
		assertTrue(cl.head() == 2);
		assertTrue(cl.last() == 1);
	}
	
	@Test
	public void DadaUnaConcurrentListaConElementosCuentoCuantosElementosHayMenoresAlPrimerElementoagregado() {
		cl.add(7); // elementos que va a ser el pivote
		cl.add(2);
		cl.add(3);
		cl.add(22);
		cl.add(8);
		
		assertTrue(2 == cl.qSort_partition(0,cl.size()-1));
	}
}
