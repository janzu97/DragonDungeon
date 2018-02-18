
public class Card {
	private String name;
	private int power;
	private int aID;
	private int row=1;
	public Card(String n,int p,int a){
		this.name=n;
		this.power=p;
		this.aID=a;
	}
	public int getRow() {

		return row;
	}
	public String getName(){
		return this.name;
	}
	public int getPower(){
		return this.power;
	}
	public int getAbility(){
		return this.aID;
	}
	@Override
	public String toString() {
		return name+" Power "+power;
	}
}
