import java.util.ArrayList;
import java.util.List;

public class ManagerLoanRequest {
    public List<LoanRequest> AcceptedLoanRequest;
    public List<LoanRequest> RejectedLoanRequest;
    public List<LoanRequest> CounterofferLoanRequest;
    public List<LoanRequest> NewLoanRequest;



    ManagerLoanRequest(){
        this.AcceptedLoanRequest = new ArrayList<LoanRequest>();
        this.RejectedLoanRequest = new ArrayList<LoanRequest>();
        this.CounterofferLoanRequest = new ArrayList<LoanRequest>();
        this.NewLoanRequest= new ArrayList<LoanRequest>();
    }
    public void findItem(){

    }

    public void changeItemState(){

    }
}
