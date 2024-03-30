import java.util.ArrayList;
import java.util.List;

public class Storage {
    private List<Item> items;
    Storage(String store){
        this.items = new ArrayList<Item>();

    }
    public List<Item> getItems(){
        return this.items;
    }
    public void addListItems(List<Item> items){
        this.items.addAll(items);
    }
}
