import java.util.ArrayList;

public class CajeroAutomatico {

    private int idUltCaj = 0;
    private int idCaj;
    private int[][] billetes;
    private ArrayList<Object> listaTarjeta;

    public void CajeroAutomatico() {
        this.setIdCaj(idUltCaj++);
        listaTarjeta = new ArrayList<Object>();
    }

    public Object getListaTarjeta() {
        return this.listaTarjeta;
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

    public void setListaTarjeta(ArrayList<Object> listaTarjeta) {
        this.listaTarjeta = listaTarjeta;
    }
    
}



