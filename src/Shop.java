import java.util.List;
import java.util.stream.Stream;


public class Shop {
    public Integer NIT;
    public String name;
    private Storage storage;
    private List<Contract> contracts;

    private ManagerLoanRequest loansRequest;
    private ManagerContract managerContract;

    Shop (Integer NIT, String name){
        this.NIT = NIT;
        this.name = name;
        this.storage= new Storage("Store");

        this.managerContract = new ManagerContract();
        this.loansRequest = new ManagerLoanRequest();

    }
    public void loadInitialData(){

    }
    public List<String> getNewLoanRequest() {
        return this.loansRequest.getNewLoanRequest().stream().map(LoanRequest::toString).toList();
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

    public List<String> getStateOfLoanRequestInteractions(){
        Stream<String> aceepted_interactions = this.loansRequest.getAcceptedLoanRequest().stream()
                .map(loanRequest -> "== Aceptada ==\n" + loanRequest.toString());
        Stream<String> rejected_interactions = this.loansRequest.getRejectedLoanRequest().stream()
                .map(loanRequest -> "== Rechazada ==\n" + loanRequest.toString());
        Stream<String> counteroffer_interactions = this.loansRequest.getCounterofferLoanRequest().stream()
                .map(loanRequest -> "== Contraofertada ==\n" + loanRequest.toString());
        return Stream.concat(aceepted_interactions, Stream.concat(rejected_interactions, counteroffer_interactions)).toList();
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
