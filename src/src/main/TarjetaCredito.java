package src.main;

public class TarjetaCredito extends Tarjeta{

    private double saldoDiponible;
    private double creditoDisponible;

    public TarjetaCredito(String NIF, int PIN, String nombre, String apellido,  double saldoDiponible, double creditoDisponible) {
        super(NIF, PIN, nombre, apellido);
        this.saldoDiponible = saldoDiponible;
        this.creditoDisponible = creditoDisponible;
    }

    public double getSaldoDiponible() {
        return this.saldoDiponible;
    }

    public void setSaldoDiponible(double saldoDiponible) {
        this.saldoDiponible = saldoDiponible;
    }

    public double getCreditoDisponible() {
        return this.creditoDisponible;
    }

    public void setCreditoDisponible(double creditoDisponible) {
        this.creditoDisponible = creditoDisponible;
    }
    @Override
    public String mostrarTarjeta() {
        return 
            "Nombre: " + getNombre()+
            "Apellido: " + getApellido()+
            "NIF: " + getNIF()+
            "Tarjeta de credito: "+ 
            "Saldo: " + getSaldoDiponible()+
            "Credito: " + getCreditoDisponible();
    }

}