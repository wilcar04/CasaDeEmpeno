import java.util.List;

public class Controller {
    private static Shop shop;
    public static void mainLoop(){
        shop.loadInitialData();
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
                    readPaidContracts();
                }
                case "7" -> {
                    payContract();
                }
                case "8" -> {
                    readItemsOwnedByShop();
                }
                case "9" -> {
                    exit();
                }
                default -> {Console.invalidOption(); continue;}
            }
            break;
        }while(true);
    }

    // Option 1
    public static void manageLoanRequest(){
        Console.entryManageLoanRequest();
        List<String> newLoanRequestInfo = shop.getNewLoanRequest();
        Console.showListInfo(newLoanRequestInfo);
        String id = getIdOfLoanRequest();
        actionSwitcherLoanRequest(Integer.parseInt(id));
    }

    // Option 1
    public static String getIdOfLoanRequest(){
        String id;
        do {
            id = Console.getId();
            if (shop.existsLoanRequest(id)){
                return id;
            }
            Console.invalidOption();
        }while(true);
    }

    // Option 1
    public static void actionSwitcherLoanRequest(int id){
        String action;
        do {
            action = Console.optionsToManageLoanRequest();
            switch (action){
                case "1" -> {
                    Console.newContract();
                }
                case "2" -> {
                    shop.rejectLoanRequest(id);
                }
                case "3" -> {
                    String price = Console.getPrice();
                    shop.counterofferLoanRequest(Integer.parseInt(price), id);
                }
                default -> {Console.invalidOption(); continue;}
            }
            Console.succes();
            break;
        } while(true);
    }

    // Option 2
    public static void readLoanRequestManagementHistory(){
        List<String> infoList = shop.getStateOfLoanRequestInteractions();
        Console.showLoanRequestHistory();
        Console.showListInfo(infoList);
    }

    // Option 3
    public static void readCurrentContractState(){
        List<String> infoList = shop.getAllContractsWithState();
        Console.showAllContractsState();
        Console.showListInfo(infoList);
    }

    // Option 4
    public static void readExpiredContracts(){
        List<String> infoList = shop.getContractsWithDeadlineDate();
        Console.showExpiredContracts();
        Console.showListInfo(infoList);
    }

    // Option 5
    public static void readContractsAboutToExpire(){
        List<String> infoList = shop.getItemsWithDeadlineDateInOneWeek();
        Console.showContractsAboutToExpire();
        Console.showListInfo(infoList);
    }

    // Option 6
    public static void readPaidContracts(){
        List<String> infoList = shop.getPaidContracts();
        Console.showPaidContracts();
        Console.showListInfo(infoList);
    }

    // Option 7
    public static void payContract(){
        Console.entryPayContract();
        List<String> currentContractsInfo = shop.getCurrentContractsInfo();
        Console.showListInfo(currentContractsInfo);
        String id;
        do {
            id = getIdOfContract();
            if (shop.existsContract(id)){
                break;
            }
            Console.invalidOption();
        } while (true);

        shop.setContractAsPaid(Integer.parseInt(id));
    }

    // Option 7
    public static String getIdOfContract(){
        String id;
        do {
            id = Console.getId();
            if (shop.existsContract(id)){
                return id;
            }
            Console.invalidOption();
        } while(true);
    }

    // Option 8
    public static void readItemsOwnedByShop(){
        List<String> infoList = shop.getItemsOwned();
        Console.showItemsOwned();
        Console.showListInfo(infoList);
    }

    // Option 9
    public static void exit() throws Exception {
        Console.farewell();
        throw new Exception();
    }
}
