import java.io.File;
import java.util.ArrayList;
public class Main {
    static Player p=new Player();
   static Controller c=new Controller();
   static boolean selectionmade=false;
	public static void main(String[] args) {
		Runnable r = new Runnable() {
			public void run() {
				
				c.launch();
			}
		};
		Musicplayer.playSong();
		p.setName();

		Thread t=new Thread(r);
		t.start();
		SReader.read(SReader.ReadFile(new File("res\\dialogue\\Opening.txt")));
		SReader.read(SReader.ReadFile(new File("res\\dialogue\\BattleOP.txt")));
		player_choose();
		
	}
	public long getScore(Dragon D) {
		return D.getScore();
	}
	public static void player_choose() {
		selectionmade=false;
		c.setMAX_loc(4);
		while(!selectionmade) {
			String[] options= {"MELEE","MAGIC","ITEM","RUN"};
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			SReader.update(SReader.GenerateMenu(options,c));
			
		}
		if(c.get_Location()==1) {
			chose_melee();
		}
		else if(c.get_Location()==2) {
			
			chose_magic();
		}
		else if(c.get_Location()==3) {
			chose_Item();
		}
		else if(c.get_Location()==4) {
			chose_run();
		}
	}
	public static void chose_melee() {
		selectionmade=false;
		c.setMAX_loc(3);
		while(!selectionmade) {
            String[] options= {"HEAVY","LIGHT","BACK"};
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			SReader.update(SReader.GenerateMenu(options,c));
		}
		switch(c.get_Location()) {
		case 1 : p.heavyAttack();
		case 2 : p.lightAttack();
		case 3 : player_choose();
		}
	}
	public static void chose_magic() {
		selectionmade=false;
		while(!selectionmade) {
String[] options= {"MELEE","MAGIC","ITEM","RUN"};
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			SReader.update(SReader.GenerateMenu(options,c));
		}
	}
	public static void chose_Item() {
		selectionmade=false;
		while(!selectionmade) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			SReader.update(SReader.GenerateMenu(p.i.getInventory(),c));
			
			
		}
	}
	public static void chose_run() {
		selectionmade=false;
		while(!selectionmade) {
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		SReader.update(SReader.GenerateMenu(new String[]{"QUIT AND SAVE","QUIT WHITHOUT SAVING","CANSEL"},c));
		
	}
		}
	public static Player getPlayer() {
		return p;
	}
}