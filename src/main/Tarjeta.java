package src.main;

public class Tarjeta implements InterTarjeta {
    
    //atributos
    private String NIF;
    private int PIN;
    private String nombre;
    protected String apellido;
    private boolean estado;

    //constructor 
    public Tarjeta(String NIF, int PIN, String nombre, String apellido) {
        this.NIF = NIF;
        this.PIN = PIN;
        this.nombre = nombre;
        this.apellido = apellido;
        this.estado = estado;
    }

    // getter/setter
    public String getNIF() {
        return this.NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public int getPIN() {
        return this.PIN;
    }

    public void setPIN(int PIN) {
        this.PIN = PIN;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public boolean isEstado() {
        return this.estado;
    }

    public boolean getEstado() {
        return this.estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    @Override
    //metodo toString pero renombrado en mostrarTarjeta y sobreescrito con override
    public void mostrarTarjeta() {
        System.out.println(
        "Nombre: " + this.nombre + "\n" +
        "Apellido: " + this.apellido + "\n" +
        "NIF: " + this.NIF);
    }
}
