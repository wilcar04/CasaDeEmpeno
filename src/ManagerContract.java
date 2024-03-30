import java.net.ConnectException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ManagerContract {
    private List<Contract> contracts;

    public ManagerContract() {
        this.contracts = new ArrayList<Contract>();

    }

    public void createContract(Float interest, Date initial_format, Date deadline, Float valor, Item item, Client client){
        Contract contract = new Contract(interest,initial_format,deadline,valor, item, client);
        this.addNewContract(contract);
    }
    public void addNewContract(Contract contract){
        this.contracts.add(contract);
    }

    public void findContract(int id ){
        Contract findContract = this.contracts
                .stream()
                .filter(contract -> contract.id == id)
                .toList()
                .getFirst();
    }

    public void updateContract(Contract contract){

        this.contracts = this.contracts
                .stream()
                .map(contract1 ->{
                    if (contract1.id == contract.id){
                        return contract;
                    }
                    else{
                        return contract1;
                    }
                } ).toList();
    }

    public void deleteContract(int id){
        this.contracts = this.contracts
                .stream()
                .filter(contract -> contract.id != id)
                .toList();


    }



}
