import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

public class ManagerContract {
    private List<Contract> contracts;

    public ManagerContract() {
        this.contracts = new ArrayList<Contract>();

    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void createContract(Float interest, Date deadline, Float price, Item item, Client client) {
        Contract contract = new Contract(interest, deadline, price, item, client);
        this.addNewContract(contract);
    }

    public void addNewContract(Contract contract) {
        this.contracts.add(contract);
    }

    public Contract findContract(int id) {
        return this.contracts
                .stream()
                .filter(contract -> contract.id == id)
                .toList()
                .getFirst();
    }

    public boolean existContract(int id) {
        return this.getContracts().stream().anyMatch(contract -> contract.id == id);
    }

    public void updateContract(Contract contract) {

        this.contracts = this.contracts
                .stream()
                .map(contract1 -> {
                    if (contract1.id == contract.id) {
                        return contract;
                    } else {
                        return contract1;
                    }
                }).toList();
    }


    public void deleteContract(int id) {
        this.contracts = this.contracts
                .stream()
                .filter(contract -> contract.id != id)
                .toList();
    }

    private  void changeStatus(int id, String status) {
        Contract findContract = this.findContract(id);
        findContract.setState(status);
    }
    public void changePaid(int id){
        this.changeStatus(id,"paid");
    }

    public List<Contract> getItemsWithDeadlineDateInOneWeek() {

        return this.getCurrentContracts().stream()
                .filter(contract-> contract.checkDeadLineInOneWeek())
                .toList();
    }

    public List<Item> getItemsOfListContracts(List<Contract> contracts) {
        return this.getContracts().stream()
                .map(contract -> contract.item)
                .toList();
    }




    public List<Contract> getExpiredContracts() {
        return this.getContracts()
                .stream()
                .filter(contract -> Objects.equals(contract.getState(), "expired"))
                .toList();
    }


    public List<Contract> getCurrentContracts() {
        return getContractsByState("current");
    }

    public List<Contract> getPaidContracts() {
        return getContractsByState("paid");
    }

    private List<Contract> getContractsByState(String state) {
        return this.contracts.stream()
                .filter(contract -> Objects.equals(contract.getState(), state))
                .toList();
    }

    public void changeCurrentsContractsExpiredToExpired() {
        this.contracts = this.contracts.stream()
                .peek(contract -> {
                    if (contract.isExpired() && Objects.equals(contract.getState(), "current")) {
                        contract.setState("expired");
                    }
                }).toList();
    }

    public List<Contract> CurrentsContractsExpired(){
        return this.contracts.stream()
                .filter(contract -> contract.isExpired() && Objects.equals(contract.getState(), "current")).toList();
    }
    }






