import java.util.Date;

public class Contract {
    private static int nextId = 0;
    public int id;
    public Float interest;
    public Date initial_format;
    public Date deadline;
    public Float valor;
    Contract(Float interest, Date initial_format, Date deadline, Float valor){
        nextId++;
        this.id = nextId;
        this.interest = interest;
        this.initial_format = initial_format;
        this.deadline = deadline;
        this.valor = valor;
    }

    public void check_deadline(){

    }
}
