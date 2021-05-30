package src.main;

public abstract class Tarjeta {
    
    private String NIF= "gaspar";
    private int PIN = 1234;
    private String nombre;
    private String apellido;
    private boolean estado;

    public Tarjeta(String NIF, int PIN, String nombre, String apellido) {
        this.NIF = NIF;
        this.PIN = PIN;
        this.nombre = nombre;
        this.apellido = apellido;
        this.estado = estado;
    }

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
    
    public String mostrarTarjeta() {
        return 
            "Nombre: " + getNombre()+
            "Apellido: " + getApellido()+
            "NIF: " + getNIF();
    }

}
