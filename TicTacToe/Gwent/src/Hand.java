import java.util.ArrayList;

public class Hand {
	private ArrayList<Card> hand=new ArrayList<Card>();
	private Deck d;
	boolean passed=false;
	private Game g;
	Field f;
	private int lives=3;
	public Hand(Deck deck,Field fe, Game game) {
		d=deck;
		f=fe;
		g=game;
	}
	public void passedtofalse() {
		passed=false;
	}
	public void passedtotrue() {
		passed=true;
	}

	public void playCard(int i){
		Card c=hand.get(i);
		hand.remove(i);
		f.playCard(c.getRow(), c);
		activateAbility(c);

	}
	private void activateAbility(Card c) {
		int ID=c.getAbility();
		if(ID==1) {
			AbilityInterface.scorch(g);
		}else if(ID==2) {
			AbilityInterface.buff(f, c.getRow());

		}else if(ID==3) {
			AbilityInterface.addFrost(g);
		}
	}
	public int getTotalStrenght() {
		return f.totalStrenght();
	}

	public void draw(int n) {
		for(int i=0; i<n; i++){
			if(d.cardsLeftinDeck()!=0) {
				hand.add(d.Draw());
			}
		}
	}
	public boolean passed() {
		return passed;
	}
	@Override
	public String toString() {
		String op="";
		for(Card i:hand) {
			op+=i.toString();
		}
		return op;
	}
	public int getLives() {
		return lives;
	}
	public void reduceLives() {

		lives--;
		
	}
	public void emptyField() {
		f.empty();
	}
	

}
