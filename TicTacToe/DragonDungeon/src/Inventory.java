import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Inventory {
	ArrayList<Item> items=new ArrayList<Item>();
	public void sortItems() {
		Collections.sort(items, Collator.getInstance());
	}
	public void activate_Item(Item i) {
		if(items.contains(i)) {
			for (Item item : items) {
				if(item.equals(i)) {
					item.activateEffect();
					items.remove(item);
					break;
				}
			}
		}
	}
	public String[] getInventory() {
		String[] List=new String[items.size()];
		for(int i=0; i<items.size(); i++) {
			List[i]=items.get(i).toString();
		}
		return List;
	}
	public String[] getInventoryforMenu() {
		String[] List=new String[items.size()+1];
		for(int i=0; i<items.size(); i++) {
			List[i]=items.get(i).toString();
		}
		List[items.size()]="BACK";
		return List;

	}
}
