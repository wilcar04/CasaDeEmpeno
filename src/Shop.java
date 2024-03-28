import java.time.LocalDate;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


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
    public void getNewLoanRequest(){

        //HU1
        // Yo como tienda quiero obtener la lista
        // de ofertas de prendas para evaluar
        // cada una.

        //RETURN LIST

    }
    public void getPawnedItems(){
        // HU2
        // Yo como tienda quiero ver las prendas empeñadas con detalles
        // para saber cuanto queda hasta que expire el contrato.



        //RETURN LIST
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

    public void getMyItemsInteractions(){
        //HU6
        //Yo como tienda quiero obtener la lista
        // de las prendas que he atendido para observar
        // su estado.

    }

    public List<Contract> getContractsWithDeadlineDate()
    {
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
                .map(contract -> contract.loanRequest.item)
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


}
