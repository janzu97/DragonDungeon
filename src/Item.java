public class Item {
    int A_ID;
	String name;
	public Item(String name){
		this.name=name;
	}
	public void activateEffect() {

	}
	@Override
	public String toString() {
		return name;
	}
}