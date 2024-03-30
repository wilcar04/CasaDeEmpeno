import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class ManagerLoanRequest {
    private List<LoanRequest> AcceptedLoanRequest;
    private List<LoanRequest> RejectedLoanRequest;
    private List<LoanRequest> CounterofferLoanRequest;
    private List<LoanRequest> NewLoanRequest;


    ManagerLoanRequest(){
        this.AcceptedLoanRequest = new ArrayList<LoanRequest>();
        this.RejectedLoanRequest = new ArrayList<LoanRequest>();
        this.CounterofferLoanRequest = new ArrayList<LoanRequest>();
        this.NewLoanRequest= new ArrayList<LoanRequest>();
    }
    public List<LoanRequest> getNewLoanRequest(){
        return this.NewLoanRequest;
    }
    public List<LoanRequest> getRejectedLoanRequest(){
        return this.RejectedLoanRequest;
    }
    public List<LoanRequest> getAcceptedLoanRequest(){
        return this.AcceptedLoanRequest;
    }
    public List<LoanRequest> getCounterofferLoanRequest(){
        return this.CounterofferLoanRequest;
    }

    public void findItem(){

    }

    public void changeItemState(){

    }

    public void changeToAcceptedState(int idloanRequest){
        this.AcceptedLoanRequest = this.NewLoanRequest.stream()
                .filter(newLoanRequest -> idloanRequest == newLoanRequest.id)
                .collect(Collectors.toList());

        this.NewLoanRequest = this.NewLoanRequest.stream()
                .filter(newLoanRequest -> idloanRequest != newLoanRequest.id)
                .collect(Collectors.toList());
    }

    public void changeToRejectedState(int idloanRequest){
        this.RejectedLoanRequest = this.NewLoanRequest.stream()
                .filter(newLoanRequest -> idloanRequest == newLoanRequest.id)
                .collect(Collectors.toList());

        this.NewLoanRequest = this.NewLoanRequest.stream()
                .filter(newLoanRequest -> idloanRequest != newLoanRequest.id)
                .collect(Collectors.toList());
    }

    public void changeToCounterofferState(int price, int idloanRequest){
        List<LoanRequest> provitionalCounterOffer = this.NewLoanRequest.stream()
                .peek(newLoanRequest -> {
                    if (newLoanRequest.id == idloanRequest){
                        newLoanRequest.price = price;
                    }
                })
                .toList();

        this.CounterofferLoanRequest = provitionalCounterOffer.stream()
                .filter(newLoanRequest -> idloanRequest == newLoanRequest.id)
                .collect(Collectors.toList());

        this.NewLoanRequest = this.NewLoanRequest.stream()
                .filter(newLoanRequest -> idloanRequest != newLoanRequest.id)
                .collect(Collectors.toList());
    }
}
