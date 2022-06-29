package models.da;
public class DatoActividad {
  private TipoDeConsumo tipo;
  private Double valor;
  private Periodicidad periodicidad;
  private String periodo;

  public DatoActividad(TipoDeConsumo tipo, Double valor, Periodicidad periodicidad, String periodo) {
    this.tipo = tipo;
    this.valor = valor;
    this.periodicidad = periodicidad;
    this.periodo = periodo;
  }

  public Double getValor() {
    return valor;
  }
  public Periodicidad getPeriodicidad() {
    return periodicidad;
  }
  public String getPeriodo() {
    return periodo;
  }
  public TipoDeConsumo getTipo() {
    return tipo;
  }
}