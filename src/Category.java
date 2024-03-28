public class Category {
    private static int nextId = 0;
    public int id ;
    public String name;
    Category (String name){
        nextId++;
        this.id = nextId;
        this.name = name;
    }
}
