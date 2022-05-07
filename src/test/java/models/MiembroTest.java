package models;

import org.junit.jupiter.api.Test;

import static java.util.Collections.singletonList;
import static models.factory.MiembroFactory.agus;
import static models.factory.TramoFactory.tramoAPieDesdeMedranoHastaAlem;
import static org.assertj.core.api.Assertions.assertThat;

public class MiembroTest {
  @Test
  public void sePuedeDarDeAltaUnNuevoTrayecto() {
    Miembro miembro = agus();
    Trayecto trayecto = new Trayecto(singletonList(tramoAPieDesdeMedranoHastaAlem()));

    miembro.darDeAltaTrayecto(trayecto);

    assertThat(miembro.getTrayectos()).containsExactly(trayecto);
  }
}
