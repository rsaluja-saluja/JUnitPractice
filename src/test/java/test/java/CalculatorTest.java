package test.java;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.*;

import main.java.Calculator;
import main.java.CalculatorService;

public class CalculatorTest {

	Calculator c = null;
	
	// First way to mock the object
	// CalculatorService cs = mock(CalculatorService.class);
	
	//2nd way to mock the object: @Rule is required otherwise it will give NullPointerException
	@Mock
	CalculatorService cs;
	
	@Rule 
	public MockitoRule rule = MockitoJUnit.rule();
	
	@Before
	public void setUp() throws Exception {
		c = new Calculator(cs);
	}

	@After
	public void tearDown() throws Exception {
		c = null;
	}

	@Test
	public void testAdd() {
		assertEquals(6, c.add(2, 4));
	}
	
	@Test
	public void testPerform() {
		when(cs.addNumbers(2, 4)).thenReturn(6);
		assertEquals(18, c.perform(2, 4));
		verify(cs).addNumbers(2, 4); //verify if mocked object is called or not.If not called then test would fail
		
	}

}
