package testwithjava;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class CaculadoraTest {
  
  @Test
  public void testSomar() {
    var calc = new Calculadora();
    int result = calc.somar(2, 2);
    int expect = 4;
    assertEquals(expect, result);
  }
}
