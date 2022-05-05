package mia;

import org.junit.jupiter.api.Test;

import static java.util.Collections.singletonList;
import static mia.factory.MiembroFactory.agus;
import static mia.factory.TramoFactory.tramoAPieDesdeMedranoHastaAlem;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MiembroTest {
  @Test
  public void sePuedeDarDeAltaUnNuevoTrayecto() {
    Miembro miembro = agus();
    Trayecto trayecto = new Trayecto(singletonList(tramoAPieDesdeMedranoHastaAlem()));

    miembro.darDeAltaTrayecto(trayecto);

    assertTrue(miembro.getTrayectos().contains(trayecto));
  }
}
