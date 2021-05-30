package src.main;
import java.util.ArrayList;
import java.util.List;

public class  CajeroAutomatico{

    // atributos 
    private int idUltCaj = 0;
    private int idCaj;
    public int[][] billetes; // lista bidimensional billetes
    public List<Object> listaTarjeta; //array

    //constructor   
    public CajeroAutomatico() {
        this.setIdCaj(++idUltCaj); // cuando empieza la aplicacion se le suma en +1 a la variable idCaj
        listaTarjeta = new ArrayList<>(); // inicializacion de la arrayList
    }

    // getter/setter
    public List<Object> getListaTarjeta() {
        return listaTarjeta;
    }

    public void setBilletes(int[][] carga_billetes) {
        this.billetes = carga_billetes;
    }

    public int getIdUltCaj() {
        return this.idUltCaj;
    }

    public void setIdUltCaj(int idUltCaj) {
        this.idUltCaj = idUltCaj;
    }

    public int getIdCaj() {
        return this.idCaj;
    }

    public void setIdCaj(int idCaj) {
        this.idCaj = idCaj;
    }

    public int[][] getBilletes() {
        return this.billetes;
    }

    public void setTarjeta(List<Object> tarjeta) {
        this.listaTarjeta = tarjeta;
    }
}

