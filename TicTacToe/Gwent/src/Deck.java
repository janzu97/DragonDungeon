import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	private ArrayList<Card> deck=new ArrayList<Card>();
	private ArrayList<Card> allcards=new ArrayList<Card>(); 
	private void defineCards() {
		allcards.add(new Card("Poor fucking infantry", 1, 0));
		allcards.add(new Card("Geralt of Rivia",15,0));
		allcards.add(new Card("Cirilla Fiona Elen Rianno",15,0));
		allcards.add(new Card("Vesemir",6,0));
		allcards.add(new Card("Yennefer of VengerBerg",7,0));
		allcards.add(new Card("Triss Merigold",7,0));
		allcards.add(new Card("Dandelion",2,0));
		allcards.add(new Card("Zoltan Chivay",5,0));
		allcards.add(new Card("Emiel Regis Rohellec Terzieff",5,0));
		allcards.add(new Card("Villentretenmerth",7,0));
		allcards.add(new Card("Avalac'h",-1,0));
		allcards.add(new Card("Decoy",-1,0));
		allcards.add(new Card("Commander's Horn",-1,0));
		allcards.add(new Card("Scorch",-1,0));
		allcards.add(new Card("Biting Frost",-1,0));
		allcards.add(new Card("Impenetrable Fog",-1,0));
		allcards.add(new Card("Torrential Rain",-1,0));
		allcards.add(new Card("Clear Weather",15,0));
		allcards.add(new Card("Vernon Roche",10,0));
		allcards.add(new Card("John Natalis",10,0));
		allcards.add(new Card("Esterad Thyssen",10,0));
		allcards.add(new Card("Philippa Eilhart",10,0));
		allcards.add(new Card("Thaler",-1,0));
		allcards.add(new Card("Ves",5,0));
		allcards.add(new Card("Siegfried of Denestle",5,0));
		allcards.add(new Card("Yarpen Zigrin",2,0));
		allcards.add(new Card("Sigismund Dijkstra",-1,0));
		allcards.add(new Card("Sigismund Dijkstra",4,0));
		allcards.add(new Card("Keira Metz",5,0));
		allcards.add(new Card("Sile de Tansarville",5,0));
		allcards.add(new Card("Sabrina Glevissig",4,0));
		allcards.add(new Card("Sheldon Skaggs",4,0));
		allcards.add(new Card("Dethmold",6,0));
		allcards.add(new Card("Prince Stennis",-1,0));
		allcards.add(new Card("Trebuchet",6,0));
		allcards.add(new Card("Cinfrid Reavers Dragon Hunter",5,0));
		allcards.add(new Card("Redanian Foot Soldier",1,0));
		allcards.add(new Card("Catapult",8,0));
		allcards.add(new Card("Ballista",6,0));
		
		
		
		
		
		
		
		
		
		
	}
	public Deck (Cardlist cl) {
		defineCards();
		for(int i:cl.getList()) {
			deck.add(allcards.get(i));
		}
	}

	public void shuffle(){
		Collections.shuffle(deck);
	}


	public Card Draw(){
		Card c=deck.get(0);
		deck.remove(0);
		return c;
	
		}
	public int cardsLeftinDeck(){
		return deck.size();
	}

}
