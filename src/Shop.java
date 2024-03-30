import java.time.LocalDate;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;


public class Shop {
    public Integer NIT;
    public String name;
    private Storage storage;
    private List<Contract> contracts;

    private ManagerLoanRequest loansRequest;

    Shop (Integer NIT, String name){
        this.NIT = NIT;
        this.name = name;
        this.storage= new Storage("Store");
        this.contracts = new ArrayList<Contract>();
        this.loansRequest = new ManagerLoanRequest();

    }
    public List<String> getNewLoanRequest() {
        return this.loansRequest.getNewLoanRequest().stream().map(LoanRequest::toString).toList();
    }
    public List<String> getCurrentContactsInfo(){
        return this.
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
        List<Contract> ContractsWithDeadlineDate =  this.contracts.stream()
            .filter(contract -> contract.checkDeadLine())
            .toList();
        return ContractsWithDeadlineDate;
    }

    public List<Contract> getItemsWithDeadlineDateInOneWeek(){
        List<Contract> ContractsWithDeadlineDateInOneWeek =  this.contracts.stream()
                .filter(contract -> contract.checkDeadLineInOneWeek())
                .toList();

        return ContractsWithDeadlineDateInOneWeek;
    }
    public  List<Item> getItemsOfListContracts(List<Contract> contracts){
        List<Item> items = contracts.stream()
                .map(contract -> contract.item)
                .toList();
        return items;
    }

    public void moveItemsOfExpiredContractsToStorage(){
        List<Item>  itemsOfExpiredContracts= getItemsOfListContracts(this.getContractsWithDeadlineDate())
                .stream()
                .toList();
        this.storage.addListItems(itemsOfExpiredContracts);
        this.deleteExpiredContracts();
    }

    public void deleteExpiredContracts(){
        this.contracts = this.contracts.stream()
                .filter(contract -> !contract.checkDeadLine())
                .toList();
    }

    public List<String> getItemsOwned(){
        return this.storage.getItems().stream().map(Item::toString).toList();
    }

    public void setContractAsPaid(){

    }
}
