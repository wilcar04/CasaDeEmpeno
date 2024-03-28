import java.util.ArrayList;
import java.util.List;

public class Storage {
    public List<Item> expiredItems;
    Storage(String store){
        this.expiredItems = new ArrayList<Item>();

    }
    public void addListItems(List<Item> items){
        this.expiredItems.addAll(items);
    }
}
