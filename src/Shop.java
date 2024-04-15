import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Shop {
    public Integer NIT;
    public String name;
    private Storage storage;

    private ManagerLoanRequest loansRequest;
    private ManagerContract managerContracts;
    private final DataContainer data;

    Shop (Integer NIT, String name){
        this.NIT = NIT;
        this.name = name;
        this.storage= new Storage("Store");
        this.managerContracts = new ManagerContract();
        this.loansRequest = new ManagerLoanRequest();
        this.data = new DataContainer();

    }
    public void loadInitialData(){
        this.storage = this.data.storageData();
        this.managerContracts = this.data.contractsData();
        this.loansRequest = this.data.loansRequestData();
    }
    public List<String> getNewLoanRequest() {
        return this.loansRequest.getNewState().stream().map(LoanRequest::toString).toList();
    }

    public void rejectLoanRequest(int idLoanRequest){
        this.loansRequest.changeToRejectedState(idLoanRequest);
    }
    public void counterofferLoanRequest(int price, int idLoanRequest){
        this.loansRequest.changeToCounterofferState(price, idLoanRequest);

    }
    public void acceptLoanRequest(int idLoanRequest,int quantityMonthsToAdd, float interest){
        this.loansRequest.changeToAcceptedState(idLoanRequest);
        Optional <LoanRequest> acceptedRequest =  this.loansRequest.getLoanRequest(idLoanRequest);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, quantityMonthsToAdd); // Agregar n meses a la fecha actual
        Date oneDateFromNow = calendar.getTime();
        acceptedRequest.ifPresent(loanRequest -> this.managerContracts.createContract(interest, oneDateFromNow, loanRequest.getPrice(), loanRequest.item, loanRequest.client));
    }

    public List<String> getStateOfLoanRequestInteractions() {
        Stream<String> acceptedLoanRequest = this.loansRequest.getAcceptedState().stream()
                .map(loanRequest -> "=== Aceptada ===\n" + loanRequest.toString());
        Stream<String> rejectedLoanRequest = this.loansRequest.getRejectedState().stream()
                .map(loanRequest -> "=== Rechazada ===\n" + loanRequest.toString());
        Stream<String> counterofferLoanRequest = this.loansRequest.getCounterofferState().stream()
                .map(loanRequest -> "=== Contraofertada ===\n" + loanRequest.toString());
        return Stream.concat(acceptedLoanRequest, Stream.concat(rejectedLoanRequest, counterofferLoanRequest)).toList();
    }

    public List<String> getItemsWithDeadlineDateInOneWeek(){
        return this.managerContracts.getItemsWithDeadlineDateInOneWeek().stream().map(Contract::toString).toList();
    }


    public void moveItemsToStorage(List<Item> items){
        this.storage.addListItems(items);
    }
    public List<String> getItemsOwned(){
        return this.storage.getItems().stream().map(Item::toString).toList();
    }

    public void setContractAsPaid(int id){
        this.managerContracts.changePaid(id);
    }

    public boolean existsNewLoanRequest(String id){
        return this.loansRequest.existsNewLoanRequest(Integer.parseInt(id));
    }

    public boolean existsContract(String id){
        return this.managerContracts.existContract(Integer.parseInt(id));
    }

    public List<String> getAllContractsWithState(){
        // TO DO: Verificar que no se estén devolviendo vigentes vencidos ***************************************
        Stream<String> paidContracts = this.getPaidContracts().stream().map(
                contractInfo -> "=== Pagado ===\n" + contractInfo
        );
        Stream<String> expiredContacts = this.getAllExpiredContracts().stream().map(
                contractInfo -> "=== Expirado ===\n" + contractInfo
        );
        Stream<String> currentContracts = this.getCurrentContractsInfo().stream().map(
                contractInfo -> "=== Vigente ===\n" + contractInfo
        );
        return Stream.concat(currentContracts, Stream.concat(paidContracts, expiredContacts)).toList();
    }

    public List<String> getPaidContracts(){
        return this.managerContracts.getPaidContracts().stream().map(Contract::toString).toList();
    }

    public List<String> getCurrentContractsInfo(){
        return this.managerContracts.getCurrentContracts().stream().map(Contract::toString).toList();
    }

    public List<String> getAllExpiredContracts(){
        List<Contract> currentExpiredContract = this.managerContracts.CurrentsContractsExpired();
        List<Item> items = this.managerContracts.getItemsOfListContracts(currentExpiredContract);
        this.moveItemsToStorage(items);
        this.managerContracts.changeCurrentsContractsExpiredToExpired();
        return this.managerContracts.getExpiredContracts().stream().map(Contract::toString).toList();
}
}
