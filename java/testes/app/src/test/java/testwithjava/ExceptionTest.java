package testwithjava;


import static org.junit.Assert.assertThat;
import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.internal.runners.statements.ExpectException;
import org.junit.rules.ExpectedException;


public class ExceptionTest {

  @Test(expected = IndexOutOfBoundsException.class)
  public void obterValorDeArrayVazioTest() {
    new ArrayList<String>().get(0);

  }

  @Test(expected = NullPointerException.class)
  public void acessarValorEmPonteiroNuloTest() {
    String valor = null;
    System.out.println(valor.toString());
  }

  @Test(expected = MinhaRegraException.class)
  public void minhasExceptionsTest() throws MinhaRegraException{
    if(true)
      throw new MinhaRegraException();
  
  }

  @Rule
  public ExpectedException lancar = ExpectedException.none();

  @Test
  public void testarMessagemDeExecaoTest() throws MinhaRegraException {
    
    lancar.expect(MinhaRegraException.class);
    lancar.expectMessage("Minha Messagem Persoanlizada deve ser igual a");
    
    // Lançando exceção da regra de negocio
    throw new MinhaRegraException("Minha Messagem Persoanlizada deve ser igual a");
  }


  @Test
  @Ignore
  public void testarMessagemDeExecao2Test() throws MinhaRegraException {
    var mensagem = "Minha Messagem Persoanlizada deve ser igual a";
    try {  
      // Lançando exceção da regra de negocio
      throw new MinhaRegraException(mensagem);
    }
    catch(Exception e) {
      // assertThat(e.getMessage(), is(mensagem));
    }
    
  }
}
