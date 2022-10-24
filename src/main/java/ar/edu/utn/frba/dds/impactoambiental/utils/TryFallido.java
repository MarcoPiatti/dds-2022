package ar.edu.utn.frba.dds.impactoambiental.utils;

import ar.edu.utn.frba.dds.impactoambiental.exceptions.ChequeoFallidoException;
import java.util.List;

public class TryFallido<T> implements Try<T> {
  private List<String> errores;

  protected TryFallido(List<String> errores) {
    this.errores = errores;
  }

  public T getValor() {
    throw new ChequeoFallidoException(errores);
  }

  public List<String> getErrores() {
    return errores;
  }
}
