package testwithjava;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotSame;


import org.junit.Ignore;
import org.junit.Test;

public class AssertTest {
  
  @Test
  // @Ignore
  public void stringsIguaisTest() {
    var expected = "aluno";
    var actual = "aluno";
    var message = "Valores não são iguais";
    assertEquals(message, expected, actual);
  }

  @Test
  public void arrayIguaisTest() {

    var arrayA = new int[]{1, 2, 3, 4};
    var arrayB = new int[]{1, 2, 3, 4};

    assertArrayEquals(arrayA, arrayB);
  }

  @Test
  public void booleanIguaisTest() {
    var ttrue = true;
    var ffalse = false;
  
    assertNotEquals("Valor não deve ser iguais", ttrue, ffalse);
  }

  @Test
  public void objetosNaoDevemSerOsMesmosTest() {
    var unexpected = "hello";
    var actual = new String("hello");

    assertNotSame(" objetos não devem ser os mesmos", unexpected, actual);
  }

  @Test
  @Ignore
  public void testeIgnoradoTest() {}

}
