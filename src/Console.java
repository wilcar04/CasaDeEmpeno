import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.lang.reflect.Array;

public class Console {
    public static Scanner scan = new Scanner(System.in);

    public static void showOptions () {
        System.out.println("\n\n============= ¡Bienvenido a Mi Casa de Empeño! =============");
        System.out.println("Has ingresado como empleado de la tienda.");
        System.out.println("\n¿Qué deseas hacer?");
        System.out.println("------------------------------------------------------------");
        System.out.println("1. Gestionar solicitudes de prestamo."); // Desde aquí se aceptan, rechanzan o contraofertan
        System.out.println("2. Consultar historial de solicitudes de prestamo atendidas."); // muestra las aceptadas, rechazadas, contraofertadas
        System.out.println("3. Consultar estado de contrado de las prendas empeñadas."); // Todos los contratos
        System.out.println("4. Consultar contratos vencidos.");
        System.out.println("5. Consultar contratos a vencer en una semana.");
        System.out.println("6. Consultar contratos pagos."); // NEW
        System.out.println("7. Registrar pago de contrato.");
        System.out.println("8. Consultar prendas adquiridas por la tienda.");
        System.out.println("9. Salir.");
        System.out.println("-----------------------------------------------------------");
    }
    public static String getOption(){
        System.out.println("Digita el número de la opción: ");
        return scan.nextLine();
    }

    public static void invalidOption(){
        System.out.println("Por favor, elija una opción válida.\n");
    }

    public static void pause(){
        System.out.println("\nPresione enter para continuar.");
        scan.nextLine();
    }

    public static void succes(){
        System.out.println("\nSe ha realizado la operación con éxito");
    }

    public static void showListInfo(List<String> listInfo){
        System.out.println("----");
        for(String info : listInfo) {
            System.out.println(info + "\n----");
        }
    }

    public static String getId(){
        System.out.println("Digita el id del objeto a gestionar: ");
        return getNumber();
    }

    public static String getPrice(){
        System.out.println("Digita el nuevo precio que le propone al solicitante: ");
        return getNumber();
    }

    public static String getNumber(){
        String input;
        do {
            input = scan.nextLine();
            if (isNumeric(input)){
                return input;
            }
            System.out.println("Opción inválida, intente de nuevo");
        } while(true);
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    // Entries: Lo que se muestra al seleccionar la opción
    // Option 1
    public static void entryManageLoanRequest(){
        System.out.println("\n------- Gestionar solicitudes de prestamo -------");
        System.out.println("Estas son las solicitudes de préstamo sin atender: ");
    }

    // Option 1
    public static String optionsToManageLoanRequest(){
        System.out.println("-----\n¿Qué deseas hacer con esta solicitud?\n");
        System.out.println("1. Aceptarla");
        System.out.println("2. Rechazarla");
        System.out.println("3. Contraofertarla");
        return scan.nextLine();
    }

    // Option 1
    public static void newContract(){
        System.out.println("\n----------------- Crear nuevo contrato -----------------");
        System.out.println("Para crear un nuevo contrato de prenda para la solicitud recién aceptada," +
                "\nporfavor ingrese los siguientes datos");
    }

    // Option 1
    public static String getQuantityOfMonths(){
        System.out.println("¿Cuántos meses de plazo se tendrá para la cancelación de la deuda?");
        do {
            String months = getNumber();
            if (Integer.parseInt(months) >= 1){
                return months;
            }
            Console.invalidOption();
        } while(true);
    }

    // Option 1
    public static String getInterest(){
        System.out.println("¿Cuál porcentaje de interés se aplicar sobre el valor acordado?");
        do {
            String interest = getNumber();
            if (Float.parseFloat(interest) >= 0){
                return interest;
            }
            Console.invalidOption();
        } while(true);
    }

    // Option 2
    public static void showLoanRequestHistory(){
        System.out.println("\n--- Consultar historial de solicitudes de prestamo atendidas ---\n");
    }

    // Option 3
    public static void showAllContractsState(){
        System.out.println("\n---- Consultar estado de contrado de las prendas empeñadas ----\n");
    }

    // Option 4
    public static void showExpiredContracts(){
        System.out.println("\n--------------- Consultar contratos vencidos ---------------\n");
    }

    // Option 5
    public static void showContractsAboutToExpire(){
        System.out.println("\n-------- Consultar contratos a vencer en una semana --------\n");
    }

    // Option 6
    public static void showPaidContracts(){
        System.out.println("\n----------------- Consultar contratos pagos -----------------\n");
    }

    // Option 7
    public static void entryPayContract(){
        System.out.println("\n------- Registrar pago de contrato -------");
        System.out.println("Estos son todos los contratos de prenda vigentes: ");
    }

    // Option 8
    public static void showItemsOwned(){
        System.out.println("\n--------- Consultar prendas adquiridas por la tienda ---------\n");
    }

    // Option 9
    public static void farewell(){
        System.out.println("¡Vuelva pronto!");
        System.out.println("-----------------------------------------------------");
    }

}


