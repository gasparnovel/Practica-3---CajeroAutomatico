package src.main;

public class TarjetaCredito extends Tarjeta{ // extiene de tarjeta

    // atributos 
    private double saldoDiponible;
    private double creditoDisponible;

    //constructor   
    public TarjetaCredito(String NIF, int PIN, String nombre, String apellido,  double saldoDiponible, double creditoDisponible) {
        super(NIF, PIN, nombre, apellido);
        this.saldoDiponible = saldoDiponible;
        this.creditoDisponible = creditoDisponible;
    }

    // getter/setter
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

    //metodo toString pero renombrado en mostrarTarjeta, y un overrde porque como extiende de Tarjeta es necesario para modificar el metodo
    @Override
    public void mostrarTarjeta() {
        super.mostrarTarjeta();
        System.out.println(
        "Tarjeta de credito: " + "\n" +
        "Saldo: " + this.saldoDiponible + "\n" + 
        "Crédito: " + this.creditoDisponible);
    }
}