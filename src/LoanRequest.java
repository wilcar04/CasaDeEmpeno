import java.util.Date;

public class LoanRequest {
    private static int nextId =0;
    public int id;
    public Date date;
    public Item item;
    public Client client;

    LoanRequest(Date date,Client client, Item item){
        this.date = date;
        // TO DO.
        nextId++;
        this.id = nextId;
        this.item = item;
    }
}
