import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.lang.reflect.Array;

public class Console {
    public static Scanner scan = new Scanner(System.in);

    public static void showOptions () {
        System.out.println("========== ¡Bienvenido a Mi Casa de Empeño! ==========");
        System.out.println("Has ingresado como empleado de la tienda.");
        System.out.println("\n¿Qué deseas hacer?");
        System.out.println("------------------------------------------------------");
        System.out.println("1. Gestionar solicitudes de prestamo."); // Desde aquí se aceptan, rechanzan o contraofertan
        System.out.println("2. Consultar historial de solicitudes de prestamo atendidas."); // muestra las aceptadas, rechazadas, contraofertadas
        System.out.println("3. Consultar estado de contrado de las prendas empeñadas."); // Todos los contratos
        System.out.println("4. Consultar contratos vencidos.");
        System.out.println("5. Consultar contratos a vencer en una semana.");
        System.out.println("6. Gestionar contratos."); // Desde aquí se marcan como pagos o se mueven a storage
        System.out.println("7. Consultar prendas adquiridas por la tienda.");
        System.out.println("8. Salir.");
        System.out.println("-----------------------------------------------------");
    }
    public static String getOption(){
        System.out.println("Digita el número de la opción: ");
        return scan.nextLine();
    }

    public static void invalidOption(){
        System.out.println("Por favor, elija una opción válida.");
    }

    public static void farewell(){
        System.out.println("¡Vuelva pronto!");
        System.out.println("-----------------------------------------------------");
    }

    public static void pause(){
        System.out.println("Presione enter para continuar.");
        scan.nextLine();
    }

    public static void manageLoanRequest(){

    }
    public static void checkStateOfItemsPawned(){

    }
    public static boolean validarPlaca(String placa) {
        String patron = "^[A-Za-z]{3}\\d{3}$";

        //
        // Compilar la expresión regular en un objeto Pattern
        Pattern pattern = Pattern.compile(patron);

        // Crear un objeto Matcher para hacer coincidir la placa con el patrón
        Matcher matcher = pattern.matcher(placa);

        // Comprobar si la placa coincide con el patrón
        return matcher.matches();
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}


