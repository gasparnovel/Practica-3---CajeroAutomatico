package src.main;

import java.util.ArrayList;
import java.util.List;

public class CajeroAutomatico {

    private int idUltCaj = 0;
    private int idCaj;
    private int[][] billetes;
    public List<Object> listaTarjeta;

    public void CajeroAutomatico() {
        this.setIdCaj(idUltCaj++);
        listaTarjeta = new ArrayList<>();
    }

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





