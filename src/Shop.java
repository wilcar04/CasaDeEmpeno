import java.util.List;
import java.util.stream.Stream;


public class Shop {
    public Integer NIT;
    public String name;
    private Storage storage;

    private ManagerLoanRequest loansRequest;
    private ManagerContract managerContracts;

    Shop (Integer NIT, String name){
        this.NIT = NIT;
        this.name = name;
        this.storage= new Storage("Store");

        this.managerContracts = new ManagerContract();
        this.loansRequest = new ManagerLoanRequest();

    }
    public void loadInitialData(){

    }
    public void getNewLoanRequest() {

    }
    public void getCurrentContactsInfo(){

    }
    public void rejectLoanRequest(int idLoanRequest){
        this.loansRequest.changeToRejectedState(idLoanRequest);
    }
    public void counterofferLoanRequest(int price, int idLoanRequest){
        this.loansRequest.changeToCounterofferState(price, idLoanRequest);

    }
    public void acceptLoanRequest(int idLoanRequest){
        this.loansRequest.changeToAcceptedState(idLoanRequest);
    }

    public void getStateOfLoanRequestInteractions(){

    }

    public List<Contract> getContractsWithDeadlineDate() {
        return this.managerContracts.getExpiredContracts();
    }

    public List<Contract> getItemsWithDeadlineDateInOneWeek(){
        return this.managerContracts.getItemsWithDeadlineDateInOneWeek();
    }
    public  List<Item> getItemsOfListContracts(List<Contract> contracts){
        return this.managerContracts.getItemsOfListContracts(contracts);
    }

    public void moveItemsOfExpiredContractsToStorage(){
        List<Item> itemsOfExpiredContracts= this.managerContracts.getItemsOfExpiredContracts();
        this.storage.addListItems(itemsOfExpiredContracts);
        this.managerContracts.deleteExpiredContracts();
    }
    public List<String> getItemsOwned(){
        return this.storage.getItems().stream().map(Item::toString).toList();
    }

    public void setContractAsPaid(){

    }
}
