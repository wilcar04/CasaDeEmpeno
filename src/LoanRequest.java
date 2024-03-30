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
    @Override
    public String toString(){
        return "Id: " + Integer.toString(this.id) + " | Fecha: " + this.date + "\nItem: " + this.item.name +
                "\nDescripción: " + this.item.description + "\nSolicitado por: " + this.client.name + " | Email: "
                + this.client.email + "\nValor propuesto: " + this.price;
    }
}
