public class Item {
    private static int nextId = 0;
    public  int id;
    public String name;
    public String description;
    public Category category;

    Item(String name, String description){
        this.name = name;
        this.description = description;
        this.category = new Category("");
        nextId ++;
        this.id = nextId;
    }
}
