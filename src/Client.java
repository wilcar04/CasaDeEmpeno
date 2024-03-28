public class Client {
    private static int nextId = 0;
    public String name;
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
