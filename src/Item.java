public class Item {
    private static int nextId = 0;
    public  int id;
    public String name;
    public String description;

    Item(String name, String description){
        this.name = name;
        this.description = description;
        nextId ++;
        this.id = nextId;
    }
    @Override
    public String toString(){
        return "Id: " + this.id + " | " + this.name + "\nDescripción: " + this.description;
    }
}
