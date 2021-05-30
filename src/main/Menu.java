package src.main; // nombre del paquete

import java.util.Scanner;

public class Menu {

    // atributos static porque lo utilizaremos en diversos metodos
    public static TarjetaDebito mitarj1; 
    public static CajeroAutomatico micajero; 
    public static TarjetaCredito mitarj2; 
    public static int[][] carga_billetes;
    static Scanner sc = new Scanner(System.in);

    // Main
    public static void main(String[] args) {
        // inicializacion de la variable con una lista de elementos
        carga_billetes = new int[][] { { 500, 1 }, { 200, 3 }, { 100, 0 }, { 50, 0 }, { 20, 0 }, { 10, 18 },
                { 5, 25 } };

        // creacion de un objeto
        CajeroAutomatico micajero = new CajeroAutomatico();

        // agregamos la lista creada dentro de la lista del objeto micajero
        micajero.setBilletes(carga_billetes);

        // creamos dos objetos
        mitarj1 = new TarjetaDebito("87654321b", 1111, "Fran", "Fran", 20000);
        mitarj2 = new TarjetaCredito("12345678a", 2222, "Javi", "Javi", 1000, 5000);

        // agregamos los objetos anteriores al objeto micajero
        micajero.getListaTarjeta().add(mitarj2);
        micajero.getListaTarjeta().add(mitarj1);
        menu(micajero);
    }

    // metodo menu
    public static CajeroAutomatico menu(CajeroAutomatico micajero) {

        //atributo para la salida del programa
        boolean salir = false;

        // bucle do-while
        do {
            try { // sentencia para capturar las excepciones producidas por la diferencia en el tipo del parametro introducido

                //atributo para coger el valor introducido por pantalla
                Scanner sc = new Scanner(System.in); 

                // llamamos a los dos metodos siguientes 
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
                    // llama al metodo comprobarCredoDeb(micajero);
                    comprobarCredoDeb(micajero);
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
        return micajero; // devuelve micajero
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

    public static void comprobarCredoDeb(CajeroAutomatico micajero){

        try{
            Scanner sc3 = new Scanner(System.in);
            Scanner sc4 = new Scanner(System.in);
            Scanner sc5 = new Scanner(System.in);

            System.out.println("Elige una de las opciones de nuevo, para confirmar la opcion escogida.");
            System.out.println("1. Opcion 1 - Sacar dinero");
            System.out.println("2. Opcion 2 - Salir");
            int dinero = sc3.nextInt();
            System.out.println("Has seleccionado la opcion 1 - Sacar dinero");

                if(dinero == 1){
                System.out.println("Dame el NIF:");
                String nif = sc4.nextLine(); 


                System.out.println("Dame el PIN:");
                Integer pin = sc5.nextInt(); 

                    // comprueba si el nif y el pin introducido y el nif de la tarjeta credito son iguales
                    if(nif.equals(((Tarjeta) micajero.getListaTarjeta().get(0)).getNIF()) && pin.equals(((Tarjeta) micajero.getListaTarjeta().get(0)).getPIN())){
                        System.out.println("¿que cantidad deseas retirar?");
                        retirarDineroCredito(micajero.getListaTarjeta().get(0));
                    }
                
                    // comprueba si el nif y el pin introducido y el nif de la tarjeta debito son iguales

                    if(nif.equals(((Tarjeta) micajero.getListaTarjeta().get(1)).getNIF()) && pin.equals(((Tarjeta) micajero.getListaTarjeta().get(1)).getPIN())){
                        System.out.println("¿que cantidad deseas retirar?");
                        retirarDineroDebito(micajero.getListaTarjeta().get(1));
                    }
                }else{
                    if(dinero == 2){
                        System.out.println("Has seleccionado la opcion 2 - Salir");
                        System.out.println("¡Finalizada la ejecución!");
                    }
                }
        }catch (Exception error) { // si se produce la excepcion muestra el siguiente texto
            System.out.println("[ERROR] opcion no valida");
        }
    
}
    //metodo que retirara el dinero de la tarjeta de credito
    private static void retirarDineroCredito(Object object) {
        
        //atributos del metodo para utilizar durante su ejecución e inicializacion
        TarjetaCredito tarjetaCredito = (TarjetaCredito) object;
        int dinero = sc.nextInt();
        int contadorCreditoDisp = 0;
        int contadorDebitoDisp = 0;
        int contadorQuin  = 0;
        int contadorDos = 0;
        int contadorCien = 0;
        int contadorCinq = 0;
        int contadorVein  = 0;
        int contadorDiez  = 0;
        int contadorCinco  = 0;

        //bucle while mientras sea mayor a 4
            while (dinero > 4 ){
                // si dinero sea mayor a 1000
                if (dinero > 1000){
                    System.err.println("Pretendes sacar mas que la cantidad del saldo que dispones, intentalo de nuevo.");
                    break;
                }
                // si dinero es mayor al saldo disponible
                if (tarjetaCredito.getSaldoDiponible() > 0){

                if (contadorQuin < 1 && dinero >= 500){
                    dinero -= 500;
                    contadorDebitoDisp += 500;
                    carga_billetes[0][1]--;
                    contadorQuin ++;
                    }
                if (contadorDos < 3 && dinero >= 200 ){
                    dinero -= 200;
                    contadorDebitoDisp += 200;
                    carga_billetes[1][1]--;
                    contadorDos ++;
                    }
                else if (contadorDiez < 18 && dinero >= 10){
                    dinero -= 10;
                    contadorDebitoDisp += 10;
                    carga_billetes[5][1]--;
                    contadorDiez ++;
                }
                else if (contadorCinco < 25 && dinero >= 5){
                    dinero -= 5;
                    contadorDebitoDisp += 5;
                    carga_billetes[6][1]--;
                    contadorCinco ++;
                }
                else if (dinero == 4 || dinero == 3 || dinero == 2 || dinero == 1)
                break;
            }
            // si el saldo disponible es igual a 0 y el credito es mayor a 0
                if(tarjetaCredito.getSaldoDiponible() == 0 && tarjetaCredito.getCreditoDisponible() > 0){
                    if (contadorQuin < 1 && dinero >= 500){
                        dinero -= 500;
                        contadorCreditoDisp += 500;
                        carga_billetes[0][1]--;
                        contadorQuin ++;
                        }
                    if (contadorDos < 3 && dinero >= 200 ){
                        dinero -= 200;
                        contadorCreditoDisp += 200;
                        carga_billetes[1][1]--;
                        contadorDos ++;
                        }
                    else if (contadorDiez < 18 && dinero >= 10){
                        dinero -= 10;
                        contadorCreditoDisp += 10;
                        carga_billetes[5][1]--;
                        contadorDiez ++;
                    }
                    else if (contadorCinco < 25 && dinero >= 5){
                        dinero -= 5;
                        contadorCreditoDisp += 5;
                        carga_billetes[6][1]--;
                        contadorCinco ++;
                    }
                    else if (dinero == 4 || dinero == 3 || dinero == 2 || dinero == 1)
                    break;
                }
            
        }
        // actualiza el saldo y el credito 
        tarjetaCredito.setSaldoDiponible(tarjetaCredito.getSaldoDiponible() - contadorDebitoDisp);
        tarjetaCredito.setCreditoDisponible(tarjetaCredito.getCreditoDisponible()- contadorCreditoDisp);
        
                // se imprimiran las siguientes sentencias
                System.out.println("Desglose de la cantidad satisfecha:");
                System.out.println(contadorQuin + " billetes de 500 €");
                System.out.println(contadorDos + " billetes de 200 €");
                System.out.println(contadorCien + " billetes de 100 €");
                System.out.println(contadorCinq + " billetes de 50 €");
                System.out.println(contadorVein + " billetes de 20 €");
                System.out.println(contadorDiez + " billetes de 10 €");
                System.out.println(contadorCinco + " billetes de 5 €");
    }

    //metodo que retirara el dinero de la tarjeta de debito
    public static void retirarDineroDebito(Object object){ 

        //atributos del metodo para utilizar durante su ejecución e inicializacion
        TarjetaDebito tarjetaDebito = (TarjetaDebito) object;        
        int dinero = sc.nextInt();
        int contadorQuin  = 0;
        int contadorDos = 0;
        int contadorCien = 0;
        int contadorCinq = 0;
        int contadorVein  = 0;
        int contadorDiez  = 0;
        int contadorCinco  = 0;
        tarjetaDebito.setSaldoDiponible(tarjetaDebito.getSaldoDiponible() - dinero);

        // bucle while mientras dinero sea mayor a 0
            while (dinero > 0 ){
                if (dinero > tarjetaDebito.getSaldoDiponible()){
                    System.err.println("Pretendes sacar mas que la cantidad del saldo que dispones, intentalo de nuevo.");
                    break;
                }
            
                if (contadorQuin < 1 && dinero >= 500){
                    dinero -= 500;
                    carga_billetes[0][1]--;
                    contadorQuin ++;
                    }
                if (contadorDos < 3 && dinero >= 200 ){
                    dinero -= 200;
                    carga_billetes[1][1]--;
                    contadorDos ++;
                    }
                else if (contadorDiez < 18 && dinero >= 10){
                    dinero -= 10;
                    carga_billetes[5][1]--;
                    contadorDiez ++;
                }
                else if (contadorCinco < 25 && dinero >= 5){
                    dinero -= 5;
                    carga_billetes[6][1]--;
                    contadorCinco ++;
                }
                else if (dinero == 4 || dinero == 3 || dinero == 2 || dinero == 1)
                    break;
        }

                // se imprimiran las siguientes sentencias
                System.out.println("Desglose de la cantidad satisfecha:");
                System.out.println(contadorQuin + " billetes de 500 €");
                System.out.println(contadorDos + " billetes de 200 €");
                System.out.println(contadorCien + " billetes de 100 €");
                System.out.println(contadorCinq + " billetes de 50 €");
                System.out.println(contadorVein + " billetes de 20 €");
                System.out.println(contadorDiez + " billetes de 10 €");
                System.out.println(contadorCinco + " billetes de 5 €");
    }
}
