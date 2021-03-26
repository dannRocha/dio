package testwithjava;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class RuleTest {
  /**
   * A 'Rule' cria algo antes de inciar os teste
   */
  @Rule
  public TemporaryFolder  tmpFolder = new TemporaryFolder();

  @Test
  public void deveCriarUmaNovaArquivoTemporaria() throws IOException {
    File created = tmpFolder.newFile("file.txt");

    assertTrue(created.isFile());
    assertEquals(tmpFolder.getRoot(), created.getParentFile());

  }
  
}
