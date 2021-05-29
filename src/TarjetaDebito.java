

public class TarjetaDebito extends Tarjeta{

    private double saldoDiponible;

    public TarjetaDebito(String NIF, int PIN, String nombre, String apellido, int saldoDiponible) {
        super(NIF, PIN, nombre, apellido);
        this.saldoDiponible = saldoDiponible;
    }

    public double getSaldoDiponible() {
        return this.saldoDiponible;
    }

    public void setSaldoDiponible(double saldoDiponible) {
        this.saldoDiponible = saldoDiponible;
    }
    
}
