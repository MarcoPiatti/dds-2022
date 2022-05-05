import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.List;


public class Sector {
  private List<Miembro> miembrosPendientes;
  private List<Miembro> miembros;

  public Sector(List<Miembro> miembros, List<Miembro> miembrosPendientes) {
    this.miembrosPendientes = miembrosPendientes;
    this.miembros = miembros;
  }

  public void solicitarVinculacion(Miembro miembro) {
    this.miembrosPendientes.add(requireNonNull(miembro, "el miembro no es valido"));
  }

  public void vincularMiembro(Miembro miembro) {
    if (!this.miembrosPendientes.remove(miembro)) {
      throw new IllegalArgumentException("El miembro no solicito vincularse al sector");
    }
    this.miembros.add(miembro);
  }

  public List<Miembro> getMiembros() {
    return new ArrayList<>(miembros);
  }
}
