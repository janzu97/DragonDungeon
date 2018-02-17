import java.util.ArrayList;

public class Lane {
	ArrayList<Card> cards=new ArrayList<Card>();
	boolean buffed=false;
	public void playCard(Card c){
		cards.add(c);
	}
	public void buff() {
		buffed=true;
		
	}
	public void debuff() {
		buffed=false;
		
	}
	public int laneStrenght() {
		int total=0;
		for(Card i:cards) {
			total+=i.getPower();
		}
		return total;
	}
	public boolean buffed() {
		return buffed;
	}
	@Override
	public String toString() {
	String op=""; 
		for(Card i:cards) {
		op+=i;
	}
		return op;
		}
	public void empty() {
		cards=new ArrayList<Card>();
	}
}
