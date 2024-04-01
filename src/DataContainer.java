import com.sun.source.tree.ReturnTree;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataContainer {
    public Storage storage;
    public ManagerLoanRequest loansRequest;
    public ManagerContract managerContracts;

    public ArrayList<Item> list_items;
    public ArrayList<Client> list_clients;
    DataContainer(){
        this.storage= new Storage("Store");
        this.managerContracts = new ManagerContract();
        this.loansRequest = new ManagerLoanRequest();
    }

    public Storage storageData() {
        Item item_1 = new Item("Name 1", "Description 1");
        Item item_2 = new Item("Name 2", "Description 2");
        Item item_3 = new Item("Name 3", "Description 3");
        Item item_4 = new Item("Name 4", "Description 4");
        Item item_5 = new Item("Name 5", "Description 5");
        Item item_6 = new Item("Name 6", "Description 6");
        Item item_7 = new Item("Name 7", "Description 7");
        Item item_8 = new Item("Name 8", "Description 8");
        Item item_9 = new Item("Name 9", "Description 9");
        Item item_10 = new Item("Name 10", "Description 10");
        Item item_11 = new Item("Name 11", "Description 11");
        Item item_12 = new Item("Name 12", "Description 12");
        this.list_items = new ArrayList<>();
        this.list_items.add(item_1);
        this.list_items.add(item_2);
        this.list_items.add(item_3);
        this.list_items.add(item_4);
        this.list_items.add(item_5);
        this.list_items.add(item_6);
        this.list_items.add(item_7);
        this.list_items.add(item_8);
        this.list_items.add(item_9);
        this.list_items.add(item_10);
        this.list_items.add(item_11);
        this.list_items.add(item_12);
        this.storage.addListItems(list_items);
        return this.storage;
    }
    public ManagerContract contractsData() {
        this.storageData();
        this.list_clients = new ArrayList<>();
        Client client_1 = new Client("Juan", "juan@gmail.com", "3013375465");
        Client client_2 = new Client("Antonio", "antonio86@gmail.com", "3014950673");
        Client client_3 = new Client("Daniel", "daniel94@gmail.com", "3116599286");
        Client client_4 = new Client("Juliana", "juli_ana33@gmail.com", "3165425794");
        Client client_5 = new Client("Sofia", "sofia97@gmail.com", "30230879456");
        Client client_6 = new Client("Albert", "albert_wolf03@gmail.com", "31130859504");

        this.managerContracts.createContract(4.3f,  new Date(2023, 2, 31), 1000f, this.list_items.get(0), client_1);
        this.managerContracts.createContract(4f,  new Date(2024, 3, 15), 1500f, this.list_items.get(1), client_2);
        this.managerContracts.createContract(3.2f,  new Date(2024, 3, 30), 2000f, this.list_items.get(2), client_3);
        this.managerContracts.createContract(5.5f, new Date(2024, 4, 15), 3000f, this.list_items.get(3), client_4);
        this.managerContracts.createContract(2.3f,  new Date(2024, 5, 7), 9000f, this.list_items.get(4), client_5);
        this.managerContracts.createContract(3.5f,  new Date(2024, 6, 10), 2500f, this.list_items.get(5), client_6);

        return this.managerContracts;

    }
    public ManagerLoanRequest loansRequestData() {
        this.contractsData();
        this.loansRequest.createNewLoanRequests(new Date(2024,1,11), this.list_clients.get(0), this.list_items.get(6), 3000);
        this.loansRequest.createNewLoanRequests(new Date(2024,2,29), this.list_clients.get(1), this.list_items.get(7), 4000);
        this.loansRequest.createNewLoanRequests(new Date(2024,3,21), this.list_clients.get(2), this.list_items.get(8), 5000);
        this.loansRequest.createNewLoanRequests(new Date(2024,3,16), this.list_clients.get(2), this.list_items.get(9), 3500);
        this.loansRequest.createNewLoanRequests(new Date(2024,2,17), this.list_clients.get(3), this.list_items.get(10), 4500);
        this.loansRequest.createNewLoanRequests(new Date(2024,4,1), this.list_clients.get(4), this.list_items.get(11), 6000);
        this.loansRequest.changeToCounterofferState(3500, 3);
        this.loansRequest.changeToRejectedState(6);
        this.loansRequest.changeToAcceptedState(2);

        return this.loansRequest;
    }

}

