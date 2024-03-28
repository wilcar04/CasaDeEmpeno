public class Client {
    public String name;
    private static int nextId = 0;
    public int id;
    public String email;
    public String telephone;
    Client (String name, String email, String telephone){
        this.name = name;
        this.email = email;
        this.telephone = telephone;
        nextId ++;
        this.id = nextId;

    }
}
