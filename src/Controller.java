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
                    readLoanRequestManagementHistory();
                }
                case "3" -> {
                    readCurrentContractState();
                }
                case "4" -> {
                    readExpiredContracts();
                }
                case "5" -> {
                    readContractsAboutToExpire();
                }
                case "6" -> {
                    manageContracts();
                }
                case "7" -> {
                    readItemsOwnedByShop();
                }
                case "8" -> {
                    exit();
                }
                default -> {Console.invalidOption(); continue;}
            }
            break;
        }while(true);
    }

    public static void manageLoanRequest(){

    }

    public static void readLoanRequestManagementHistory(){

    }

    public static void readCurrentContractState(){

    }

    public static void readExpiredContracts(){

    }

    public static void readContractsAboutToExpire(){

    }

    public static void manageContracts(){

    }

    public static void readItemsOwnedByShop(){

    }

    public static void exit() throws Exception {
        Console.farewell();
        throw new Exception();
    }
}
