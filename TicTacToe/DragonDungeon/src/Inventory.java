import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Inventory {
	ArrayList<Item> items=new ArrayList<Item>();
	public void sortItems() {
		Collections.sort(items, Collator.getInstance());
	}
	public void addItem(Item i) {
		items.add(i);
		//lisää itemin inventoriin
	}
	public Item getItem(int i) {
		return items.get(i);
		//palauttaa itemin annetusta indeksista
	}
	
	
	public void activate_Item(Item i) {
		//aktivoi itemin effektin ja poistaa sen inventorista
		if(items.contains(i)) {
			for (Item item : items) {
				if(item.equals(i)) {
					item.activateEffect(Main.p,Main.d);
					items.remove(item);
					break;
				}
			}
		}
	}
	public String[] getInventory() {
		//palauttaa inventorin sisallon listana String olioita
		String[] List=new String[items.size()];
		for(int i=0; i<items.size(); i++) {
			List[i]=items.get(i).toString();
		}
		return List;
	}
	public String[] getInventoryforMenu() {
		//palauttaa inventorin sisallon listana String olioita menuun sopivaksi muotoiltuna
		String[] List=new String[items.size()+1];
		for(int i=0; i<items.size(); i++) {
			List[i]=items.get(i).toString().replaceAll("_", " ");;
		}
		List[items.size()]="BACK";
		return List;

	}
}
