import java.util.Date;

public class LoanRequest {
    private static int nextId =0;
    public int id;
    public Date date;
    public Item item;
    public Client client;
    public int price;

    LoanRequest(Date date, Client client, Item item, int price){
        this.date = date;
        nextId++;
        this.id = nextId;
        this.client = client;
        this.item = item;
        this.price = price;
    }
}
