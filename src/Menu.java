import java.io.*;
import java.util.*;

class Menu{

    public static void main(String[] args) {

        int[][] carga_billetes = {{500, 1}, {200, 3}, {100, 0}, {50, 0},
        {20, 0}, {10, 18}, {5, 25}};

        CajeroAutomatico micajero = new CajeroAutomatico();

        micajero.setBilletes(carga_billetes);

        TarjetaDebito mitarj1 = new TarjetaDebito("12345678a", 1111, "Fran", "Fran", 20000);
        
        TarjetaCredito mitarj2 = new TarjetaCredito("87654321b", 2222, "Javi", "Javi", 1000, 5000);

        micajero.getListaTarjeta().add(mitarj1);

        micajero.getListaTarjeta().add(mitarj2);
    }
}





