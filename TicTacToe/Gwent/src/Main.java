import java.util.Scanner;

public class Main {

	private static int round=0;

	public static void main(String[] args) {
		Deck d1=new Deck(new Cardlist(1));
		Deck d2=new Deck(new Cardlist(1));
		Game g=new Game(d2, d2);
		String command;
		g.getHand(2).draw(10);
		g.draw(10, 0);
		Scanner sc=new Scanner(System.in);
		while(g.getHand(0).getLives()!=0 && g.getHand(1).getLives()!=0) {
			g.getHand(0).passedtofalse();
			g.getHand(1).passedtofalse();
			round++;
			while(!(g.getHand(0).passed()&&g.getHand(2).passed())) {
				if(!g.getHand(0).passed()) {
					System.out.println("player 1 play");
					command=sc.nextLine();
					if(command.equals("pass")) {
						g.getHand(0).passedtotrue();
					}else {
						g.getHand(0).playCard(Integer.parseInt(command));
					}
				}
				System.out.println(g);
				if(!g.getHand(1).passed()) {
					System.out.println("player 2 play");
					command=sc.nextLine();
					if(command.equals("pass")) {
						g.getHand(1).passedtotrue();
					}else {
						g.getHand(1).playCard(Integer.parseInt(command));
					}
				}

				System.out.println(g);
			}

			if(g.getHand(0).getTotalStrenght()>g.getHand(2).getTotalStrenght()) {
				g.getHand(2).reduceLives();
				System.out.println("player 1 wins");
			}
			if(g.getHand(1).getTotalStrenght()>g.getHand(0).getTotalStrenght()) {
				g.getHand(0).reduceLives();
				System.out.println("player 2 wins");
			}if(g.getHand(1).getTotalStrenght()==g.getHand(0).getTotalStrenght()) {
				g.getHand(0).reduceLives();
				g.getHand(1).reduceLives();
				System.out.println("Draw");
			}

			g.emptyField();
			System.out.println("Round "+round);

		}
		if(g.getHand(0).getLives()>0) {
			System.out.println("player 1 wins");
		}else if(g.getHand(1).getLives()>0) {
			System.out.println("player 2 wins");
		}else {
			System.out.println("Draw");
		}
	}

}
