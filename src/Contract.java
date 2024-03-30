import java.util.Calendar;
import java.util.Date;

public class Contract {
    private static int nextId = 0;
    public int id;
    public Float interest;
    public Date initial_format;
    public Date deadline;
    public Float valor;
    public Item item;
    public Client client;

    Contract(Float interest, Date initial_format, Date deadline, Float valor, Item item,Client client){
        nextId++;
        this.id = nextId;
        this.interest = interest;
        this.initial_format = initial_format;
        this.deadline = deadline;
        this.valor = valor;
        this.item = item;
        this.client = client;
    }

    @Override
    public String toString(){
        return "Id: " + this.id + " | Item: " + this.item.name + "\nFecha límite de pago: " + this.deadline
                + "\nValor: " + this.valor + " con " + this.interest + "% de intereses\nDeudor: " + this.client.name
                + "\nFecha del prestamo: " + this.initial_format;
    }

    public boolean checkDeadLine(){
       return this.deadline.before(new Date());
    }
    public boolean checkDeadLineInOneWeek(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 7); // Agregar 7 días a la fecha actual
        Date oneWeekFromNow = calendar.getTime();
        return this.deadline.before(oneWeekFromNow);
    }
}
