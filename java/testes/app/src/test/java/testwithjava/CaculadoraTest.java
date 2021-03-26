package testwithjava;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class CaculadoraTest {
  
  @Test
  public void testSomar() {
    var calc = new Calculadora();
    int result = calc.somar(2, 2);
    int expect = 4;
    assertEquals(expect, result);
  }

  @Test
  public void testarSomarComMock() {
    Calculadora calc = mock(Calculadora.class);

	// Forçar resposta
    when(calc.somar(1, 2)).thenReturn(3);
    
    var resultado = calc.somar(1, 2);
    assertEquals(3, resultado);
  }
}
