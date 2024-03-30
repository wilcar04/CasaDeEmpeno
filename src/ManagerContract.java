import java.net.ConnectException;
import java.util.List;

public class ManagerContract {
    private List<Contract> currentContracts;
    private List<Contract> paidContracts;
    private List<Contract> expiredContracts;

    public List<Contract> getExpiredContracts() {
        return expiredContracts;
    }
    public List<Contract> getPaidContracts() {
        return paidContracts;
    }
    public List<Contract> getCurrentContracts(){
        return currentContracts;
    }

    public void addContract(){

    }

    public void payContract(){

    }
}
