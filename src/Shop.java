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
        // TO DO: super importante!!!! crear diferentes contratos, items, clientes y loanRequest con diferentes atributos, fechas y estados
        // con el fin de poder testear todas las HU y opciones de consola y para que el profe pueda ver funcionando todas las operaciones
    }
    public List<String> getNewLoanRequest() {
        return this.loansRequest.getNewState().stream().map(LoanRequest::toString).toList();
    }
    public List<String> getCurrentContractsInfo(){
        return this.managerContracts.getCurrentContracts().stream().map(Contract::toString).toList();
    }
    public void rejectLoanRequest(int idLoanRequest){
        this.loansRequest.changeToRejectedState(idLoanRequest);
    }
    public void counterofferLoanRequest(int price, int idLoanRequest){
        this.loansRequest.changeToCounterofferState(price, idLoanRequest);

    }
    public void acceptLoanRequest(int idLoanRequest){
        this.loansRequest.changeToAcceptedState(idLoanRequest);
        // TO DO: Crear contrato
    }

    public List<String> getStateOfLoanRequestInteractions(){
        Stream<String> acceptedLoanRequest = this.loansRequest.getAcceptedState().stream()
                .map(loanRequest -> "=== Aceptada ===\n" + loanRequest.toString());
        Stream<String> rejectedLoanRequest = this.loansRequest.getRejectedState().stream()
                .map(loanRequest -> "=== Rechazada ===\n" + loanRequest.toString());
        Stream<String> counterofferLoanRequest = this.loansRequest.getCounterofferState().stream()
                .map(loanRequest -> "=== Contraofertada ===\n" + loanRequest.toString());
        return Stream.concat(acceptedLoanRequest, Stream.concat(rejectedLoanRequest, counterofferLoanRequest)).toList();
    }

    public List<String> getContractsWithDeadlineDate() {
        return this.managerContracts.getExpiredContracts().stream().map(Contract::toString).toList();
    }

    public List<String> getItemsWithDeadlineDateInOneWeek(){
        return this.managerContracts.getItemsWithDeadlineDateInOneWeek().stream().map(Contract::toString).toList();
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

    public void setContractAsPaid(int id){
        // TO DO: Hacer en ManagerContract un método para cambiar a cada estado (cambiar a pagado, vencido)
        // TO DO: Testear que en ningún momento un contrato pagado caiga a la categoría vencido por la fecha limite
    }

    public boolean existsLoanRequest(String id){
        return this.loansRequest.existsLoanRequest(Integer.parseInt(id));
    }

    public boolean existsContract(String id){
        return this.managerContracts.existContract(Integer.parseInt(id));
    }

    public List<String> getAllContractsWithState(){
        Stream<String> acceptedLoanRequest = this.managerContracts.getCurrentContracts().stream()
                .map(loanRequest -> "=== Vigente ===\n" + loanRequest.toString());
        Stream<String> rejectedLoanRequest = this.managerContracts.getPaidContracts().stream()
                .map(loanRequest -> "=== Pagado ===\n" + loanRequest.toString());
        Stream<String> counterofferLoanRequest = this.managerContracts.getExpiredContracts().stream()
                .map(loanRequest -> "=== Vencido ===\n" + loanRequest.toString());
        return Stream.concat(acceptedLoanRequest, Stream.concat(rejectedLoanRequest, counterofferLoanRequest)).toList();
    }

    public List<String> getPaidContracts(){
        return this.managerContracts.getPaidContracts().stream().map(Contract::toString).toList();
    }
}
