
public class Game {
	private Hand h1;
	private Hand h2;
	public Game(Deck d,Deck d2) {
		h1=new Hand(d, new Field(),this);
		h2=new Hand(d2,new Field(),this);
	}
	public void draw(int m,int h) {
		if(h==0) {
			h1.draw(m);
		}else {
			h2.draw(m);
		}
	}
	public Hand getHand(int h) {
		if(h==0) {
			return h1;
		}else return h2;
	}
	public void emptyField() {
		h1.emptyField();
		h2.emptyField();
	}
	@Override
	public String toString(){
		return getHand(0).f+"\n\n"+getHand(1).f;
	}
}
