public class Controller {
    public static void mainLoop(){
        while(true){
            try{
                optionsSwitcher();
            } catch (Exception e){
                break;
            }
            Console.pause();
        }
    }
    public static void optionsSwitcher() throws Exception {
        Console.showOptions();
        do {
            String optionSelected = Console.getOption();

            switch (optionSelected) {
                case "1" -> {
                    manageLoanRequest();
                }
                case "2" -> {
                    checkStateOfItemsPawned();
                }
                case "3" -> {
                    exit();
                }
                default -> {Console.invalidOption(); continue;}
            }
            break;
        }while(true);
    }

    public static void manageLoanRequest(){

    }

    public static void checkStateOfItemsPawned(){

    }
    public static void exit() throws Exception {
        Console.farewell();
        throw new Exception();
    }
}
