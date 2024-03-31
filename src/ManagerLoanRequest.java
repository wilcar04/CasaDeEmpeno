import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class ManagerLoanRequest {

    private List<LoanRequest> LoanRequests;


    ManagerLoanRequest() {
        this.LoanRequests = new ArrayList<LoanRequest>();
    }

    public List<LoanRequest> getLoanRequests() {
        return this.LoanRequests;
    }


    public void findItem() {

    }

    public void changeItemState() {

    }

    public void changeToAcceptedState(int idloanRequest) {
        this.LoanRequests = this.LoanRequests
                .stream()
                .peek(loanRequest -> {
                    if (loanRequest.id == idloanRequest) {
                        loanRequest.setState("accepted");
                    }
                })
                .collect(Collectors.toList());
    }

    public void changeToRejectedState(int idloanRequest) {
        this.LoanRequests = this.LoanRequests
                .stream()
                .peek(loanRequest -> {
                    if (loanRequest.id == idloanRequest) {
                        loanRequest.setState("rejected");
                    }
                })
                .collect(Collectors.toList());

    }

    public void changeToCounterofferState(int price, int idloanRequest) {
        this.LoanRequests = this.LoanRequests
                .stream()
                .peek(loanRequest -> {
                    if (loanRequest.id == idloanRequest) {
                        loanRequest.setState("counter");
                        loanRequest.price = price;
                    }
                })
                .collect(Collectors.toList());

    }

    public List<LoanRequest> getAcceptedState() {
        return this.LoanRequests.stream().filter(loanRequest -> loanRequest.getState().equals("accepted")).collect(Collectors.toList());
    }

    public List<LoanRequest> getRejectedState() {
        return this.LoanRequests.stream().filter(loanRequest -> loanRequest.getState().equals("rejected")).collect(Collectors.toList());
    }

    public List<LoanRequest> getCounterofferState() {
        return this.LoanRequests.stream().filter(loanRequest -> loanRequest.getState().equals("counter")).collect(Collectors.toList());
    }

    public List<LoanRequest> getNewState() {
        return this.LoanRequests.stream().filter(loanRequest -> loanRequest.getState().equals("new")).collect(Collectors.toList());
    }

    public List<LoanRequest> getLoanRequest(int idLoanRequest){
        return this.LoanRequests.stream().filter(loanRequest -> loanRequest.id == idLoanRequest).collect(Collectors.toList());
    }

    public boolean existsLoanRequest(int idLoanRequest){
        return this.LoanRequests.stream().anyMatch(loanRequest -> loanRequest.id == idLoanRequest);
    }
}
