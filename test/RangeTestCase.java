package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import tpLista.Range;

public class RangeTestCase {
	
	Range testRange;
	
	@Test
	public void TestDeUnRangoInvalido() {
		testRange = new Range(-1,0);
		
		assertTrue(testRange.isInvalid());
	}
	
	@Test
	public void TestDeUnRangoValido() {
		testRange = new Range(1,0);
		
		assertTrue(testRange.isInvalid());
	}
	
	@Test
	public void TestDeUnRangoConStarYEndigualACeroYVerificoSiEsInvalido() {
		testRange = new Range(0,0);
		
		assertTrue(testRange.isInvalid());
	}
	
	@Test
	public void TestDeUnRangoValidoConTamanioMayorACero() {
		testRange = new Range(1,3);
		
		assertFalse(testRange.isInvalid());
	}
	
	@Test
	public void TesteoTamañoDeUnRango() {
		testRange = new Range(1,3);
		
		assertEquals(testRange.size(), 2);
		assertFalse(testRange.size() == 1);
		assertFalse(testRange.size() == 3);
	}
	
	@Test
	public void TestDeUnRangoVacioConStarYEndIguales() {
		testRange = new Range(1,1);
		
		assertFalse(testRange.isEmpty());
	}
	
	@Test
	public void TestDeUnRangoVacioConStartMasGrandeQueEnd() {
		testRange = new Range(2,1);
		
		assertTrue(testRange.isEmpty());
	}
	
	@Test
	public void TestDeUnRangoVacioConStartMasChicoQueEnd() {
		testRange = new Range(1,3);
		
		assertFalse(testRange.isEmpty());
	}
	
	@Test
	public void TestDeUnRangoVacioConStartIgualACeroYMasChicoQueEnd() {
		testRange = new Range(0,3);
		
		assertFalse(testRange.isEmpty());
	}
	
	@Test
	public void TestDeUnRangoVacioConStartYEndIgualACero() {
		testRange = new Range(0,0);
		
		assertFalse(testRange.isEmpty());
	}
	
	

}
