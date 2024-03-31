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

}
