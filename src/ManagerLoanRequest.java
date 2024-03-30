import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class ManagerLoanRequest {

    private List<LoanRequest> LoanRequests;


    ManagerLoanRequest(){
        this.LoanRequests= new ArrayList<LoanRequest>();
    }
    public List<LoanRequest> getLoanRequests(){
        return this.LoanRequests;
    }



    public void findItem(){

    }

    public void changeItemState(){

    }

    public void changeToAcceptedState(int idloanRequest){
        this.LoanRequests = this.LoanRequests
                .stream()
                .peek(loanRequest -> {
                    if (loanRequest.id == idloanRequest){
                        loanRequest.setState("Accepted");}
                })
                .collect(Collectors.toList());
    }

    public void changeToRejectedState(int idloanRequest){
        this.LoanRequests = this.LoanRequests
                .stream()
                .peek(loanRequest -> {
                    if (loanRequest.id == idloanRequest){
                        loanRequest.setState("Rejected");}
                })
                .collect(Collectors.toList());

    }

    public void changeToCounterofferState(int price, int idloanRequest){
        this.LoanRequests = this.LoanRequests
                .stream()
                .peek(loanRequest -> {
                    if (loanRequest.id == idloanRequest){
                        loanRequest.setState("Counteroffer");
                        loanRequest.price = price;}
                })
                .collect(Collectors.toList());

    }
}
