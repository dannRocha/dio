package testwithjava;

public class MinhaRegraException extends Throwable {
  
  public MinhaRegraException() {}

  public MinhaRegraException(String msg) {
    super(msg);
  }

  public MinhaRegraException(String msg, Throwable cause) {
    super(msg, cause);
  }
}
