import java.util.Date;

public class LoanRequest {
    private static int nextId =0;
    public int id;
    public Date date;
    public Item item;

    LoanRequest(Date date){
        this.date = date;
        // TO DO.
        nextId++;
        this.id = nextId;
        this.item = new Item("", "");

    }
}
