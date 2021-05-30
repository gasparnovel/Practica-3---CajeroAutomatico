package src.main; // nombre del paquete

import java.util.InputMismatchException;
import java.text.MessageFormat;
import java.util.Scanner;

public class Menu {

    // atributos static porque lo utilizaremos en diversos metodos
    public static TarjetaDebito mitarj1; 
    public static TarjetaCredito mitarj2; 
    public static int[][] carga_billetes;

    // Main
    public static void main(String[] args) {
        menu();
    }

    // metodo menu
    public static void menu() {

        //atributo para la salida del programa
        boolean salir = false;

        // bucle do-while
        do {
            try { // sentencia para capturar las excepciones producidas por la diferencia en el tipo del parametro introducido

                //atributo para coger el valor introducido por pantalla
                Scanner sc = new Scanner(System.in); 

                // inicializacion de la variable con una lista de elementos
                carga_billetes = new int[][] { { 500, 1 }, { 200, 3 }, { 100, 0 }, { 50, 0 }, { 20, 0 }, { 10, 18 },
                        { 5, 25 } };

                // creacion de un objeto 
                CajeroAutomatico micajero = new CajeroAutomatico();

                // agregamos la lista creada dentro de la lista del objeto micajero
                micajero.setBilletes(carga_billetes);

                // creamos dos objetos 
                mitarj2 = new TarjetaCredito("87654321b", 2222, "Javi", "Javi", 1000, 5000);
                mitarj1 = new TarjetaDebito("12345678a", 1111, "Fran", "Fran", 20000);

                // agregamos los objetos anteriores al objeto micajero
                micajero.getListaTarjeta().add(mitarj2);
                micajero.getListaTarjeta().add(mitarj1);

                // llamamos a los dos metodos siguientes para que nos muestren las tarjetas y la lista de billetes en micajero
                mostrarTarjeta();
                mostrarCajero();

                // nos muestra una salida por pantalla
                System.out.println("1. Opcion 1 - Sacar dinero");
                System.out.println("2. Opcion 2 - Salir");
                System.out.println("Escribe una de las opciones");

                //atributo para coger el valor introducido por pantalla
                int opcion = sc.nextInt();

                // bucle if-else 
                if (opcion == 1) {
                    sacarDinero(); // llama al metodo que sacara dinero y lo restara de los billetes del cajero
                } else {
                    if (opcion == 2) {
                        System.out.println("Has seleccionado la opcion 2 - Salir");
                        System.out.println("¡Finalizada la ejecución!");
                        break;
                    }
                }
            } catch (Exception error) { // si se produce la excepcion muestra el siguiente texto
                System.out.println("[ERROR] opcion no valida");
            }

        } while (!salir); // final del bucle do-while
    }

    // metodo mostrarTarjeta que devuelve sentencias por pantalla y el metodo mostrarTarjeta de los dos tipos de tarjeta
    public static void mostrarTarjeta() {

        System.out.println("======================" + "\n" + " DATOS DE LA TARJETA DEL CLIENTE");
        mitarj1.mostrarTarjeta();
        System.out.println("======================" + "\n" + " DATOS DE LA TARJETA DEL CLIENTE");
        mitarj2.mostrarTarjeta();
    }

    // metodo mostrarTarjeta que devuelve sentencias a traves del bucle con el contador
    public static void mostrarCajero() {
        // contador que se actualizara durante el for para cada fila de la lista
        int cont = 0;

        for (int i = 0; i < carga_billetes.length; i++) {
            System.out.print(carga_billetes[cont][1] + " billetes de " + carga_billetes[cont][0] + " €" + "\n");
            cont++;
        }
    }

    // metodo sacarDinero 
    public static void sacarDinero() {

        try { 
            Scanner sc2 = new Scanner(System.in);
            Scanner sc3 = new Scanner(System.in);

            System.out.println("Has seleccionado la opcion 1 - Sacar dinero");
            System.out.println("Dame el NIF:");
            String nif = sc2.nextLine();
            System.out.println("Dame el PIN:");
            int pin = sc3.nextInt();

            // bucle if-else
            if (nif.equals(mitarj1.getNIF()) && pin == mitarj1.getPIN()
                    || nif.equals(mitarj2.getNIF()) && pin == mitarj2.getPIN()) { // si el nif es igual al nif de una tarjeta y el pin igual permitira retirar dinero

                Scanner sc4 = new Scanner(System.in);

                System.out.println("¿que cantidad deseas sacar?");
                int dinero = sc4.nextInt();

                // contadores
                int ContadorQ = 0;
                int ContadorD = 0;
                int ContadorDiez = 0;
                int ContadorCinco = 0;

                //bucle while
                while (dinero > 0) {
                    if (dinero > 1405) {
                        System.err.println("Has sacado más cantidad de la que dispone el cajero, intentalo de nuevo.");
                        break;
                    }

                    if (ContadorQ < 1 && dinero >= 500) {
                        dinero -= 500;
                        carga_billetes[0][1]--;
                        ContadorQ++;
                    }
                    if (ContadorD < 3 && dinero >= 200) {
                        dinero -= 200;
                        carga_billetes[1][1]--;
                        ContadorD++;
                    } else if (ContadorDiez < 18 && dinero >= 10) {
                        dinero -= 10;
                        carga_billetes[5][1]--;
                        ContadorDiez++;
                    } else if (ContadorCinco < 25 && dinero >= 5) {
                        dinero -= 5;
                        carga_billetes[6][1]--;
                        ContadorCinco++;
                    }
                }

                // se imprimiran las siguientes sentencias
                System.out.println("Desglose de la cantidad satisfecha:");
                System.out.println(ContadorQ + " billetes de 500 €");
                System.out.println(ContadorD + " billetes de 200 €");
                System.out.println("0 billetes de 100 €");
                System.out.println("0 billetes de 50 €");
                System.out.println("0 billetes de 20 €");
                System.out.println(ContadorDiez + " billetes de 10 €");
                System.out.println(ContadorCinco + " billetes de 5 €");
            } else {
                if (nif.equals(mitarj1.getNIF()) || nif.equals(mitarj2.getNIF())) { 
                } else { // si el nif no es igual al nif de una tarjeta mostrara la senencia
                    System.out.println("NIF incorrecto");
                }
                if (pin == mitarj1.getPIN() || pin == mitarj2.getPIN()) {
                } else { // si el pin no es igual al pin de una tarjeta mostrara la senencia
                    System.out.println("PIN incorrecto");
                }
            }
        } catch (Exception error) { // si se produce la excepcion mostrara la sentencia
            System.out.println("[ERROR] opcion no válido");
        }
    }
}
