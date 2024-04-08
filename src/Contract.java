import java.util.Calendar;
import java.util.Date;

public class Contract {
    private static int nextId = 0;
    public int id;
    public Float interest;
    public Date initial_date;
    public Date deadline;
    public Float price;
    public Item item;
    public Client client;
    private String state;

    Contract(Float interest, Date deadline, Float price, Item item,Client client){
        nextId++;
        this.id = nextId;
        this.interest = interest;
        this.initial_date = new Date();
        this.deadline = deadline;
        this.price = price;
        this.item = item;
        this.client = client;
        this.state = "current";
    }

    @Override
    public String toString(){
        return "Id: " + this.id + " | Item: " + this.item.name + "\nFecha límite de pago: " + this.deadline
                + "\nValor: " + this.price + " con " + this.interest + "% de intereses\nDeudor: " + this.client.name
                + "\nFecha del prestamo: " + this.initial_date;
    }


    public boolean isExpired(){
        return this.deadline.before(new Date());
    }
    public boolean checkDeadLineInOneWeek(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 8); // Agregar 8 días a la fecha actual
        Date oneWeekFromNow = calendar.getTime();
        System.out.println(oneWeekFromNow);
        return (this.deadline.before(oneWeekFromNow) && this.deadline.after(new Date())) ;
    }

    public void setState(String state) {
        switch (state){
            case "current":
                this.state = "current";
                break;
            case "paid":
                this.state = "paid";
                break;
            case "expired":
                this.state = "expired";
                break;
            default:
                System.out.println("Invalid state");
        }

    }

    public String getState() {
        return state;
    }
}
