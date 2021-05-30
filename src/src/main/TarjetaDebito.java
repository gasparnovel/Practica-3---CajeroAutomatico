package src.main;

public class TarjetaDebito extends Tarjeta{

    //atributos
    private double saldoDiponible;

    //constructor   
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

    //metodo toString pero renombrado en mostrarTarjeta, y un overrde porque como extiende de Tarjeta es necesario para modificar el metodo
    @Override
    public void mostrarTarjeta() {
        System.out.println(
        "Nombre: " + getNombre() + "\n" +
        "Apellido: " + getApellido() + "\n" +
        "NIF: " + getNIF()+ "\n" + 
        "Tarjeta de credito: " + "\n" +
        "Saldo: " + getSaldoDiponible());
    }
}