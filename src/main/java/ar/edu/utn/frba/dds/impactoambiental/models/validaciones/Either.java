package ar.edu.utn.frba.dds.impactoambiental.models.validaciones;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface Either<T> {
  T getValor();
  List<String> getErrores();
  <R> Either<R> map(Function<T, R> function, String error);

  static <T> Either<T> desde(Supplier<T> supplier, String error) {
    try {
      return exitoso(supplier.get());
    } catch (Exception e) {
      return fallido(error);
    }
  }

  static <T> Either<T> exitoso(T valor) {
    return new EitherExitoso<>(valor);
  }

  static <T> Either<T> fallido(List<String> errores) {
    return new EitherFallido<>(errores);
  }

  static <T> Either<T> fallido(String error) {
    return fallido(Collections.singletonList(error));
  }

  static List<String> colectarErrores(Either<?>... eithers) {
    return Stream.of(eithers).distinct()
        .flatMap(t -> t.getErrores().stream())
        .collect(Collectors.toList());
  }
}
